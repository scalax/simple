package net.scalax.simple.adt
package support

object S2Support {

  trait Func {
    type U[A] <: Any
    def instance: U[Nothing]
  }
  trait Append11[Data, Tail <: Func] extends Func {
    override type U[A] = ResultFolder[Data, Tail#U, A]
    override def instance: ResultFolder[Data, Tail#U, Nothing]
  }
  trait Zero extends Func {
    override type U[A] = A
    override def instance: Nothing
  }

  trait M1ToM2[P1, X1, M1[_ <: P1, _ <: X1, _ <: Func], M2[_ <: P1, _ <: X1, _[_] <: Any]] {
    def to[PX <: P1, XX <: X1, FuncX <: Func](input: M1[PX, XX, FuncX]): M2[PX, XX, FuncX#U]
  }

  type AP3 = utils.ProductType22[S2Support.Func, S2Support.Append11, S2Support.Zero]

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
    M3[_ <: Append1, _ <: Append2, _ <: S2Support.Func],
    M4[_ <: Append1, _ <: Append2, _[_] <: Any]
  ](
    appender: utils.ProductType22Appender[
      Append1,
      AppendPositive1,
      AppendZero1,
      Append2,
      AppendPositive2,
      AppendZero2,
      S2Support.Func,
      S2Support.Append11,
      S2Support.Zero,
      M3
    ],
    tran: S2Support.M1ToM2[Append1, Append2, M3, M4]
  ): utils.ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] =
    utils.Product22Gen.gen[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M3, M4](appender, tran)

  def gen2[
    Append1,
    AppendPositive1[_, _ <: Append1] <: Append1,
    AppendZero1 <: Append1,
    Append2,
    AppendPositive2[_, _ <: Append2] <: Append2,
    AppendZero2 <: Append2,
    M3[_ <: Append1, _ <: Append2, _ <: S2Support.Func],
    M4[_ <: Append1, _ <: Append2, _[_] <: Any]
  ](
    appender: CCDD.ABDECD[
      Append1,
      AppendPositive1,
      AppendZero1,
      Append2,
      AppendPositive2,
      AppendZero2,
      S2Support.Func,
      S2Support.Append11,
      S2Support.Zero,
      M3
    ],
    tran: S2Support.M1ToM2[Append1, Append2, M3, M4]
  ): utils.ProductType22Support[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M4] =
    self.gen1[Append1, AppendPositive1, AppendZero1, Append2, AppendPositive2, AppendZero2, M3, M4](
      utils.ProductType22AppenderGen.gen[
        Append1,
        AppendPositive1,
        AppendZero1,
        Append2,
        AppendPositive2,
        AppendZero2,
        S2Support.Func,
        S2Support.Append11,
        S2Support.Zero,
        M3
      ](appender),
      tran
    )

}
