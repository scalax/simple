package net.scalax.simple.adt.text.v3

class SimpleProductIt10Codengen(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TypeGenTrait(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"

    val text: String = s"""
      def typeGen: Type10Gen$index[M, ${typeParam1.mkString(',')}]
    """

  }

  class TraitDef(val index: Int) {

    val typeParam2: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1"
    val typeParam3: Seq[String] =
      for (i1 <- 1 to index)
        yield s"APRHLLike$i1[N$i1[Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10], HCollection$i1]"
    val typeParam8: Seq[String] = for (i1 <- 1 to index) yield s"HCollection$i1 <: HLLike$i1"

    val text: String = s"""
      def append10[Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10, ${typeParam8.mkString(',')}](p1: M[${typeParam2
        .mkString(',')}]): M[${typeParam3.mkString(
        ','
      )}] = Parameter10NatSupport${index}Self.content.append(Parameter10NatSupport${index}Self.typeGen.gen10[Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10], p1)
    """

  }

  class TraitContentDef(val index: Int) {

    val typeParam1: Seq[String] = for (i1 <- 1 to index) yield s"HLLike$i1"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"APRHLLike$i1"

    val text: String = s"""
      def content: AppenderNatSupport$index[M, ${typeParam1.mkString(',')}, ${typeParam4.mkString(',')}]
    """

  }

  class SimpleProductXBody(val index: Int) {

    val traitDef: TraitDef               = new TraitDef(index)
    val traitContentDef: TraitContentDef = new TraitContentDef(index)
    val typeGenTrait: TypeGenTrait       = new TypeGenTrait(index)

    val typeParam1: Seq[String] = for (_ <- 1 to index) yield s"_"
    val typeParam3: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam4: Seq[String] = for (i1 <- 1 to index) yield s"N$i1"
    val typeParam5: Seq[String] = for (i1 <- 1 to index) yield s"N$i1[T]"
    val typeParam6: Seq[String] = for (i1 <- 1 to index) yield s"({ type NXX[_] = N$i1[T] })#NXX"
    val typeParam7: Seq[String] = for (i1 <- 1 to index) yield s"TPF[({ type NXX[_] = N$i1[T] })#NXX]"

    val text: String = s"""
      override def simpleProduct$index: SimpleProduct$index.ProductAdapter[TPF] = new SimpleProduct$index.ProductAdapter[TPF] {
        override def append[M[${typeParam1.mkString(',')}], ${typeParam3.mkString(',')}]
          (
            typeGen: SimpleProduct$index.TypeGen[M, ${typeParam4.mkString(',')}],
            sAppender: SimpleProduct$index.SimpleAppender[M])
          : M[${typeParam7.mkString(',')}] =
            spc.simpleProduct$index.append[M, ${typeParam6.mkString(',')}](
              new SimpleProduct$index.TypeGen[M, ${typeParam6.mkString(',')}] {
                override def gen[U1]: M[${typeParam5.mkString(',')}] = typeGen.gen[T]
              },
              sAppender
            )
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new SimpleProductXBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    object SimpleProductIt10Codengen {
      SimpleProductIt10CodengenSelf =>

      def toItera[F[_[_]], T](spc: SimpleProductContextX[F]): SimpleProductContextX[({ type TPF[MXX[_]] = F[({ type XUU[_] = MXX[T] })#XUU] })#TPF] = {
        type TPF[MXX[_]] = F[({ type XUU[_] = MXX[T] })#XUU]
        new SimpleProductContextX[TPF] {
          ${preTextContent.mkString('\n')}
        }
      }

    }
  """

}
