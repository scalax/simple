package net.scalax.simple.adt.codegen.text

class ProductTypeAppenderCodegen(val index: Int) {
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

    val text: String = s"""
      def Instance$index${ParamList(1, self5.index).text}: M3[
        AP1#Parameter${self5.index}${ParamList(1, self5.index).text},
        AP2#Parameter${self5.index}${ParamList(1, self5.index).text},
        AP3#Parameter${self5.index}${ParamList(1, self5.index).text}
      ]
    """
  }

  val preText = for (i <- 0 to self1.index) yield EachProductTypeCodegen(i).text
  val text: String = s"""
      package net.scalax.simple.adt
      package utils

      trait ProductType22Appender[
        Append1, AppendPositive1[_, _ <: Append1] <: Append1, AppendZero1 <: Append1,
        Append2, AppendPositive2[_, _ <: Append2] <: Append2, AppendZero2 <: Append2,
        Append3, AppendPositive3[_, _ <: Append3] <: Append3, AppendZero3 <: Append3,
        M3[_ <: Append1, _ <: Append2, _ <: Append3]
      ] {
        type AP1 = ProductType22[Append1, AppendPositive1, AppendZero1]
        type AP2 = ProductType22[Append2, AppendPositive2, AppendZero2]
        type AP3 = ProductType22[Append3, AppendPositive3, AppendZero3]

        ${preText.mkString("\n\n\n")}
      }
    """

}
