package net.scalax.simple.adt.text.v3

class ADTUnapplyBuilder(val index: Int) {
  ADTUnapplyBuilderSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam2: Seq[String] = for (i1 <- index to ADTUnapplyBuilderSelf.index) yield EachObject(i1).text

    class EachObject(val index: Int) {
      EachObjectSelf =>

      val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"
      val typeParam2: Seq[String] = for (i1 <- 2 to TraitBodySelf.index) yield ".tail"

      val text =
        if (EachObjectSelf.index == 1 && TraitBodySelf.index == 1)
          s"""
            def unapply[${typeParam1.mkString(',')}](
              p: CoProduct$index[${typeParam1.mkString(',')}]
            ): Some[T${TraitBodySelf.index}] = Some(p.drop1)
          """
        else
          s"""
            def unapply[${typeParam1.mkString(',')}](
              p: CoProduct$index[${typeParam1.mkString(',')}]
            ): Option[T${TraitBodySelf.index}] = AppendTail6[T${TraitBodySelf.index}].take(AppendTail6.toValue(p))
          """
    }

    val text: String = s"""
      trait ADTOptionsUnapply$index {
        ${typeParam2.mkString('\n')}
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTUnapplyBuilder {
      ${preTextContent.mkString('\n')}
    }
  """

}
