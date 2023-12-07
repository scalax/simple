package net.scalax.simple.codec.generic

import shapeless._

trait SimpleName[Model, +HList] {
  def names: HList
}

trait SimpleNameGeneric[Model] {

  def generic[H1](implicit g: DefaultSymbolicLabelling.Aux[Model, H1]): SimpleName[Model, H1] = new SimpleName[Model, H1] {
    override def names: H1 = g.apply()
  }

  def law[ModelImpl >: Model <: Model]: SimpleNameGeneric[ModelImpl] = SimpleNameGeneric[ModelImpl]

}

object SimpleNameGeneric {
  def apply[T]: SimpleNameGeneric[T] = new SimpleNameGeneric[T] {
    //
  }
}
