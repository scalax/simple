package net.scalax.simple.codec

import shapeless.Generic

trait SimpleTo[-Model, +HList] {
  def to(model: Model): HList
}

trait SimpleToGeneric[Model] {
  def generic[H](implicit g: Generic.Aux[Model, H]): SimpleTo[Model, H] = new SimpleTo[Model, H] {
    override def to(h: Model): H = g.to(h)
  }
  def law[ModelImpl >: Model <: Model]: SimpleToGeneric[ModelImpl] = SimpleToGeneric[ModelImpl]
}

object SimpleToGeneric {
  def apply[T]: SimpleToGeneric[T] = new SimpleToGeneric[T] {
    //
  }
}
