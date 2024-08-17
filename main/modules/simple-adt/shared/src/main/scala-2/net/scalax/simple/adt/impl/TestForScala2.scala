package net.scalax.simple.adt
package impl

import net.scalax.simple.adt.CCDD.ABCD2
import net.scalax.simple.adt.support.S2Support
import net.scalax.simple.adt.utils.ProductType22Support

object TestForScala2 {

  private def helperImpl: ABCD2[
    RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,
    S2Support.Func,
    ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
    S2Support.Zero,
    ({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP
  ] = ???

  private class CurateAppend
      extends CCDD.ProductType22AppenderImpl2[
        RuntimeNat,
        ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
        RuntimeZero,
        S2Support.Func,
        ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
        S2Support.Zero,
        ({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP
      ] {
    override protected def helper: ABCD2[
      RuntimeNat,
      ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
      RuntimeZero,
      S2Support.Func,
      ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
      S2Support.Zero,
      ({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP
    ] = helperImpl
  }

  private def tempAppend: CurateAppend = new CurateAppend

  def tempProduct: ProductType22Support[
    RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,
    RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,
    ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#BP,
    ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#BP
  ] = new ProductType22Support[
    RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,
    RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,
    ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#BP,
    ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#BP
  ] {
    override protected def appender: utils.ProductType22Appender[
      RuntimeNat,
      ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
      RuntimeZero,
      RuntimeNat,
      ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
      RuntimeZero,
      S2Support.Func,
      ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
      S2Support.Zero,
      ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#BP
    ] = tempAppend

    override protected def tran: S2Support.M1ToM2[
      RuntimeNat,
      RuntimeNat,
      ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#BP,
      ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#BP
    ] = new S2Support.M1ToM2[
      RuntimeNat,
      RuntimeNat,
      ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#BP,
      ({ type BP[A <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#BP
    ] {
      override def to[PX <: RuntimeNat, XX <: RuntimeNat, FuncX <: S2Support.Func](
        input: AppendUser[XX, FuncX]
      ): AppendUserAb[XX, FuncX#U] = input
    }
  }

}

trait AppendUserAb[In <: RuntimeNat, Out[_] <: Any] {
  def appendUser[ST](in: ADTData[In, ST]): Out[Nothing]
}

trait AppendUser[In <: RuntimeNat, Out <: S2Support.Func] extends AppendUserAb[In, Out#U] {
  override def appendUser[ST](in: ADTData[In, ST]): Out#U[Nothing]
}
