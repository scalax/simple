package net.scalax.simple.adt.text.v3

class ADTTraitBuilderHelper1(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String]  = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam2: Seq[String]  = "Target1" +: (for (i1 <- 2 to index) yield s"Target$i1 >: Target${i1 - 1}")
    val typeParam3: Seq[String]  = for (i1 <- 1 to index) yield s"param$i1: T$i1 => Target$i1"
    val typeParam4: Seq[String]  = s"TargetOther$index" +: (for (i1 <- 2 to index) yield s"T$i1")
    val typeParam5: Seq[String]  = for (i1 <- 1 to index) yield s"apply(param$i1)"
    val typeParam9: Seq[String]  = for (i1 <- 1 to index) yield s"param$i1"
    val typeParam10: Seq[String] = for (i1 <- 1 to index) yield s"implicit val paramImpl$i1 = param$i1"
    val typeParam12: Seq[String] = for (i1 <- 1 to index) yield s".map1(param$i1).tail"
    val typeParam13: Seq[String] = for (i1 <- 1 to index) yield s"_ <: T"

    class MethodMapBody(val index: Int) {
      MethodMapBodySelf =>

      val typeParam1: Seq[String] = for (i1 <- 1 to TraitBodySelf.index) yield if (i1 == MethodMapBodySelf.index) "TargetN" else s"T$i1"
      val typeParam2: Seq[String] =
        for (i1 <- 1 to TraitBodySelf.index) yield if (i1 == MethodMapBodySelf.index) ".map1(func).tail" else ".tail"

      val text: String = s"""
        def map$index[TargetN](func: T$index => TargetN): CoProduct${TraitBodySelf.index}[
          ${typeParam1.mkString(',')}
        ] = FoldApplySelf${typeParam2.mkString("")}
      """

    }

    class MethodDropBody(val index: Int) {
      MethodDropBodySelf =>

      val typeParam1: Seq[Option[String]] =
        for (i1 <- 1 to TraitBodySelf.index) yield if (i1 == MethodDropBodySelf.index) Option.empty else Some(s"T$i1")
      val typeParam2: Seq[String] =
        for (i1 <- 1 to TraitBodySelf.index) yield if (i1 == MethodDropBodySelf.index) ".map1(func).tail" else ".tail"
      val typeParam3: Seq[String] = typeParam1.collect { case Some(s) => s }
      val typeParam4: Seq[String] = for (i1 <- 2 to MethodDropBodySelf.index) yield ".tail"
      val typeParam5: Seq[String] = for (i1 <- MethodDropBodySelf.index + 1 to TraitBodySelf.index) yield ".tail"

      val text: String = s"""
        def drop$index: Either[T$index, CoProduct${TraitBodySelf.index - 1}[${typeParam3.mkString(',')}]] = {
          for (item1 <- FoldApplySelf${typeParam4.mkString("")}.drop1) yield item1${typeParam5.mkString("")}
        }
      """

    }

    val typeParam14: Seq[String] = for (i1 <- 2 to index) yield new MethodMapBody(i1).text
    val typeParam15: Seq[String] = for (i1 <- 2 to index) yield new MethodDropBody(i1).text

    val text: String = s"""
      trait CoProduct${index}Helper[${typeParam1.mkString(',')}] {
        FoldApplySelf: CoProduct$index[${typeParam1.mkString(',')}] =>
        ${typeParam14.mkString('\n')}
        ${typeParam15.mkString('\n')}
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 2 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    object helper1 {
      trait CoProduct1Helper[T1] {
        FoldApplySelf: CoProduct1[T1] =>
      }

      ${preTextContent.mkString('\n')}
    }
  """

}
