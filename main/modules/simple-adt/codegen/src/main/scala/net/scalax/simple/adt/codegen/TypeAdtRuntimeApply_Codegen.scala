package net.scalax.simple.adt.codegen

object CodePre2:

  case class CoProductXApplyCodegen(index: Int) {
    self1 =>
    // ===
    case class ParameterString(typeFunc: Int => String)(index: Int) {
      self2 =>
      val text: String = if (index > 1) s"${ParameterString(typeFunc)(index - 1).text}, ${typeFunc(self2.index)}" else typeFunc(1)
    }
    val param1 = ParameterString(i => s"I$i")(index).text
    // ===

    // ===
    case class DataTypeString(typeFunc: Int => String)(index: Int) {
      self2 =>
      val text: String =
        if (self2.index <= self1.index) s"RuntimeData[${typeFunc(self2.index)}, ${DataTypeString(typeFunc)(self2.index + 1).text}]"
        else "RuntimeZero"
    }
    val param3 = DataTypeString(i => s"I$i")(1).text
    // ===

    // ===
    lazy val param5 = DataTypeString(i => s"Adt.Context[ParamType, I$i, DefaultAdtContext.type]")(1).text
    // ===

    // ===
    case class ApplyStrCodegen(index: Int) {
      val text: String =
        s"""override def apply[ParamType, S <: ADTStatus](a: ParamType)(implicit b: ADTData[$param5, S with ADTFunctionImplicitFetch.type]): ADTData[$param3, ADTStatus.Passed.type] = {
           new Adt.Status.Passed.extra$index(b).fold(${repeat(index)(i3 => s"t => option$i3(t.input(a))")(','.toString)})
         }"""
    }
    lazy val param4: String = ApplyStrCodegen(index).text
    // ===

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
    // ===

    val text: String = {

      lazy val param6 = s"({ type F1[ParamType] = $param5 })#F1"

      lazy val param7 = s"CoProduct$index[${param1}]"
      lazy val param8 = s"CoProduct${index}Apply[${param1}]"

      s"""
      def $param7:  $param8 = new $param8 {
        //
      }

      trait $param8 extends ApplyFactory[$param6, $param3] {

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
    ${repeatBlank(22)(i1 => CoProductXApplyCodegen(i1).text)}
  }
  """

end CodePre2
