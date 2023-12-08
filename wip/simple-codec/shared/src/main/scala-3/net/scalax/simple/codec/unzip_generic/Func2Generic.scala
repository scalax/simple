package net.scalax.simple.codec.unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}

trait Func2Generic[F[_[_]]] {
  def unfunction[S[_], T[_]](func: Func2Generic.Func2Func[S, T]): F[S] => F[T]
  def unzip[S[_], T[_]](fs1: F[S], ft1: F[T]): F[Func2Generic.Zip2Func[S, T]#Zip]
  def function2[S[_], T[_], U[_]](func2Func: Func2Generic.Func3Func[S, T, U]): F[S] => F[T] => F[U] = { fs => ft =>
    val temp1: Func2Generic.Func2Func[Func2Generic.Zip2Func[S, T]#Zip, U] => F[Func2Generic.Zip2Func[S, T]#Zip] => F[U] = gen1 =>
      unfunction[Func2Generic.Zip2Func[S, T]#Zip, U](gen1)

    val temp2: Func2Generic.Func2Func[Func2Generic.Zip2Func[S, T]#Zip, U] = new Func2Generic.Func2Func[Func2Generic.Zip2Func[S, T]#Zip, U] {
      override def apply[X](in: (S[X], T[X])): U[X] = func2Func[X](in._1)(in._2)
    }

    val temp3: F[Func2Generic.Zip2Func[S, T]#Zip] => F[U] = temp1(temp2)

    temp3(unzip[S, T](fs, ft))
  }
}

object Func2Generic {
  type IdImpl[T] = T

  trait Func2Func[S[_], T[_]] {
    def apply[U](in: S[U]): T[U]
  }

  trait Func3Func[S[_], T[_], U[_]] {
    def apply[X]: S[X] => T[X] => U[X]
  }

  trait Zip2Func[S[_], T[_]] {
    type Zip[U] = (S[U], T[U])
  }

  type Match1[In, S[_]] <: Tuple = In match {
    case h *: tail  => S[h] *: Match1[tail, S]
    case EmptyTuple => EmptyTuple
  }

  // ===
  trait HListFuncMap[HListInput, S[_], T[_], FuncIn, FuncOut] {
    def input(func: Func2Func[S, T]): FuncIn => FuncOut
  }
  object HListFuncMap {
    private val instanceImpl: HListFuncMap[Any, [x] =>> Any, [x] =>> Any, Tuple, Tuple] =
      new HListFuncMap[Any, [x] =>> Any, [x] =>> Any, Tuple, Tuple] {
        self =>
        override def input(func: Func2Func[[x] =>> Any, [x] =>> Any]): Tuple => Tuple = _.match {
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

  // ===
  type MatchZip1[In, S[_], T[_]] <: Tuple = In match {
    case h *: tail  => (S[h], T[h]) *: MatchZip1[tail, S, T]
    case EmptyTuple => EmptyTuple
  }
  type MatchZip2[In, S[_]] <: Tuple = In match {
    case h *: tail  => S[h] *: MatchZip2[tail, S]
    case EmptyTuple => EmptyTuple
  }

  trait HListZipMap[HListInput, S[_], T[_], ZipIn, Out1, Out2] {
    def input(in1: Out1, in2: Out2): ZipIn
  }
  object HListZipMap {
    private val instanceImpl: HListZipMap[Any, [x] =>> Any, [x] =>> Any, Tuple, Tuple, Tuple] =
      new HListZipMap[Any, [x] =>> Any, [x] =>> Any, Tuple, Tuple, Tuple] {
        self =>
        override def input(fs1: Tuple, fs2: Tuple): Tuple = (fs1, fs2) match {
          case ((h1 *: tail1), (h2 *: tail2)) =>
            val newTail = self.input(tail1, tail2)
            (h1 -> h2) -> newTail
          case (EmptyTuple, EmptyTuple) => EmptyTuple
        }
      }

    def instance[U, S[_], T[_]]: HListZipMap[U, S, T, MatchZip1[U, S, T], MatchZip2[U, S], MatchZip2[U, T]] = instanceImpl.asInstanceOf
  }

  trait HListZipMapGeneric[In, S[_], T[_]] {
    def generic: HListZipMap[In, S, T, MatchZip1[In, S, T], MatchZip2[In, S], MatchZip2[In, T]] = HListZipMap.instance
  }
  object HListZipMapGeneric {
    def apply[In, S[_], T[_]]: HListZipMapGeneric[In, S, T] = new HListZipMapGeneric[In, S, T] {
      //
    }
  }

  // ===
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

  // ===
  class SimpleUnZip2Impl[F[_[_]], S[_], T[_]] {
    self =>
    def derived2[Target1](simpleTo: SimpleTo[F[IdImpl], Target1]): ZipInnerApply1[F, S, T, Target1] = new ZipInnerApply1[F, S, T, Target1]
  }

  class ZipInnerApply1[F[_[_]], S[_], T[_], Target1] {
    def apply[ZipInput, U1, U2](
      genericFunc: HListZipMapGeneric[Target1, S, T] => HListZipMap[Target1, S, T, ZipInput, U1, U2]
    ): ZipInnerApply2[F, S, T, ZipInput, U1, U2, Target1] =
      new ZipInnerApply2[F, S, T, ZipInput, U1, U2, Target1](genericFunc(HListZipMapGeneric[Target1, S, T]))
  }

  class ZipInnerApply2[F[_[_]], S[_], T[_], ZipInput, U1, U2, Unused](t: HListZipMap[Unused, S, T, ZipInput, U1, U2]) {
    def apply(
      zipTo: SimpleFrom[F[Zip2Func[S, T]#Zip], ZipInput],
      from1: SimpleTo[F[S], U1],
      from2: SimpleTo[F[T], U2]
    ): (F[S], F[T]) => F[Zip2Func[S, T]#Zip] = { (fs, ft) =>
      val tuple2Temp = t.input(from1.to(fs), from2.to(ft))
      zipTo.from(tuple2Temp)
    }
  }

  trait Impl[F[_[_]]] extends Func2Generic[F] {
    def impl1[T1[_], T2[_]]: SimpleFuncion2Impl[F, T1, T2] => Func2Func[T1, T2] => F[T1] => F[T2]
    def impl2[T1[_], T2[_]]: SimpleUnZip2Impl[F, T1, T2] => (F[T1], F[T2]) => F[Func2Generic.Zip2Func[T1, T2]#Zip]
    override def unfunction[T1[_], T2[_]](func: Func2Generic.Func2Func[T1, T2]): F[T1] => F[T2] =
      impl1[T1, T2](new SimpleFuncion2Impl[F, T1, T2])(func)
    override def unzip[T1[_], T2[_]](fs1: F[T1], ft1: F[T2]): F[Func2Generic.Zip2Func[T1, T2]#Zip] =
      impl2[T1, T2](new SimpleUnZip2Impl[F, T1, T2])(fs1, ft1)
  }

}

class BB(val aa: String) extends AnyVal
