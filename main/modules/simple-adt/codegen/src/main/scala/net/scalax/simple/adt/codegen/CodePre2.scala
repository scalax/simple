package net.scalax.simple.adt.codegen

object CodePre2:

  def repeatBlank(count: Int)(text: Int => String): String = {
    repeat(count)(text)("")
  }

  def repeat(count: Int)(text: Int => String)(str: String): String = {
    val textVector1 = for i1 <- 1 to count yield text(i1)
    textVector1.mkString(str)
  }

  def adtFunnctionDataType(max: Int)(i: Int): String =
    if i < max then s"AdtNatPositive[Adt.Context[ParamType, I${max - i}, DefaultAdtContext.type], ${adtFunnctionDataType(max)(i + 1)}]"
    else "AdtNatZero"

  def adtDataType(max: Int)(i: Int): String = if i < max then s"AdtNatPositive[I${max - i}, ${adtDataType(max)(i + 1)}]" else "AdtNatZero"

  val text1: String = s"""
package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait TypeAdtRuntimeApply {
  ${repeatBlank(22) { i1 =>
      val parameterString: String       = repeat(i1)(i2 => s"I$i2")(','.toString)
      val pamateterFunctionType: String = adtFunnctionDataType(i1)(0)
      val typeFunction                  = s"({ type F1[ParamType] = $pamateterFunctionType })#F1"

    s"""
      def CoProduct$i1[$parameterString] = ApplyFactory.build[$typeFunction]
      type CoProduct${i1}Apply[$parameterString] = ApplyFactory[$typeFunction]
    """

    }}
}
"""

end CodePre2
