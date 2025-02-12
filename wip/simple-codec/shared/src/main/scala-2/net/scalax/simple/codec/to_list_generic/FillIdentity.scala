package net.scalax.simple.codec
package to_list_generic

import shapeless.{::, Generic, HList, HNil}

trait FillIdentity[T] {
  def value: T
}

object FillIdentity {

  implicit def hlistImplicit1[T, Tail <: HList](implicit u: T, t1: FillIdentity[Tail]): FillIdentity[T :: Tail] =
    new FillIdentity[T :: Tail] {
      override val value: T :: Tail = u :: t1.value
    }

  implicit val hlistHNilImplicit2: FillIdentity[HNil] = new FillIdentity[HNil] {
    override val value: HNil = HNil
  }

  final class Builder[T] {
    def derived[H <: HList](implicit generic: Generic.Aux[T, H], filler: FillIdentity[H]): T = generic.from(filler.value)
  }

  def apply[T]: Builder[T] = new Builder

}
