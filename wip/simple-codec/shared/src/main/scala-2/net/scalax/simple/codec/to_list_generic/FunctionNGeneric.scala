package net.scalax.simple.codec
package to_list_generic

import shapeless._

trait ToListGenerc[F[_[_]]] {
  def toList[T](input: F[({ type U1[_] = T })#U1]): List[T]
}

object ToListGenerc {
  type IdImpl[T] = T

  trait HListFuncMapGeneric[Target1, Target2, T] {
    def output(o: Target2): List[T]
  }
  object HListFuncMapGeneric {
    implicit def implicit1[T1, T2, HL1 <: HList, HL2 <: HList](implicit
      tail: HListFuncMapGeneric[HL1, HL2, T2]
    ): HListFuncMapGeneric[T1 :: HL1, T2 :: HL2, T2] = new HListFuncMapGeneric[T1 :: HL1, T2 :: HL2, T2] {
      override def output(o: T2 :: HL2): List[T2] = o.head :: tail.output(o.tail)
    }
    implicit def implicit2[T2]: HListFuncMapGeneric[HNil, HNil, T2] = new HListFuncMapGeneric[HNil, HNil, T2] {
      override def output(o: HNil): List[T2] = List.empty
    }
  }

  trait HListFuncMapGenericGen[Target1, Target2, T] {
    def generic(implicit i: HListFuncMapGeneric[Target1, Target2, T]): HListFuncMapGeneric[Target1, Target2, T] = i
  }
  object HListFuncMapGenericGen {
    def apply[Target1, Target2, T]: HListFuncMapGenericGen[Target1, Target2, T] = new HListFuncMapGenericGen[Target1, Target2, T] {
      //
    }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], U] {
    self =>
    def derived2[Target1](
      simpleTo: SimpleTo[F[({ type U1[_] = U })#U1], Target1]
    ): FuncInnerApply1[F, U, Target1] = new FuncInnerApply1[F, U, Target1](simpleTo)
  }

  class FuncInnerApply1[F[_[_]], U, Target1](simpleTo: SimpleTo[F[({ type U1[_] = U })#U1], Target1]) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Target1, Target1, U] => HListFuncMapGeneric[Target1, Target1, U]
    ): F[({ type U1[_] = U })#U1] => List[U] = fu => genericFunc(HListFuncMapGenericGen[Target1, Target1, U]).output(simpleTo.to(fu))
  }

  trait Impl[F[_[_]]] extends ToListGenerc[F] {
    def impl[U]: SimpleFuncion1Impl[F, U] => F[({ type U1[_] = U })#U1] => List[U]
    override def toList[T](input: F[({ type U1[_] = T })#U1]): List[T] = impl[T](new SimpleFuncion1Impl[F, T])(input)
  }
}
