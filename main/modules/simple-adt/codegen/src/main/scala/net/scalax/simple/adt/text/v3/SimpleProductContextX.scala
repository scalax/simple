package net.scalax.simple.adt.text.v3

class SimpleProductContextX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val text: String = s"""
      def simpleProduct$index: SimpleProduct$index.ProductAdapter[F]
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    trait SimpleProductContextX[F[_[_]]] {
      ${preTextContent.mkString('\n')}
    }
  """

}
