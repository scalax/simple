package net.scalax.simple.codec
package to_list_generic

trait ToListByTheSameTypeGeneric[F[_[_]]] {
  def toListByTheSameType[TA, SeqType](
    zero: SeqType,
    append: (SeqType, TA) => SeqType
  ): F[({ type U1[_] = TA })#U1] => SeqType
}

object ToListByTheSameTypeGeneric {

  class Builder[F[_[_]]] {
    def derived(o1: Fold1FGenerc[F]): ToListByTheSameTypeGeneric[F] = new ToListByTheSameTypeGeneric[F] {
      override def toListByTheSameType[TA, SeqType](
        zero: SeqType,
        append: (SeqType, TA) => SeqType
      ): F[({ type U1[_] = TA })#U1] => SeqType = { input =>
        o1.foldLeft[({ type T1[_] = TA })#T1, SeqType](
          new Fold1FGenerc.FoldF[({ type T1[_] = TA })#T1, SeqType] {
            override def fold[T](n: TA, col: SeqType): SeqType = append(col, n)
          },
          input,
          zero
        )
      }
    }

    @inline def implicitly(implicit modelSize: ToListByTheSameTypeGeneric[F]): ToListByTheSameTypeGeneric[F] = modelSize
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
