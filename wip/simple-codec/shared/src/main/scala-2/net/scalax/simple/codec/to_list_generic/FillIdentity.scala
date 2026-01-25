package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.utils.ByNameImplicit
import shapeless.{::, Generic, HList, HNil}

trait FillIdentity[T] {
  def value: T
}

object FillIdentity {

  implicit def hlistImplicit1[T, Tail <: HList](implicit u: ByNameImplicit[T], t1: FillIdentity[Tail]): FillIdentity[T :: Tail] =
    new FillIdentity[T :: Tail] {
      override def value: T :: Tail = u.value :: t1.value
    }

  implicit val hlistHNilImplicit2: FillIdentity[HNil] = new FillIdentity[HNil] {
    override val value: HNil = HNil
  }

  class ModelFBuilder[T] {
    def derived[H <: HList](implicit generic: Generic.Aux[T, H], filler: FillIdentity[H]): T = generic.from(filler.value)
  }
  class ModelPojoBuilder[E[_], Model] {
    def derived[H <: shapeless.HList](implicit
      x: shapeless.Generic.Aux[Model, H],
      n: PojoInstance[E, H]
    ): PojoInstance[E, Model] = n.asInstanceOf[PojoInstance[E, Model]]
  }

  object F {
    def apply[U[_], FMM[_[_]]]: ModelFBuilder[FMM[U]] = new ModelFBuilder[FMM[U]]
  }
  type F[U[_], FMM[_[_]]] = FMM[U]

  object Pojo {
    def apply[U[_], Model]: ModelPojoBuilder[U, Model] = new ModelPojoBuilder[U, Model]
  }
  type Pojo[U[_], Model] = PojoInstance[U, Model]

}
