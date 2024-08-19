package net.scalax.simple.adt.codegen.text

class TranCodegen(val index: Int) {
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
      s"""
      override def InstanceImpl$index${ParamList(1, self5.index).text}:
        M4[
          AP1#Parameter${self5.index}${ParamList(1, self5.index).text},
          AP2#Parameter${self5.index}${ParamList(1, self5.index).text},
          Folder22TypeParam#Parameter${self5.index}${ParamList(1, self5.index).text}#Result
        ] = tran.to[
          AP1#Parameter${self5.index}${ParamList(1, self5.index).text},
          AP2#Parameter${self5.index}${ParamList(1, self5.index).text},
          S2Support.AP3#Parameter${self5.index}${ParamList(1, self5.index).text}
        ](appender.Instance$index${ParamList(1, self5.index).text})
      """
  }

  val preText = for (i <- 0 to self1.index) yield EachProductTypeCodegen(i).text
  val text: String = s"""
    package net.scalax.simple.adt
    package utils

    import support.S2Support

    object Product22Gen {
      def gen[
        Append1, AppendPositive1[_, _ <: Append1] <: Append1, AppendZero1 <: Append1,
        Append2, AppendPositive2[_, _ <: Append2] <: Append2, AppendZero2 <: Append2,
        M3[_ <: Append1, _ <: Append2, _ <: S2Support.Func],
        M4[_ <: Append1, _ <: Append2, _[_] <: Any]
      ](
        appender: ProductType22Appender[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, S2Support.Func, S2Support.Append11, S2Support.Zero, M3],
        tran: S2Support.M1ToM2[Append1, Append2, M3, M4]
      ): ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] =
        new ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] {
          ${preText.mkString("\n\n\n")}
        }
    }
  """

}
