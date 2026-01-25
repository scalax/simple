package net.scalax.simple.adt.text.v3

class ParameterSingleNatSupportX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TypeGenTrait(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val text: String = s"""
      override def typeGen: TypeGen$index[M, ${typeParam1.mkString(',')}]
    """

  }

  class TraitBody(val index: Int) {

    val typeGenTrait: TypeGenTrait = new TypeGenTrait(index)

    val appenderH: Seq[String] =
      for (i1 <- 1 to index) yield s"override final def apH$i1: HListFunc[HLLike, APRHLLike] = ParameterNatSupport${index}Self.apH"

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"

    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"HLLike"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike"

    val text: String = s"""
      trait ParameterSingleNatSupport$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam3.mkString(',')},
        HLLike,
        APRHLLike[_, _ <: HLLike] <: HLLike
      ] extends ParameterSimpleSupport$index[M, ${typeParam2.mkString(',')}, ${typeParam4.mkString(',')}, ${typeParam6.mkString(',')}] {
        ParameterNatSupport${index}Self =>

        ${typeGenTrait.text}

        override def simpleAppender: SimpleAppender${index}Positive[M]
        def apH: HListFunc[HLLike, APRHLLike]

        ${appenderH.mkString('\n')}
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    ${preTextContent.mkString('\n')}
  """

}
