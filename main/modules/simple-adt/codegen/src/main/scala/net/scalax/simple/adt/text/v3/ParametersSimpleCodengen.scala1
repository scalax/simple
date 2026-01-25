package net.scalax.simple.adt.text.v3

class ParametersSimpleCodengen(val index: Int) {

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

    val typeParam5: Seq[String] = for (i1 <- 1 to index) yield s"I$i1"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"H$i1 <: HLLike$i1"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[I$i1, H$i1]"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"H$i1"
    val typeParam9: Seq[String] = for (i1 <- 1 to index) yield {
      s"""
      new ABCFunc[I$i1, H$i1, APRHLLike$i1[I$i1, H$i1]] {
        override def takeHead(m: APRHLLike$i1[I$i1, H$i1]): I$i1 = ParameterSimpleSupport${index}Self.apH$i1.takeHead(m)
        override def takeTail(m: APRHLLike$i1[I$i1, H$i1]): H$i1 = ParameterSimpleSupport${index}Self.apH$i1.takeTail(m)
        override def append(h: I$i1, t: H$i1): APRHLLike$i1[I$i1, H$i1] = ParameterSimpleSupport${index}Self.apH$i1.append(h, t)
      }
      """
    }

    val text: String = s"""
      override final def content: AppenderNatSupport$index[M, ${typeParam1.mkString(',')}, ${typeParam4.mkString(',')}] =
        new AppenderNatSupport$index[M, ${typeParam1.mkString(',')}, ${typeParam4.mkString(',')}] {
          override def append[${typeParam5.mkString(',')}, ${typeParam6.mkString(',')}](p1: M[${typeParam5.mkString(
        ','
      )}], p2: M[${typeParam8.mkString(',')}]): M[${typeParam7.mkString(',')}] = ParameterSimpleSupport${index}Self
          .simpleAppender
          .append(${typeParam9.mkString(',')})(p1, p2)
        }
    """

  }

  class SimpleAppenderDef(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val text: String = s"""
      def simpleAppender: SimpleAppender${index}Positive[M]
    """

  }

  class TraitBody(val index: Int) {

    val traitContentDef: TraitContentDef     = new TraitContentDef(index)
    val typeGenTrait: TypeGenTrait           = new TypeGenTrait(index)
    val simpleAppenderDef: SimpleAppenderDef = new SimpleAppenderDef(index)

    val appenderH: Seq[String] = for (i1 <- 1 to index) yield s"def apH$i1: HListFunc[HLLike$i1, APRHLLike$i1]"

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[_, _ <: HLLike$i1] <: HLLike$i1"

    val text: String = s"""
      trait ParameterSimpleSupport$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam3.mkString(',')},
        ${typeParam4.mkString(',')},
        ${typeParam6.mkString(',')}
      ] extends ParameterNatSupport$index[M, ${typeParam7.mkString(',')}, ${typeParam4.mkString(',')}, ${typeParam8.mkString(',')}] {
        ParameterSimpleSupport${index}Self =>

        ${traitContentDef.text}
        ${simpleAppenderDef.text}
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
