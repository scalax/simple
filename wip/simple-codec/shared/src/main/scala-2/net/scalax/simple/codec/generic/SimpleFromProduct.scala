package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}
import shapeless.Generic

trait SimpleFromTo[Model, Target] extends SimpleFrom[Model, Target] with SimpleTo[Model, Target] {
  override def from(t: Target): Model
  override def to(t: Model): Target
}

trait SimpleFromProduct[F[_[_]], I[_]] {
  type Target
  val generic: SimpleFromTo[F[I], Target]
}

object SimpleFromProduct {

  type Aux[F[_[_]], I[_], To] = SimpleFromProduct[F, I] {
    type Target = To
  }

  def apply[F[_[_]], I[_]]: ApplyImpl1[F, I, F[I]] = new ApplyImpl2[F, I]

  trait ApplyImpl1[F[_[_]], I[_], ModelType >: F[I] <: F[I]] {
    def law[ModelTypeImpl >: ModelType <: ModelType]: ApplyImpl1[F, I, ModelTypeImpl] = new ApplyImpl1[F, I, ModelTypeImpl] {
      //
    }
    def derived[H](implicit g: Generic.Aux[ModelType, H]): SimpleFromProduct.Aux[F, I, H] = new SimpleFromProduct[F, I] {
      override type Target = H
      override val generic: SimpleFromTo[F[I], Target] = new SimpleFromTo[F[I], Target] {
        override def from(t: H): F[I] = g.from(t)
        override def to(t: F[I]): H   = g.to(t)
      }
    }
  }

  class ApplyImpl2[F[_[_]], I[_]] extends ApplyImpl1[F, I, F[I]]

}
