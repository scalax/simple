package net.scalax.simple.adt.text.v3

class ADTTraitBuilder(val index: Int) {

  extension (list: Seq[String]) {
    def mkString(c: Char): String                      = list.mkString(c.toString)
    def mkString(c1: Char, c2: Char, c3: Char): String = list.mkString(c1.toString, c2.toString, c3.toString)
  }

  class TraitBody(val index: Int) {
    TraitBodySelf =>

    val typeParam1: Seq[String]  = for (i1 <- 1 to index) yield s"T$i1"
    val typeParam2: Seq[String]  = "Target1" +: (for (i1 <- 2 to index) yield s"Target$i1 >: Target${i1 - 1}")
    val typeParam3: Seq[String]  = for (i1 <- 1 to index) yield s"param$i1: T$i1 => Target"
    val typeParam4: Seq[String]  = s"TargetOther$index" +: (for (i1 <- 2 to index) yield s"T$i1")
    val typeParam5: Seq[String]  = for (i1 <- 1 to index) yield s"apply(param$i1)"
    val typeParam9: Seq[String]  = for (i1 <- 1 to index) yield s"param$i1"
    val typeParam10: Seq[String] = for (i1 <- 1 to index) yield s"implicit val paramImpl$i1 = param$i1"
    // val typeParam11: Seq[String] = for (i1 <- index to (1, -1)) yield s".append[T$i1]"
    val typeParam12: Seq[String] = for (i1 <- 1 to index) yield s".map1(param$i1).tail"
    val typeParam13: Seq[String] = for (i1 <- 1 to index) yield s"_ <: T"

    def typeParam6Impl(index: Int): String = if (index > 1) {
      val typeParam7: Seq[String] =
        s"TargetOther${index + 1}" +: (for (i1 <- (TraitBodySelf.index - index) + 1 to TraitBodySelf.index) yield s"T$i1")
      val typeParam8: Seq[String] =
        s"TargetOther$index" +: (for i1 <- (TraitBodySelf.index - index) + 2 to TraitBodySelf.index yield s"T$i1")

      s"""
        new ADTFoldApplyImpl$index[${typeParam7.mkString(',')}] {
          override def fold$index[TargetOther$index >: TargetOther${index + 1}](
            param${(TraitBodySelf.index - index) + 1}: T${(TraitBodySelf.index - index) + 1} => TargetOther$index
          ): ADTFoldApplyImpl${index - 1}[${typeParam8.mkString(',')}] = ${typeParam6Impl(index - 1)}
        }
      """
    } else {
      s"""
        new ADTFoldApplyImpl1[TargetOther2, T${TraitBodySelf.index}] {
          override def fold1[TargetOther1 >: TargetOther2](param${TraitBodySelf.index}: T${TraitBodySelf.index} => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(${typeParam9.mkString(',')})
          }
        }
      """
    }

    val typeParam6: String = typeParam6Impl(index - 1)

    def typeParam7Impl(index: Int): String = if (index < TraitBodySelf.index) {
      s"""AdtCoProduct.Use.Positive[T$index, ${typeParam7Impl(index + 1)}]"""
    } else {
      s"""AdtCoProduct.Use.One[T$index]"""
    }

    val typeParam7: String       = typeParam7Impl(1)
    val typeParam14: String      = typeParam7Impl(2)
    val typeParam15: Seq[String] = for (i1 <- 2 to index) yield s"T$i1"

    def typeParam16Impl(index: Int): String = if (index < TraitBodySelf.index) {
      s"""AdtCoProduct.Use.Positive[_ <: T, ${typeParam16Impl(index + 1)}]"""
    } else {
      s"""AdtCoProduct.Use.One[_ <: T]"""
    }
    val typeParam16: String = typeParam16Impl(1)

    def typeParam17Impl(index: Int): String = if (index <= TraitBodySelf.index) {
      s"""AdtHList.UsePositive.append(param$index: T$index => Target, ${typeParam17Impl(index + 1)})"""
    } else {
      s"""AdtHList.zero"""
    }

    val typeParam17: String = typeParam17Impl(1)

    val text: String = s"""
      trait ADTFoldApplyImpl$index[
        Target0,
        ${typeParam1.mkString(',')}
      ] {
        FoldApplySelf =>

        def fold$index[TargetOther$index >: Target0](param1: T1 => TargetOther$index):
          ADTFoldApplyImpl${index - 1}[${typeParam4.mkString(',')}]
      }

      class CoProduct$index[${typeParam1.mkString(',')}](foldImpl: $typeParam7)
        extends $typeParam7
        with helper1.CoProduct${index}Helper[${typeParam1.mkString(',')}] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: $typeParam14 => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct${index - 1}[${typeParam15.mkString(',')}]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct${index - 1}[${typeParam15.mkString(',')}]]](
          (i1: T1) => Left(i1),
          (i1: $typeParam14) => Right(new CoProduct${index - 1}[${typeParam15.mkString(',')}](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct$index[U1, ${typeParam1.drop(1).mkString(',')}] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct$index[U1, ${typeParam1.drop(1).mkString(',')}](valueR)
        }

        def tail: CoProduct$index[${typeParam1.drop(1).mkString(',')}, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct$index[${typeParam1.drop(1).mkString(',')}, T1](valueR)
        }

        @inline def fold[Target](${typeParam3.mkString(',')}): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take($typeParam17)
          func(foldImpl)
        }

        def fold$index[TargetOther${index}](param1: T1 => TargetOther$index):
          ADTFoldApplyImpl${index - 1}[${typeParam4.mkString(',')}] = $typeParam6

      }

      object CoProduct$index {
        //
      }
    """

  }

  val preTextContent: Seq[String] = for (i <- 2 to index) yield new TraitBody(i).text

  val text: String = s"""
    package net.scalax.simple.adt
    package instance
    package support

    import AppendTailHelper2._

    trait ADTFoldApplyImpl1[Target0, T1] {
      FoldApplySelf =>

      def fold1[TargetOther0 >: Target0](param1: T1 => TargetOther0): TargetOther0
    }

    class CoProduct1[T1](foldImpl: AdtCoProduct.Use.One[T1])
      extends AdtCoProduct.Use.One[T1]
      with helper1.CoProduct1Helper[T1] {
      FoldApplySelf =>

      override def _foldCoProduct[TU](hFunc: T1 => TU, tFunc: AdtCoProduct.Use.One[T1] => TU): TU =
        FoldApplySelf.foldImpl._foldCoProduct[TU](hFunc, tFunc)

      def drop1: T1 = AdtCoProduct.Use.One.unapplyImpl(foldImpl)

      def map1[U1](func: T1 => U1): CoProduct1[U1] = {
        val valueR = func(AdtCoProduct.Use.One.unapplyImpl(foldImpl))
        val valueR2 = AdtCoProduct.Use.One.left[U1](valueR)
        new CoProduct1[U1](valueR2)
      }

      def tail: CoProduct1[T1] = FoldApplySelf

      @inline def fold[TargetOther0](param1: T1 => TargetOther0): TargetOther0 = {
        val v1 = FoldApplySelf.map1(param1)
        AdtCoProduct.Use.One.unapplyImpl(v1)
      }

      def fold1[TargetOther0](param1: T1 => TargetOther0): TargetOther0 = FoldApplySelf.fold(param1)

    }

    object CoProduct1 {
      //
    }

    ${preTextContent.mkString('\n')}
  """

}
