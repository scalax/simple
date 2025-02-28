package net.scalax.simple.codec
package to_list_generic

object SimpleProduct1 {

  trait ConvertF1[A1, B1, C1] {
    def from1(a: A1, b: B1): C1
    def takeHead1(c: C1): A1
    def takeTail1(c: C1): B1
  }

  trait AppendMonad[M[_]] {
    def zip[A1, B1, C1](c: ConvertF1[A1, B1, C1], ma: M[A1], mb: M[B1]): M[C1]
    def zero[N1](n1: N1): M[N1]
  }

  trait TypeGen[M1[_], M2[_]] {
    def apply[T]: M1[M2[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList1[M1[_], M2[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2]): M1[F[M2]]
  }

  class Builder[F[_[_]]] {
    def derived(t: SimpleProductX[F]): Appender[F] = ConvertM1Impl.Appender.to1[F](t.model)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
