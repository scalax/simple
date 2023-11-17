package net.scalax.simple.codec.function_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}

trait FuncIndex1[F[_[_]]] {
  def input[In1[_], In2[_], Out[_]](func3k: F[FunctionKCol.Func3K[In1, In2, Out]#Input]): (F[In1], F[In2]) => F[Out]
}

object FuncIndex1 {

  type MatchT1[u <: Tuple] <: Tuple = u match {
    case ((h1, h2) => h3) *: t => h1 *: MatchT1[t]
    case EmptyTuple            => EmptyTuple
  }
  type MatchT2[u <: Tuple] <: Tuple = u match {
    case ((h1, h2) => h3) *: t => h2 *: MatchT2[t]
    case EmptyTuple            => EmptyTuple
  }
  type MatchT3[u <: Tuple] <: Tuple = u match {
    case ((h1, h2) => h3) *: t => h3 *: MatchT3[t]
    case EmptyTuple            => EmptyTuple
  }

  trait Func3ModelTrans[Input, -F1, -F2, +F3] {
    def input(i: Input): (F1, F2) => F3
  }
  object Func3ModelTrans {
    def tranImpl: Func3ModelTrans[Tuple, Tuple, Tuple, Tuple] = new Func3ModelTrans[Tuple, Tuple, Tuple, Tuple] {
      self =>
      override def input(i: Tuple): (Tuple, Tuple) => Tuple = i match {
        case (head: ((Any, Any) => Any)) *: tail =>
          (tuple2_1, tuple2_2) =>
            (tuple2_1, tuple2_2) match {
              case ((h1 *: tail1), (h2 *: tail2)) => head(h1, h2) *: self.input(tail)(tail1, tail2)
            }
        case EmptyTuple => (emptyTuple1, _) => EmptyTuple
      }
    }

    def tran[Input, F1, F2, F3]: Func3ModelTrans[Input, F1, F2, F3] = tranImpl.asInstanceOf
  }

  trait Func3ModelTransGeneric[Input <: Tuple] {
    def generic: Func3ModelTrans[Input, MatchT1[Input], MatchT2[Input], MatchT3[Input]] = Func3ModelTrans.tran
  }
  object Func3ModelTransGeneric {
    def apply[Input <: Tuple]: Func3ModelTransGeneric[Input] = new Func3ModelTransGeneric[Input] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_], In2[_], In3[_]] {
    def derived2[H1 <: Tuple](generic1: SimpleTo[F[FunctionKCol.Func3K[In1, In2, In3]#Input], H1]): InnerApply1[F, In1, In2, In3, H1] =
      new InnerApply1[F, In1, In2, In3, H1](generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], In3[_], H1 <: Tuple](to: SimpleTo[F[FunctionKCol.Func3K[In1, In2, In3]#Input], H1]) {
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
