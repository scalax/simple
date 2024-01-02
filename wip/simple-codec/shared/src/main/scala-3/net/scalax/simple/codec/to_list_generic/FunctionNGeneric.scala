package net.scalax.simple.codec
package to_list_generic

trait ToListGenerc[F[_[_]]] {
  def toList[T](input: F[({ type U1[_] = T })#U1]): List[T]
}

object ToListGenerc {
  type IdImpl[T] = T

  type Macher1[A1, T] <: Tuple = T match {
    case h *: tail  => A1 *: Macher1[A1, tail]
    case EmptyTuple => EmptyTuple
  }

  trait HListFuncMapGeneric[Target1, Target2, T] {
    def output(o: Target1): List[T]
  }
  object HListFuncMapGeneric {
    private val applyAny: HListFuncMapGeneric[Tuple, Tuple, Any] = new HListFuncMapGeneric[Tuple, Tuple, Any] {
      self =>
      override def output(o: Tuple): List[Any] = if (o.size > 0) {
        self.output(o.asInstanceOf[Any *: Tuple].tail)
      } else List.empty
    }
    def apply[Target1, T]: HListFuncMapGeneric[Target1, Macher1[T, Target1], T] =
      applyAny.asInstanceOf[HListFuncMapGeneric[Target1, Macher1[T, Target1], T]]
  }

  trait HListFuncMapGenericGen[Target1, T] {
    def generic: HListFuncMapGeneric[Target1, Macher1[T, Target1], T] = HListFuncMapGeneric[Target1, T]
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
      genericFunc: HListFuncMapGenericGen[Target1, U] => HListFuncMapGeneric[Target1, Target1, U]
    ): F[({ type U1[_] = U })#U1] => List[U] = fu => genericFunc(HListFuncMapGenericGen[Target1, U]).output(simpleTo.to(fu))
  }

  trait Impl[F[_[_]]] extends ToListGenerc[F] {
    def impl[U]: SimpleFuncion1Impl[F, U] => (F[({ type U1[_] = U })#U1] => List[U])
    override def toList[T](input: F[({ type U1[_] = T })#U1]): List[T] = impl[T](new SimpleFuncion1Impl[F, T])(input)
  }
}
