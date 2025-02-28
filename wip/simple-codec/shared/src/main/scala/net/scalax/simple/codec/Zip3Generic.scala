package net.scalax.simple.codec

import to_list_generic.SimpleProduct4

trait Zip3Generic[F[_[_]]] {
  def zip[S[_], T[_], U[_]](input1: F[S], input2: F[T], input3: F[U]): F[({ type X1[MM1] = (S[MM1], T[MM1], U[MM1]) })#X1]
}

object Zip3Generic {

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct4.Appender[F]): Zip3Generic[F] = new Zip3Generic[F] {
      override def zip[S[_], T[_], U[_]](input1: F[S], input2: F[T], input3: F[U]): F[({ type X1[U1] = (S[U1], T[U1], U[U1]) })#X1] = {
        type MA[A, B, C, D] = (A, B, C) => D
        val func = new SimpleProduct4.AppendMonad[MA] {
          override def zip[A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4](
            c: SimpleProduct4.ConvertF4[A1, B1, C1, A2, B2, C2, A3, B3, C3, A4, B4, C4],
            ma: (A1, A2, A3) => A4,
            mb: (B1, B2, B3) => B4
          ): (C1, C2, C3) => C4 = (c1, c2, c3) =>
            c.from4(ma(c.takeHead1(c1), c.takeHead2(c2), c.takeHead3(c3)), mb(c.takeTail1(c1), c.takeTail2(c2), c.takeTail3(c3)))

          override def zero[N1, N2, N3, N4](n1: N1, n2: N2, n3: N3, n4: N4): (N1, N2, N3) => N4 = (_, _, _) => n4
        }

        val typeGen: SimpleProduct4.TypeGen[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1] =
          new SimpleProduct4.TypeGen[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1] {
            override def apply[X1]: (S[X1], T[X1], U[X1]) => (S[X1], T[X1], U[X1]) = (s, t, u) => (s, t, u)
          }

        o1.toHList1[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1](func)(typeGen)(input1, input2, input3)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
