package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}

trait ADTPassedFunction:

  extension [N <: AdtNat, S <: ADTStatus](data: ADTData[N, S])(using t: impl1.HListTran[N])
    def fold: impl1.ApplyImplicitInstance[[r] =>> impl1.ExportToFunction[t.Out, r], S] =
      impl1.ApplyImplicitInstance[[r] =>> impl1.ExportToFunction[t.Out, r], S](data)
  end extension

end ADTPassedFunction

package impl1:

  trait HListI1
  class HListI1Positive[T, Tail <: HListI1] extends HListI1
  class HListI1Zero                         extends HListI1

  trait HListTran[N <: AdtNat]:
    type Out <: HListI1
  end HListTran

  object HListTran extends HListTranImplicit1:
    type Aux[N <: AdtNat, O <: HListI1] = HListTran[N] { type Out = O }

    given HListTran.Aux[AdtNatZero, HListI1Zero] = new HListTran[AdtNatZero] {
      override type Out = HListI1Zero
    }
  end HListTran

  trait HListTranImplicit1:
    given [Data, T <: AdtNat, O <: HListI1](using
      t1: HListTran.Aux[T, O]
    ): HListTran.Aux[AdtNatPositive[Data, T], HListI1Positive[Data, O]] = new HListTran[AdtNatPositive[Data, T]] {
      override type Out = HListI1Positive[Data, O]
    }
  end HListTranImplicit1

  type ExportToFunction[t <: HListI1, r] <: Tuple = t match
    case HListI1Positive[d, tail] => (d => r) *: ExportToFunction[tail, r]
    case HListI1Zero              => EmptyTuple
  end ExportToFunction

  class ApplyImplicitInstance[O[U] <: Tuple, S <: ADTStatus](private val data: ADTData[AdtNat, S]) extends AnyVal:
    def apply[D](parameters: O[D]): D =
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs             = parameters.productIterator.asInstanceOf[Iterator[Any => Any]].to(List)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]

      funcInstance(dataInstance)
    end apply
  end ApplyImplicitInstance

end impl1
