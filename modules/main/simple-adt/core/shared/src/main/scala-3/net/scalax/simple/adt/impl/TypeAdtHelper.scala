package net.scalax.simple.adt
package impl

import CoreInstance._

final class FetchAdtApply[S <: Tuple]:
  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, ConfirmSucceed]
  ): InnerApply[[t] =>> Tuple.Map[S, [x] =>> (x => t)]] = InnerApply(adtList = v.value, data = data)
end FetchAdtApply

object FetchAdtApply:
  inline final def get[S <: Tuple]: FetchAdtApply[S] = null
end FetchAdtApply

final class InnerApply[O[_] <: Tuple](adtList: Core2, data: Any):
  inline def fold[U](inline funcCol: O[U]): U =
    def tranToFoldList(t: Tuple): () => Core2 = t.match
      case head *: tail => () => FoldListAppender.append(data, head.asInstanceOf[Any => Any])(tranToFoldList(tail))
      case EmptyTuple   => () => FoldListZero
    end tranToFoldList

    val foldNumber = tranToFoldList(funcCol)
    adtList(foldNumber).asInstanceOf[TypeAdtGetter].runGetter.asInstanceOf[U]
  end fold
end InnerApply
