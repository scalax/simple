package net.scalax.simple.codec
package to_list_generic

class SimpleProduct3[AppendFunc[_, _]] {
  SimpleProduct3Self =>

  trait AppendContext[HListLike, ZeroType <: HListLike, AppendType[_, _ <: HListLike] <: HListLike] {
    AppendContextSelf =>

    def zero: ZeroType
    def append[H, T <: HListLike](h: AppendFunc[H, T]): AppendType[H, T]
    def unappend[H, T <: HListLike](a: AppendType[H, T]): AppendFunc[H, T]

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
    trait GetSet[Item, HL <: ColType, FT <: NotHList.FType]
        extends NotHList.Mapper[
          NotHList.ZipInputType[NotHList.ItemInputType[Item, FT], NotHList.FGenericInputType[HL#toM, FT]],
          NotHList.FGenericInputType[AppendColType[Item, HL]#toM, FT]
        ] {
      override def map(n: AppendFunc[FT#toF[Item], HL#toM[FT#toF]]): AppendType[FT#toF[Item], HL#toM[FT#toF]]        = append(n)
      override def reverseMap(n: AppendType[FT#toF[Item], HL#toM[FT#toF]]): AppendFunc[FT#toF[Item], HL#toM[FT#toF]] = unappend(n)

      override def nextMapper: GetSet[Item, HL, FT#Next] = new GetSet[Item, HL, FT#Next] {
        //
      }
    }

    trait ZeroUnitMapper[FT <: NotHList.FType]
        extends NotHList.Mapper[NotHList.UnitInputType, NotHList.FGenericInputType[ZeroColType#toM, FT]] {

      override def map(ia: Unit): ZeroType        = AppendContextSelf.zero
      override def reverseMap(ib: ZeroType): Unit = ()

      override def nextMapper: ZeroUnitMapper[FT#Next] = new ZeroUnitMapper[FT#Next] {
        //
      }
    }

    object ZeroUnitMapper {
      @inline private val zeroUnitMapperProductImplImpl: ZeroUnitMapper[NotHList.FType] = new ZeroUnitMapper[NotHList.FType] {
        thisSelf =>
        @inline override lazy val nextMapper: ZeroUnitMapper[NotHList.FType#Next] =
          thisSelf.asInstanceOf[ZeroUnitMapper[NotHList.FType#Next]]
      }
      zeroUnitMapperProductImplImpl.nextMapper
      // ===
      trait ToZero {
        @inline def to[FT <: NotHList.FType]: ZeroUnitMapper[FT]
      }
      // ===
      val zeroAppender: ToZero = new ToZero {
        @inline override def to[FT <: NotHList.FType]: ZeroUnitMapper[FT] = zeroUnitMapperProductImplImpl.asInstanceOf[ZeroUnitMapper[FT]]
      }
    }

    def positiveAppender[M1[_ <: NotHList.InputType], C <: ColType, FT <: NotHList.FType, T](
      appendMonad: NotHList.AppendMonad[M1],
      typeGen: NotHList.TypeGen[M1, FT],
      m: M1[NotHList.FGenericInputType[C#toM, FT]]
    ): M1[NotHList.FGenericInputType[AppendColType[T, C]#toM, FT]] = {
      val x1: M1[NotHList.ZipInputType[NotHList.ItemInputType[T, FT], NotHList.FGenericInputType[C#toM, FT]]] =
        appendMonad.zip(typeGen[T], m)
      val mapper: GetSet[T, C, FT] = new GetSet[T, C, FT] {
        //
      }
      appendMonad
        .to[NotHList.ZipInputType[NotHList.ItemInputType[T, FT], NotHList.FGenericInputType[C#toM, FT]], NotHList.FGenericInputType[
          AppendColType[T, C]#toM,
          FT
        ]](x1)(mapper)
    }

    // ===
    trait HListLikeAppender[X <: ColType] extends NotHList.Appender[X#toM] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[X#toM, FT]]

      def tailHListLikeAppender: HListLikeAppender[X#Tail]
    }

    trait PositiveHListLikeAppender[A, X <: ColType] extends HListLikeAppender[AppendColType[A, X]] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[AppendColType[A, X]#toM, FT]] = {
        val tailModel: M[NotHList.FGenericInputType[X#toM, FT]] = tailHListLikeAppender.toHList(monad)(func)
        positiveAppender[M, X, FT, A](monad, func, tailModel)
      }

      override def tailHListLikeAppender: HListLikeAppender[X]
    }

    trait ZeroHListLikeAppender extends HListLikeAppender[ZeroColType] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[ZeroColType#toM, FT]]

      override def tailHListLikeAppender: ZeroHListLikeAppender
    }

    object ZeroHListLikeAppender {
      val value: ZeroHListLikeAppender = new ZeroHListLikeAppender {
        ZeroHListLikeAppenderSelf =>
        override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
          func: NotHList.TypeGen[M, FT]
        ): M[NotHList.FGenericInputType[ZeroColType#toM, FT]] = monad.to(monad.zero)(ZeroUnitMapper.zeroAppender.to[FT])

        override lazy val tailHListLikeAppender: ZeroHListLikeAppender = ZeroHListLikeAppenderSelf
      }
      value.tailHListLikeAppender
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
      override type toItem  = AppendFunc[In1#toItem, In2#toItem]
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
        override def map(ia: Unit): Unit                                   = ia
        override def reverseMap(ib: Unit): Unit                            = ib
        override lazy val nextMapper: Mapper[UnitInputType, UnitInputType] = unitInputType
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

    trait FromOtherAppender[F[_[_]], G[_[_]]] extends Appender[G] {
      def fromModel[X[_]](f: F[X]): G[X]
      def toModel[X[_]](g: G[X]): F[X]
      def appenderF: Appender[F]

      private class InnerMapperHelper[FT <: FType] extends Mapper[FGenericInputType[F, FT], FGenericInputType[G, FT]] {
        override def map(ia: F[FT#toF]): G[FT#toF]          = fromModel(ia)
        override def reverseMap(ib: G[FT#toF]): F[FT#toF]   = toModel(ib)
        override def nextMapper: InnerMapperHelper[FT#Next] = new InnerMapperHelper[FT#Next]
      }

      override def toHList[M[_ <: InputType], FT <: FType](monad: AppendMonad[M])(func: TypeGen[M, FT]): M[FGenericInputType[G, FT]] = {
        val mModel: M[FGenericInputType[F, FT]]                                 = appenderF.toHList[M, FT](monad)(func)
        val mapperA: Mapper[FGenericInputType[F, FT], FGenericInputType[G, FT]] = new InnerMapperHelper
        monad.to[FGenericInputType[F, FT], FGenericInputType[G, FT]](mModel)(mapperA)
      }
    }
  }

}

object SimpleProduct3 extends SimpleProduct3[Tuple2]
