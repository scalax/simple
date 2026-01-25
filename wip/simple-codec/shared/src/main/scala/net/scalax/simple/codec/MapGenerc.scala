package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct2, SimpleProductContextX}

trait MapGenerc[F[_[_]]] {
  def map[S[_], T[_]](input: MapGenerc.MapFunction[S, T]): F[S] => F[T]
}

object MapGenerc {

  trait MapFunction[S[_], T[_]] {
    def map[X1](in: S[X1]): T[X1]
  }

  class Builder[F[_[_]]] {
    def derived(generic3: SimpleProduct2.ProductAdapter[F]): MapGenerc[F] = new MapGenerc[F] {
      override def map[S[_], T[_]](input: MapFunction[S, T]): F[S] => F[T] = {
        type MA[H, HH] = H => HH
        val m: SimpleProduct2.SimpleAppender[({ type F2[X1, X2] = X1 => X2 })#F2] =
          new SimpleProduct2.SimpleAppender[({ type F2[X1, X2] = X1 => X2 })#F2] {
            override def append[A1, A2, B1, B2, C1, C2](hlistA1: ABCFunc[A1, B1, C1], hlistA2: ABCFunc[A2, B2, C2])(
              ma: A1 => A2,
              mb: B1 => B2
            ): C1 => C2 = c1 => hlistA2.append(ma(hlistA1.takeHead(c1)), mb(hlistA1.takeTail(c1)))

            @inline override def zero[N1, N2](n1: N1, n2: N2): N1 => N2 = _ => n2
          }
        val funcImpl: SimpleProduct2.TypeGen[MA, S, T] = new SimpleProduct2.TypeGen[MA, S, T] {
          @inline override def gen[X1]: S[X1] => T[X1] = sx => input.map(sx)
        }
        generic3.append[MA, S, T](funcImpl, m)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
