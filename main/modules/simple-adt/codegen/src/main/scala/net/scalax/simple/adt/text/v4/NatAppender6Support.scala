package net.scalax.simple.adt.text.v4

class NatAppender6SupportCodegen(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam5: Seq[String] = for (index <- 1 to index) yield s"T$index"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1 <: HListLike"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam9: Seq[String] = for (i1 <- 1 to index) yield s"AppendLike[T$i1, HCollection$i1]"
    val typeParam14: Seq[String] =
      for (i1 <- 1 to index) yield s"NatNext2HelperSelf.hlistFunc.toABCFunc[T$i1, HCollection$i1]"

    val text: String = s"""
      def append$index[M[${typeParam1.mkString(',')}], ${typeParam5.mkString(',')}, ${typeParam7.mkString(',')}](
        appender$index: SimpleAppender${index}Positive[M]
      )(
        head: M[${typeParam5.mkString(',')}],
        tail: M[${typeParam8.mkString(',')}]
      ): M[${typeParam9.mkString(',')}] =
        appender$index.append[${typeParam5.mkString(',')}, ${typeParam8.mkString(',')}, ${typeParam9.mkString(',')}](
          ${typeParam14.mkString(',')}
        )(
          head,
          tail
        )
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext2Helper[HListLike, AppendLike[_, _ <: HListLike] <: HListLike] {
      NatNext2HelperSelf =>

      def hlistFunc: HListFunc[HListLike, AppendLike]

      ${preTextContent.mkString('\n')}
    }
  """

}
