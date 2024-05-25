package net.scalax.simple.codec

import shapeless.Generic

trait SimpleFrom[+Model, -HList] {
  def from(model: HList): Model
}

trait SimpleFromGeneric[Model] {
  def generic[H](implicit g: Generic.Aux[Model, H]): SimpleFrom[Model, H] = new SimpleFrom[Model, H] {
    override def from(h: H): Model = g.from(h)
  }
  def law[ModelImpl >: Model <: Model]: SimpleFromGeneric[ModelImpl] = SimpleFromGeneric[ModelImpl]
}

object SimpleFromGeneric {
  def apply[T]: SimpleFromGeneric[T] = new SimpleFromGeneric[T] {
    //
  }
}
