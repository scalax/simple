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

abstract class FoldOptApplyInstance[O[_] <: Tuple]:
  protected def natFuncData: NatFunc

  def apply[U](funcCol: O[U]): Option[U] =
    val funcList = funcCol.productIterator.asInstanceOf[Iterator[Any => Any]].to(List)

    def findDeep(funcList: List[Any => Any], d: NatFunc): Option[Any] =

      inline def aliasD = d.asInstanceOf[NatFuncPositive[Any, NatFunc]]

      funcList.match
        case headFunc :: tailFunc =>
          val headDataOpt = aliasD.dataInstance
          if (headDataOpt.isDefined)
            Some(headFunc(headDataOpt.get))
          else
            findDeep(tailFunc, aliasD.tail)
          end if

        case Nil =>
          Option.empty
      end match

    end findDeep

    findDeep(funcList, natFuncData).asInstanceOf[Option[U]]
  end apply

end FoldOptApplyInstance

abstract class FoldApplyInstance[O[_] <: Tuple]:
  protected def natFuncData: NatFunc

  def apply[U](funcCol: O[U]): U =
    inline def aliasNatFuncData = natFuncData

    val instance =
      new FoldOptApplyInstance[O]:
        override protected def natFuncData: NatFunc = aliasNatFuncData
      end new
    end instance

    instance(funcCol).get
  end apply

end FoldApplyInstance

final class InnerApply[Data, T <: NatFunc](override val dataInstance: Option[Data], override val tail: T)
    extends NatFuncPositive[Data, T](dataInstance = dataInstance):
  self: InnerApply[Data, T] =>

  inline def foldOpt: FoldOptApplyInstance[[x] =>> FetchAdtApply.HListFix[NatFuncPositive[Data, T], x]] =
    new FoldOptApplyInstance[[x] =>> FetchAdtApply.HListFix[NatFuncPositive[Data, T], x]]:
      protected def natFuncData: NatFunc = self
    end new
  end foldOpt

  inline def fold: FoldApplyInstance[[x] =>> FetchAdtApply.HListFix[NatFuncPositive[Data, T], x]] =
    new FoldApplyInstance[[x] =>> FetchAdtApply.HListFix[NatFuncPositive[Data, T], x]]:
      protected def natFuncData: NatFunc = self
    end new
  end fold

end InnerApply
