package net.scalax.simple.codec

import shapeless.{Generic, HList}

trait SimpleTo[-Model] {
  def to(model: Model): HList
}

trait SimpleToGeneric[Model] {
  def generic(implicit g: Generic.Aux[Model, _ <: HList]): SimpleTo[Model] = new SimpleTo[Model] {
    override def to(h: Model): HList = g.asInstanceOf[Generic.Aux[Model, HList]].to(h)
  }
}

object SimpleToGeneric {
  def apply[T]: SimpleToGeneric[T] = new SimpleToGeneric[T] {
    //
  }
}
