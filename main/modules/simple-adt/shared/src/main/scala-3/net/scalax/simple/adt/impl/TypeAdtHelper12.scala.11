package net.scalax.simple
package adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._

final class FetchAdtApply[S <: NatFunc]:

  inline final def apply[T](inline data: T)(using
    inline v: TypeAdtApply.Aux[T, S, Adt.Status.Passed]
  ): InnerApply[FetchAdtApply.TakeHead[S], FetchAdtApply.TakeTail[S]] =

    val list = v.value(false)(data).asInstanceOf[NatFuncPositive[Any, NatFunc]]

    val applyModel = new InnerApply(dataInstance = list.dataInstance, isAlreadyOk = list.isAlreadyOk, tail = list.tail) {
      override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = list.inputGHDMZSK(t)
      override val index: Int                           = list.index
    }

    applyModel.asInstanceOf[InnerApply[FetchAdtApply.TakeHead[S], FetchAdtApply.TakeTail[S]]]

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
          aliasD.match
            case TypeAdt.Option1(data) =>
              Some(headFunc(data))
            case _ =>
              findDeep(tailFunc, aliasD.tail)
          end match

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

abstract class InnerApply[Data, T <: NatFunc](
  override val dataInstance: Option[Data],
  override val isAlreadyOk: Boolean,
  override val tail: T
) extends NatFuncPositive[Data, T](dataInstance = dataInstance):
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
