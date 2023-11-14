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
        override val fillResult: H1 :: Tail = h :: t.fillResult
      }
    implicit val implicit2: FillIdentityImpl[HNil] = new FillIdentityImpl[HNil] {
      override val fillResult: HNil = HNil
    }
  }

  trait FillIdentityGeneric[H1] {
    def generic(implicit g: FillIdentityImpl[H1]): FillIdentityImpl[H1] = g
  }
  object FillIdentityGeneric {
    def apply[H1]: FillIdentityGeneric[H1] = new FillIdentityGeneric[H1] {
      //
    }
  }

  class DerivedApply[F[_[_]], I[_]] {
    /*object law {
      def apply[Model >: ModelMode <: ModelMode]: DerivedApply[F, I, Model] = new DerivedApply[F, I, Model]
    }*/

    def derived2[H1](generic1: SimpleFrom[F[I], H1]): InnerApply2[F, I, H1] = new InnerApply2(generic1)

    def instance(model: F[I]): FillIdentity[F, I] = {
      val model1 = model
      new FillIdentity[F, I] {
        override val model: F[I] = model1
      }
    }

    def summon(implicit model: FillIdentity[F, I]): FillIdentity[F, I] = model
  }

  class InnerApply2[F[_[_]], I[_], H1](simpleForm: SimpleFrom[F[I], H1]) {
    def apply(f: FillIdentityGeneric[H1] => FillIdentityImpl[H1]): FillIdentity[F, I] = new FillIdentity[F, I] {
      override val model: F[I] = simpleForm.from(f(FillIdentityGeneric[H1]).fillResult)
    }
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I] = new DerivedApply[F, I]

}
