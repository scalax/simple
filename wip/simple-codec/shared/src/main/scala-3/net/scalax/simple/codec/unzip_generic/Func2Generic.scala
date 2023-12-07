package net.scalax.simple.codec.unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}

trait Func2Generic[F[_[_]]] {
  def unfunction[S[_], T[_]](func: Func2Generic.Func2Func[S, T]): F[S] => F[T]
}

object Func2Generic {
  type IdImpl[T]  = T
  type AnyImpl[T] = Any

  trait Func2Func[S[_], T[_]] {
    def apply[U](in: S[U]): T[U]
  }

  type Match1[In, S[_]] <: Tuple = In match {
    case h *: tail  => S[h] *: Match1[tail, S]
    case EmptyTuple => EmptyTuple
  }

  trait HListFuncMap[HListInput, S[_], T[_], FuncIn, FuncOut] {
    def input(func: Func2Func[S, T]): FuncIn => FuncOut
  }
  object HListFuncMap {
    private val instanceImpl: HListFuncMap[Any, AnyImpl, AnyImpl, Tuple, Tuple] = new HListFuncMap[Any, AnyImpl, AnyImpl, Tuple, Tuple] {
      self =>
      override def input(func: Func2Func[AnyImpl, AnyImpl]): Tuple => Tuple = _.match {
        case h *: tail  => func(h) *: self.input(func)(tail)
        case EmptyTuple => EmptyTuple
      }
    }

    def instance[U, S[_], T[_]]: HListFuncMap[U, S, T, Match1[U, S], Match1[U, T]] = instanceImpl.asInstanceOf
  }

  trait HListFuncMapGeneric[In, S[_], T[_]] {
    def generic: HListFuncMap[In, S, T, Match1[In, S], Match1[In, T]] = HListFuncMap.instance
  }
  object HListFuncMapGeneric {
    def apply[In, S[_], T[_]]: HListFuncMapGeneric[In, S, T] = new HListFuncMapGeneric[In, S, T] {
      //
    }
  }

  class SimpleFuncion2Impl[F[_[_]], S[_], T[_]] {
    self =>
    def derived2[Target1](simpleTo: SimpleTo[F[IdImpl], Target1]): FuncInnerApply1[F, S, T, Target1] = new FuncInnerApply1[F, S, T, Target1]
  }

  class FuncInnerApply1[F[_[_]], S[_], T[_], Target1] {
    def apply[U1, U2](
      genericFunc: HListFuncMapGeneric[Target1, S, T] => HListFuncMap[Target1, S, T, U1, U2]
    ): FuncInnerApply2[F, S, T, U1, U2, Target1] =
      new FuncInnerApply2[F, S, T, U1, U2, Target1](genericFunc(HListFuncMapGeneric[Target1, S, T]))
  }

  class FuncInnerApply2[F[_[_]], S[_], T[_], U1, U2, Unused](t: HListFuncMap[Unused, S, T, U1, U2]) {
    def apply(
      simpleTo: SimpleTo[F[S], U1],
      simpleFrom: SimpleFrom[F[T], U2]
    ): Func2Func[S, T] => F[S] => F[T] = u => f => simpleFrom.from(t.input(u)(simpleTo.to(f)))
  }

  trait Impl[F[_[_]]] extends Func2Generic[F] {
    def impl[T1[_], T2[_]]: SimpleFuncion2Impl[F, T1, T2] => Func2Func[T1, T2] => F[T1] => F[T2]
    override def unfunction[T1[_], T2[_]](func: Func2Generic.Func2Func[T1, T2]): F[T1] => F[T2] =
      impl[T1, T2](new SimpleFuncion2Impl[F, T1, T2])(func)
  }

}

class BB(val aa: String) extends AnyVal
