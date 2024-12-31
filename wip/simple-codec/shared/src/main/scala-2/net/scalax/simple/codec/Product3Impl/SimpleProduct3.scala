package net.scalax.simple.codec
package to_list_generic

object SimpleProduct3 {
  SimpleProduct3Self =>

  trait AppendContext[HListLike, ZeroType <: HListLike, AppendType[_, _ <: HListLike] <: HListLike] {
    AppendContextSelf =>

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
    trait ColInputType[HL <: ColType, FT <: NotHList.FType] extends NotHList.InputType {
      override type toItem  = HL#toM[FT#toF]
      override type AndThen = ColInputType[HL, FT#Next]
    }

    trait ZeroInputType extends NotHList.InputType {
      override type toItem  = ZeroType
      override type AndThen = ZeroInputType
    }

    // ===
    trait GetSet[Item, HL <: ColType, FT <: NotHList.FType]
        extends NotHList.Mapper[
          NotHList.ZipInputType[NotHList.ItemInputType[Item, FT], ColInputType[HL, FT]],
          ColInputType[AppendColType[Item, HL], FT]
        ] {
      override def map(n: (FT#toF[Item], HL#toM[FT#toF])): AppendType[FT#toF[Item], HL#toM[FT#toF]]        = append(n._1, n._2)
      override def reverseMap(n: AppendType[FT#toF[Item], HL#toM[FT#toF]]): (FT#toF[Item], HL#toM[FT#toF]) = (takeHead(n), takeTail(n))

      override def nextMapper: GetSet[Item, HL, FT#Next] = new GetSet[Item, HL, FT#Next] {
        //
      }
    }

    trait ZeroUnitMapper extends NotHList.Mapper[NotHList.UnitInputType, ZeroInputType] {
      ZeroUnitMapperSelf =>

      override def map(ia: Unit): ZeroType        = AppendContextSelf.zero
      override def reverseMap(ib: ZeroType): Unit = ()

      override def nextMapper: ZeroUnitMapper = ZeroUnitMapperSelf
    }

    def zeroAppender[M1[_ <: NotHList.InputType]](appendMonad: NotHList.AppendMonad[M1]): M1[ZeroInputType] = {
      val z = new ZeroUnitMapper {
        //
      }
      appendMonad.to(appendMonad.zero)(z)
    }

    def positiveAppender[M1[_ <: NotHList.InputType], C <: ColType, FT <: NotHList.FType, T](
      appendMonad: NotHList.AppendMonad[M1],
      typeGen: NotHList.TypeGen[M1, FT],
      m: M1[ColInputType[C, FT]]
    ): M1[ColInputType[AppendColType[T, C], FT]] = {
      val x1: M1[NotHList.ZipInputType[NotHList.ItemInputType[T, FT], ColInputType[C, FT]]] = appendMonad.zip(typeGen[T], m)
      val mapper: GetSet[T, C, FT] = new GetSet[T, C, FT] {
        //
      }
      appendMonad
        .to[NotHList.ZipInputType[NotHList.ItemInputType[T, FT], ColInputType[C, FT]], ColInputType[AppendColType[T, C], FT]](x1)(mapper)
    }

  }

  object NotHList {
    NotHListSelf =>

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

    trait UnitInputType extends InputType {
      override type toItem  = Unit
      override type AndThen = UnitInputType
    }

    trait ZipInputType[In1 <: InputType, In2 <: InputType] extends InputType {
      override type toItem  = (In1#toItem, In2#toItem)
      override type AndThen = ZipInputType[In1#AndThen, In2#AndThen]
    }

    trait FGenericInputType[F[_[_]], FT <: FType] extends InputType {
      override type toItem  = F[FT#toF]
      override type AndThen = FGenericInputType[F, FT#Next]
    }

    // ===
    trait Mapper[InputA <: InputType, InputB <: InputType] {
      def map(ia: InputA#toItem): InputB#toItem
      def reverseMap(ib: InputB#toItem): InputA#toItem

      def nextMapper: Mapper[InputA#AndThen, InputB#AndThen]
    }

    object Mapper {
      val unitInputType: Mapper[UnitInputType, UnitInputType] = new Mapper[UnitInputType, UnitInputType] {
        override def map(ia: Unit): Unit                              = ia
        override def reverseMap(ib: Unit): Unit                       = ib
        override def nextMapper: Mapper[UnitInputType, UnitInputType] = unitInputType
      }
    }

    // ===
    trait AppendMonad[M[_ <: InputType]] {
      def zip[A <: InputType, B <: InputType](ma: M[A], ms: M[B]): M[ZipInputType[A, B]]
      def to[A <: InputType, B <: InputType](m1: M[A])(in1: Mapper[A, B]): M[B]
      def zero: M[UnitInputType]
    }

    // ===
    trait TypeGen[M2[_ <: InputType], FT <: FType] {
      def apply[T]: M2[ItemInputType[T, FT]]
    }

    // ===
    trait Appender[F[_[_]]] {
      def toHList[M[_ <: InputType], FT <: FType](monad: AppendMonad[M])(func: TypeGen[M, FT]): M[FGenericInputType[F, FT]]
    }
  }

}
