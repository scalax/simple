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
          override def zip[A1, B1, C1](c: SimpleProduct1.ConvertF1[A1, B1, C1], ma: A1, mb: B1): C1 = c.from1(ma, mb)
          override def zero[N1](n1: N1): N1                                                         = n1
        })(new SimpleProduct1.TypeGen[({ type Id[T] = T })#Id, S] {
          override def apply[T]: S[T] = t.fill[T]
        })
    }
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]
}
