package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric2222}

trait MapGenerc[F[_[_]]] {
  def map[S[_], T[_]](input: MapGenerc.MapImpl[S, T]): F[S] => F[T]
}

object MapGenerc {

  trait MapImpl[S[_], T[_]] {
    def map[X1]: S[X1] => T[X1]
  }

  class ApplyImpl[F[_[_]]] {
    def derived(to: ToDecoderGeneric2222[F]): MapGenerc[F] = fromInstance(ToDecoderGeneric[F].derived(to))
    def fromInstance(generic3: ToDecoderGeneric[F]): MapGenerc[F] = new MapGenerc[F] {
      override def map[S[_], T[_]](input: MapImpl[S, T]): F[S] => F[T] = {
        type MA[H, HH] = H => HH
        val m: MonadAdd1111[MA] = new MonadAdd1111[MA] {
          override def zip[A, B, S, T](ma: A => B, ms: S => T): ((A, S)) => (B, T)                            = a => (ma(a._1), ms(a._2))
          override def to[A, B, S, T](m1: A => B)(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): S => T = s => in2(m1(in3(s)))
          override val zero: Unit => Unit                                                                     = identity _
        }
        val funcImpl: ToDecoderGeneric.FuncImpl[MA, S, T] = new ToDecoderGeneric.FuncImpl[MA, S, T] {
          override def apply[X1]: S[X1] => T[X1] = sx => input.map(sx)
        }
        generic3.toHList[MA, S, T](m)(funcImpl)
      }
    }
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

}
