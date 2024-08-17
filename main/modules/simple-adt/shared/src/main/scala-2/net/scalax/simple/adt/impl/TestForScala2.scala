package net.scalax.simple.adt
package impl

import net.scalax.simple.adt.CCDD.ABCD2
import net.scalax.simple.adt.support.S2Support
import utils.ProductType22Support

object TestForScala2 {

  /*trait Abc[PI, Append[_, _ <: PI] <: PI, Zero <: PI] {
    type AB[I1, I2, I3, I4] = Append[I1, Append[I2, Append[I3, Append[I4, Zero]]]]
    def abc[I1, I2, I3, I4]: AB[I1, I2, I3, I4] = ???
  }

  trait Positive2[Data, Tail[_] <: Any, Result] {
    def apply[TD >: Result](f: Data => TD): Tail[TD]
  }

  trait Func {
    type U[A] <: Any
    def instance: U[Nothing]
  }
  trait Append11[Data, Tail <: Func] extends Func {
    override type U[A] = Positive2[Data, Tail#U, A]
  }
  trait Zero extends Func {
    override type U[A] = A
  }

  val CC: Abc[Func, ({ type AP[A, B <: Func] = Append11[A, B] })#AP, Zero] = ???

  val dd = CC.abc[List[String], Long, Option[Int], BigDecimal].instance

  locally {
    val ee      = dd(t => t.map(_.size).sum)(t => t.toInt + 1)(t => t.getOrElse(55))(t => t.toInt)
    val ff: Int = ee
  }*/

  def helperImpl: ABCD2[
    RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,
    S2Support.Func,
    ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
    Zero,
    ({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP
  ] = ???

  class CurateAppend
      extends CCDD.ProductType22AppenderImpl2[
        RuntimeNat,
        ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
        RuntimeZero,
        S2Support.Func,
        ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
        S2Support.Zero,
        ({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP
      ] {
    override def helper: ABCD2[
      RuntimeNat,
      ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
      RuntimeZero,
      S2Support.Func,
      ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
      S2Support.Zero,
      ({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP
    ] = helperImpl
  }

  def tempAppend: CurateAppend = new CurateAppend

  def tempProduct: ProductType22Support[ RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero, RuntimeNat,
    ({ type AP[A, B <: RuntimeNat] = RuntimeData[A, B] })#AP,
    RuntimeZero,S2Support.Func,
    ({ type AP[A, B <: S2Support.Func] = S2Support.Append11[A, B] })#AP,
    S2Support.Zero,({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP,({ type BP[A <: RuntimeNat, B <: S2Support.Func] = AppendUser[A, B] })#BP]

  trait AppendUser[In <: RuntimeNat, Out <: Func] {
    def appendUser[ST](in: ADTData[In, ST]): Out#U[Nothing]
  }

}
