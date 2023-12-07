package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ADTPassedFunction:

  import utils._

  extension [N <: AdtNat, S <: ADTStatus](data: ADTData[N, S])(using t: GenericUtil.SimpleHListFromAdtNat[N])
    def fold: ApplyToFunc.FunctionApplyInstance[[r] =>> ApplyToFunc.ToFunctionTuple[t.Out, r], S] =
      ApplyToFunc.FunctionApplyInstance[[r] =>> ApplyToFunc.ToFunctionTuple[t.Out, r], S](data)
  end extension

end ADTPassedFunction

package utils:

  object GenericUtil extends GenericUtilInstance
  object ApplyToFunc extends ApplyToFunctionUtilInstance

end utils
