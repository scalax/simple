package net.scalax.simple
package codec

import shapeless._

trait NoneModelFiller[F[_[_]]] {
  def instance: ContextO[F]#Tag
}

object NoneModelFiller {
  def apply[F[_[_]]]: ModelLengthImpl[F] = new ModelLengthImpl[F]

  class ModelLengthImpl[F[_[_]]] extends ModelLengthImplImpl[F, F[ContextI#Tag]]

  trait ModelLengthImplImpl[F[_[_]], Model] {
    def generic[H <: HList](implicit g: Generic.Aux[Model, H], v: ValueW[H]): NoneModelFiller[F] = new NoneModelFiller[F] {
      override val instance: F[ContextI#Tag] = g.asInstanceOf[Generic.Aux[F[ContextI#Tag], H]].from(v.value)
    }
  }
}
