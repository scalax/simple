package net.scalax.simple.codec

import net.scalax.simple.codec.impl.GenericBuilder

trait TypeParameterBuilder[F[_[_]]] {
  def build[H[_]]: TypeParameterBuilder.GenericBuilderInstanceImpl[F, H]
}

object TypeParameterBuilder {
  def apply[F[_[_]]]: TypeParameterBuilder[F] = any.asInstanceOf[TypeParameterBuilder[F]]

  private object any extends TypeParameterBuilder[({ type E[_[_]] = Any })#E] {
    def build[H[_]]: TypeParameterBuilder.GenericBuilderInstanceImpl[({ type E[_[_]] = Any })#E, H] =
      new TypeParameterBuilder.GenericBuilderInstanceImpl[({ type E[_[_]] = Any })#E, H](implicitly)
  }

  class GenericBuilderInstanceImpl[F[_[_]], H[_]](override protected val cvImpl: F[H] <:< F[H])
      extends GenericBuilderInstanceImplImpl[F, H, F[H]]

  trait GenericBuilderInstanceImplImpl[F[_[_]], H[_], Model] {
    protected implicit def cvImpl: Model <:< F[H]
    def generic(implicit v: GenericBuilder[Model]): F[H] = v.value
  }
}
