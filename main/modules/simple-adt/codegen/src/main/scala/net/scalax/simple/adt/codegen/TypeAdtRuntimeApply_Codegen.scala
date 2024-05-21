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
    if i <= max then s"RuntimeData[Adt.Context[ParamType, I$i, DefaultAdtContext.type], ${adtFunnctionDataType(max)(i + 1)}]"
    else "RuntimeZero"

  def adtDataType(max: Int)(i: Int): String = if i <= max then s"RuntimeData[I$i, ${adtDataType(max)(i + 1)}]" else "RuntimeZero"

  def optionString(index: Int): String =
    if (index > 0) s"ADTData.copyTail(${optionString(index - 1)}.toGHDMZSK)" else "ADTData.success(iData)"

  val text1: String = s"""
package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus, FunctionApply}
import temp._
import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}

trait TypeAdtRuntimeApply {
  ${repeatBlank(22) { i1 =>
      val parameterString: String = repeat(i1)(i2 => s"I$i2")(','.toString)

      val pamateterFunctionType: String = adtFunnctionDataType(i1)(1)

      val dataTypeString: String = adtDataType(i1)(1)

      val typeFunction = s"({ type F1[ParamType] = $pamateterFunctionType })#F1"

      s"""
      def CoProduct$i1[$parameterString]:  CoProduct${i1}Apply[$parameterString] = new CoProduct${i1}Apply[$parameterString] {
        //
      }

      trait CoProduct${i1}Apply[$parameterString] extends ApplyFactory[$typeFunction, $dataTypeString] {
        ${repeat(i1) { i2 =>
          s"def option$i2(iData: I$i2): ADTData[$dataTypeString, ADTStatus.Passed.type] = ${optionString(i2 - 1)}"
        }('\n'.toString)}

         def apply[ParamType, S <: ADTStatus](a: ParamType)(implicit b: ADTData[$pamateterFunctionType, S with ADTFunctionImplicitFetch.type]): Adt.Status.Passed.extra$i1[ParamType, ${repeat(
          i1
        )(i3 => s"I${i1 - i3 + 1}")(','.toString)}, ${repeat(i1)(i3 => "DefaultAdtContext.type")(','.toString)}, ADTStatus.Passed.type] = {
          new Adt.Status.Passed.extra$i1(new Adt.Status.Passed.extra$i1(b).fold(${repeat(i1)(i3 => s"t => option$i3(t.input(a))")(
          ','.toString
        )}))
        }
      }
    """

    }}
}
"""

end CodePre2
