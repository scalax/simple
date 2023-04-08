package net.scalax.simple
package codec

import net.scalax.simple.codec.utils.GenericBuilder

trait EmptyTagModelFiller[F[_[_]]] {
  def instance: ContextO[F]#EmptyTagF
}

object EmptyTagModelFiller {
  def apply[F[_[_]]]: EmptyTagModelFillerImpl[F] = new EmptyTagModelFillerImpl[F]

  class EmptyTagModelFillerImpl[F[_[_]]] extends EmptyTagModelFillerImplImpl[F, F[ContextI#EmptyTagF]]

  trait EmptyTagModelFillerImplImpl[F[_[_]], Model] {

    private val uuInstance: TypeParameterBuilder.GenericBuilderInstanceImpl[F, ContextI#EmptyTagF, EmptyTagModelFiller.type] =
      TypeParameterBuilder[F].poly[EmptyTagModelFiller.type].build[ContextI#EmptyTagF]
    def generic(implicit g: GenericBuilder[Model, EmptyTagModelFiller.type]): EmptyTagModelFiller[F] = {
      implicit val e: GenericBuilder[F[ContextI#EmptyTagF], EmptyTagModelFiller.type] =
        g.asInstanceOf[GenericBuilder[F[ContextI#EmptyTagF], EmptyTagModelFiller.type]]
      new EmptyTagModelFiller[F] {
        override val instance: F[ContextI#EmptyTagF] = uuInstance.generic
      }
    }
  }

  implicit def modelI[PolyInstance, T]: ModelImplement[PolyInstance, EmptyTag[T]] =
    new ModelImplement[PolyInstance, EmptyTag[T]](EmptyTag.value)
}
