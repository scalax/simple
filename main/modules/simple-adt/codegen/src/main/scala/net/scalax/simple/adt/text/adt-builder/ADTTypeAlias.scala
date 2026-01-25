package net.scalax.simple.adt.text.v3

class ADTTypeAliasBuilder(val index: Int) {
  ADTTypeAliasBuilderSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"T$i1"

    def typeParam6Impl(index: Int): String = if (index < TraitBodySelf.index) {
      s"""AdtCoProduct.Use.Positive[AdtFunction[Target, T$index], ${typeParam6Impl(index + 1)}]"""
    } else {
      s"""AdtCoProduct.Use.One[AdtFunction[Target, T$index]]"""
    }

    val typeParam6: String = typeParam6Impl(1)

    val text: String = s"""
      type CoProducts$index[Target, ${typeParam1.mkString(',')}] = ADTValue[$typeParam6]
      type CoProduct$index[${typeParam1.mkString(',')}] = net.scalax.simple.adt.instance.support.CoProduct$index[${typeParam1.mkString(
        ','
      )}]
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTTypeAlias {
      ${preTextContent.mkString('\n')}
    }
  """

}
