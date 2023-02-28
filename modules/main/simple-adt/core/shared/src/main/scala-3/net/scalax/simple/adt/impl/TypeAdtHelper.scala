package net.scalax.simple
package adt
package impl

import core.Core2

final class FetchAdtApply[S <: Tuple]:
  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, Adt.Status.Passed]
  ): InnerApply[[t] =>> Tuple.Map[S, [x] =>> (x => t)]] = InnerApply(adtList = v.value, data = data)
end FetchAdtApply

object FetchAdtApply:
  inline final def get[S <: Tuple]: FetchAdtApply[S] = null
end FetchAdtApply

final class InnerApply[O[_] <: Tuple](adtList: Core2, data: Any):
  inline def fold[U](inline funcCol: O[U]): U =
    val foldNumber = () => FoldListAppender.appendAll(data, funcCol.productIterator.asInstanceOf[Iterator[Any => Any]].to(List))
    val result     = adtList(foldNumber).asInstanceOf[AdtValueGetter]
    result.value.asInstanceOf[U]
  end fold
end InnerApply
