package net.scalax.simple.adt.codegen

class FunctionTypeCodegen(val index: Int) {
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
      val REAbsText: String = if (self4.index == 1) "Nothing" else s"RE${self4.index - 1}"

      val text: String =
        if (self4.index <= self3.index)
          s"type Result[RE${self4.index} >: $REAbsText] = ResultFolder[I${self4.index}, ({ ${ProductTypeAppenderImpl(self4.index + 1).text} })#Result, RE${self4.index}]"
        else s"type Result[RE${self4.index} >: $REAbsText] = RE${self4.index}"
    }

    val text: String = ProductTypeAppenderImpl(1).text
  }

  class EachProductTypeCodegen(val index: Int) {
    self5 =>

    val text: String =
      s"""trait Parameter$index${ProductTypeCodegenDefParam(self5.index).text} {
        ${ProductTypeAppender(self5.index).text}
      }"""
  }

  val preText = for (i <- 0 to self1.index) yield EachProductTypeCodegen(i).text
  val text: String = s"""
      package net.scalax.simple.adt
      package utils

      trait Folder22TypeParam {
        ${preText.mkString("\n\n\n")}
      }
    """

}
