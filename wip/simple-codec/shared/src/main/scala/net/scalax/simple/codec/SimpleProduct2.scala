package net.scalax.simple.codec
package to_list_generic

object SimpleProduct2 {

  trait AppendMonad[M[_, _]] {
    def zip[A, B, S, T](ma: M[A, B], ms: M[S, T]): M[(A, S), (B, T)]
    def to[A, B, S, T](m1: M[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M[S, T]
    def zero: M[SimpleZero, SimpleZero]
  }

  trait TypeGen[M2[_, _], M1[_], M3[_]] {
    def apply[T]: M2[M1[T], M3[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M3[_, _], M1[_], M2[_]](monad: AppendMonad[M3])(func: TypeGen[M3, M1, M2]): M3[F[M1], F[M2]]
  }

  class Builder[F[_[_]]] {
    def derived(t: SimpleProductX[F]): Appender[F] = ConvertM2Impl.Appender.to2[F](t.model)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
