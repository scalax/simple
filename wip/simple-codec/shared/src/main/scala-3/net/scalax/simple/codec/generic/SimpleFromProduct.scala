package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{SimpleFrom, SimpleFromGeneric, SimpleTo, SimpleToGeneric}
import scala.deriving.Mirror

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

  def apply[F[_[_]] <: Product, I[_]]: ApplyImpl3[F, I] = new ApplyImpl3[F, I]

  trait ApplyImpl1[F[_[_]] <: Product, I[_]] {
    def derived(using
      g: Mirror.ProductOf[F[I]]
    )(using SimpleNameGeneric.ToInstance[g.MirroredElemLabels]): SimpleFromProduct.Aux[F, I, g.MirroredElemTypes, g.MirroredElemLabels] =
      new SimpleFromProduct[F, I] {
        override type Target     = g.MirroredElemTypes
        override type NameTarget = g.MirroredElemLabels
        override val generic: SimpleFromTo[F[I], g.MirroredElemTypes, g.MirroredElemLabels] =
          new SimpleFromTo[F[I], g.MirroredElemTypes, g.MirroredElemLabels] {
            override def from(t: g.MirroredElemTypes): F[I] = SimpleFromGeneric[F[I]].generic.from(t)
            override def to(t: F[I]): g.MirroredElemTypes   = SimpleToGeneric[F[I]].generic.to(t)
            override val names: g.MirroredElemLabels        = SimpleNameGeneric[F[I]].generic.names
          }
      }
  }

  trait ApplyImpl2[F[_[_]] <: Product, I[_], ModelType >: F[I] <: F[I]] extends ApplyImpl1[F, I] {
    def law[ModelTypeImpl >: ModelType <: ModelType]: ApplyImpl2[F, I, ModelTypeImpl] = new ApplyImpl2[F, I, ModelTypeImpl] {
      //
    }

    override def derived(using g: Mirror.ProductOf[ModelType])(using
      toInstance: SimpleNameGeneric.ToInstance[g.MirroredElemLabels]
    ): SimpleFromProduct.Aux[F, I, g.MirroredElemTypes, g.MirroredElemLabels] =
      super.derived
  }

  class ApplyImpl3[F[_[_]] <: Product, I[_]] extends ApplyImpl2[F, I, F[I]]

}
