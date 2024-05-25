package net.scalax.simple.adt

import temp._
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}
import builder.{coproducter, producter_build}

object ADTPassedFunction {

  import utils._

  implicit class extra[N <: RuntimeNat, SH <: GenericUtil.SimpleHList, ADTExtension](data: ADTData[N, ADTExtension])(using
    mapType: GenericUtil.MapType[N, SH]
  ) {

    def fold: ApplyToFunc.FunctionApplyInstance[[r] =>> ApplyToFunc.ToFunctionTuple[SH, r], ADTExtension] =
      ApplyToFunc.FunctionApplyInstance[[r] =>> ApplyToFunc.ToFunctionTuple[SH, r], ADTExtension](data)

  }

}
