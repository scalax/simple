package net.scalax.simple.adt.text.v4

class NatAppender4SupportCodegen(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"HListLike"
    val typeParam5: Seq[String] = for (i1 <- 1 to index) yield s"T$i1[_]"
    val typeParam6: Seq[String] =
      for (i1 <- 1 to index) yield s"({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T$i1[X12], Tail]})#XUAPPendEach"
    val typeParam7: Seq[String]  = for (i1 <- 1 to index) yield s"HCollection$i1 <: HListLike"
    val typeParam8: Seq[String]  = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam9: Seq[String]  = for (i1 <- 1 to index) yield s"AppendLike[T$i1[U], HCollection$i1]"
    val typeParam13: Seq[String] = for (i1 <- 1 to index) yield s"T$i1[U]"
    val typeParam14: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam15: Seq[String] = for (i1 <- 1 to index) yield s"ZeroLike"
    val typeParam16: Seq[String] = for (i1 <- 1 to index) yield s"NatNext4Self.zeroInstance"

    val text: String = s"""
      def Support$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam5.mkString(',')}
      ](
        simpleAppender: SimpleProduct$index.SimpleAppender[M],
        typeGen: SimpleProduct$index.TypeGen[M, ${typeParam14.mkString(',')}]
      ): NatNext1.Support$index[
        M,
        ${typeParam3.mkString(',')},
        ${typeParam6.mkString(',')},
        ${typeParam15.mkString(',')}
      ] = {
        val ctx = new NatNext4Self.Impl1.Support${index}Context[
          M,
          ${typeParam14.mkString(',')}
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ${typeParam15.mkString(',')}
        ] {
          override def current: M[
            ${typeParam15.mkString(',')}
          ] = simpleAppender.zero[${typeParam15.mkString(',')}](${typeParam16.mkString(',')})
        }
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext4[HListLike, AppendLike[_, _ <: HListLike] <: HListLike, ZeroLike <: HListLike] extends NatNext3[HListLike, AppendLike] {
      NatNext4Self =>

      def zeroInstance: ZeroLike

      object Impl2 {
        ${preTextContent.mkString('\n')}
      }
    }
  """

}
