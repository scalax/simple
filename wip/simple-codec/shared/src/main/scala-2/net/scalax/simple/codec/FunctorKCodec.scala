package net.scalax.simple.codec

import shapeless._
import cats._

trait FunctorKCodec[F[_[_]]] {
  def mapK[I1[_], I2[_]](cv: I1 ~> I2): F[I1] => F[I2]
}

object FunctorKCodec {

  trait FillIdentityImpl[I1[_], I2[_], H1, H2] {
    def fillResult(cv: I1 ~> I2)(u1: I1[H1]): I2[H2]
  }

  /*object FillIdentityImpl {
    implicit def implicit1[H1, Tail <: HList](implicit h: H1, t: FillIdentityImpl[Tail]): FillIdentityImpl[H1 :: Tail] =
      new FillIdentityImpl[H1 :: Tail] {
        override def fillResult: H1 :: Tail = h :: t.fillResult
      }
    implicit val implicit2: FillIdentityImpl[HNil] = new FillIdentityImpl[HNil] {
      override val fillResult: HNil = HNil
    }
  }

  class DerivedApply[F[_[_]], I[_], ModelMode >: F[I] <: F[I]] {
    object law {
      def apply[Model >: ModelMode <: ModelMode]: DerivedApply[F, I, Model] = new DerivedApply[F, I, Model]
    }

    def derived[H1](implicit generic1: Generic.Aux[ModelMode, H1], generic2: FillIdentityImpl[H1]): FillIdentity[F, I] =
      new FillIdentity[F, I] {
        override def model: ModelMode = generic1.from(generic2.fillResult)
      }

    def instance(model: ModelMode): FillIdentity[F, I] = {
      val model1 = model
      new FillIdentity[F, I] {
        override def model: ModelMode = model1
      }
    }

    def summon(implicit model: FillIdentity[F, I]): FillIdentity[F, I] = model
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I, F[I]] = new DerivedApply[F, I, F[I]]*/

}
