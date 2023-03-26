package net.scalax.simple
package codec
package impl

import shapeless._

trait GenericBuilderImpl {
  implicit def caseClassGenericBuilder[T, H <: HList](implicit gen: Generic.Aux[T, H], builder: GenericBuilder[H]): GenericBuilder[T] =
    new GenericBuilder[T] {
      override def value: T = gen.from(builder.value)
    }
  implicit val genericBuilderZero: GenericBuilder[HNil] = new GenericBuilder[HNil] {
    override val value: HNil = HNil
  }
  implicit def genericBuilderPositive[Head, Tail <: HList](implicit
    headInstance: Lazy[Head],
    genericBuilder: GenericBuilder[Tail]
  ): GenericBuilder[Head :: Tail] = new GenericBuilder[Head :: Tail] {
    override def value: Head :: Tail = headInstance.value :: genericBuilder.value
  }
}
