package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{SimpleFrom, SimpleFromGeneric, SimpleTo, SimpleToGeneric}
import shapeless.{DefaultSymbolicLabelling, Generic}

trait SimpleFromTo[Model, Target, NameTarget]
    extends SimpleFrom[Model, Target]
    with SimpleTo[Model, Target]
    with SimpleName[Model, NameTarget] {
  override def from(t: Target): Model
  override def to(t: Model): Target
  override def names: NameTarget
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

    def derived[H, N1, N2](implicit
      g: Generic.Aux[ModelType, H],
      d1: DefaultSymbolicLabelling.Aux[ModelType, N1],
      d2: SimpleNameGeneric.SymbolHListToStringHList[N1, N2]
    ): SimpleFromProduct.Aux[F, I, H, N2] = new SimpleFromProduct[F, I] {
      override type Target     = H
      override type NameTarget = N2
      override val generic: SimpleFromTo[F[I], Target, N2] = new SimpleFromTo[F[I], Target, N2] {
        override def from(t: H): F[I] = g.from(t)
        override def to(t: F[I]): H   = g.to(t)
        override val names: N2        = d2.to(d1.apply())
      }
    }
  }

  class ApplyImpl2[F[_[_]], I[_]] extends ApplyImpl1[F, I, F[I]]

}
