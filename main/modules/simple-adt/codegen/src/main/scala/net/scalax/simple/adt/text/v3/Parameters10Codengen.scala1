package net.scalax.simple.adt.text.v3

class Parameters10Codengen(val index: Int) {
  Parameters10CodengenSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TypeGenTrait(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val text: String = s"""
      def typeGen: Type10Gen$index[M, ${typeParam1.mkString(',')}]
    """

  }

  class TraitDef(val index: Int) {

    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam9: Seq[String] = for (i1 <- 1 to Parameters10CodengenSelf.index) yield s"Item$i1"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[N$i1[${typeParam9.mkString(',')}], HCollection$i1]"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1 <: HLLike$i1"

    val text: String = s"""
      def append10[${typeParam9.mkString(',')}, ${typeParam8.mkString(',')}](p1: M[${typeParam2.mkString(',')}]): M[${typeParam3.mkString(
        ','
      )}] = Parameter10NatSupport${index}Self.content.append(Parameter10NatSupport${index}Self.typeGen.gen10[${typeParam9.mkString(
        ','
      )}], p1)
    """

  }

  class TraitContentDef(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val text: String = s"""
      def content: AppenderNatSupport$index[M, ${typeParam1.mkString(',')}, ${typeParam4.mkString(',')}]
    """

  }

  class TraitBody(val index: Int) {

    val traitDef: TraitDef               = new TraitDef(index)
    val traitContentDef: TraitContentDef = new TraitContentDef(index)
    val typeGenTrait: TypeGenTrait       = new TypeGenTrait(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String] = for (_ <- 1 to Parameters10CodengenSelf.index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[${typeParam2.mkString(',')}]"

    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[_, _ <: HLLike$i1] <: HLLike$i1"

    val text: String = s"""
      trait Parameter10NatSupport$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam3.mkString(',')},
        ${typeParam4.mkString(',')},
        ${typeParam6.mkString(',')}
      ] {
        Parameter10NatSupport${index}Self =>

        ${traitDef.text}

        ${traitContentDef.text}
        ${typeGenTrait.text}
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
