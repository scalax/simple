package net.scalax.simple.codec

import net.scalax.simple.codec.utils.GenericBuilder

trait TypeParameterBuilder[F[_[_]]] {
  def poly[PolyInstance]: BB[PolyInstance]
  def default: BB[DefaultModelImplement.type] = poly[DefaultModelImplement.type]

  trait BB[Poly] {
    def build[H[_]]: TypeParameterBuilder.GenericBuilderInstanceImpl[F, H, Poly]
  }
}

object TypeParameterBuilder {
  def apply[F[_[_]]]: TypeParameterBuilder[F] = anyInstance.asInstanceOf[TypeParameterBuilder[F]]

  private object anyInstance extends TypeParameterBuilder[({ type E[_[_]] = Any })#E] {
    override def poly[PolyInstance]: BB[PolyInstance] = new BB[PolyInstance] {
      override def build[H[_]]: TypeParameterBuilder.GenericBuilderInstanceImpl[({ type E[_[_]] = Any })#E, H, PolyInstance] =
        new TypeParameterBuilder.GenericBuilderInstanceImpl[({ type E[_[_]] = Any })#E, H, PolyInstance]
    }
  }

  class GenericBuilderInstanceImpl[F[_[_]], H[_], Poly] extends GenericBuilderInstanceImpl1[F, H, Poly]

  trait GenericBuilderInstanceImpl1[F[_[_]], H[_], Poly] extends GenericBuilderInstanceImplImpl[F, H, F[H], Poly] {
    override protected val cvImpl: F[H] <:< F[H] = implicitly[F[H] <:< F[H]]
  }

  trait GenericBuilderInstanceImplImpl[F[_[_]], H[_], Model, Poly] {
    protected implicit def cvImpl: Model <:< F[H]
    def generic(implicit v: GenericBuilder[Model, Poly]): F[H] = v.value
  }
}
