package net.scalax.simple.adt.text.v3

class TypeGen10Codegen(val index: Int) {
  TypeGen10CodegenSelf =>

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class Param1Def(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to TypeGen10CodegenSelf.index) yield s"Item$i1"
    val typeParam2: Seq[String] =
      for (i1 <- 1 to index) yield s"N$i1[${typeParam1.mkString(',')}]"

    val text: String = s"M[${typeParam2.mkString(',')}]"

  }

  class TraitBody(val index: Int) {

    val param1Def: Param1Def = new Param1Def(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String] = for (_ <- 1 to TypeGen10CodegenSelf.index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[${typeParam2.mkString(',')}]"
    val typeParam4: Seq[String] = for (i1 <- 1 to TypeGen10CodegenSelf.index) yield s"Item$i1"

    val text: String = s"""
      trait Type10Gen$index[M[${typeParam1.mkString(',')}], ${typeParam3.mkString(',')}] {
        def gen10[${typeParam4.mkString(',')}]: ${param1Def.text}
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
