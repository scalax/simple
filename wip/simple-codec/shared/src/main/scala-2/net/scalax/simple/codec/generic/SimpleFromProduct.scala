package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{NamedImplicit, SimpleFrom, SimpleTo}
import shapeless.Generic

trait SimpleNamed[Model] {
  def labelled: List[String]
}

trait SimpleFromTo[Model, Target, NameTarget] extends SimpleFrom[Model, Target] with SimpleTo[Model, Target] with SimpleNamed[Model] {
  override def from(t: Target): Model
  override def to(t: Model): Target
  override def labelled: List[String]
}

trait SimpleFromProduct[F[_[_]], I[_]] {
  type Target
  type NameTarget
  val generic: SimpleFromTo[F[I], Target, NameTarget]
}

object SimpleFromProduct {

  type Aux[F[_[_]], I[_], To, Name] = SimpleFromProduct[F, I] {
    type Target     = To
    type NameTarget = Name
  }

  def apply[F[_[_]], I[_]]: ApplyImpl2[F, I] = new ApplyImpl2[F, I]

  trait ApplyImpl1[F[_[_]], I[_], ModelType >: F[I] <: F[I]] {

    def law[ModelTypeImpl >: ModelType <: ModelType]: ApplyImpl1[F, I, ModelTypeImpl] = new ApplyImpl1[F, I, ModelTypeImpl] {
      //
    }

    def derived[H, N1](implicit g: Generic.Aux[ModelType, H], n: NamedImplicit[ModelType]): SimpleFromProduct.Aux[F, I, H, N1] =
      new SimpleFromProduct[F, I] {
        override type Target     = H
        override type NameTarget = N1
        override val generic: SimpleFromTo[F[I], Target, N1] = new SimpleFromTo[F[I], Target, N1] {
          override def from(t: H): F[I]       = g.from(t)
          override def to(t: F[I]): H         = g.to(t)
          override val labelled: List[String] = n.input
        }
      }

  }

  class ApplyImpl2[F[_[_]], I[_]] extends ApplyImpl1[F, I, F[I]]

}
