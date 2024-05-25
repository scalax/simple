package net.scalax.simple.codec

import scala.deriving.Mirror

trait SimpleFrom[+Model, -HList] {
  def from(model: HList): Model
}

trait SimpleFromGeneric[Model] {
  def generic(using g: Mirror.ProductOf[Model]): SimpleFrom[Model, g.MirroredElemTypes] = h => g.fromTuple(h)
  def law[ModelImpl >: Model <: Model]: SimpleFromGeneric[ModelImpl]                    = SimpleFromGeneric[ModelImpl]
}

object SimpleFromGeneric {
  def apply[T]: SimpleFromGeneric[T] = new SimpleFromGeneric[T] {
    //
  }
}
