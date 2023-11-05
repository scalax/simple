package net.scalax.simple.codec.function_generic

import net.scalax.simple.codec.SimpleFrom
import shapeless._

trait FuncIndex3[F[_[_]]] {
  def input[In1[_]](func3k: FunctionKCol.Func1K[In1]): F[In1]
}

object FuncIndex3 {

  trait Func1ModelTrans[In1[_], +F1] {
    def input(i: FunctionKCol.Func1K[In1]): F1
  }
  object Func1ModelTrans {
    implicit def implicit1[F1, In1[_], HFTail1 <: HList](implicit
      cv: Func1ModelTrans[In1, HFTail1]
    ): Func1ModelTrans[In1, In1[F1] :: HFTail1] = new Func1ModelTrans[In1, In1[F1] :: HFTail1] {
      override def input(i: FunctionKCol.Func1K[In1]): In1[F1] :: HFTail1 = i.input[F1] :: cv.input(i)
    }
    implicit def implicit2[In1[_]]: Func1ModelTrans[In1, HNil] = new Func1ModelTrans[In1, HNil] {
      override def input(i: FunctionKCol.Func1K[In1]): HNil = HNil
    }
  }

  trait Func1ModelTransGeneric[In1[_], F1] {
    def generic(implicit t: Func1ModelTrans[In1, F1]): Func1ModelTrans[In1, F1] = t
  }
  object Func1ModelTransGeneric {
    def apply[In1[_], F1]: Func1ModelTransGeneric[In1, F1] = new Func1ModelTransGeneric[In1, F1] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_]] {
    def derived2[H1](generic1: SimpleFrom[F[In1], H1]): InnerApply1[F, In1, H1] = new InnerApply1[F, In1, H1](generic1)
  }
  class InnerApply1[F[_[_]], In1[_], H1](g1: SimpleFrom[F[In1], H1]) {
    def apply(u: Func1ModelTransGeneric[In1, H1] => Func1ModelTrans[In1, H1]): FunctionKCol.Func1K[In1] => F[In1] = func1k =>
      g1.from(u(Func1ModelTransGeneric[In1, H1]).input(func1k))
  }

  def apply[F[_[_]], In1[_]]: DerivedApply[F, In1] = new DerivedApply[F, In1]

}
