package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct1, SimpleProductContextX}

trait SimpleFill[F[_[_]]] {
  def fill[S[_]](t: SimpleFill.FillI[S]): F[S]
}

object SimpleFill {
  trait FillI[S[_]] {
    def fill[T]: S[T]
  }

  class Builder[F[_[_]]] {
    def derived(basedInstalled: SimpleProduct1.ProductAdapter[F]): SimpleFill[F] = new SimpleFill[F] {
      override def fill[S[_]](t: SimpleFill.FillI[S]): F[S] = {
        val a: SimpleProduct1.TypeGen[({ type Id[T] = T })#Id, S] = new SimpleProduct1.TypeGen[({ type Id[T] = T })#Id, S] {
          override def gen[T]: S[T] = t.fill[T]
        }
        val b: SimpleProduct1.SimpleAppender[({ type Id[T] = T })#Id] = new SimpleProduct1.SimpleAppender[({ type Id[T] = T })#Id] {
          override def append[A1, B1, C1](c: ABCFunc[A1, B1, C1])(ma: A1, mb: B1): C1 = c.append(ma, mb)
          override def zero[N1](n1: N1): N1                                           = n1
        }

        basedInstalled.append[({ type Id[T] = T })#Id, S](a, b)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
