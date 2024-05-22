package net.scalax.simple.adt.codegen

object CodePre2:

  case class ParameterString(index: Int) {
    val text: String = if (index > 1) s"${ParameterString(index - 1).text}, I$index" else "I1"
  }

  case class CoProductXApplyCodegen(index: Int) {

    val param1 = ParameterString(index).text

    // ===
    case class DataTypeString(max: Int) {
      self =>
      val text: String = textImpl(1)

      private def textImpl(index: Int): String =
        if (index <= max) s"RuntimeData[I$index, ${self.textImpl(index + 1)}]" else "RuntimeZero"
    }
    val param3 = DataTypeString(index).text
    // ===

    // ===
    case class ApplyStrCodegen(index: Int) {
      val text: String =
        s"""override def apply[ParamType, S <: ADTStatus](a: ParamType)(implicit b: ADTData[$param5, S with ADTFunctionImplicitFetch.type]): ADTData[${DataTypeString(
            index
          ).text}, ADTStatus.Passed.type] = {
           new Adt.Status.Passed.extra$index(b).fold(${repeat(index)(i3 => s"t => option$i3(t.input(a))")(','.toString)})
         }"""
    }
    lazy val param4: String = ApplyStrCodegen(index).text
    // ===

    // ===
    case class AdtFunnctionDataType(max: Int) {
      self =>
      def text(ParamType: String): String = textImpl(ParamType)(1)

      private def textImpl(ParamType: String)(index: Int): String =
        if (index <= max) s"RuntimeData[Adt.Context[$ParamType, I$index, DefaultAdtContext.type], ${self.textImpl(ParamType)(index + 1)}]"
        else "RuntimeZero"
    }
    lazy val param5 = AdtFunnctionDataType(index).text("ParamType")
    // ===

    case class option22Codegen(index: Int) {
      val text: String = if (index > 0) option22Codegen(index - 1).text + '\n'.toString + pathCodegen(index).text else ""

      case class pathCodegen(index: Int) {
        val text: String = s"def option$index(iData: I$index): this.NatModelType = ${optionPathCodegen(index - 1).text}"

        case class optionPathCodegen(index: Int) {
          val text: String = if (index > 0) s"ADTData.copyTail(${optionPathCodegen(index - 1).text})" else "ADTData.success(iData)"
        }
      }
    }

    val text: String = {

      lazy val param6 = s"({ type F1[ParamType] = $param5 })#F1"

      s"""trait CoProduct${index}Apply[$param1] extends ApplyFactory[$param6, $param3] {

        ${option22Codegen(index).text}

        $param4

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

  val text1: String = s"""
  package net.scalax.simple.adt
  package impl

  import Adt.{Status => ADTStatus}
  import temp._
  import net.scalax.simple.adt.{RuntimeNat, RuntimeData, RuntimeZero}

  trait TypeAdtRuntimeApply {
    ${repeatBlank(22) { i1 =>
      s"""
        def CoProduct$i1[${ParameterString(i1).text}]:  CoProduct${i1}Apply[${ParameterString(
          i1
        ).text}] = new CoProduct${i1}Apply[${ParameterString(
          i1
        ).text}] {
          //
        }

         ${CoProductXApplyCodegen(i1).text}

      """

    }}
  }
  """

end CodePre2
