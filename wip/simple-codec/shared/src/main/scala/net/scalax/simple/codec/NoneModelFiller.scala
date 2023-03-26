package net.scalax.simple
package codec

import net.scalax.simple.codec.impl.GenericBuilder

trait EmptyTagModelFiller[F[_[_]]] {
  def instance: ContextO[F]#TagF
}

object EmptyTagModelFiller {
  def apply[F[_[_]]]: EmptyTagModelFillerImpl[F] = new EmptyTagModelFillerImpl[F]

  class EmptyTagModelFillerImpl[F[_[_]]] extends EmptyTagModelFillerImplImpl[F, F[ContextI#Tag]]

  trait EmptyTagModelFillerImplImpl[F[_[_]], Model] {
    def generic(implicit g: GenericBuilder[Model]): EmptyTagModelFiller[F] = new EmptyTagModelFiller[F] {
      override val instance: F[ContextI#Tag] = g.asInstanceOf[GenericBuilder[F[ContextI#Tag]]].value
    }
  }
}
