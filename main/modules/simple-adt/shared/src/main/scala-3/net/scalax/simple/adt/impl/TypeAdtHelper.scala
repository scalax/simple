package net.scalax.simple
package adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._

final class FetchAdtApply[S <: NatFunc]:

  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, Adt.Status.Passed]
  ): InnerApply[FetchAdtApply.TakeHead[S], FetchAdtApply.TakeTail[S]] =

    val list = v.value(data).asInstanceOf[NatFuncPositive[Any, NatFunc]]

    InnerApply(dataInstance = list.dataInstance, tail = list.tail)
      .asInstanceOf[InnerApply[FetchAdtApply.TakeHead[S], FetchAdtApply.TakeTail[S]]]

  end apply

end FetchAdtApply

object FetchAdtApply:

  type HListFix[t <: NatFunc, r] <: Tuple = t match
    case NatFuncPositive[IsFinishAndNothing, tail] => EmptyTuple
    case NatFuncPositive[d, tail]                  => (d => r) *: HListFix[tail, r]
  end HListFix

  type TakeHead[t <: NatFunc] = t match
    case NatFuncPositive[d, tail] => d
  end TakeHead

  type TakeTail[t <: NatFunc] <: NatFunc = t match
    case NatFuncPositive[d, tail] => tail
  end TakeTail

  inline final def get[S <: NatFunc]: FetchAdtApply[S] = null

end FetchAdtApply

abstract class FoldApplyInstance[O[_] <: Tuple]:
  protected def natFuncData: NatFunc

  def apply[U](funcCol: O[U]): U =
    val funcList = funcCol.productIterator.asInstanceOf[Iterator[Any => Any]].to(List)

    def findDeep(deep: Int, d: NatFunc): NatFuncPositive[Any, NatFunc] =
      if (deep == 0)
        d.asInstanceOf[NatFuncPositive[Any, NatFunc]]
      else
        findDeep(deep - 1, d).asInstanceOf[NatFuncPositive[Any, NatFunc]].tail.asInstanceOf[NatFuncPositive[Any, NatFunc]]
      end if
    end findDeep

    val result = funcList.zipWithIndex
      .foldLeft(FoldContext.empty: FoldContext[Any])((b, func) => b.overrideOnce(findDeep(func._2, natFuncData))(func._1))
      .asInstanceOf[FoldContext[U]]

    result.option.get
  end apply

end FoldApplyInstance

final class InnerApply[Data, T <: NatFunc](override val dataInstance: Option[Data], override val tail: T)
    extends NatFuncPositive[Data, T](dataInstance = dataInstance):
  self: InnerApply[Data, T] =>

  inline def fold: FoldApplyInstance[[x] =>> FetchAdtApply.HListFix[NatFuncPositive[Data, T], x]] =
    new FoldApplyInstance[[x] =>> FetchAdtApply.HListFix[NatFuncPositive[Data, T], x]]:
      protected def natFuncData: NatFunc = self
    end new
  end fold

end InnerApply
