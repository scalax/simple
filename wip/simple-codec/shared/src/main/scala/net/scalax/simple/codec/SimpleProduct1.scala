package net.scalax.simple.codec
package to_list_generic

object SimpleProduct1 {

  trait AppendMonad[M[_]] {
    def zip[A, B](ma: M[A], ms: M[B]): M[(A, B)]
    def to[A, B](m1: M[A])(in1: A => B)(out1: B => A): M[B]
    def zero: M[Unit]
  }

  trait TypeGen[M1[_], M2[_]] {
    def apply[T]: M1[M2[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList1[M1[_], M2[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2]): M1[F[M2]]
  }

  class Builder[F[_[_]]] {
    def derived(t: SimpleProductX[F]): Appender[F] = ??? // ConvertM1Impl.Appender.to1[F](t.model)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
