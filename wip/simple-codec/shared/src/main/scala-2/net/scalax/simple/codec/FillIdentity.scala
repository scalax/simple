package net.scalax.simple.codec

import shapeless._

trait FillIdentity[F[_[_]], I[_]] {
  def model: F[I]
}

object FillIdentity {
  trait FillIdentityImpl[H] {
    def fillResult: H
  }
  object FillIdentityImpl {
    implicit def implicit1[H1, Tail <: HList](implicit h: H1, t: FillIdentityImpl[Tail]): FillIdentityImpl[H1 :: Tail] =
      new FillIdentityImpl[H1 :: Tail] {
        override def fillResult: H1 :: Tail = h :: t.fillResult
      }
    implicit val implicit2: FillIdentityImpl[HNil] = new FillIdentityImpl[HNil] {
      override val fillResult: HNil = HNil
    }
  }

  trait DerivedApply[F[_[_]], I[_]] {
    def derived[H1](implicit generic1: Generic.Aux[F[I], H1], generic2: FillIdentityImpl[H1]): FillIdentity[F, I] = new FillIdentity[F, I] {
      override def model: F[I] = generic1.from(generic2.fillResult)
    }
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I] = new DerivedApply[F, I] {
    //
  }

}
