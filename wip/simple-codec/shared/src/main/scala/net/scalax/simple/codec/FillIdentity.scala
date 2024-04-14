package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1, ToDecoderGeneric2222}

trait SimpleFill[F[_[_]]] {
  def fill[S[_]](t: SimpleFill.FillI[S]): F[S]
}

object SimpleFill {
  trait FillI[S[_]] {
    def fill[T]: S[T]
  }

  class ApplyImpl[F[_[_]]] {
    def derived(implicit basedInstalled: ToDecoderGeneric2222[F]): SimpleFill[F] = new SimpleFill[F] {
      override def fill[S[_]](t: SimpleFill.FillI[S]): F[S] = {
        val genericImpl = ToDecoderGeneric[F].derived(basedInstalled)
        val generic1    = ToDecoderGeneric1[F].derived(genericImpl)

        generic1.toHList1[({ type Id[T] = T })#Id, S](new MonadAdd1[({ type Id[T] = T })#Id] {
          override def zip[A, B](ma: A, ms: B): (A, B)               = (ma, ms)
          override def to[A, B](m1: A)(in1: A => B)(out1: B => A): B = in1(m1)
          override val zero: Unit                                    = ()
        })(new ToDecoderGeneric1.FuncImpl1[({ type Id[T] = T })#Id, S] {
          override def apply[T]: S[T] = t.fill[T]
        })
      }
    }

    /*def derived(implicit basedInstalled: BasedInstalled[F]): SimpleFill[F] = new SimpleFill[F] {
      override def fill[S[_]](t: SimpleFill.FillI[S]): F[S] = {
        val generic1 = ToDecoderGeneric1[F].derived(basedInstalled)
        generic1.toHList1[({ type Id[T] = T })#Id, S](new MonadAdd1[({ type Id[T] = T })#Id] {
          override def zip[A, B](ma: A, ms: B): (A, B)               = (ma, ms)
          override def to[A, B](m1: A)(in1: A => B)(out1: B => A): B = in1(m1)
          override val zero: Unit                                    = ()
        })(new ToDecoderGeneric1.FuncImpl1[({ type Id[T] = T })#Id, S] {
          override def apply[T]: S[T] = t.fill[T]
        })
      }
    }*/
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]
}
