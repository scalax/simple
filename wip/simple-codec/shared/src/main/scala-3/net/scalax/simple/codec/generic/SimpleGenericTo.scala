package net.scalax.simple.codec

import scala.deriving.Mirror

trait SimpleTo[-Model] {
  def to(model: Model): Tuple
}

trait SimpleToGeneric[Model <: Product] {
  def generic(using g: Mirror.ProductOf[Model]): SimpleTo[Model] = h => Tuple.fromProductTyped(h)
}

object SimpleToGeneric {
  def apply[T <: Product]: SimpleToGeneric[T] = new SimpleToGeneric[T] {
    //
  }
}
