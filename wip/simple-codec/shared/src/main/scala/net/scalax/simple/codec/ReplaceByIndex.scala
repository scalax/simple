package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct1, SimpleProductContextX}

trait ReplaceByIndex[F[_[_]]] {
  def replaceImpl[UX](index: Int, proValue: UX): F[({ type X1[_] = UX })#X1] => F[({ type X1[_] = UX })#X1]
  def replace[T[_]](index: Int, proValue: Any): F[T] => F[T] = {
    val func: F[({ type X1[_] = Any })#X1] => F[({ type X1[_] = Any })#X1] = replaceImpl[Any](index = index, proValue = proValue)
    func.asInstanceOf[F[T] => F[T]]
  }
}

object ReplaceByIndex {

  private class Helper1[ProType] {
    type MA[H] = (Int, ProType, H) => H
  }
  private def appendMonad[ProType]: SimpleProduct1.SimpleAppender[Helper1[ProType]#MA] =
    new SimpleProduct1.SimpleAppender[Helper1[ProType]#MA] {
      override def append[A1, B1, C1](c: ABCFunc[A1, B1, C1])(
        ma: (Int, ProType, A1) => A1,
        mb: (Int, ProType, B1) => B1
      ): (Int, ProType, C1) => C1 = (index, anyModel, c1) => {
        if (index >= 0) {
          val oldA1: A1 = c.takeHead(c1)
          val oldB1: B1 = c.takeTail(c1)
          val newA1: A1 = ma(index, anyModel, oldA1)
          val newB1: B1 = mb(index - 1, anyModel, oldB1)

          c.append(newA1, newB1)
        } else c1
      }

      @inline override def zero[N1](n1: N1): (Int, ProType, N1) => N1 = (_, _, t) => t
    }

  private def funcImpl[ProType]: SimpleProduct1.TypeGen[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1] =
    new SimpleProduct1.TypeGen[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1] {
      @inline override def gen[X1]: (Int, ProType, ProType) => ProType = (index, anyModel, x1) => if (index == 0) anyModel else x1
    }

  class Builder[F[_[_]]] {
    def derived(fromList: SimpleProduct1.ProductAdapter[F]): ReplaceByIndex[F] = new ReplaceByIndex[F] {
      override def replaceImpl[ProType](
        index: Int,
        proValue: ProType
      ): F[({ type X1[_] = ProType })#X1] => F[({ type X1[_] = ProType })#X1] = {
        val fromInt = fromList.append[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1](funcImpl[ProType], appendMonad[ProType])
        (t: F[({ type X1[_] = ProType })#X1]) => fromInt(index, proValue, t)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
