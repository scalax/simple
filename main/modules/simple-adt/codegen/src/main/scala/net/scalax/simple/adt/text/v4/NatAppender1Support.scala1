package net.scalax.simple.adt.text.v4

class NatAppender1SupportCodegen(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[_, _ <: HLLike$i1] <: HLLike$i1"
    val typeParam5: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1 <: HLLike$i1"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[T$i1, HCollection$i1]"

    val text: String = s"""
      trait Support$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam5.mkString(',')},
        ${typeParam3.mkString(',')},
        ${typeParam4.mkString(',')}
      ] {
        def append[${typeParam6.mkString(',')}](parameter: M[${typeParam7.mkString(',')}]): M[${typeParam8.mkString(',')}]
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    object NatAppender1 {
      ${preTextContent.mkString('\n')}
    }
  """

}
