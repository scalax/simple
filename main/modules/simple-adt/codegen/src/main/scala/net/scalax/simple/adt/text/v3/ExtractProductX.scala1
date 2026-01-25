package net.scalax.simple.adt.text.v3

class ExtractProductX(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String = list.mkString(c.toString)
  }

  class TraitBody(val index: Int) {

    val typeParam1: Seq[String]  = for (_ <- 1 to index) yield s"_"
    val typeParam2: Seq[String]  = for (i1 <- 1 to index) yield s"N$i1[_]"
    val typeParam3: Seq[String]  = for (i1 <- 1 to index) yield s"F[N$i1]"
    val typeParam4: Seq[String]  = for (i1 <- 1 to index) yield s"N$i1"
    val typeParam5: Seq[String]  = for (i1 <- 1 to index) yield s"HListLike"
    val typeParam6: Seq[String]  = for (i1 <- 1 to index) yield s"ExtractProductSelf.extraAbstraction.hlistSimpleCompat.zero"
    val typeParam8: Seq[String]  = for (i1 <- 1 to index) yield s"simpleFunc1[N$i1]"
    val typeParam9: Seq[String]  = for (i1 <- 1 to index) yield s"N$i1[Any]"
    val typeParam11: Seq[String] = for (i1 <- 1 to index) yield s"F[N$i1]"

    val appendHLStr = "({ type AP1[_, T1 <: HListLike] = T1 })#AP1"

    val text: String = s"""
      override final def simpleProduct$index: SimpleProduct$index.ProductAdapter[F] = new SimpleProduct$index.ProductAdapter[F] {
        override final def append[M[${typeParam1.mkString(',')}], ${typeParam2.mkString(',')}](
          tpGen: SimpleProduct$index.TypeGen[M, ${typeParam4.mkString(',')}],
          sAppender: SimpleProduct$index.SimpleAppender[M]
        ): M[${typeParam3.mkString(',')}] = {
          val ap1: ParameterSingleNatSupport$index[M, ${typeParam4.mkString(',')}, HListLike, $appendHLStr] =
            new ParameterSingleNatSupport$index[M, ${typeParam4.mkString(',')}, HListLike, $appendHLStr] {
              override def simpleAppender: SimpleProduct$index.SimpleAppender[M] = sAppender
              override def typeGen: SimpleProduct$index.TypeGen[M, ${typeParam4.mkString(',')}] = tpGen
              override def apH: HListFunc[HListLike, $appendHLStr] = ExtractProductSelf.extraAbstraction.hlistSimpleCompat.hListFunc
            }

          val zero1: M[${typeParam5.mkString(',')}] = sAppender.zero(${typeParam6.mkString(',')})

          def appendImpl1(len: Int, model: M[${typeParam5.mkString(',')}]): M[${typeParam5.mkString(',')}] = {
            if (len > 0) appendImpl1(len - 1, ap1.append1[Any, ${typeParam5.mkString(',')}](model)) else model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] = ExtractProductSelf.extraAbstraction.hlistSimpleCompat.hListFunc.takeHead[U[Any], HListLike](fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]])).asInstanceOf[U[Any]]
            override def takeTail(m: F[U]): HListLike = ExtractProductSelf.extraAbstraction.hlistSimpleCompat.hListFunc.takeTail[U[Any], HListLike](fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]))
            override def append(a: U[Any], b: HListLike): F[U] = toModel(ExtractProductSelf.extraAbstraction
            .hlistSimpleCompat.hListFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            ${typeParam9.mkString(',')},
            ${typeParam5.mkString(',')},
            ${typeParam11.mkString(',')}
          ](${typeParam8.mkString(',')})(tpGen.gen[Any], appendImpl1(autalLen, zero1))
        }
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    trait ExtractProduct[HListLike, AppLike[_, _ <: HListLike] <: HListLike, HZero <: HListLike] {
      ExtractProductSelf =>

      def extraAbstraction: ExtractProductAbstraction[HListLike, AppLike, HZero]

      final def genSimpleProduct[F[_[_]]](
        length: Int,
        toModel: HListLike => F[({ type AnyF[_] = Any })#AnyF],
        fromModel: F[({ type AnyF[_] = Any })#AnyF] => HListLike
      ): SimpleProductContextX[F] = {
        val autalLen: Int = length - 1

        new SimpleProductContextX[F] {
          ${preTextContent.mkString('\n')}
        }
      }
    }
  """

}
