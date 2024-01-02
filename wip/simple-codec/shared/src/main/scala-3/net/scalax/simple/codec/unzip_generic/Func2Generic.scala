package net.scalax.simple.codec
package unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}

trait Func50GenericImpl[F[_[_]]] extends FunctionNGenericSum[F] {
  self =>
  override def function0[T[_]](func1: Function0Apply[T]): F[T]
  override def function1[T1[_], T2[_]](func1: Function1Apply[T1, T2])(f1: F[T1]): F[T2] = super.function1[T1, T2](func1)(f1)
  override def function2[S[_], T[_], U[_]](func1: Function2Apply[S, T, U])(f1: F[S], f2: F[T]): F[U]
}

object Func50Generic {
  type IdImpl[T] = T

  type Match1[InTuple, S[_]] = InTuple match {
    case h *: tail  => S[h] *: Match1[tail, S]
    case EmptyTuple => EmptyTuple
  }

  // ===
  trait HListFuncMap[HListInput, FuncOut, S[_]] {
    def input(func: Function0Apply[S]): FuncOut
  }
  object HListFuncMap {
    private def instanceImpl(size: Int): HListFuncMap[Tuple, Tuple, [x] =>> Any] = new HListFuncMap[Tuple, Tuple, [x] =>> Any] {
      self =>
      override def input(func: Function0Apply[[x] =>> Any]): Tuple = {
        def sizeOfTuple(s: Int): Tuple = if (s > 0) func[Any] *: sizeOfTuple(s - 1) else EmptyTuple
        sizeOfTuple(size)
      }
    }

    def instance[U <: Tuple, S[_], T[_]](using ValueOf[Tuple.Size[U]]): HListFuncMap[U, Match1[U, S], S] = instanceImpl(
      summon[ValueOf[Tuple.Size[U]]].value
    ).asInstanceOf
  }

  trait HListFuncMapGeneric[In <: Tuple, S[_]] {
    def generic(using ValueOf[Tuple.Size[In]]): HListFuncMap[In, Match1[In, S], S] = HListFuncMap.instance
  }
  object HListFuncMapGeneric {
    def apply[In <: Tuple, S[_]]: HListFuncMapGeneric[In, S] = new HListFuncMapGeneric[In, S] {
      //
    }
  }

  // ===
  type MatchZip1[In, S[_]] <: Tuple = In match {
    case h *: tail  => S[h] *: MatchZip1[tail, S]
    case EmptyTuple => EmptyTuple
  }

  // ===
  trait HListZipMap[HListInput, S[_], T[_], G[_], ZipIn, Out1, Out2] {
    def input(in1: Function2Apply[S, T, G]): (ZipIn, Out1) => Out2
  }
  object HListZipMap {
    private val instanceImpl: HListZipMap[Any, [x] =>> Any, [x] =>> Any, [x] =>> Any, Tuple, Tuple, Tuple] =
      new HListZipMap[Any, [x] =>> Any, [x] =>> Any, [x] =>> Any, Tuple, Tuple, Tuple] {
        self =>
        override def input(in1: Function2Apply[[x] =>> Any, [x] =>> Any, [x] =>> Any]): (Tuple, Tuple) => Tuple = {
          (_, _).match
            case ((h1 *: tail1), (h2 *: tail2)) =>
              val newTail = self.input(in1)(tail1, tail2)
              (in1(h1, h2)) -> newTail
            case (EmptyTuple, EmptyTuple) => EmptyTuple
        }
      }

    def instance[U, S[_], T[_], G[_]]: HListZipMap[U, S, T, G, MatchZip1[U, S], MatchZip1[U, T], MatchZip1[U, G]] =
      instanceImpl.asInstanceOf
  }

  trait HListZipMapGeneric[In, S[_], T[_], G[_]] {
    def generic: HListZipMap[In, S, T, G, MatchZip1[In, S], MatchZip1[In, T], MatchZip1[In, G]] = HListZipMap.instance
  }
  object HListZipMapGeneric {
    def apply[In, S[_], T[_], G[_]]: HListZipMapGeneric[In, S, T, G] = new HListZipMapGeneric[In, S, T, G] {
      //
    }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], S[_]] {
    self =>
    def derived2[Target1 <: Tuple, Target2](
      simpleTo: SimpleTo[F[IdImpl], Target1],
      simpleFrom: SimpleFrom[F[S], Target2]
    ): FuncInnerApply1[F, S, Target1, Target2] = new FuncInnerApply1[F, S, Target1, Target2](simpleFrom = simpleFrom)
  }

  class FuncInnerApply1[F[_[_]], S[_], Target1 <: Tuple, Target2](simpleFrom: SimpleFrom[F[S], Target2]) {
    def apply(genericFunc: HListFuncMapGeneric[Target1, S] => HListFuncMap[Target1, Target2, S]): Function0Apply[S] => F[S] = applyM =>
      simpleFrom.from(genericFunc(HListFuncMapGeneric[Target1, S]).input(applyM))
  }

  // ===
  class SimpleUnZip2Impl[F[_[_]], S[_], T[_], G[_]] {
    self =>
    def derived2[HListBoot, HListInput1, HListInput2, HListOut1](
      simpleTo: SimpleTo[F[IdImpl], HListBoot],
      to1: SimpleTo[F[S], HListInput1],
      to2: SimpleTo[F[T], HListInput2],
      from1: SimpleFrom[F[G], HListOut1]
    ): ZipInnerApply1[F, S, T, G, HListBoot, HListInput1, HListInput2, HListOut1] =
      new ZipInnerApply1[F, S, T, G, HListBoot, HListInput1, HListInput2, HListOut1](to1 = to1, to2 = to2, from1 = from1)
  }

  class ZipInnerApply1[F[_[_]], S[_], T[_], G[_], HListBoot, HListInput1, HListInput2, HListOut1](
    to2: SimpleTo[F[T], HListInput2],
    to1: SimpleTo[F[S], HListInput1],
    from1: SimpleFrom[F[G], HListOut1]
  ) {
    def apply(
      genericFunc: HListZipMapGeneric[HListBoot, S, T, G] => HListZipMap[HListBoot, S, T, G, HListInput1, HListInput2, HListOut1]
    ): Function2Apply[S, T, G] => (F[S], F[T]) => F[G] = in1 =>
      (fs, ft) => from1.from(genericFunc(HListZipMapGeneric[HListBoot, S, T, G]).input(in1)(to1.to(fs), to2.to(ft)))
  }

  trait Impl[F[_[_]]] extends Func50GenericImpl[F] {
    def impl1[T1[_]]: SimpleFuncion1Impl[F, T1] => Function0Apply[T1] => F[T1]
    def impl2[T1[_], T2[_], T3[_]]: SimpleUnZip2Impl[F, T1, T2, T3] => Function2Apply[T1, T2, T3] => (F[T1], F[T2]) => F[T3]
    override def function0[T[_]](func: Function0Apply[T]): F[T] = impl1[T](new SimpleFuncion1Impl[F, T])(func)
    override def function2[S[_], T[_], U[_]](func2Func: Function2Apply[S, T, U])(f1: F[S], f2: F[T]): F[U] =
      impl2[S, T, U](new SimpleUnZip2Impl[F, S, T, U])(func2Func)(f1, f2)
  }

}
