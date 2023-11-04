package net.scalax.simple.codec

import shapeless._

trait NewFuncTyped[F[_[_]]] {
  def input[In1[_], In2[_], Out[_]](func3k: F[NewFuncTyped.Func3K[In1, In2, Out]#Input]): NewFuncTyped.Func3Model[F[In1], F[In2], F[Out]]
}

object NewFuncTyped {
  trait Func3K[In1[_], In2[_], In3[_]] {
    def input[T]: Func3Model[In1[T], In2[T], In3[T]]
    type Input[T] = Func3Model[In1[T], In2[T], In3[T]]
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

  trait Func3ModelTransGeneric[Input] {
    def generic[In1, In2, In3](implicit t: Func3ModelTrans[Input, In1, In2, In3]): Func3ModelTrans[Input, In1, In2, In3] = t
  }
  object Func3ModelTransGeneric {
    def apply[Input]: Func3ModelTransGeneric[Input] = new Func3ModelTransGeneric[Input] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_], In2[_], In3[_]] {
    def derived2[H1](generic1: SimpleTo[F[Func3K[In1, In2, In3]#Input], H1]): InnerApply1[F, In1, In2, In3, H1] =
      new InnerApply1[F, In1, In2, In3, H1](generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], In3[_], H1](to: SimpleTo[F[Func3K[In1, In2, In3]#Input], H1]) {
    def apply[II1, II2, II3](
      in: Func3ModelTransGeneric[H1] => Func3ModelTrans[H1, II1, II2, II3]
    ): InnerApply2[F, In1, In2, In3, II1, II2, II3] = new InnerApply2[F, In1, In2, In3, II1, II2, II3](input =>
      in(Func3ModelTransGeneric[H1]).input(to.to(input))
    )
  }
  class InnerApply2[F[_[_]], In1[_], In2[_], In3[_], II1, II2, II3](inOut: F[Func3K[In1, In2, In3]#Input] => Func3Model[II1, II2, II3]) {
    def apply(
      to1: SimpleTo[F[In1], II1],
      to2: SimpleTo[F[In2], II2],
      from3: SimpleFrom[F[In3], II3]
    ): F[NewFuncTyped.Func3K[In1, In2, In3]#Input] => NewFuncTyped.Func3Model[F[In1], F[In2], F[In3]] = inOut.andThen(t =>
      new Func3Model[F[In1], F[In2], F[In3]] {
        override def input(f1: F[In1], f2: F[In2]): F[In3] = from3.from(t.input(to1.to(f1), to2.to(f2)))
      }
    )
  }

  def apply[F[_[_]], In1[_], In2[_], In3[_]]: DerivedApply[F, In1, In2, In3] = new DerivedApply[F, In1, In2, In3]

}
