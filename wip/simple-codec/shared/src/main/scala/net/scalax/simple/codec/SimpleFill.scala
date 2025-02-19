package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct1

trait SimpleFill[F[_[_]]] {
  def fill[S[_]](t: SimpleFill.FillI[S]): F[S]
}

object SimpleFill {
  trait FillI[S[_]] {
    def fill[T]: S[T]
  }

  class ApplyImpl[F[_[_]]] {
    def derived(basedInstalled: SimpleProduct1.Appender[F]): SimpleFill[F] = new SimpleFill[F] {
      override def fill[S[_]](t: SimpleFill.FillI[S]): F[S] =
        basedInstalled.toHList1[({ type Id[T] = T })#Id, S](new SimpleProduct1.AppendMonad[({ type Id[T] = T })#Id] {
          override def zip[A, B](ma: A, ms: B): (A, B)               = (ma, ms)
          override def to[A, B](m1: A)(in1: A => B)(out1: B => A): B = in1(m1)
          override val zero: SimpleZero                              = SimpleZero.value
        })(new SimpleProduct1.TypeGen[({ type Id[T] = T })#Id, S] {
          override def apply[T]: S[T] = t.fill[T]
        })
    }
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]
}
