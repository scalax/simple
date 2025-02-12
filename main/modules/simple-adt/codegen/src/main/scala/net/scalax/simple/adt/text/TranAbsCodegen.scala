package net.scalax.simple.adt.codegen.text

class TranAbsCodegen(val index: Int) {
  self1 =>

  class ParamList(val start: Int, val index: Int) {
    self2 =>
    val col          = for (i <- start to index) yield s"I$i"
    val text: String = if (col.isEmpty) col.mkString else col.mkString("[", ",", "]")
  }

  class EachProductTypeCodegen(val index: Int) {
    self5 =>

    val text: String = s"""
      def InstanceImpl$index${ParamList(1, self5.index).text}: M4[
        AP1#Parameter${self5.index}${ParamList(1, self5.index).text},
        AP2#Parameter${self5.index}${ParamList(1, self5.index).text},
        Folder22TypeParam#Parameter${self5.index}${ParamList(1, self5.index).text}#Result
      ]
    """
  }

  val preText = for (i <- 0 to self1.index) yield EachProductTypeCodegen(i).text
  val text: String = s"""
    package net.scalax.simple.adt
    package utils

    trait ProductType22Support[
      Append1, AppendPositive1[_, _ <: Append1] <: Append1, AppendZero1 <: Append1,
      Append2, AppendPositive2[_, _ <: Append2] <: Append2, AppendZero2 <: Append2,
      M4[_ <: Append1, _ <: Append2, _[_] <: Any]
    ] {
      type AP1 = ProductType22[Append1, AppendPositive1, AppendZero1]
      type AP2 = ProductType22[Append2, AppendPositive2, AppendZero2]

      ${preText.mkString("\n\n\n")}
    }
  """

}
