package net.scalax.simple.adt.codegen

class ProductTypeCodegen(val index: Int) {
  self1 =>

  class ProductTypeCodegenDefParam(val index: Int) {
    self2 =>
    val col          = for (i <- 1 to index) yield s"I$i"
    val text: String = if (col.isEmpty) col.mkString else col.mkString("[", ",", "]")
  }

  class ProductTypeAppender(val index: Int) {
    self3 =>

    class ProductTypeAppenderImpl(val index: Int) {
      self4 =>
      val text: String =
        if (self4.index <= self3.index) s"AppendPositive[I${self4.index}, ${ProductTypeAppenderImpl(self4.index + 1).text}]"
        else "AppendZero"
    }

    val text: String = ProductTypeAppenderImpl(1).text
  }

  class EachProductTypeCodegen(val index: Int) {
    self5 =>

    val text: String = s"type Parameter$index${ProductTypeCodegenDefParam(self5.index).text} = ${ProductTypeAppender(self5.index).text}"
  }

  val preText = for (i <- 0 to self1.index) yield EachProductTypeCodegen(i).text
  val text: String = s"""
      package net.scalax.simple.adt
      package utils

      trait ProductType22[Append, AppendPositive[_, _ <: Append] <: Append, AppendZero <: Append] {
        ${preText.mkString("\n\n\n")}
      }
    """

}
