package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{NamedImplicit, SimpleFrom, SimpleFromGeneric, SimpleTo, SimpleToGeneric}
import scala.deriving.Mirror

trait SimpleNamed[Model] {
  def labelled: Tuple
}

trait SimpleFromTo[Model] extends SimpleFrom[Model] with SimpleTo[Model] with SimpleNamed[Model] {
  override def from(t: Tuple): Model
  override def to(t: Model): Tuple
  override def labelled: Tuple
}

trait SimpleFromProduct[F[_[_]]] {
  val generic: SimpleFromTo[F[[x] =>> Any]]
}

object SimpleFromProduct {

  def apply[F[_[_]] <: Product]: ApplyImpl1[F] = new ApplyImpl1[F] {
    //
  }

  trait ApplyImpl1[F[_[_]] <: Product] {
    def derived(using g: Mirror.ProductOf[F[[x] =>> Any]], n: NamedImplicit[g.MirroredElemLabels]): SimpleFromProduct[F] =
      new SimpleFromProduct[F] {
        override val generic: SimpleFromTo[F[[x] =>> Any]] = new SimpleFromTo[F[[x] =>> Any]] {
          override def from(t: Tuple): F[[x] =>> Any] = SimpleFromGeneric[F[[x] =>> Any]].generic.from(t.asInstanceOf[g.MirroredElemTypes])
          override def to(t: F[[x] =>> Any]): Tuple   = SimpleToGeneric[F[[x] =>> Any]].generic.to(t)
          override val labelled: Tuple                = n.input
        }
      }
  }

}
