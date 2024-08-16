package net.scalax.simple.adt.codegen

class CodePre2(val isScala3: Boolean) {

  class CoProductXApplyCodegen(val index: Int) {
    self1 =>
    // ===
    class ParameterString(typeFunc: Int => String)(val index: Int) {
      self2 =>
      val text: String = if (index > 1) s"${ParameterString(typeFunc)(self2.index - 1).text} ${typeFunc(self2.index)}" else typeFunc(1)
    }
    class param1(override val index: Int) extends ParameterString(i => if (i > 1) s", I$i" else s"I$i")(index)
    // ===

    // ===
    case class DataTypeString(typeFunc: Int => String)(val index: Int) {
      self2 =>
      val text: String =
        if (self2.index <= self1.index) s"RuntimeData[${typeFunc(self2.index)}, ${DataTypeString(typeFunc)(self2.index + 1).text}]"
        else "RuntimeZero"
    }
    val param3 = DataTypeString(i => s"I$i")(1).text
    // ===

    // ===
    lazy val param5 = DataTypeString(i => s"AdtFunction[ParamType, I$i]")(1).text
    // ===

    // ===
    class ApplyStrCodegen(val index: Int) {
      self2 =>
      lazy val text: String =
        s"""override def apply[ParamType](a: ParamType)(implicit b: ADTData[this.NatModelTypeFunction[ParamType], ADTPassedFunction.type with ADTTypeParameterFetch.type]): NatModelType = {
           ${
            val str1 =
              if (isScala3) s"new ADTPassedFunction.extra(b).fold.except[NatModelType].apply"
              else s"new ADTPassedFunction.extra$index(b).fold"

            s"$str1${FoldStrFuncs(self2.index).text}"
          }
         }"""

      class FoldStrFuncs(override val index: Int)
          extends ParameterString(i => s"(t => option$i(t.adtFunctionApply(a)))")(
            index
          )
    }
    // ===

    // ===
    class OptionXCodegen(val index: Int) {
      self2 =>
      val text: String = if (self2.index > 0) OptionXCodegen(self2.index - 1).text + '\n'.toString + pathCodegen(self2.index).text else ""

      case class pathCodegen(index: Int) {
        val text: String = s"def option$index(iData: I$index): this.NatModelType = ${optionPathCodegen(index - 1).text}"

        case class optionPathCodegen(index: Int) {
          val text: String = if (index > 0) s"ADTData.copyTail(${optionPathCodegen(index - 1).text})" else "ADTData.success(iData)"
        }
      }
    }
    // ===

    val text: String = {

      lazy val param6 = s"({ type F1[ParamType] = $param5 })#F1"

      lazy val param7 = s"CoProduct$index[${param1(self1.index).text}]"
      lazy val param8 = s"CoProduct${index}Apply[${param1(self1.index).text}]"

      s"""
      def $param7:  $param8 = new $param8 {
        //
      }

      trait $param8 extends ApplyFactory[$param6, $param3] {

        ${OptionXCodegen(self1.index).text}

        ${ApplyStrCodegen(self1.index).text}

      }"""
    }
  }

  def repeatBlank(count: Int)(text: Int => String): String = {
    repeat(count)(text)("")
  }

  def repeat(count: Int)(text: Int => String)(str: String): String = {
    val textVector1 = for i1 <- 1 to count yield text(i1)
    textVector1.mkString(str)
  }

  val text: String = s"""
  package net.scalax.simple.adt
  package impl

  import temp._
  import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}

  trait TypeAdtRuntimeApply {
    ${repeatBlank(22)(i1 => CoProductXApplyCodegen(i1).text)}
  }
  """

}
