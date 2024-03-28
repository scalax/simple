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
    if i <= max then s"AdtNatPositive[Adt.Context[ParamType, I$i, DefaultAdtContext.type], ${adtFunnctionDataType(max)(i + 1)}]"
    else "AdtNatZero"

  def adtDataType(max: Int)(i: Int): String = if i <= max then s"AdtNatPositive[I$i, ${adtDataType(max)(i + 1)}]" else "AdtNatZero"

  val text1: String = s"""
package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait TypeAdtRuntimeApply {
  ${repeatBlank(22) { i1 =>
      val parameterString: String       = repeat(i1)(i2 => s"I$i2")(','.toString)
      val pamateterFunctionType: String = adtFunnctionDataType(i1)(1)
      val dataTypeString: String        = adtDataType(i1)(1)
      val typeFunction                  = s"({ type F1[ParamType] = $pamateterFunctionType })#F1"

    s"""
      def CoProduct$i1[$parameterString]:  CoProduct${i1}Apply[$parameterString] = new ApplyFactory[$typeFunction, $dataTypeString] {
        override protected def cv[ParamType, S <: ADTStatus](a: ParamType, b: ADTData[$pamateterFunctionType, S with ADTFunctionImplicitFetch.type]): ADTData[$dataTypeString, ADTStatus.Passed.type] = {
1
???
        }
      }
      type CoProduct${i1}Apply[$parameterString] = ApplyFactory[$typeFunction, $dataTypeString]
    """

    }}
}
"""

end CodePre2
