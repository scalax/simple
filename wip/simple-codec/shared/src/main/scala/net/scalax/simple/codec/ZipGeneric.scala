package net.scalax.simple.codec

import to_list_generic._

trait ZipGeneric[F[_[_]]] {
  def zip[S[_], T[_]](input1: F[S], input2: F[T]): F[({ type X1[U1] = (S[U1], T[U1]) })#X1]
}

object ZipGeneric {

  class ToListGenericApply[F[_[_]]] {
    def derived(o1: ToDecoderGeneric2222[F]): ZipGeneric[F] = new ZipGeneric[F] {
      override def zip[S[_], T[_]](input1: F[S], input2: F[T]): F[({ type X1[U1] = (S[U1], T[U1]) })#X1] = {
        type MA[A, B, C] = (A, B) => C
        val func = new MonadAdd[MA] {
          override def zip[A, B, C, S, T, U](ma: (A, B) => C, ms: (S, T) => U): ((A, S), (B, T)) => (C, U) = (as, bt) =>
            (ma(as._1, bt._1), ms(as._2, bt._2))
          override def to[A, B, C, S, T, U](
            m1: (A, B) => C
          )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): (S, T) => U = (s, t) => in3(m1(in4(s), in5(t)))
          override def zero: (Unit, Unit) => Unit = (a, _) => a
        }

        o1.toHList[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1](func)(
          new ToDecoderGeneric2222.FuncImpl[MA, S, T, ({ type X1[NN] = (S[NN], T[NN]) })#X1] {
            override def apply[X1]: (S[X1], T[X1]) => (S[X1], T[X1]) = (s, t) => (s, t)
          }
        )(input1, input2)
      }
    }
  }

  def apply[F[_[_]]] = new ToListGenericApply[F]

}
