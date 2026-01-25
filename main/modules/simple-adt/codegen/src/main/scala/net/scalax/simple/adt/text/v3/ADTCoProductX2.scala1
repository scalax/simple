package net.scalax.simple.adt.text.v3

class ADTCoProductX2(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam2: Seq[String] = "Target" +: (for (i1 <- 2 to index) yield s"T$i1")

    def typeParam4Impl(index: Int): String =
      if (index <= TraitBodySelf.index) s"APProduct1[T$index => Target, ${typeParam4Impl(index + 1)}]" else "ProZero1"
    val typeParam4: String = typeParam4Impl(1)
    val typeParam6: String = typeParam4Impl(2)

    val typeParam5: Seq[String] = for (i1 <- 1 to index) yield s"cv$i1: T$i1 <:< Target"

    val text: String = s"""
      def inputHList$index[
        Target,
        ${typeParam1.mkString(',')}
      ](implicit ${typeParam5.mkString(',')}): $typeParam4 = {
        ADTCoProductX2Self.hlistModelCompat.append[T1 => Target, $typeParam6](cv1, ADTCoProductX2Self.inputHList${index - 1}[${typeParam2
        .mkString(
          ','
        )}])
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTCoProductX2[Product1, APProduct1[_, _ <: Product1] <: Product1, ProZero1 <: Product1] extends
      ADTCoProductX2Helper[Product1, APProduct1, ProZero1] { ADTCoProductX2Self =>

      ${preTextContent.mkString('\n')}

    }
  """

}
