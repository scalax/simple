package net.scalax.simple.adt.text.v3

class ParametersCodengen(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TypeGenTrait(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val text: String = s"""
      override def typeGen: TypeGen$index[M, ${typeParam1.mkString(',')}]
    """

  }

  class TraitContentDef(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val text: String = s"""
      override def content: AppenderNatSupport$index[M, ${typeParam1.mkString(',')}, ${typeParam4.mkString(',')}]
    """

  }

  class TraitBody(val index: Int) {

    val traitContentDef: TraitContentDef = new TraitContentDef(index)
    val typeGenTrait: TypeGenTrait       = new TypeGenTrait(index)

    val appenderH: Seq[String] = for (i1 <- 1 to index) yield s"def apH$i1: HListFunc[HLLike$i1, APRHLLike$i1]"

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[_, _ <: HLLike$i1] <: HLLike$i1"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val text: String = s"""
      trait ParameterNatSupport$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam3.mkString(',')},
        ${typeParam4.mkString(',')},
        ${typeParam6.mkString(',')}
      ] extends Parameter1NatSupport$index[
        M,
        ${typeParam7.mkString(',')},
        ${typeParam4.mkString(',')},
        ${typeParam8.mkString(',')}
      ] {
        ParameterNatSupport${index}Self =>

        ${traitContentDef.text}
        ${typeGenTrait.text}
        ${appenderH.mkString('\n')}
      }"""

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    ${preTextContent.mkString('\n')}
  """

}
