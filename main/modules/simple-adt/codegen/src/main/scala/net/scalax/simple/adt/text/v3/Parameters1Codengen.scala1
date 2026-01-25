package net.scalax.simple.adt.text.v3

class Parameter1sCodengen(val index: Int) {
  Parameter1sCodengenSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TypeGenTrait(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val text: String = s"""
      override def typeGen: TypeGen$index[M, ${typeParam1.mkString(',')}]
    """

  }

  class TraitDef(val index: Int) {

    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[N$i1[Item], HCollection$i1]"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1 <: HLLike$i1"
    val typeParam9: Seq[String] = for (i1 <- 1 until Parameter1sCodengenSelf.index) yield s"Any"

    val text: String = s"""
      final def append1[Item, ${typeParam8.mkString(',')}](p1: M[${typeParam2.mkString(',')}]): M[${typeParam3.mkString(
        ','
      )}] = Parameter1NatSupport${index}Self.append10[Item, ${typeParam9.mkString(',')}, ${typeParam2.mkString(',')}](p1)
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

    val traitDef: TraitDef               = new TraitDef(index)
    val traitContentDef: TraitContentDef = new TraitContentDef(index)
    val typeGenTrait: TypeGenTrait       = new TypeGenTrait(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam9: Seq[String] = for (i1 <- 1 to Parameter1sCodengenSelf.index) yield s"U$i1"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"({ type TypeXM[${typeParam9.mkString(',')}] = N$i1[U1] })#TypeXM"

    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[_, _ <: HLLike$i1] <: HLLike$i1"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val text: String = s"""
      trait Parameter1NatSupport$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam3.mkString(',')},
        ${typeParam4.mkString(',')},
        ${typeParam6.mkString(',')}
      ] extends Parameter10NatSupport$index[
        M,
        ${typeParam7.mkString(',')},
        ${typeParam4.mkString(',')},
        ${typeParam8.mkString(',')}
      ] {
        Parameter1NatSupport${index}Self =>

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
