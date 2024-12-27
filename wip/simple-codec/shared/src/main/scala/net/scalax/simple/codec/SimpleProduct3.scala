package net.scalax.simple.codec
package to_list_generic

import utils.SimpleP

object SimpleProduct3 {

  trait AppendContext[HListLike, ZeroType <: HListLike, AppendType[_, _ <: HListLike] <: HListLike] {
    def zero: ZeroType
    def append[H, T <: HListLike](h: H, t: T): AppendType[H, T]

    trait ColType {
      type toM[M[_]] <: HListLike
      type Tail <: ColType
    }

    trait AppendColType[T, TailType <: ColType] extends ColType {
      override type toM[M[_]] = AppendType[M[T], TailType#toM[M]]
      override type Tail      = TailType
    }

    trait ZeroColType extends ColType {
      override type toM[M[_]] = ZeroType
      override type Tail      = ZeroColType
    }

    trait FType {
      type toF[T]
      type Next <: FType
    }

    trait IdentityFType extends FType {
      override type toF[T] = T
      override type Next   = IdentityFType
    }

    trait AppendFType[F[_], TailType <: FType] extends FType {
      override type toF[T] = F[T]
      override type Next   = TailType
    }

    trait HListLikeFType[HL <: ColType, FT <: FType] extends FType {
      override type toF[T] = HL#toM[FT#toF]
      override type Next   = HListLikeFType[HL, FT#Next]
    }

  }

}
