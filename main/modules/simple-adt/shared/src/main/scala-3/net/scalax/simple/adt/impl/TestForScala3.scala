package net.scalax.simple.adt
package impl

import net.scalax.simple.adt.CCDD.ABCD2
import net.scalax.simple.adt.support.S3Support
import net.scalax.simple.adt.support.Product22Support
import net.scalax.simple.adt.utils.ProductType22Support
import net.scalax.simple.adt.utils.{ResultFolderBuilder, ResultFolderBuilderPositive, ResultFolderBuilderZero}

object TestForScala3 {

  type TakeInnerF[o <: S3Support.Func[?]] <: Any = o match {
    case S3Support.Func[u1] => u1[Nothing]
  }

  type TakeInnerFImpl[Data, o <: S3Support.Func[?]] <: Any = o match {
    case S3Support.Func[u1] => u1[Data]
  }

  trait AppendUser[In <: RuntimeNat, Out <: S3Support.Func[?]] extends AppendUserAb[In, [x] =>> TakeInnerFImpl[x, Out]] {
    def builder: ResultFolderBuilder
    override def appendUser[ST](in: ADTData[In, ST]): TakeInnerF[Out] =
      builder.toResultFolder(in.toGHDMZSK, ResultFolderBuilder.identityGhdmzsk).asInstanceOf[TakeInnerF[Out]]
  }

  private def helperImpl: ABCD2[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    S3Support.Func[?],
    S3Support.Append11,
    S3Support.Zero,
    AppendUser
  ] = new ABCD2[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    S3Support.Func[?],
    S3Support.Append11,
    S3Support.Zero,
    AppendUser
  ] {
    override def append2[A, P <: RuntimeNat, X <: S3Support.Func[?]](
      m: AppendUser[P, X]
    ): AppendUser[RuntimeData[A, P], S3Support.Append11[A, X]] = new AppendUser[RuntimeData[A, P], S3Support.Append11[A, X]] {
      override def builder: ResultFolderBuilder = ResultFolderBuilderPositive(m.builder)
    }
    override val zero2: AppendUser[RuntimeZero, S3Support.Zero] = new AppendUser[RuntimeZero, S3Support.Zero] {
      override val builder: ResultFolderBuilder = ResultFolderBuilderZero
    }
  }

  private def tran: S3Support.M1ToM2[
    RuntimeNat,
    RuntimeNat,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C <: S3Support.Func[?]] = AppendUser[B, C] })#MP,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ] = new S3Support.M1ToM2[
    RuntimeNat,
    RuntimeNat,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C <: S3Support.Func[?]] = AppendUser[B, C] })#MP,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ] {
    override def to[PX1 <: RuntimeNat, PX2 <: RuntimeNat, PX3[_] <: Any](
      input: AppendUser[PX2, S3Support.Func[PX3]]
    ): AppendUserAb[PX2, PX3] = input
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
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C <: S3Support.Func[?]] = AppendUser[B, C] })#MP,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ](helperImpl, tran)

}

trait AppendUserAb[In <: RuntimeNat, Out[_] <: Any] {
  def appendUser[ST](in: ADTData[In, ST]): Out[Nothing]
}

object CompatAppend {
  val compatAppend: ProductType22Support[
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    RuntimeNat,
    RuntimeData,
    RuntimeZero,
    ({ type MP[_ <: RuntimeNat, B <: RuntimeNat, C[_] <: Any] = AppendUserAb[B, C] })#MP
  ] = TestForScala3.tempProduct
}
