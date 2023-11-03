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

  class DerivedApply[F[_[_]], I[_]] {
    /*object law {
      def apply[Model >: ModelMode <: ModelMode]: DerivedApply[F, I, Model] = new DerivedApply[F, I, Model]
    }*/

    def derived1[H1](generic1: SimpleFrom[F[I], H1])(implicit generic2: FillIdentityImpl[H1]): FillIdentity[F, I] =
      new FillIdentity[F, I] {
        override def model: F[I] = generic1.from(generic2.fillResult)
      }

    def instance(model: F[I]): FillIdentity[F, I] = {
      val model1 = model
      new FillIdentity[F, I] {
        override def model: F[I] = model1
      }
    }

    def summon(implicit model: FillIdentity[F, I]): FillIdentity[F, I] = model
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I] = new DerivedApply[F, I]

}
