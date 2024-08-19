package net.scalax.simple.adt
package impl

import net.scalax.simple.adt.CCDD.ABCD2
import net.scalax.simple.adt.support.S2Support
import net.scalax.simple.adt.support.Product22Support
import net.scalax.simple.adt.utils.ProductType22Support

object TestForScala2 {

  private def helperImpl: ABCD2[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    S2Support.Func,
    S2Support.Append11,
    S2Support.Zero,
    AppendUser
  ] = new ABCD2[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    S2Support.Func,
    S2Support.Append11,
    S2Support.Zero,
    AppendUser
  ] {
    override def append2[A, P <: RuntimeNat, X <: S2Support.Func](
      m: AppendUser[P, X]
    ): AppendUser[RuntimeData[A, P], S2Support.Append11[A, X]] = new AppendUser[RuntimeData[A, P], S2Support.Append11[A, X]] {
      override def appendUser[ST](in: ADTData[RuntimeData[A, P], ST]): ResultFolder[A, X#U, Nothing] = ???
    }
    override def zero2: AppendUser[RuntimeZero, S2Support.Zero] = new AppendUser[RuntimeZero, S2Support.Zero] {
      override def appendUser[ST](in: ADTData[RuntimeZero, ST]): Nothing = ???
    }
  }

  private def tran: S2Support.M1ToM2[
    RuntimeNat,
    RuntimeNat,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#MP,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ] = new S2Support.M1ToM2[
    RuntimeNat,
    RuntimeNat,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#MP,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ] {
    override def to[PX1 <: RuntimeNat, PX2 <: RuntimeNat, PX3 <: S2Support.Func](input: AppendUser[PX2, PX3]): AppendUserAb[PX2, PX3#U] =
      input
  }

  def tempProduct: ProductType22Support[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ] = Product22Support.gen2[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C <: S2Support.Func] = AppendUser[B, C] })#MP,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ](helperImpl, tran)

}

trait AppendUserAb[In <: RuntimeNat, Out[_] <: Any] {
  def appendUser[ST](in: ADTData[In, ST]): Out[Nothing]
}

trait AppendUser[In <: RuntimeNat, Out <: S2Support.Func] extends AppendUserAb[In, Out#U] {
  override def appendUser[ST](in: ADTData[In, ST]): Out#U[Nothing]
}
