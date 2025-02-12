package net.scalax.simple.codec

import shapeless.{Generic, HList}

trait SimpleFrom[+Model] {
  def from(model: HList): Model
}

trait SimpleFromGeneric[Model] {
  def generic(implicit g: Generic.Aux[Model, _ <: HList]): SimpleFrom[Model] = new SimpleFrom[Model] {
    override def from(h: HList): Model = g.asInstanceOf[Generic.Aux[Model, HList]].from(h)
  }
}

object SimpleFromGeneric {
  def apply[T]: SimpleFromGeneric[T] = new SimpleFromGeneric[T] {
    //
  }
}
