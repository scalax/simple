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
          override def zip[A, B, C, D, S, T, U, V](ma: (A, B, C) => D, ms: (S, T, U) => V): ((A, S), (B, T), (C, U)) => (D, V) =
            (as, bt, ct) => (ma(as._1, bt._1, ct._1), ms(as._2, bt._2, ct._2))
          override def to[A, B, C, D, S, T, U, V](
            m1: (A, B, C) => D
          )(in1: A => S, in2: B => T, in3: C => U, in4: D => V)(in5: S => A, in6: T => B, in7: U => C, in8: V => D): (S, T, U) => V =
            (s, t, u) => in4(m1(in5(s), in6(t), in7(u)))
          override def zero: (Unit, Unit, Unit) => Unit = (a, _, _) => a
        }

        o1.toHList[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1](func)(
          new SimpleProduct4.TypeGen[MA, S, T, U, ({ type X1[NN] = (S[NN], T[NN], U[NN]) })#X1] {
            override def apply[X1]: (S[X1], T[X1], U[X1]) => (S[X1], T[X1], U[X1]) = (s, t, u) => (s, t, u)
          }
        )(input1, input2, input3)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
