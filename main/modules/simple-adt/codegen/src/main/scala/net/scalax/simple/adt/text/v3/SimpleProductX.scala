package net.scalax.simple.adt.text.v3

class SimpleProductX(val index: Int) {
  SimpleProductXSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TypeGenTraitDef(val index: Int) {
    TypeGenTraitDefSelf =>

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam7: Seq[String] = for (i1 <- 1 to SimpleProductXSelf.index) yield s"M$i1"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"({ type TypeX[${typeParam7.mkString(',')}] = N$i1[M1] })#TypeX"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[Item1]"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[Item1]"
    val typeParam9: Seq[String] = for (i1 <- 1 to SimpleProductXSelf.index) yield s"Item$i1"

    val text: String = s"""
      trait TypeGen[
        M[${typeParam1.mkString(',')}],
        ${typeParam2.mkString(',')}
      ] extends Type10Gen$index[
        M,
        ${typeParam3.mkString(',')}
      ] {
        TypeGen${index}Self =>
        def gen[Item1]: M[${typeParam6.mkString(',')}]
        override final def gen10[${typeParam9.mkString(',')}]: M[${typeParam8.mkString(',')}] = TypeGen${index}Self.gen[Item1]
      }
    """

  }

  class SimpleAppender(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[T]"
    val typeParam2: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val text: String = s"""
      trait SimpleAppender[M[${typeParam2.mkString(',')}]] extends SimpleAppender${index}Positive[M] with SimpleAppender${index}Zero[M]
    """

  }

  class AppenderTrait(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[T]"
    val typeParam2: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam5: Seq[String] = for (i1 <- 1 to index) yield s"F[N$i1]"

    val text: String = s"""
      trait ProductAdapter[F[_[_]]] {
        def append[M[${typeParam2.mkString(',')}], ${typeParam4.mkString(',')}]
          (typeGen: SimpleProduct$index.TypeGen[M, ${typeParam3.mkString(',')}], sAppender: SimpleProduct$index.SimpleAppender[M])
          : M[${typeParam5.mkString(',')}]
      }
    """

  }

  class TraitBody(val index: Int) {

    val typeGenTraitDef: TypeGenTraitDef = new TypeGenTraitDef(index)
    val simpleAppender: SimpleAppender   = new SimpleAppender(index)
    val appenderTrait: AppenderTrait     = new AppenderTrait(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"({ type TypeX[M1, _, _, _, _, _, _, _, _, _] = N$i1[M1] })#TypeX"

    val text: String = s"""
      object SimpleProduct$index {
        SimpleProduct${index}Self =>

        ${typeGenTraitDef.text}
        ${simpleAppender.text}
        ${appenderTrait.text}
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    ${preTextContent.mkString('\n')}
  """

}
