package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct2

trait MapGenerc[F[_[_]]] {
  def map[S[_], T[_]](input: MapGenerc.MapFunction[S, T]): F[S] => F[T]
}

object MapGenerc {

  trait MapFunction[S[_], T[_]] {
    def map[X1](in: S[X1]): T[X1]
  }

  @inline private val anyToAnyImplImpl: Any => Any = identity[Any]
  @inline private def anyToAnyImpl[T]: T => T      = anyToAnyImplImpl.asInstanceOf[T => T]

  class Builder[F[_[_]]] {
    def derived(generic3: SimpleProduct2.Appender[F]): MapGenerc[F] = new MapGenerc[F] {
      override def map[S[_], T[_]](input: MapFunction[S, T]): F[S] => F[T] = {
        type MA[H, HH] = H => HH
        val m: SimpleProduct2.AppendMonad[MA] = new SimpleProduct2.AppendMonad[MA] {
          override def zip[A1, B1, C1, A2, B2, C2](
            c: SimpleProduct2.ConvertF2[A1, B1, C1, A2, B2, C2],
            ma: A1 => A2,
            mb: B1 => B2
          ): MA[C1, C2] = c1 => c.from2(ma(c.takeHead1(c1)), mb(c.takeTail1(c1)))
          override def zero[N1, N2](n1: N1, n2: N2): N1 => N2 = _ => n2
        }
        val funcImpl: SimpleProduct2.TypeGen[MA, S, T] = new SimpleProduct2.TypeGen[MA, S, T] {
          override def apply[X1]: S[X1] => T[X1] = sx => input.map(sx)
        }
        generic3.toHList1[MA, S, T](m)(funcImpl)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
