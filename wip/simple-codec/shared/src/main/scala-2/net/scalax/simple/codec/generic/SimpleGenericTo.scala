package net.scalax.simple.codec

import shapeless.Generic

trait SimpleTo[-Model, +HList] extends Function1[Model, HList] {
  override def apply(model: Model): HList
}

trait SimpleToGeneric[Model] {
  def generic[H](implicit g: Generic.Aux[Model, H]): SimpleTo[Model, H] = new SimpleTo[Model, H] {
    override def apply(h: Model): H = g.to(h)
  }
  def law[ModelImpl >: Model <: Model]: SimpleToGeneric[ModelImpl] = SimpleToGeneric[ModelImpl]
}

object SimpleToGeneric {
  def apply[T]: SimpleToGeneric[T] = new SimpleToGeneric[T] {
    //
  }
}
