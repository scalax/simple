package net.scalax.simple.adt.text.v3

class TypeGenCodegen(val index: Int) {
  TypeGenCodegenSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class Param1Def(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[T]"

    val text: String = s"M[${typeParam1.mkString(',')}]"

  }

  class TraitBody(val index: Int) {

    val param1Def: Param1Def = new Param1Def(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam4: Seq[String] = for (i1 <- 1 to TypeGenCodegenSelf.index) yield s"M$i1"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"({ type TypeX[${typeParam4.mkString(',')}] = N$i1[M1] })#TypeX"
    val typeParam5: Seq[String] = for (i1 <- 2 to TypeGenCodegenSelf.index) yield s"Item$i1"

    val text: String = s"""
      trait TypeGen$index[M[${typeParam1.mkString(',')}], ${typeParam2.mkString(',')}] extends Type10Gen$index[M, ${typeParam3.mkString(
        ','
      )}] {
        TypeGen${index}Self =>
        def gen[T]: ${param1Def.text}
        override final def gen10[T, ${typeParam5.mkString(',')}]: ${param1Def.text} = TypeGen${index}Self.gen[T]
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
