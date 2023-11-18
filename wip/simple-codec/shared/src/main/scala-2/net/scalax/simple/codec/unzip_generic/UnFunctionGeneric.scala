package net.scalax.simple.codec

import shapeless._

trait UnFunctionGeneric[F[_[_]]] {
  def unfunction[T1[_], T2[_]](from: F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun]): F[T1] => F[T2]
}

object UnFunctionGeneric {
  class UnFunctionType[T1[_], T2[_]] {
    type UNFun[T] = T1[T] => T2[T]
  }

  trait Impl[F[_[_]]] extends UnFunctionGeneric[F] {
    type FuncImpl[T1[_], T2[_]] = UnFunctionType[T1, T2]
    def impl[T1[_], T2[_]]: (DerivedApply[F, T1, T2] => (F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun] => (F[T1] => F[T2])))
    override def unfunction[T1[_], T2[_]](from: F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun]): F[T1] => F[T2] =
      impl[T1, T2](UnFunctionGeneric[F, T1, T2])(from)
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

  trait Func1ModelTransGeneric[Input] {
    def generic[I1, I2](implicit i: Func1ModelTrans[Input, I1, I2]): Func1ModelTrans[Input, I1, I2] = i
  }
  object Func1ModelTransGeneric {
    def apply[I]: Func1ModelTransGeneric[I] = new Func1ModelTransGeneric[I] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_], In2[_]] {
    def derived2[H1](generic1: SimpleTo[F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun], H1]): InnerApply1[F, In1, In2, H1] =
      new InnerApply1[F, In1, In2, H1](generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], H1](generic: SimpleTo[F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun], H1]) {
    def apply[H2, H3](func1: Func1ModelTransGeneric[H1] => Func1ModelTrans[H1, H2, H3]): InnerApply2[F, In1, In2, H1, H2, H3] =
      new InnerApply2[F, In1, In2, H1, H2, H3](generic = generic, funcTrans = func1(Func1ModelTransGeneric[H1]))
  }
  class InnerApply2[F[_[_]], In1[_], In2[_], H1, H2, H3](
    generic: SimpleTo[F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun], H1],
    funcTrans: Func1ModelTrans[H1, H2, H3]
  ) {
    def apply(
      g1: SimpleTo[F[In1], H2],
      g2: SimpleFrom[F[In2], H3]
    ): F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun] => (F[In1] => F[In2]) = { input => f1 =>
      g2.from(funcTrans.input(generic.to(input))(g1.to(f1)))
    }
  }

  def apply[F[_[_]], In1[_], In2[_]]: DerivedApply[F, In1, In2] = new DerivedApply[F, In1, In2]

}
