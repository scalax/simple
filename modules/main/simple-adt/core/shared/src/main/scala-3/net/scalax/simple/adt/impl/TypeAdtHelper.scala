package net.scalax.simple.adt
package impl

import CoreInstance._

final class FetchAdtApply[S <: Tuple, Poly]:
  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, ConfirmSucceed, Poly]
  ): InnerApply[[t] =>> Tuple.Map[S, [x] =>> (x => t)]] = InnerApply(adtList = v.value, data = data)
end FetchAdtApply

object FetchAdtApply:
  inline final def get[S <: Tuple, Poly]: FetchAdtApply[S, Poly] = null
end FetchAdtApply

final class InnerApply[O[_] <: Tuple](adtList: Core2, data: Any):
  inline def fold[U](inline funcCol: O[U]): U =
    def tranToFoldList(t: Tuple): () => Core2 = t.match
      case head *: tail => () => FoldListAppender.append(data, head.asInstanceOf[Any => Any], tranToFoldList(tail))
      case EmptyTuple   => () => FoldListZero
    end tranToFoldList

    val foldNumber = tranToFoldList(funcCol)
    val result     = adtList(foldNumber).asInstanceOf[AdtConvertWrapper]
    result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[U]
  end fold
end InnerApply
