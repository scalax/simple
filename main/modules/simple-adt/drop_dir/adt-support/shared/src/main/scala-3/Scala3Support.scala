package net.scalax.simple.adt
package support

object S3Support {

  trait Func[U[_] <: Any] {
    def instance: U[Nothing]
  }
  type Append11[Data, f <: Func[_]] <: Func[_] = f match {
    case Func[u1] => Func[[x] =>> ResultFolder[Data, u1, x]]
  }
  type Zero = Func[[x] =>> x]

  trait M1ToM2[P1, X1, M1[_ <: P1, _ <: X1, _ <: S3Support.Func[_]], M2[_ <: P1, _ <: X1, _[_] <: Any]] {
    def to[PX <: P1, XX <: X1, UX[_] <: Any](input: M1[PX, XX, S3Support.Func[UX]]): M2[PX, XX, UX]
  }

  type AP3 = utils.ProductType22[S3Support.Func[_], S3Support.Append11, S3Support.Zero]

}

object Product22Support {
  self =>

  def gen1[
    Append1,
    AppendPositive1[_, _ <: Append1] <: Append1,
    AppendZero1 <: Append1,
    Append2,
    AppendPositive2[_, _ <: Append2] <: Append2,
    AppendZero2 <: Append2,
    M3[_ <: Append1, _ <: Append2, _ <: S3Support.Func[_]],
    M4[_ <: Append1, _ <: Append2, _[_] <: Any]
  ](
    appender: utils.ProductType22Appender[
      Append1,
      AppendPositive1,
      AppendZero1,
      Append2,
      AppendPositive2,
      AppendZero2,
      S3Support.Func[_],
      S3Support.Append11,
      S3Support.Zero,
      M3
    ],
    tran: S3Support.M1ToM2[Append1, Append2, M3, M4]
  ): utils.ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] =
    utils.Product22Gen.gen[
      Append1,
      AppendPositive1,
      AppendZero1,
      Append2,
      AppendPositive2,
      AppendZero2,
      M3,
      M4
    ](appender, tran)

  def gen2[
    Append1,
    AppendPositive1[_, _ <: Append1] <: Append1,
    AppendZero1 <: Append1,
    Append2,
    AppendPositive2[_, _ <: Append2] <: Append2,
    AppendZero2 <: Append2,
    M3[_ <: Append1, _ <: Append2, _ <: S3Support.Func[_]],
    M4[_ <: Append1, _ <: Append2, _[_] <: Any]
  ](
    appender: CCDD.ABDECD[
      Append1,
      AppendPositive1,
      AppendZero1,
      Append2,
      AppendPositive2,
      AppendZero2,
      S3Support.Func[_],
      S3Support.Append11,
      S3Support.Zero,
      M3
    ],
    tran: S3Support.M1ToM2[Append1, Append2, M3, M4]
  ): utils.ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] =
    self.gen1[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M3, M4](
      utils.ProductType22AppenderGen.gen[
        Append1,
        AppendPositive1,
        AppendZero1,
        Append2,
        AppendPositive2,
        AppendZero2,
        S3Support.Func[_],
        S3Support.Append11,
        S3Support.Zero,
        M3
      ](appender),
      tran
    )

}
