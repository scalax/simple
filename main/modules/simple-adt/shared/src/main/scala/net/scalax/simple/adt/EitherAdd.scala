package net.scalax.simple
package adt

import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive}

object SimpleCoProduct {

  trait AppendMonad[M[_, _, _]] {
    def either[A, B, C, S, T, U](ma: Either[M[A, B, C], M[S, T, U]]): M[Either[A, S], Either[B, T], Either[C, U]]
    def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
    def zero: M[Unit, Unit, Unit]
  }

  trait TypeGen[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]]
  }

}

object SimpleCoProductImpl {

  def append[TCurrent <: AdtNat, FADT[_[_]] <: AdtNat](
    tail: SimpleCoProduct.Appender[FADT]
  ): SimpleCoProduct.Appender[({ type F1[UF1[_]] = AdtNatPositive[TCurrent, FADT[UF1]] })#F1] =
    new SimpleCoProduct.Appender[({ type F1[UF1[_]] = AdtNatPositive[TCurrent, FADT[UF1]] })#F1] {
      override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: SimpleCoProduct.AppendMonad[M1])(
        func: SimpleCoProduct.TypeGen[M1, M2, M3, M4]
      ): M1[AdtNatPositive[TCurrent, FADT[M2]], AdtNatPositive[TCurrent, FADT[M3]], AdtNatPositive[TCurrent, FADT[M4]]] = {
        ???
      }
    }

}
