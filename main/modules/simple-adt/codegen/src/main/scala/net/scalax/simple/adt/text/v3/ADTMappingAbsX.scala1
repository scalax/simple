package net.scalax.simple.adt.text.v3

class ADTMappingAbsX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    def typeParam3Impl(index: Int): String =
      if (index <= TraitBodySelf.index) s"APProduct2[M2[T$index, N$index], ${typeParam3Impl(index + 1)}]" else "ProZero2"
    val typeParam3: String = typeParam3Impl(1)

    def typeParam4Impl(index: Int): String =
      if (index <= TraitBodySelf.index) s"APCoProduct1[M1[T$index, N$index], ${typeParam4Impl(index + 1)}]" else "CoZero1"
    val typeParam4: String = typeParam4Impl(1)

    def typeParam5Impl(index: Int): String =
      if (index <= TraitBodySelf.index) s"APCoProduct3[M3[T$index, N$index], ${typeParam5Impl(index + 1)}]" else "CoZero3"
    val typeParam5: String = typeParam5Impl(1)

    val text: String = s"""
      def inputHList$index[
        ${typeParam1.mkString(',')}, ${typeParam2.mkString(',')}
      ]: ($typeParam4, $typeParam3) => $typeParam5
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    trait AdtFunctionSupport[
      M1[_, _], M2[_, _], M3[_, _],
      CoProduct1, APCoProduct1[_, _ <: CoProduct1] <: CoProduct1, CoZero1 <: CoProduct1,
      Product2, APProduct2[_, _ <: Product2] <: Product2, ProZero2 <: Product2,
      CoProduct3, APCoProduct3[_, _ <: CoProduct3] <: CoProduct3, CoZero3 <: CoProduct3
    ] { AdtFunctionSupportSelf =>

      def inputHList0: (CoZero1, ProZero2) => CoZero3

      ${preTextContent.mkString('\n')}

    }
  """

}
