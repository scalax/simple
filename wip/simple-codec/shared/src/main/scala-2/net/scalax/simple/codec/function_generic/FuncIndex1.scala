package net.scalax.simple.codec.function_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}
import shapeless._

trait FuncIndex1[F[_[_]]] {
  def input[In1[_], In2[_], Out[_]](func3k: F[FunctionKCol.Func3K[In1, In2, Out]#Input]): (F[In1], F[In2]) => F[Out]
}

object FuncIndex1 {

  trait Func3ModelTrans[Input, -F1, -F2, +F3] {
    def input(i: Input): (F1, F2) => F3
  }
  object Func3ModelTrans {
    implicit def implicit1[F1, F2, F3, HFTailInput <: HList, HFTail1 <: HList, HFTail2 <: HList, HFTail3 <: HList](implicit
      cv: Func3ModelTrans[HFTailInput, HFTail1, HFTail2, HFTail3]
    ): Func3ModelTrans[((F1, F2) => F3) :: HFTailInput, F1 :: HFTail1, F2 :: HFTail2, F3 :: HFTail3] =
      new Func3ModelTrans[((F1, F2) => F3) :: HFTailInput, F1 :: HFTail1, F2 :: HFTail2, F3 :: HFTail3] {
        override def input(i: ((F1, F2) => F3) :: HFTailInput): (F1 :: HFTail1, F2 :: HFTail2) => (F3 :: HFTail3) =
          new ((F1 :: HFTail1, F2 :: HFTail2) => (F3 :: HFTail3)) {
            override def apply(f1: F1 :: HFTail1, f2: F2 :: HFTail2): F3 :: HFTail3 =
              i.head(f1.head, f2.head) :: cv.input(i.tail)(f1.tail, f2.tail)
          }
      }
    implicit val implicit2: Func3ModelTrans[HNil, HNil, HNil, HNil] = new Func3ModelTrans[HNil, HNil, HNil, HNil] {
      private val preFunc: (HNil, HNil) => HNil = (i1, _) => i1

      override def input(i: HNil): (HNil, HNil) => HNil = preFunc
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
    def derived2[H1](generic1: SimpleTo[F[FunctionKCol.Func3K[In1, In2, In3]#Input], H1]): InnerApply1[F, In1, In2, In3, H1] =
      new InnerApply1[F, In1, In2, In3, H1](generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], In3[_], H1](to: SimpleTo[F[FunctionKCol.Func3K[In1, In2, In3]#Input], H1]) {
    def apply[II1, II2, II3](
      in: Func3ModelTransGeneric[H1] => Func3ModelTrans[H1, II1, II2, II3]
    ): InnerApply2[F, In1, In2, In3, II1, II2, II3] = new InnerApply2[F, In1, In2, In3, II1, II2, II3](input =>
      in(Func3ModelTransGeneric[H1]).input(to.to(input))
    )
  }
  class InnerApply2[F[_[_]], In1[_], In2[_], In3[_], II1, II2, II3](
    inOut: F[FunctionKCol.Func3K[In1, In2, In3]#Input] => (II1, II2) => II3
  ) {
    def apply(
      to1: SimpleTo[F[In1], II1],
      to2: SimpleTo[F[In2], II2],
      from3: SimpleFrom[F[In3], II3]
    ): F[FunctionKCol.Func3K[In1, In2, In3]#Input] => ((F[In1], F[In2]) => F[In3]) =
      inOut.andThen(t => (f1: F[In1], f2: F[In2]) => from3.from(t(to1.to(f1), to2.to(f2))))
  }

  def apply[F[_[_]], In1[_], In2[_], In3[_]]: DerivedApply[F, In1, In2, In3] = new DerivedApply[F, In1, In2, In3]

}
