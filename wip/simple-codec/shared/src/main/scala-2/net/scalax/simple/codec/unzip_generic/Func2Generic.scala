package net.scalax.simple.codec
package unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}
import shapeless._

trait Func50GenericImpl[F[_[_]]] extends FunctionNGenericSum[F] {
  self =>
  override def function0[T[_]](func1: Function0Apply[T]): F[T]
  override def function2[S[_], T[_], U[_]](func1: Function2Apply[S, T, U])(f1: F[S], f2: F[T]): F[U]
}

object Func50Generic {
  type IdImpl[T] = T

  // ===
  trait HListFuncMap[HListInput, FuncOut, T[_]] {
    def input(func: Function0Apply[T]): FuncOut
  }
  object HListFuncMap {
    implicit def implicit1[In, T[_], HImplHList <: HList, HListOut <: HList](implicit
      tailImpl: HListFuncMap[HImplHList, HListOut, T]
    ): HListFuncMap[In :: HImplHList, T[In] :: HListOut, T] = new HListFuncMap[In :: HImplHList, T[In] :: HListOut, T] {
      override def input(func: Function0Apply[T]): T[In] :: HListOut = func[In] :: tailImpl.input(func)
    }

    implicit def implicit2[T[_]]: HListFuncMap[HNil, HNil, T] = new HListFuncMap[HNil, HNil, T] {
      override def input(func: Function0Apply[T]): HNil = HNil
    }
  }

  trait HListFuncMapGeneric[In, T[_]] {
    def generic[HListOut](implicit io: HListFuncMap[In, HListOut, T]): HListFuncMap[In, HListOut, T] = io
  }
  object HListFuncMapGeneric {
    def apply[In, T[_]]: HListFuncMapGeneric[In, T] = new HListFuncMapGeneric[In, T] {
      //
    }
  }

  // ===
  trait HListZipMap[HListInput, S[_], T[_], G[_], ZipIn, Out1, Out2] {
    def input(in1: Function2Apply[S, T, G]): (ZipIn, Out1) => Out2
  }
  object HListZipMap {
    implicit def implicit1[In, S[_], T[_], G[_], HImplHList <: HList, ZipIn <: HList, HOut1 <: HList, HOut2 <: HList](implicit
      tailImpl: HListZipMap[HImplHList, S, T, G, ZipIn, HOut1, HOut2]
    ): HListZipMap[In :: HImplHList, S, T, G, S[In] :: ZipIn, T[In] :: HOut1, G[In] :: HOut2] =
      new HListZipMap[In :: HImplHList, S, T, G, S[In] :: ZipIn, T[In] :: HOut1, G[In] :: HOut2] {
        override def input(in1: Function2Apply[S, T, G]): ((S[In] :: ZipIn), (T[In] :: HOut1)) => (G[In] :: HOut2) =
          (sIn1, sOut1) => in1[In](sIn1.head, sOut1.head) :: tailImpl.input(in1)(sIn1.tail, sOut1.tail)
      }

    implicit def implicit2[S[_], T[_], G[_]]: HListZipMap[HNil, S, T, G, HNil, HNil, HNil] =
      new HListZipMap[HNil, S, T, G, HNil, HNil, HNil] {
        override def input(in1: Function2Apply[S, T, G]): (HNil, HNil) => HNil = (i1, _) => i1
      }
  }

  trait HListZipMapGeneric[In, S[_], T[_], G[_]] {
    def generic[ZipInput, HOut1, HOut2](implicit
      io: HListZipMap[In, S, T, G, ZipInput, HOut1, HOut2]
    ): HListZipMap[In, S, T, G, ZipInput, HOut1, HOut2] = io
  }
  object HListZipMapGeneric {
    def apply[In, S[_], T[_], G[_]]: HListZipMapGeneric[In, S, T, G] = new HListZipMapGeneric[In, S, T, G] {
      //
    }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], S[_]] {
    self =>
    def derived2[Target1, Target2](
      simpleTo: SimpleTo[F[IdImpl], Target1],
      simpleFrom: SimpleFrom[F[S], Target2]
    ): FuncInnerApply1[F, S, Target1, Target2] = new FuncInnerApply1[F, S, Target1, Target2](simpleFrom = simpleFrom)
  }

  class FuncInnerApply1[F[_[_]], S[_], Target1, Target2](simpleFrom: SimpleFrom[F[S], Target2]) {
    def apply(genericFunc: HListFuncMapGeneric[Target1, S] => HListFuncMap[Target1, Target2, S]): Function0Apply[S] => F[S] =
      applyM => simpleFrom.from(genericFunc(HListFuncMapGeneric[Target1, S]).input(applyM))
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
