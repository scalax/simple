package net.scalax.simple.codec
package to_list_generic

import utils.SimpleP

object SimpleProduct3 {

  trait AppendContext[HListLike, ZeroType <: HListLike, AppendType[_, _ <: HListLike] <: HListLike] {
    def zero: ZeroType
    def append[H, T <: HListLike](h: H, t: T): AppendType[H, T]
    def takeHead[H, T <: HListLike](a: AppendType[H, T]): H
    def takeTail[H, T <: HListLike](a: AppendType[H, T]): T

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

    // ===
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

    // ===
    trait InputType {
      type toItem
      type AndThen <: InputType
    }

    trait ItemInputType[T, FT <: FType] extends InputType {
      override type toItem  = FT#toF[T]
      override type AndThen = ItemInputType[T, FT#Next]
    }

    trait ColInputType[HL <: ColType, FT <: FType] extends InputType {
      override type toItem  = HL#toM[FT#toF]
      override type AndThen = ColInputType[HL, FT#Next]
    }

    trait ZipInputType[In1 <: InputType, In2 <: InputType] extends InputType {
      override type toItem  = (In1#toItem, In2#toItem)
      override type AndThen = ZipInputType[In1#AndThen, In2#AndThen]
    }

    // ===
    trait Mapper[InputA <: InputType, InputB <: InputType] {
      def map(ia: InputA#toItem): InputB#toItem
      def reverseMap(ib: InputB#toItem): InputA#toItem

      def nextMapper: Mapper[InputA#AndThen, InputB#AndThen]
    }

    trait GetSet[Item, HL <: ColType, FT <: FType]
        extends Mapper[ZipInputType[ItemInputType[Item, FT], ColInputType[HL, FT]], ColInputType[AppendColType[Item, HL], FT]] {
      override def map(n: (FT#toF[Item], HL#toM[FT#toF])): AppendType[FT#toF[Item], HL#toM[FT#toF]]        = append(n._1, n._2)
      override def reverseMap(n: AppendType[FT#toF[Item], HL#toM[FT#toF]]): (FT#toF[Item], HL#toM[FT#toF]) = (takeHead(n), takeTail(n))

      override def nextMapper: GetSet[Item, HL, FT#Next] = new GetSet[Item, HL, FT#Next] {
        //
      }
    }

  }

}
