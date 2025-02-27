package net.scalax.simple.codec

import shapeless.HNil
import to_list_generic.SimpleProduct3

trait ZipGeneric[F[_[_]]] {
  def zip[S[_], T[_]](input1: F[S], input2: F[T]): F[({ type X1[U1] = (S[U1], T[U1]) })#X1]
}

object ZipGeneric {

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct3.Appender[F]): ZipGeneric[F] = new ZipGeneric[F] {
      override def zip[S[_], T[_]](input1: F[S], input2: F[T]): F[({ type X1[U1] = (S[U1], T[U1]) })#X1] = {
        type MA[A, B, C] = (A, B) => C
        val func = new SimpleProduct3.AppendMonad[MA] {
          override def zip[A1, B1, C1, A2, B2, C2, A3, B3, C3](
            c: SimpleProduct3.ConvertF3[A1, B1, C1, A2, B2, C2, A3, B3, C3],
            ma: (A1, A2) => A3,
            mb: (B1, B2) => B3
          ): (C1, C2) => C3 = (c1, c2) => c.from3(ma(c.takeHead1(c1), c.takeHead2(c2)), mb(c.takeTail1(c1), c.takeTail2(c2)))
          override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): (N1, N2) => N3 = (_, _) => n3
        }

        val typeGen: SimpleProduct3.TypeGen[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1] =
          new SimpleProduct3.TypeGen[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1] {
            override def apply[X1]: (S[X1], T[X1]) => (S[X1], T[X1]) = (s, t) => (s, t)
          }

        o1.toHList1[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1](func)(typeGen)(input1, input2)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
