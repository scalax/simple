package net.scalax.simple.adt.text.v3

class SimpleAppenderZeroX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class ZeroDef(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"p$i1: N$i1"

    val text: String = s"""
      def zero[${typeParam1.mkString(',')}](${typeParam2.mkString(',')}): M[${typeParam1.mkString(',')}]
    """

  }

  class TraitBody(val index: Int) {

    val zeroDef: ZeroDef = new ZeroDef(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"

    val text: String = s"""
      trait SimpleAppender${index}Zero[M[${typeParam1.mkString(',')}]] {
        ${zeroDef.text}
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
