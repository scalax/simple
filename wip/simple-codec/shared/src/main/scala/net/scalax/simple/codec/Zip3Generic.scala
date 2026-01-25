package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct4}

trait Zip3Generic[F[_[_]]] {
  def zip[S[_], T[_], U[_]](input1: F[S], input2: F[T], input3: F[U]): F[({ type X1[MM1] = (S[MM1], T[MM1], U[MM1]) })#X1]
}

object Zip3Generic {

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct4.ProductAdapter[F]): Zip3Generic[F] = new Zip3Generic[F] {
      override def zip[S[_], T[_], U[_]](input1: F[S], input2: F[T], input3: F[U]): F[({ type X1[U1] = (S[U1], T[U1], U[U1]) })#X1] = {
        type MA[A, B, C, D] = (A, B, C) => D
        val func = new SimpleProduct4.SimpleAppender[MA] {
          override def append[A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4](
            cxF1: ABCFunc[A1, B1, C1],
            cxF2: ABCFunc[A2, B2, C2],
            cxF3: ABCFunc[A3, B3, C3],
            cxF4: ABCFunc[A4, B4, C4]
          )(
            ma: (A1, A2, A3) => A4,
            mb: (B1, B2, B3) => B4
          ): (C1, C2, C3) => C4 = (c1, c2, c3) =>
            cxF4.append(
              ma(cxF1.takeHead(c1), cxF2.takeHead(c2), cxF3.takeHead(c3)),
              mb(cxF1.takeTail(c1), cxF2.takeTail(c2), cxF3.takeTail(c3))
            )

          override def zero[N1, N2, N3, N4](n1: N1, n2: N2, n3: N3, n4: N4): (N1, N2, N3) => N4 = (_, _, _) => n4
        }

        val typeGen: SimpleProduct4.TypeGen[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1] =
          new SimpleProduct4.TypeGen[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1] {
            override def gen[X1]: (S[X1], T[X1], U[X1]) => (S[X1], T[X1], U[X1]) = (s, t, u) => (s, t, u)
          }

        o1.append[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1](typeGen, func)(input1, input2, input3)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
