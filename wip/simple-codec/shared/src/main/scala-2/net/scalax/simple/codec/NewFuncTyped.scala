package net.scalax.simple.codec

import shapeless._

trait NewFuncTyped[F[_[_]]] {
  def input[In1[_], In2[_], Out[_]](func3k: NewFuncTyped.Func3K[In1, In2, Out]): NewFuncTyped.Func3Model[F[In1], F[In2], F[Out]]
}

object NewFuncTyped {
  trait Func3K[-In1[_], -In2[_], +In3[_]] {
    def input[T]: Func3Model[In1[T], In2[T], In3[T]]
  }

  trait Func3Model[-F1, -F2, +F3] {
    def input(f1: F1, f2: F2): F3
  }

  trait Func3ModelTrans[Input, -F1, -F2, +F3] {
    def input(i: Input): Func3Model[F1, F2, F3]
  }
  object Func3ModelTrans {
    implicit def implicit1[F1, F2, F3, HFTailInput <: HList, HFTail1 <: HList, HFTail2 <: HList, HFTail3 <: HList](implicit
      cv: Func3ModelTrans[HFTailInput, HFTail1, HFTail2, HFTail3]
    ): Func3ModelTrans[Func3Model[F1, F2, F3] :: HFTailInput, F1 :: HFTail1, F2 :: HFTail2, F3 :: HFTail3] =
      new Func3ModelTrans[Func3Model[F1, F2, F3] :: HFTailInput, F1 :: HFTail1, F2 :: HFTail2, F3 :: HFTail3] {
        override def input(i: Func3Model[F1, F2, F3] :: HFTailInput): Func3Model[F1 :: HFTail1, F2 :: HFTail2, F3 :: HFTail3] =
          new Func3Model[F1 :: HFTail1, F2 :: HFTail2, F3 :: HFTail3] {
            override def input(f1: F1 :: HFTail1, f2: F2 :: HFTail2): F3 :: HFTail3 =
              i.head.input(f1.head, f2.head) :: cv.input(i.tail).input(f1.tail, f2.tail)
          }
      }
    implicit val implicit2: Func3ModelTrans[HNil, HNil, HNil, HNil] = new Func3ModelTrans[HNil, HNil, HNil, HNil] {
      private val preFunc: Func3Model[HNil, HNil, HNil] = new Func3Model[HNil, HNil, HNil] {
        override def input(f1: HNil, f2: HNil): HNil = HNil
      }

      override def input(i: HNil): Func3Model[HNil, HNil, HNil] = preFunc
    }
  }

  trait Func3ModelTransGeneric[Input]
  object Func3ModelTransGeneric {
    def apply[Input]: Func3ModelTransGeneric[Input] = new Func3ModelTransGeneric[Input] {
      //
    }
  }

}
