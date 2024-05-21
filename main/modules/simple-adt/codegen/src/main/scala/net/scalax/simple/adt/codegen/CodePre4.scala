package net.scalax.simple.adt.codegen

object CodePre4:

  def repeatBlank(count: Int)(text: Int => String): String = {
    repeat(count)(text)("")
  }

  def repeat(count: Int)(text: Int => String)(str: String): String = {
    val textVector1 = for i1 <- 1 to count yield text(i1)
    textVector1.mkString(str)
  }

  def repeatDot(count: Int)(text: Int => String): String = repeat(count)(text)(','.toString)

  /*def adtFunnctionDataType(max: Int)(i: Int): String =
    if i <= max then s"RuntimeData[Adt.Context[ParamType, I$i, Poly$i], ${adtFunnctionDataType(max)(i + 1)}]"
    else "RuntimeZero"*/

  def adtDataType(max: Int)(i: Int): String = if i < max then s"RuntimeData[I${max - i}, ${adtDataType(max)(i + 1)}]" else "RuntimeZero"

  def repeatParameter(i: Int): String = repeatDot(i)(u1 => s"func$u1: I$u1 => D")

  // def lawRepeatParameter(i: Int): String = repeatDot(i)(u1 => s"func$u1: Adt.Context[ParamType, I$u1, Poly$u1] => D")

  val text4: String = s"""
package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}

trait ADTPassedFunction {

  ${repeatBlank(22)(i =>
                          s"""implicit class extra$i[ParamType, ${repeatDot(i)(u1 => s"I$u1")}, ${repeatDot(i)(u1 =>
                              s"Poly$u1"
                            )}, SImpl <: ADTStatus](data$i: ADTData[${adtDataType(i)(
                              1
                            )}, SImpl]) {

    def fold[D](${repeatParameter(i)}): D = ???

}

"""
                        )}

}
""".stripMargin

end CodePre4
