package net.scalax.simple.codec
package to_list_generic

object SimpleProduct3 {

  trait AppendMonad[M[_, _, _]] {
    def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[(A, S), (B, T), (C, U)]
    def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
    def zero: M[SimpleZero, SimpleZero, SimpleZero]
  }

  trait TypeGen[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]]
  }

  class Builder[F[_[_]]] {
    def derived(t: SimpleProductX[F]): Appender[F] = ConvertM3Impl.Appender.to3[F](t.model)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
