package net.scalax.simple
package adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk

final class FetchAdtApply[S <: Tuple]:
  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, Adt.Status.Passed]
  ): InnerApply[[t] =>> Tuple.Map[S, [x] =>> (x => t)]] = InnerApply(adtList = v.value, data = data)
end FetchAdtApply

object FetchAdtApply:
  inline final def get[S <: Tuple]: FetchAdtApply[S] = null
end FetchAdtApply

final class InnerApply[O[_] <: Tuple](adtList: VarSetting[TypeAdt.Context[Any, Any, Any]] => ghdmzsk, data: Any):
  inline def fold[U](inline funcCol: O[U]): U =
    val foldList = FoldListAppender.appendAll(funcCol.productIterator.asInstanceOf[Iterator[Any => Any]].to(List))
    FoldListAppender.result(foldList = foldList, adtList = adtList, data = data)
  end fold
end InnerApply
