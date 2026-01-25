package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct3}

trait ZipGeneric[F[_[_]]] {
  def zip[S[_], T[_]](input1: F[S], input2: F[T]): F[({ type X1[U1] = (S[U1], T[U1]) })#X1]
}

object ZipGeneric {

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct3.ProductAdapter[F]): ZipGeneric[F] = new ZipGeneric[F] {
      override def zip[S[_], T[_]](input1: F[S], input2: F[T]): F[({ type X1[U1] = (S[U1], T[U1]) })#X1] = {
        type MA[A, B, C] = (A, B) => C
        val func = new SimpleProduct3.SimpleAppender[MA] {
          override def append[A1, A2, A3, B1, B2, B3, C1, C2, C3](
            cxF1: ABCFunc[A1, B1, C1],
            cxF2: ABCFunc[A2, B2, C2],
            cxF3: ABCFunc[A3, B3, C3]
          )(
            ma: (A1, A2) => A3,
            mb: (B1, B2) => B3
          ): (C1, C2) => C3 = (c1, c2) => cxF3.append(ma(cxF1.takeHead(c1), cxF2.takeHead(c2)), mb(cxF1.takeTail(c1), cxF2.takeTail(c2)))

          override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): (N1, N2) => N3 = (_, _) => n3
        }

        val typeGen: SimpleProduct3.TypeGen[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1] =
          new SimpleProduct3.TypeGen[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1] {
            override def gen[X1]: (S[X1], T[X1]) => (S[X1], T[X1]) = (s, t) => (s, t)
          }

        o1.append[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1](typeGen, func)(input1, input2)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
