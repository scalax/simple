package net.scalax.simple.adt.codegen

object CodePre1:

  def repeatBlank(count: Int)(text: Int => String): String = {
    repeat(count)(text)("")
  }

  def repeat(count: Int)(text: Int => String)(str: String): String = {
    val textVector1 = for i1 <- 1 to count yield text(i1)
    textVector1.mkString(str)
  }

  def adtFunnctionDataType(max: Int)(i: Int): String =
    if i <= max then s"AdtNatPositive[Adt.Context[ParamType, I$i, Poly$i], ${adtFunnctionDataType(max)(i + 1)}]"
    else "AdtNatZero"

  def adtDataType(max: Int)(i: Int): String = if i < max then s"AdtNatPositive[I${max - i}, ${adtDataType(max)(i + 1)}]" else "AdtNatZero"

  val text1: String = s"""
package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ADTPassedFunctionImpl {
  ${repeatBlank(22)(i1 =>
                          val str1 = s"Adt.CoProduct$i1[${repeat(i1)(i2 => s"I$i2")(','.toString)}]"

                          s"""implicit class extraFunctionAdt$i1[ParamType, ${repeat(i1)(i2 => s"I$i2, Poly$i2")(
                              ','.toString
                            )}, S <: ADTStatus](private val data: ADTData[${adtFunnctionDataType(i1)(1)}, S]) {

    private val adtApply = Adt.CoProduct$i1[${repeat(i1)(i2 => s"I$i2")(','.toString)}]

    def apply(param: ParamType): $str1 =
      new ADTStatus.Passed.extra$i1(data).fold(${repeat(i1)(i2 => s"s => adtApply.option$i2(s.input(param): I$i2): $str1")(
                              ','.toString
                            )})

  }

  """.stripMargin
                        )}
}
""".stripMargin

end CodePre1
