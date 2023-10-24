package net.scalax.simple.adt
package impl
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ApplyToFunctionUtilInstance:

  type ToFunctionTuple[t <: GenericUtil.SimpleHList, r] <: Tuple = t match
    case GenericUtil.SimpleHListPositive[d, tail] => (d => r) *: ToFunctionTuple[tail, r]
    case GenericUtil.SimpleHListZero              => EmptyTuple
  end ToFunctionTuple

  class FunctionApplyInstance[O[U] <: Tuple, S <: ADTStatus](private val data: ADTData[AdtNat, S]):
    def apply[D](parameters: O[D]): D =
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(() => ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs             = parameters.productIterator.asInstanceOf[Iterator[Any => Any]].to(List)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(() => listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]

      funcInstance(dataInstance)
    end apply
  end FunctionApplyInstance

end ApplyToFunctionUtilInstance
