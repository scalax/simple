package net.scalax.simple.codec
package to_list_generic

import shapeless._

trait ToListGenerc[F[_[_]]] {
  def toList[T](input: F[({ type U1[_] = T })#U1]): List[T]
}

object ToListGenerc {
  type IdImpl[T] = T

  trait HListFuncMapGeneric[Target1, T] {
    def output(o: Target1): List[T]
  }
  object HListFuncMapGeneric {
    implicit def implicit1[T, HL1 <: HList](implicit
      tail: HListFuncMapGeneric[HL1, T]
    ): HListFuncMapGeneric[T :: HL1, T] = new HListFuncMapGeneric[T :: HL1, T] {
      override def output(o: T :: HL1): List[T] = o.head :: tail.output(o.tail)
    }
    implicit def implicit2[T]: HListFuncMapGeneric[HNil, T] = new HListFuncMapGeneric[HNil, T] {
      override def output(o: HNil): List[T] = List.empty
    }
  }

  trait HListFuncMapGenericGen[Target1, T] {
    def generic(implicit i: HListFuncMapGeneric[Target1, T]): HListFuncMapGeneric[Target1, T] = i
  }
  object HListFuncMapGenericGen {
    def apply[Target1, T]: HListFuncMapGenericGen[Target1, T] = new HListFuncMapGenericGen[Target1, T] {
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
      genericFunc: HListFuncMapGenericGen[Target1, U] => HListFuncMapGeneric[Target1, U]
    ): F[({ type U1[_] = U })#U1] => List[U] = fu => genericFunc(HListFuncMapGenericGen[Target1, U]).output(simpleTo.to(fu))
  }

  trait Impl[F[_[_]]] extends ToListGenerc[F] {
    def impl1[U]: SimpleFuncion1Impl[F, U] => F[({ type U1[_] = U })#U1] => List[U]
    override def toList[T](input: F[({ type U1[_] = T })#U1]): List[T] = impl1[T](new SimpleFuncion1Impl[F, T])(input)
  }
}
