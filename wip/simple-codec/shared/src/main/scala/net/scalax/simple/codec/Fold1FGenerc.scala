package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct1, SimpleProductContextX}

trait Fold1FGenerc[F[_[_]]] {
  def foldLeft[N[_], SeqType](folder: Fold1FGenerc.FoldF[N, SeqType], model: F[N], zero: SeqType): SeqType
  def foldRight[N[_], SeqType](folder: Fold1FGenerc.FoldF[N, SeqType], model: F[N], zero: SeqType): SeqType
}

object Fold1FGenerc {

  trait FoldF[N[_], ColType] {
    def fold[T](n: N[T], col: ColType): ColType
  }

  private def toNamed[N[_], SeqType](folderF: FoldF[N, SeqType]): SimpleProduct1.TypeGen[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new SimpleProduct1.TypeGen[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def gen[T]: (N[T], SeqType) => SeqType = (n, seq) => folderF.fold[T](n, seq)
    }

  private def monadAddLeft[SeqType]: SimpleProduct1.SimpleAppender[({ type T1[U] = (U, SeqType) => SeqType })#T1] =
    new SimpleProduct1.SimpleAppender[({ type T1[U] = (U, SeqType) => SeqType })#T1] {
      override def append[A1, B1, C1](c: ABCFunc[A1, B1, C1])(
        ma: (A1, SeqType) => SeqType,
        mb: (B1, SeqType) => SeqType
      ): (C1, SeqType) => SeqType = (ab, l) => {
        val rb = mb(c.takeTail(ab), l)
        ma(c.takeHead(ab), rb)
      }

      override def zero[N1](n1: N1): (N1, SeqType) => SeqType = (_, a) => a
    }

  private def monadAddRight[SeqType]: SimpleProduct1.SimpleAppender[({ type T1[U] = (U, SeqType) => SeqType })#T1] =
    new SimpleProduct1.SimpleAppender[({ type T1[U] = (U, SeqType) => SeqType })#T1] {
      override def append[A1, B1, C1](c: ABCFunc[A1, B1, C1])(
        ma: (A1, SeqType) => SeqType,
        mb: (B1, SeqType) => SeqType
      ): (C1, SeqType) => SeqType = (ab, l) => {
        val rb = ma(c.takeHead(ab), l)
        mb(c.takeTail(ab), rb)
      }

      override def zero[N1](n1: N1): (N1, SeqType) => SeqType = (_, a) => a
    }

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct1.ProductAdapter[F]): Fold1FGenerc[F] = new Fold1FGenerc[F] {
      override def foldLeft[N[_], SeqType](
        folderF: Fold1FGenerc.FoldF[N, SeqType],
        model: F[N],
        zero: SeqType
      ): SeqType = {
        val u: (F[N], SeqType) => SeqType =
          o1.append[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](toNamed[N, SeqType](folderF), monadAddLeft[SeqType])
        u(model, zero)
      }

      override def foldRight[N[_], SeqType](
        folderF: Fold1FGenerc.FoldF[N, SeqType],
        model: F[N],
        zero: SeqType
      ): SeqType = {
        val u: (F[N], SeqType) => SeqType =
          o1.append[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](toNamed[N, SeqType](folderF), monadAddRight[SeqType])
        u(model, zero)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
