package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}

trait ADTPassedFunction:

  import utils._

  extension [N <: AdtNat, S <: ADTStatus, H <: GenericUtil.SimpleHList](data: ADTData[N, S])(using t: GenericUtil.SimpleHListAux[N, H])
    def fold: ApplyToFunc.FunctionApplyInstance[[r] =>> ApplyToFunc.ToFunctionTuple[H, r], S] =
      ApplyToFunc.FunctionApplyInstance[[r] =>> ApplyToFunc.ToFunctionTuple[H, r], S](data)
  end extension

end ADTPassedFunction

package utils:

  object GenericUtil extends GenericUtilInstance
  object ApplyToFunc extends ApplyToFunctionUtilInstance

end utils
