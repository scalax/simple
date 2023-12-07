package net.scalax.simple.codec.generic

import scala.deriving.Mirror
import scala.compiletime._

trait SimpleName[+Model, +HList] {
  def names: HList
}

trait SimpleNameGeneric[Model] {

  def generic(using
    l: Mirror.ProductOf[Model],
    toInstance: SimpleNameGeneric.ToInstance[l.MirroredElemLabels]
  ): SimpleName[Model, l.MirroredElemLabels] = new SimpleName[Model, l.MirroredElemLabels] {
    override val names: l.MirroredElemLabels = toInstance.value
  }

  def law[ModelImpl >: Model <: Model]: SimpleNameGeneric[ModelImpl] = SimpleNameGeneric[ModelImpl]

}

object SimpleNameGeneric {
  trait ToInstance[T] {
    def value: T
  }

  object ToInstance {
    inline given [T <: Tuple]: ToInstance[T] = new ToInstance[T] {
      override val value: T = constValueTuple[T]
    }
  }

  def apply[T]: SimpleNameGeneric[T] = new SimpleNameGeneric[T] {
    //
  }
}
