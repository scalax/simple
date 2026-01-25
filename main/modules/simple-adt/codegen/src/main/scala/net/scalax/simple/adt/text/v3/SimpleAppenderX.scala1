package net.scalax.simple.adt.text.v3

class SimpleAppenderX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"

    val text: String = s"""
      trait SimpleAppender$index[M[${typeParam1.mkString(
        ','
      )}]] extends SimpleAppender${index}Positive[M] with SimpleAppender${index}Zero[M]
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
