package net.scalax.simple.adt.text.v4

class NatAppender3SupportCodegen(val index: Int) {

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
    val typeParam12: Seq[String] = for (i1 <- 1 to index) yield s"AppLike"

    val max: Int                 = 22
    val typeParam13: Seq[String] = for (i1 <- 1 to max) yield s"Any"

    val appendHLStr = "({ type AP1[_, T1 <: HListLike] = T1 })#AP1"

    val text: String = s"""
      override final def simpleProduct$index: SimpleProduct$index.ProductAdapter[F] = new SimpleProduct$index.ProductAdapter[F] {
        override final def append[M[${typeParam1.mkString(',')}], ${typeParam2.mkString(',')}](
          tpGen: SimpleProduct$index.TypeGen[M, ${typeParam4.mkString(',')}],
          sAppender: SimpleProduct$index.SimpleAppender[M]
        ): M[${typeParam3.mkString(',')}] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support$index[M, ${typeParam4.mkString(',')}](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support$index[
                M,
                ${typeParam5.mkString(',')},
                ${typeParam12.mkString(',')},
                ${typeParam5.mkString(',')}
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support$index[
            M,
            ${typeParam5.mkString(',')},
            ${typeParam12.mkString(',')},
            ${typeParam5.mkString(',')}
          ]): NatNext1.Support$index[
            M,
            ${typeParam5.mkString(',')},
            ${typeParam12.mkString(',')},
            ${typeParam5.mkString(',')}
          ] = {
            if (len > 0) {
              val nextModel = model.next[${typeParam13.mkString(',')}].asInstanceOf[
                NatNext1.Support$index[
                  M,
                  ${typeParam5.mkString(',')},
                  ${typeParam12.mkString(',')},
                  ${typeParam5.mkString(',')}
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            ${typeParam9.mkString(',')},
            ${typeParam5.mkString(',')},
            ${typeParam11.mkString(',')}
          ](${typeParam8.mkString(',')})(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 1 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext5[HListLike, AppLike[_, _ <: HListLike] <: HListLike, HZero <: HListLike] {
      NatNext5Self =>

      val extraAbstraction: NatNext4[HListLike, AppLike, HZero]

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
