package net.scalax.simple.codec.unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}
import shapeless._

trait Func2Generic[F[_[_]]] {
  def unfunction[S[_], T[_]](func: Func2Generic.Func2Func[S, T]): F[S] => F[T]
  def unzip[S[_], T[_]](zipModel: F[Func2Generic.Zip2Func[S, T]#Zip]): (F[S], F[T])
}

object Func2Generic {
  type IdImpl[T] = T

  trait Func2Func[S[_], T[_]] {
    def apply[U](in: S[U]): T[U]
  }

  trait Zip2Func[S[_], T[_]] {
    type Zip[U] = (S[U], T[U])
  }

  // ===
  trait HListFuncMap[HListInput, S[_], T[_], FuncIn, FuncOut] {
    def input(func: Func2Func[S, T])(funcIn: FuncIn): FuncOut
  }
  object HListFuncMap {
    implicit def implicit1[In, S[_], T[_], HImplHList <: HList, HListIn <: HList, HListOut <: HList](implicit
      tailImpl: HListFuncMap[HImplHList, S, T, HListIn, HListOut]
    ): HListFuncMap[In :: HImplHList, S, T, S[In] :: HListIn, T[In] :: HListOut] =
      new HListFuncMap[In :: HImplHList, S, T, S[In] :: HListIn, T[In] :: HListOut] {
        override def input(func: Func2Func[S, T])(funcIn: S[In] :: HListIn): (T[In] :: HListOut) =
          func(funcIn.head) :: tailImpl.input(func)(funcIn.tail)
      }

    implicit def implicit2[S[_], T[_]]: HListFuncMap[HNil, S, T, HNil, HNil] = new HListFuncMap[HNil, S, T, HNil, HNil] {
      override def input(func: Func2Func[S, T])(funcIn: HNil): HNil = HNil
    }
  }

  trait HListFuncMapGeneric[In, S[_], T[_]] {
    def generic[HListIn, HListOut](implicit io: HListFuncMap[In, S, T, HListIn, HListOut]): HListFuncMap[In, S, T, HListIn, HListOut] = io
  }
  object HListFuncMapGeneric {
    def apply[In, S[_], T[_]]: HListFuncMapGeneric[In, S, T] = new HListFuncMapGeneric[In, S, T] {
      //
    }
  }

  // ===
  trait HListZipMap[HListInput, S[_], T[_], ZipIn, Out1, Out2] {
    def input(func: ZipIn): (Out1, Out2)
  }
  object HListZipMap {
    implicit def implicit1[In, S[_], T[_], HImplHList <: HList, ZipIn <: HList, HListIn <: HList, HListOut <: HList](implicit
      tailImpl: HListZipMap[HImplHList, S, T, ZipIn, HListIn, HListOut]
    ): HListZipMap[In :: HImplHList, S, T, (S[In], T[In]) :: ZipIn, S[In] :: HListIn, T[In] :: HListOut] =
      new HListZipMap[In :: HImplHList, S, T, (S[In], T[In]) :: ZipIn, S[In] :: HListIn, T[In] :: HListOut] {
        override def input(func: (S[In], T[In]) :: ZipIn): (S[In] :: HListIn, T[In] :: HListOut) = {
          val tupleTemp = tailImpl.input(func.tail)
          (func.head._1 :: tupleTemp._1, func.head._2 :: tupleTemp._2)
        }
      }

    private val identityHNil: (HNil, HNil) = (HNil, HNil)
    implicit def implicit2[S[_], T[_]]: HListZipMap[HNil, S, T, HNil, HNil, HNil] =
      new HListZipMap[HNil, S, T, HNil, HNil, HNil] {
        override def input(zipIn: HNil): (HNil, HNil) = identityHNil
      }
  }

  trait HListZipMapGeneric[In, S[_], T[_]] {
    def generic[ZipInput, HListIn, HListOut](implicit
      io: HListZipMap[In, S, T, ZipInput, HListIn, HListOut]
    ): HListZipMap[In, S, T, ZipInput, HListIn, HListOut] = io
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
      zipTo: SimpleTo[F[Zip2Func[S, T]#Zip], ZipInput],
      from1: SimpleFrom[F[S], U1],
      from2: SimpleFrom[F[T], U2]
    ): F[Zip2Func[S, T]#Zip] => (F[S], F[T]) = { u =>
      val tuple2Temp = t.input(zipTo.to(u))
      (from1.from(tuple2Temp._1), from2.from(tuple2Temp._2))
    }
  }

  trait Impl[F[_[_]]] extends Func2Generic[F] {
    def impl1[T1[_], T2[_]]: SimpleFuncion2Impl[F, T1, T2] => Func2Func[T1, T2] => F[T1] => F[T2]
    def impl2[T1[_], T2[_]]: SimpleUnZip2Impl[F, T1, T2] => F[Func2Generic.Zip2Func[T1, T2]#Zip] => (F[T1], F[T2])
    override def unfunction[T1[_], T2[_]](func: Func2Generic.Func2Func[T1, T2]): F[T1] => F[T2] =
      impl1[T1, T2](new SimpleFuncion2Impl[F, T1, T2])(func)
    override def unzip[T1[_], T2[_]](func: F[Func2Generic.Zip2Func[T1, T2]#Zip]): (F[T1], F[T2]) =
      impl2[T1, T2](new SimpleUnZip2Impl[F, T1, T2])(func)
  }

}

class BB(val aa: String) extends AnyVal
