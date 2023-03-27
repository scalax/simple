package net.scalax.simple
package codec

import net.scalax.simple.codec.impl.GenericBuilder

trait EmptyTagModelFiller[F[_[_]]] {
  def instance: ContextO[F]#EmptyTagF
}

object EmptyTagModelFiller {
  def apply[F[_[_]]]: EmptyTagModelFillerImpl[F] = new EmptyTagModelFillerImpl[F](implicitly)

  class EmptyTagModelFillerImpl[F[_[_]]](protected val cvImpl: F[ContextI#EmptyTagF] <:< F[ContextI#EmptyTagF])
      extends EmptyTagModelFillerImplImpl[F, F[ContextI#EmptyTagF]]

  trait EmptyTagModelFillerImplImpl[F[_[_]], Model] {
    protected implicit def cvImpl: Model <:< F[ContextI#EmptyTagF]
    def build(m: Model): EmptyTagModelFiller[F] = new EmptyTagModelFiller[F] {
      override val instance: F[ContextI#EmptyTagF] = m
    }
    def generic(implicit g: GenericBuilder[Model]): EmptyTagModelFiller[F] = new EmptyTagModelFiller[F] {
      override val instance: F[ContextI#EmptyTagF] = g.asInstanceOf[GenericBuilder[F[ContextI#EmptyTagF]]].value
    }
  }
}
