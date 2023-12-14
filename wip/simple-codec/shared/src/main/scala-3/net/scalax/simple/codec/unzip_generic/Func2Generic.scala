package net.scalax.simple.codec
package unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}

trait Func2Generic[F[_[_]]] extends FunctionNGenericSum[F] {
  self =>
  override def function0[T[_]](func1: Function0Apply[T]): F[T]
  override def function1[T1[_], T2[_]](func1: Function1Apply[T1, T2])(f1: F[T1]): F[T2] = super.function1[T1, T2](func1)(f1)
  override def function2[S[_], T[_], U[_]](func1: Function2Apply[S, T, U])(f1: F[S], f2: F[T]): F[U]
}

object Func2Generic {
  type IdImpl[T] = T

  type Match1[In <: Tuple, S[_]] <: Tuple = In match {
    case h *: tail  => S[h] *: Match1[tail, S]
    case EmptyTuple => EmptyTuple
  }

  // ===
  trait HListFuncMap[HListInput, S[_], FuncOut] {
    def input(func: Function0Apply[S]): FuncOut
  }
  object HListFuncMap {
    private def instanceImpl(size: Int): HListFuncMap[Tuple, [x] =>> Any, Tuple] =
      new HListFuncMap[Tuple, [x] =>> Any, Tuple] {
        self =>
        override def input(func: Function0Apply[[x] =>> Any]): Tuple = {
          def sizeOfTuple(s: Int): Tuple = if (s > 0) func[Any] *: sizeOfTuple(s - 1) else EmptyTuple
          sizeOfTuple(size)
        }
      }

    def instance[U <: Tuple, S[_], T[_]](using ValueOf[Tuple.Size[U]]): HListFuncMap[U, S, Match1[U, S]] = instanceImpl(
      summon[ValueOf[Tuple.Size[U]]].value
    ).asInstanceOf
  }

  trait HListFuncMapGeneric[In <: Tuple, S[_]] {
    def generic(using ValueOf[Tuple.Size[In]]): HListFuncMap[In, S, Match1[In, S]] = HListFuncMap.instance
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
    def derived2[Target1 <: Tuple](simpleTo: SimpleTo[F[IdImpl], Target1]): FuncInnerApply1[F, S, Target1] =
      new FuncInnerApply1[F, S, Target1]
  }

  class FuncInnerApply1[F[_[_]], S[_], Target1 <: Tuple] {
    def apply[U1](
      genericFunc: HListFuncMapGeneric[Target1, S] => HListFuncMap[Target1, S, U1]
    ): FuncInnerApply2[F, S, U1, Target1] =
      new FuncInnerApply2[F, S, U1, Target1](genericFunc(HListFuncMapGeneric[Target1, S]))
  }

  class FuncInnerApply2[F[_[_]], S[_], U1, Unused](t: HListFuncMap[Unused, S, U1]) {
    def apply(
      simpleTo: SimpleFrom[F[S], U1]
    ): Function0Apply[S] => F[S] = u => simpleTo.from(t.input(u))
  }

  // ===
  class SimpleUnZip2Impl[F[_[_]], S[_], T[_], G[_]] {
    self =>
    def derived2[Target1 <: Tuple](simpleTo: SimpleTo[F[IdImpl], Target1]): ZipInnerApply1[F, S, T, G, Target1] =
      new ZipInnerApply1[F, S, T, G, Target1]
  }

  class ZipInnerApply1[F[_[_]], S[_], T[_], G[_], Target1 <: Tuple] {
    def apply[ZipInput, U1, U2](
      genericFunc: HListZipMapGeneric[Target1, S, T, G] => HListZipMap[Target1, S, T, G, ZipInput, U1, U2]
    ): ZipInnerApply2[F, S, T, G, ZipInput, U1, U2, Target1] =
      new ZipInnerApply2[F, S, T, G, ZipInput, U1, U2, Target1](genericFunc(HListZipMapGeneric[Target1, S, T, G]))
  }

  class ZipInnerApply2[F[_[_]], S[_], T[_], G[_], ZipInput, U1, U2, Unused](t: HListZipMap[Unused, S, T, G, ZipInput, U1, U2]) {
    def apply(
      to1: SimpleTo[F[S], ZipInput],
      to2: SimpleTo[F[T], U1],
      from1: SimpleFrom[F[G], U2]
    ): Function2Apply[S, T, G] => (F[S], F[T]) => F[G] = in1 => (fs, ft) => from1.from(t.input(in1)(to1.to(fs), to2.to(ft)))
  }

  trait Impl[F[_[_]]] extends Func2Generic[F] {
    def impl1[T1[_]]: SimpleFuncion1Impl[F, T1] => Function0Apply[T1] => F[T1]
    def impl2[T1[_], T2[_], T3[_]]: SimpleUnZip2Impl[F, T1, T2, T3] => Function2Apply[T1, T2, T3] => (F[T1], F[T2]) => F[T3]
    override def function0[T[_]](func: Function0Apply[T]): F[T] = impl1[T](new SimpleFuncion1Impl[F, T])(func)
    override def function2[S[_], T[_], U[_]](func2Func: Function2Apply[S, T, U])(f1: F[S], f2: F[T]): F[U] =
      impl2[S, T, U](new SimpleUnZip2Impl[F, S, T, U])(func2Func)(f1, f2)
  }

}
