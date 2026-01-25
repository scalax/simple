package net.scalax.simple.adt.text.v3

class SimpleAppenderPositiveX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class AppenderDef(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"A$i1"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"B$i1"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"C$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"f$i1: ABCFunc[A$i1, B$i1, C$i1]"

    val text: String = s"""
      def append[${typeParam1.mkString(',')}, ${typeParam2.mkString(',')}, ${typeParam3.mkString(',')}]
        (${typeParam4.mkString(',')})
        (a: M[${typeParam1.mkString(',')}], b: M[${typeParam2.mkString(',')}])
        : M[${typeParam3.mkString(',')}]
    """

  }

  class TraitBody(val index: Int) {

    val appenderDef: AppenderDef = new AppenderDef(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"

    val text: String = s"""
      trait SimpleAppender${index}Positive[M[${typeParam1.mkString(',')}]] {
        ${appenderDef.text}
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
