package net.scalax.simple
package adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._

final class FetchAdtApply[S <: NatFunc]:
  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, Adt.Status.Passed]
  ): InnerApply[[t] =>> FetchAdtApply.HListFix[S, t]] = InnerApply(v.value(data))
end FetchAdtApply

object FetchAdtApply:
  type HListFix[t <: NatFunc, r] <: Tuple = t match {
    case NatFuncPositive[IsFinishAndNothing, tail] => EmptyTuple
    case NatFuncPositive[d, tail]                  => (d => r) *: HListFix[tail, r]
  }

  inline final def get[S <: NatFunc]: FetchAdtApply[S] = null
end FetchAdtApply

final class InnerApply[O[_] <: Tuple](data: NatFunc):
  inline def fold[U](inline funcCol: O[U]): U =
    val funcList = funcCol.productIterator.asInstanceOf[Iterator[Any => Any]].to(List)
    def findDeep(deep: Int, d: NatFunc): NatFuncPositive[Any, NatFunc] =
      if (deep == 0) d.asInstanceOf[NatFuncPositive[Any, NatFunc]]
      else findDeep(deep - 1, d).asInstanceOf[NatFuncPositive[Any, NatFunc]].tail.asInstanceOf[NatFuncPositive[Any, NatFunc]]
    val result = funcList.zipWithIndex
      .foldLeft(FoldContext.empty: FoldContext[Any])((b, func) => b.overrideOnce(findDeep(func._2, data))(func._1))
      .asInstanceOf[FoldContext[U]]
    result.option.get
  end fold
end InnerApply
