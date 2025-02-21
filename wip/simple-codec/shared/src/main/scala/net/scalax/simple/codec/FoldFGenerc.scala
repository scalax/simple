package net.scalax.simple.codec
package to_list_generic

trait FoldFGenerc[F[_[_]]] {
  def foldLeft[N[_], SeqType](folder: FoldFGenerc.FoldF[N, SeqType], model: F[N], zero: SeqType): SeqType
  def foldRight[N[_], SeqType](folder: FoldFGenerc.FoldF[N, SeqType], model: F[N], zero: SeqType): SeqType
}

object FoldFGenerc {

  trait FoldF[N[_], ColType] {
    def fold[T](n: N[T], col: ColType): ColType
  }

  private def toNamed[N[_], SeqType](folderF: FoldF[N, SeqType]): SimpleProduct1.TypeGen[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new SimpleProduct1.TypeGen[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def apply[T]: (N[T], SeqType) => SeqType = (n, seq) => folderF.fold[T](n, seq)
    }

  private def monadAddLeft[SeqType]: SimpleProduct1.AppendMonad[({ type T1[U] = (U, SeqType) => SeqType })#T1] =
    new SimpleProduct1.AppendMonad[({ type T1[U] = (U, SeqType) => SeqType })#T1] {
      override def zip[A, B](ma: (A, SeqType) => SeqType, ms: (B, SeqType) => SeqType): ((A, B), SeqType) => SeqType = { (ab, l) =>
        val rb = ms(ab._2, l)
        ma(ab._1, rb)
      }

      override def to[A, B](m1: (A, SeqType) => SeqType)(in1: A => B)(out1: B => A): (B, SeqType) => SeqType = (b, col) => m1(out1(b), col)

      override val zero: (SimpleZero, SeqType) => SeqType = (_, a) => a
    }

  private def monadAddRight[SeqType]: SimpleProduct1.AppendMonad[({ type T1[U] = (U, SeqType) => SeqType })#T1] =
    new SimpleProduct1.AppendMonad[({ type T1[U] = (U, SeqType) => SeqType })#T1] {
      override def zip[A, B](ma: (A, SeqType) => SeqType, ms: (B, SeqType) => SeqType): ((A, B), SeqType) => SeqType = { (ab, l) =>
        val rb = ma(ab._1, l)
        ms(ab._2, rb)
      }

      override def to[A, B](m1: (A, SeqType) => SeqType)(in1: A => B)(out1: B => A): (B, SeqType) => SeqType = (b, col) => m1(out1(b), col)

      override val zero: (SimpleZero, SeqType) => SeqType = (_, a) => a
    }

  class Builder[F[_[_]]] {
    def derived(o1: SimpleProduct1.Appender[F]): FoldFGenerc[F] = new FoldFGenerc[F] {
      override def foldLeft[N[_], SeqType](
        folderF: FoldFGenerc.FoldF[N, SeqType],
        model: F[N],
        zero: SeqType
      ): SeqType = {
        val u: (F[N], SeqType) => SeqType =
          o1.toHList1[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](monadAddLeft[SeqType])(toNamed[N, SeqType](folderF))
        u(model, zero)
      }

      override def foldRight[N[_], SeqType](
        folderF: FoldFGenerc.FoldF[N, SeqType],
        model: F[N],
        zero: SeqType
      ): SeqType = {
        val u: (F[N], SeqType) => SeqType =
          o1.toHList1[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](monadAddRight[SeqType])(toNamed[N, SeqType](folderF))
        u(model, zero)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
