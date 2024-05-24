package net.scalax.simple.adt.codegen

object ADTPassedFunctionCodegen:

  def repeatBlank(count: Int)(text: Int => String): String = {
    repeat(count)(text)("")
  }

  def repeat(count: Int)(text: Int => String)(str: String): String = {
    val textVector1 = for i1 <- 1 to count yield text(i1)
    textVector1.mkString(str)
  }

  def repeatDot(count: Int)(text: Int => String): String = repeat(count)(text)(','.toString)

  def adtDataType(max: Int)(i: Int): String = if i < max then s"RuntimeData[I$i, ${adtDataType(max)(i + 1)}]" else "RuntimeZero"

  def repeatParameter(i: Int): String = repeatDot(i)(u1 => s"func$u1: I$u1 => D")

  def lawRepeatParameter(max: Int)(i: Int): String =
    if (i < max) s"producter_build.appended(func${i + 1}).inputGHDMZSK(() => ${lawRepeatParameter(max)(i + 1)})"
    else "producter_build.zero"

  def typeStr(count: Int) = s"ADTData[${adtDataType(count)(1)}, SImpl]"

  val text4: String =
    s"""
package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}
import builder.{coproducter, producter_build}

trait ADTPassedFunction {

  ${repeatBlank(22)(i =>
        s"""implicit class extra$i[ParamType, ${repeatDot(i)(u1 => s"I$u1")}, SImpl <: AdtExtension](data$i: ${typeStr(i + 1)}) {

    def fold[D](${repeatParameter(i)}): D = {
      val func_link: ghdmzsk = ${lawRepeatParameter(i)(0)}

      TypeAdtGetter.getFromFunction(data$i.toGHDMZSK, func_link).asInstanceOf[D]
    }

}

"""
      )}

}
""".stripMargin

end ADTPassedFunctionCodegen
