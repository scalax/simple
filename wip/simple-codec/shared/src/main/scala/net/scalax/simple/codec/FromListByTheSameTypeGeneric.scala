package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct1

trait FromListByTheSameTypeGeneric[F[_[_]]] {
  def fromListByTheSameType[TA, SeqType](
    takeHead: SeqType => TA,
    takeTail: SeqType => SeqType
  ): SeqType => F[({ type U1[_] = TA })#U1]
}

object FromListByTheSameTypeGeneric {

  private def toNamed[T, SeqType](
    takeHead: SeqType => T,
    takeTail: SeqType => SeqType
  ): SimpleProduct1.TypeGen[({ type T1[U] = SeqType => (SeqType, U) })#T1, ({ type T1[_] = T })#T1] =
    new SimpleProduct1.TypeGen[({ type T1[U] = SeqType => (SeqType, U) })#T1, ({ type T1[_] = T })#T1] {
      override def apply[U]: SeqType => (SeqType, T) = l => (takeTail(l), takeHead(l))
    }

  private def monadAdd[SeqType]: SimpleProduct1.AppendMonad[({ type T1[U] = SeqType => (SeqType, U) })#T1] =
    new SimpleProduct1.AppendMonad[({ type T1[U] = SeqType => (SeqType, U) })#T1] {
      override def zip[A, B](ma: SeqType => (SeqType, A), ms: SeqType => (SeqType, B)): SeqType => (SeqType, (A, B)) = { l =>
        val rb = ms(l)
        val ra = ma(rb._1)
        (ra._1, (ra._2, rb._2))
      }

      override def to[A, B](m1: SeqType => (SeqType, A))(in1: A => B)(out1: B => A): SeqType => (SeqType, B) = { l =>
        val temp = m1(l)
        (temp._1, in1(temp._2))
      }

      override val zero: SeqType => (SeqType, Unit) = l => (l, ())
    }

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct1.Appender[F]): FromListByTheSameTypeGeneric[F] = new FromListByTheSameTypeGeneric[F] {
      override def fromListByTheSameType[TA, SeqType](
        takeHead: SeqType => TA,
        takeTail: SeqType => SeqType
      ): SeqType => F[({ type U1[_] = TA })#U1] = { u1 =>
        val u = o1.toHList1[({ type ModelF[M] = SeqType => (SeqType, M) })#ModelF, ({ type T1[_] = TA })#T1](monadAdd[SeqType])(
          toNamed[TA, SeqType](takeHead, takeTail)
        )
        u(u1)._2
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
