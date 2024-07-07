package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{NamedImplicit, SimpleFrom, SimpleFromGeneric, SimpleTo, SimpleToGeneric}
import scala.deriving.Mirror

trait SimpleNamed[Model] {
  def labelled: List[String]
}

trait SimpleFromTo[Model, Target] extends SimpleFrom[Model, Target] with SimpleTo[Model, Target] with SimpleNamed[Model] {
  override def from(t: Target): Model
  override def to(t: Model): Target
  override def labelled: List[String]
}

trait SimpleFromProduct[F[_[_]], I[_]] {
  type Target
  val generic: SimpleFromTo[F[I], Target]
}

object SimpleFromProduct {

  type Aux[F[_[_]], I[_], To] = SimpleFromProduct[F, I] {
    type Target = To
  }

  def apply[F[_[_]] <: Product, I[_]]: ApplyImpl3[F, I] = new ApplyImpl3[F, I]

  trait ApplyImpl1[F[_[_]] <: Product, I[_]] {
    def derived(using g: Mirror.ProductOf[F[I]], n: NamedImplicit[g.MirroredElemLabels]): SimpleFromProduct.Aux[F, I, g.MirroredElemTypes] =
      new SimpleFromProduct[F, I] {
        override type Target = g.MirroredElemTypes
        override val generic: SimpleFromTo[F[I], g.MirroredElemTypes] = new SimpleFromTo[F[I], g.MirroredElemTypes] {
          override def from(t: g.MirroredElemTypes): F[I] = SimpleFromGeneric[F[I]].generic.from(t)
          override def to(t: F[I]): g.MirroredElemTypes   = SimpleToGeneric[F[I]].generic.to(t)
          override val labelled: List[String]             = n.input
        }
      }
  }

  trait ApplyImpl2[F[_[_]] <: Product, I[_], ModelType >: F[I] <: F[I]] extends ApplyImpl1[F, I] {
    def law[ModelTypeImpl >: ModelType <: ModelType]: ApplyImpl2[F, I, ModelTypeImpl] = new ApplyImpl2[F, I, ModelTypeImpl] {
      //
    }

    override def derived(using
      g: Mirror.ProductOf[ModelType],
      n: NamedImplicit[g.MirroredElemLabels]
    ): SimpleFromProduct.Aux[F, I, g.MirroredElemTypes] = super.derived
  }

  class ApplyImpl3[F[_[_]] <: Product, I[_]] extends ApplyImpl2[F, I, F[I]]

}
