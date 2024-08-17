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
