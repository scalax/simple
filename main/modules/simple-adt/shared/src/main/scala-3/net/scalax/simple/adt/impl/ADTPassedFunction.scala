package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}

trait ADTPassedFunction:

  extension [N <: AdtNat, S <: ADTStatus](data: ADTData[N, S])
    def fold: impl.ApplyImplicitInstance[[r] =>> impl.ExportToFunction[N, r], S] =
      impl.ApplyImplicitInstance[[r] =>> impl.ExportToFunction[N, r], S](data)
  end extension

end ADTPassedFunction

package impl:

  type ExportToFunction[t <: AdtNat, r] <: Tuple = t match
    case AdtNatPositive[IsFinishAndNothing, _] => EmptyTuple
    case AdtNatPositive[d, tail]               => (d => r) *: ExportToFunction[tail, r]
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

end impl
