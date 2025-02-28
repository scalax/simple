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
      override def zip[A1, B1, C1](
        c: SimpleProduct1.ConvertF1[A1, B1, C1],
        ma: SeqType => (SeqType, A1),
        mb: SeqType => (SeqType, B1)
      ): SeqType => (SeqType, C1) = { l =>
        val rb = ma(l)
        val ra = mb(rb._1)
        (ra._1, c.from1(rb._2, ra._2))
      }

      override def zero[N1](n1: N1): SeqType => (SeqType, N1) = l => (l, n1)
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
