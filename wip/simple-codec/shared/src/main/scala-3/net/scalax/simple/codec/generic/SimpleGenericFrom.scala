package net.scalax.simple.codec

import scala.deriving.Mirror

trait SimpleFrom[+Model] {
  def from(model: Tuple): Model
}

trait SimpleFromGeneric[Model] {
  def generic(using g: Mirror.ProductOf[Model]): SimpleFrom[Model] = h => g.fromTuple(h.asInstanceOf[g.MirroredElemTypes])
}

object SimpleFromGeneric {
  def apply[T]: SimpleFromGeneric[T] = new SimpleFromGeneric[T] {
    //
  }
}
