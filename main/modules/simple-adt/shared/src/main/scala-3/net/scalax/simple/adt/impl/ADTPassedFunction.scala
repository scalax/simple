package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._
import temp._
import temp.{Status => ADTStatus}

trait ADTPassedFunction:

  extension [N <: AdtNat](data: ADTData[N, ADTStatus.Passed])
    def fold: impl.ApplyImplicitInstance[[r] =>> impl.ExportToFunction[N, r]] =
      impl.ApplyImplicitInstance[[r] =>> impl.ExportToFunction[N, r]](data)
  end extension

end ADTPassedFunction

package impl:

  type ExportToFunction[t <: AdtNat, r] <: Tuple = t match
    case AdtNatData[d, tail] => (d => r) *: ExportToFunction[tail, r]
    case AdtNatZero          => EmptyTuple
  end ExportToFunction

  class ApplyImplicitInstance[O[U] <: Tuple](private val data: ADTData[AdtNat, ADTStatus.Passed]) extends AnyVal:
    def apply[D](parameters: O[D]): D =
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
        .value
      val funcs             = parameters.productIterator.asInstanceOf[Iterator[Any => Any]].to(List)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]

      funcInstance(dataInstance)
    end apply
  end ApplyImplicitInstance

end impl
