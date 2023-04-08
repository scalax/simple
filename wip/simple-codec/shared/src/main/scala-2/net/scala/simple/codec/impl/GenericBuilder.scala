package net.scalax.simple
package codec
package utils
package impl

import shapeless._

trait GenericBuilderImpl {
  implicit def caseClassGenericBuilder[T, H <: HList, PInstance](implicit
    gen: Generic.Aux[T, H],
    builder: GenericBuilder[H, PInstance]
  ): GenericBuilder[T, PInstance] = new GenericBuilder[T, PInstance] {
    override def value: T = gen.from(builder.value)
  }

  private val any: GenericBuilder[HNil, Any] = new GenericBuilder[HNil, Any] {
    override val value: HNil = HNil
  }
  implicit def genericBuilderZero[PInstance]: GenericBuilder[HNil, PInstance] = any.asInstanceOf[GenericBuilder[HNil, PInstance]]

  implicit def genericBuilderPositive[Head, Tail <: HList, PInstance](implicit
    headInstance: Lazy[ModelImplement[PInstance, Head]],
    genericBuilder: GenericBuilder[Tail, PInstance]
  ): GenericBuilder[Head :: Tail, PInstance] = new GenericBuilder[Head :: Tail, PInstance] {
    override def value: Head :: Tail = headInstance.value.value :: genericBuilder.value
  }
}
