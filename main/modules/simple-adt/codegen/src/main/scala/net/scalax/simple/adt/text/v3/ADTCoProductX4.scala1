package net.scalax.simple.adt.text.v3

class ADTCoProductX4(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"T$i1 <: Target"
    val typeParam2: Seq[String] = "Target" +: (for (i1 <- 2 to index) yield s"T$i1")

    def typeParam4Impl(index: Int): String =
      if (index <= TraitBodySelf.index) s"APCoProduct1[T$index, ${typeParam4Impl(index + 1)}]" else "CoZero1"
    val typeParam4: String = typeParam4Impl(1)
    val typeParam6: String = typeParam4Impl(2)

    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"

    val text: String = s"""
      def inputHList$index[
        Target,
        ${typeParam1.mkString(',')}
      ]: $typeParam4 => Option[Target] = {
        ADTCoProductX4Self.supportX1.inputHList$index[Target, ${typeParam7.mkString(
        ','
      )}](ADTCoProductX4Self.supportX3.inputHList$index[Target, ${typeParam7.mkString(',')}])
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTCoProductX4[CoProduct1, APCoProduct1[_, _ <: CoProduct1] <: CoProduct1, CoZero1 <: CoProduct1] extends
      ADTCoProductX4Helper[CoProduct1, APCoProduct1, CoZero1] { ADTCoProductX4Self =>

      ${preTextContent.mkString('\n')}

    }
  """

}
