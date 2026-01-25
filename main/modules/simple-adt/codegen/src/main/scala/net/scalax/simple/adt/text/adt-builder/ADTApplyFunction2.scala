package net.scalax.simple.adt.text.v3

class ADTApplyFunction2(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String]  = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam2: Seq[String]  = "Target1 >: Nothing" +: (for (i1 <- 2 to index) yield s"Target$i1 >: Target${i1 - 1}")
    val typeParam3: Seq[String]  = for (i1 <- 1 to index) yield s"param$i1: T$i1 => Target$i1"
    val typeParam4: Seq[String]  = s"TargetOther${index - 1}" +: (for (i1 <- 2 to index) yield s"T$i1")
    val typeParam5: Seq[String]  = for (i1 <- 1 to index) yield s"apply(param$i1)"
    val typeParam9: Seq[String]  = for (i1 <- 1 to index) yield s"param$i1"
    val typeParam10: Seq[String] = for (i1 <- 1 to index) yield s"AdtFunction[Target, T$i1]"
    val typeParam11: Seq[String] = for (i1 <- 1 to index) yield s".map1(_.adtFunctionApply(target)).tail"

    /*def typeParam6Impl(index: Int): String = if (index < TraitBodySelf.index) {
      s"""AdtCoProduct.Use.Positive[T$index, ${typeParam6Impl(index + 1)}]"""
    } else {
      s"""AdtCoProduct.Use.One[T$index]"""
    }

    val typeParam6: String = typeParam6Impl(1)*/

    def typeParam7Impl(index: Int): String = if (index < TraitBodySelf.index) {
      s"""AdtCoProduct.Use.Positive[AdtFunction[Target, T$index], ${typeParam7Impl(index + 1)}]"""
    } else {
      s"""AdtCoProduct.Use.One[AdtFunction[Target, T$index]]"""
    }

    val typeParam7: String = typeParam7Impl(1)

    val text: String = s"""
      trait CoProduct${index}Apply[${typeParam1.mkString(',')}] extends
        ADTApplyFunction2Self.CoProduct${index}ApplyHelper[${typeParam1.mkString(',')}] {
        CoProduct${index}ApplySelf =>
        def instance[Target](target: Target)(implicit param: ADTValue[$typeParam7]): CoProduct$index[${typeParam1.mkString(',')}] = {
          CoProduct${index}ApplySelf.typeOnly[Target]${typeParam11.mkString("")}
        }

        def typeOnly[Target](implicit param: ADTValue[$typeParam7]): CoProduct$index[${typeParam10.mkString(',')}] = {
          new CoProduct$index(param.value)
        }
      }

      object CoProduct$index extends ADTApplyFunction2Self.ADTOptionsUnapply$index {
        def apply[${typeParam1.mkString(',')}]: CoProduct${index}Apply[${typeParam1.mkString(',')}] =
          new CoProduct${index}Apply[${typeParam1.mkString(',')}] {
            //
          }
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    trait ADTApplyFunction2 extends helper2 { ADTApplyFunction2Self: ADTUnapplyBuilder =>
      ${preTextContent.mkString('\n')}
    }
  """

}
