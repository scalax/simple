package net.scalax.simple.codec

import scala.deriving.Mirror

trait SimpleTo[-Model, +HList] {
  def to(model: Model): HList
}

trait SimpleToGeneric[Model <: Product] {
  def generic(using g: Mirror.ProductOf[Model]): SimpleTo[Model, g.MirroredElemTypes] = h => Tuple.fromProductTyped(h)
  def law[ModelImpl >: Model <: Model]: SimpleToGeneric[ModelImpl]                    = SimpleToGeneric[ModelImpl]
}

object SimpleToGeneric {
  def apply[T <: Product]: SimpleToGeneric[T] = new SimpleToGeneric[T] {
    //
  }
}
