package net.scalax.simple.codec
package to_list_generic

object SimpleProduct4 {

  trait ConvertF4[A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4] {
    def from1(a: A1, b: B1): C1
    def takeHead1(c: C1): A1
    def takeTail1(c: C1): B1

    def from2(a: A2, b: B2): C2
    def takeHead2(c: C2): A2
    def takeTail2(c: C2): B2

    def from3(a: A3, b: B3): C3
    def takeHead3(c: C3): A3
    def takeTail3(c: C3): B3

    def from4(a: A4, b: B4): C4
    def takeHead4(c: C4): A4
    def takeTail4(c: C4): B4
  }

  trait AppendMonad[M[_, _, _, _]] {
    def zip[A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4](
      c: ConvertF4[A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4],
      ma: M[A1, A2, A3, A4],
      mb: M[B1, B2, B3, B4]
    ): M[C1, C2, C3, C4]
    def zero[N1, N2, N3, N4](n1: N1, n2: N2, n3: N3, n4: N4): M[N1, N2, N3, N4]
  }

  trait TypeGen[M1[_, _, _, _], M2[_], M3[_], M4[_], M5[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T], M5[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList1[M1[_, _, _, _], M2[_], M3[_], M4[_], M5[_]](monad: AppendMonad[M1])(
      func: TypeGen[M1, M2, M3, M4, M5]
    ): M1[F[M2], F[M3], F[M4], F[M5]]
  }

  class Builder[F[_[_]]] {
    def derived(t: SimpleProductX[F]): Appender[F] = ConvertM4Impl.Appender.to4[F](t.model)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
