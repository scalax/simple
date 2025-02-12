package net.scalax.simple.adt.codegen

object ADTPassedFunctionCodegen:

  /*class ParamCodegen1(val index: Int) {
    self2 =>

    class InnerParamCodegen2(val index: Int) {
      self3 =>

      val text: String =
        if (self3.index <= self2.index)
          s"({ type UU${self3.index}X[T${self3.index}] = Positive2[I${self3.index}, ${InnerParamCodegen2(self3.index + 1).text}, T${self3.index}] })#UU${self3.index}X"
        else
          s"({ type UU${self3.index}X[T${self3.index}] = T${self3.index} })#UU${self3.index}X"
    }

    val text: String = self2.InnerParamCodegen2(1).text
  }*/

  class DefParamCodegen2(val index: Int) {
    self4 =>

    private val preText = for i <- 1 to index yield s"I$i"

    val text: String = if (preText.isEmpty) preText.mkString else preText.mkString("[", ",", "]")
  }

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

  def typeStr(count: Int) = s"ADTData[${adtDataType(count)(1)}, ADTExtension]"

  val text4: String =
    s"""
package net.scalax.simple.adt

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}
import builder.{coproducter, producter_build}
import net.scalax.simple.adt.impl.CompatAppend

object ADTPassedFunction extends ADTPassedFunctionImpl1 {

  ${repeatBlank(22) { i1 =>
        s"""implicit class extra$i1[ParamType, ${repeatDot(i1)(u1 => s"I$u1")}, ADTExtension](private val data$i1: ${typeStr(
            i1 + 1
          )}) extends AnyVal {

    def fold: utils.Folder22TypeParam#Parameter$i1${DefParamCodegen2(i1).text}#Result[Nothing] = {
      val r1 = CompatAppend.compatAppend.InstanceImpl$i1${DefParamCodegen2(i1).text}
      r1.appendUser[ADTExtension](data$i1)
    }

    // def fold11[D](${repeatParameter(i1)}): D = {
    //   val func_link: ghdmzsk = ${lawRepeatParameter(i1)(0)}
    //
    //   TypeAdtGetter.getFromFunction(data$i1.toGHDMZSK, func_link).asInstanceOf[D]
    // }

}

"""
      }}

}
""".stripMargin

end ADTPassedFunctionCodegen
