package net.scalax.simple.codec

import shapeless._
import CirceAlias.JsonObjectEncoder

trait UnFunctionGeneric[F[_[_]]] {
  def unfunction[T1[_], T2[_]](from: F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun]): F[T1] => F[T2]
}

object UnFunctionGeneric {
  class UnFunctionType[T1[_], T2[_]] {
    type UNFun[T] = T1[T] => T2[T]
  }

  trait Func1ModelTrans[Input, -F1, +F3] {
    def input(i: Input): F1 => F3
  }

  object Func1ModelTrans {
    implicit def implicit1[F1, F3, HFTailInput <: HList, HFTail1 <: HList, HFTail2 <: HList](implicit
      cv: Func1ModelTrans[HFTailInput, HFTail1, HFTail2]
    ): Func1ModelTrans[(F1 => F3) :: HFTailInput, F1 :: HFTail1, F3 :: HFTail2] =
      new Func1ModelTrans[(F1 => F3) :: HFTailInput, F1 :: HFTail1, F3 :: HFTail2] {
        override def input(i: (F1 => F3) :: HFTailInput): (F1 :: HFTail1) => (F3 :: HFTail2) =
          new ((F1 :: HFTail1) => (F3 :: HFTail2)) {
            override def apply(f1: F1 :: HFTail1): F3 :: HFTail2 = i.head(f1.head) :: cv.input(i.tail)(f1.tail)
          }
      }

    implicit val implicit2: Func1ModelTrans[HNil, HNil, HNil] = new Func1ModelTrans[HNil, HNil, HNil] {
      private val preFunc: HNil => HNil = identity[HNil]

      override def input(i: HNil): HNil => HNil = preFunc
    }
  }

}
