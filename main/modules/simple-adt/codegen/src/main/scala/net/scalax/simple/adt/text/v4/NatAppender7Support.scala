package net.scalax.simple.adt.text.v4

class NatAppender7SupportCodegen(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val typeParam1: Seq[String]  = for (i1 <- 1 to index) yield s"_ <: HLLike$i1"
    val typeParam3: Seq[String]  = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam6: Seq[String]  = for (i1 <- 1 to index) yield s"APRHLLike$i1"
    val typeParam7: Seq[String]  = for (i1 <- 1 to index) yield s"HCollection$i1 <: HLLike$i1"
    val typeParam8: Seq[String]  = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam9: Seq[String]  = for (i1 <- 1 to index) yield s"APRHLLike$i1[T1, HCollection$i1]"
    val typeParam15: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1[_, _ <: HLLike$i1] <: HLLike$i1"

    val max: Int                 = 22
    val typeParam16: Seq[String] = for (i1 <- 1 to max) yield s"T$i1"

    val typeParam17: Seq[String] = for (i1 <- 1 to index) yield s"H$i1 <: HLLike$i1"
    val typeParam18: Seq[String] = for (i1 <- index + 1 to max) yield s"H$i1 <: Any"
    val typeParam19: Seq[String] = typeParam17 ++: typeParam18
    val typeParam20: Seq[String] = for (i1 <- 1 to index) yield s"H$i1"

    class AppendLike(val index: Int) {
      val text: String =
        s"({ type AppLike[${typeParam16.mkString(',')}, H$index <: HLLike$index] = APRHLLike$index[T1, H$index] })#AppLike"
    }
    val typeParam21: Seq[String] = for (i1 <- 1 to index) yield AppendLike(i1).text
    val typeParam22: Seq[String] = for (i1 <- index + 1 to max) yield "net.scalax.simple.adt.nat.support.CodegenHelper.AppendAny"
    val typeParam23: Seq[String] = for (i1 <- index + 1 to max) yield "Any"

    val text: String = s"""
      trait Support$index[
        M[${typeParam1.mkString(',')}],
        ${typeParam3.mkString(',')},
        ${typeParam15.mkString(',')},
        ${typeParam7.mkString(',')}
      ] extends SimpleAppender[
        ({ type XM1[${typeParam19.mkString(',')}] = M[${typeParam20.mkString(',')}] })#XM1,
        ${(typeParam3 ++: typeParam23 ++: typeParam21 ++: typeParam22 ++: typeParam8 ++: typeParam23).mkString(',')}
      ] {
        SupportSelf =>

        // def current: M[${typeParam8.mkString(',')}]

        /* def getTail[T1]: NatNext1.Support$index[
          M,
          ${typeParam3.mkString(',')},
          ${typeParam6.mkString(',')},
          ${typeParam9.mkString(',')}
        ] */

        override def next[${typeParam16.mkString(',')}]: NatNext1.Support$index[
          M,
          ${typeParam3.mkString(',')},
          ${typeParam6.mkString(',')},
          ${typeParam9.mkString(',')}
        ]
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    import net.scalax.simple.append.support.collectioncount22.typeparameter22.SimpleAppender

    object NatNext1 {
      ${preTextContent.mkString('\n')}
    }
  """

}
