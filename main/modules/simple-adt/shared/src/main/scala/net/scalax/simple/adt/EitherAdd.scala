package net.scalax.simple
package adt

trait EitherAdd[M[_, _, _]] {
  def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[Either[A, S], Either[B, T], Either[C, U]]
  def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
  def zero: M[Unit, Unit, Unit]
}

trait EitherAddDecode[F[_[_]]] {
  def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: EitherAdd[M1])(
    func: EitherAddDecode.FuncImpl[M1, M2, M3, M4]
  ): M1[F[M2], F[M3], F[M4]]
}

object EitherAddDecode {

  trait FuncImpl[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

}
