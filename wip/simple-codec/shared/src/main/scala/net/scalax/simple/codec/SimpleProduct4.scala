package net.scalax.simple.codec
package to_list_generic

object SimpleProduct4 {

  trait AppendMonad[M[_, _, _, _]] {
    def zip[A, B, C, D, S, T, U, V](ma: M[A, B, C, D], ms: M[S, T, U, V]): M[(A, S), (B, T), (C, U), (D, V)]
    def to[A, B, C, D, S, T, U, V](
      m1: M[A, B, C, D]
    )(in1: A => S, in2: B => T, in3: C => U, in4: D => V)(in5: S => A, in6: T => B, in7: U => C, in8: V => D): M[S, T, U, V]
    def zero: M[SimpleZero, SimpleZero, SimpleZero, SimpleZero]
  }

  trait TypeGen[M1[_, _, _, _], M2[_], M3[_], M4[_], M5[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T], M5[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M1[_, _, _, _], M2[_], M3[_], M4[_], M5[_]](
      monad: AppendMonad[M1],
      func: TypeGen[M1, M2, M3, M4, M5]
    ): M1[F[M2], F[M3], F[M4], F[M5]]
  }

  class Builder[F[_[_]]] {
    def derived(t: SimpleProductX[F]): Appender[F] = ConvertM4Impl.Appender.to3[F](t.model)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
