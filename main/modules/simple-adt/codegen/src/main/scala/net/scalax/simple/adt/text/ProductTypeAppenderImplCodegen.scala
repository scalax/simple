package net.scalax.simple.adt.codegen.text

class ProductTypeAppenderImplCodegen(val index: Int) {
  self1 =>

  class ParamList(val start: Int, val index: Int) {
    self2 =>
    val col          = for (i <- start to index) yield s"I$i"
    val text: String = if (col.isEmpty) col.mkString else col.mkString("[", ",", "]")
  }

  class DefValue(val index: Int) {
    self3 =>

    val text: String =
      if (self3.index == 0) s"helper.zero"
      else s"helper.append(productSelf.Instance${self3.index - 1}${ParamList(2, self3.index).text})"
  }
  class EachProductTypeCodegen(val index: Int) {
    self5 =>

    val text: String =
      s"""override def Instance$index${ParamList(1, self5.index).text}:
        M3[
          AP1#Parameter${self5.index}${ParamList(1, self5.index).text},
          AP2#Parameter${self5.index}${ParamList(1, self5.index).text},
          AP3#Parameter${self5.index}${ParamList(1, self5.index).text}
        ] = ${DefValue(self5.index).text}""".stripMargin
  }

  val preText = for (i <- 0 to self1.index) yield EachProductTypeCodegen(i).text
  val text: String = s"""
    package net.scalax.simple.adt
    package utils

    object ProductType22AppenderGen {

      def gen[
        Append1, AppendPositive1[_, _ <: Append1] <: Append1, AppendZero1 <: Append1,
        Append2, AppendPositive2[_, _ <: Append2] <: Append2, AppendZero2 <: Append2,
        Append3, AppendPositive3[_, _ <: Append3] <: Append3, AppendZero3 <: Append3,
        M3[_ <: Append1, _ <: Append2, _ <: Append3]
      ](
        helper: CCDD.ABDECD[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, Append3, AppendPositive3, AppendZero3, M3]
      ): ProductType22Appender[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, Append3, AppendPositive3, AppendZero3, M3] =
        new ProductType22Appender[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, Append3, AppendPositive3, AppendZero3, M3] {
          productSelf =>

          ${preText.mkString("\n\n\n")}
      }

    }
  """

}
