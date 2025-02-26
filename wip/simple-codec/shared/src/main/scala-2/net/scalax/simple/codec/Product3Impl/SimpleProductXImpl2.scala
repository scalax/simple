package net.scalax.simple.codec
package to_list_generic

class SimpleProductXImpl2 {
  SimpleProduct3Self =>

  trait AppendContext[HListLike, ZeroType <: HListLike, AppendType[_, _ <: HListLike] <: HListLike] {
    AppendContextSelf =>

    def zero: ZeroType
    def append[H, T <: HListLike](h: H, t: T): AppendType[H, T]
    def unappendHead[H, T <: HListLike](a: AppendType[H, T]): H
    def unappendTail[H, T <: HListLike](a: AppendType[H, T]): T

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

    @inline def positiveAppender[M1[_ <: NotHList.InputType], C <: ColType, FT <: NotHList.FType, T](
      appendMonad: NotHList.AppendMonad[M1],
      typeGen: NotHList.TypeGen[M1, FT],
      m: M1[NotHList.FGenericInputType[C#toM, FT]]
    ): M1[NotHList.FGenericInputType[AppendColType[T, C]#toM, FT]] = {
      def inSet1[X1, FT1X <: NotHList.FType, CT1X <: ColType]
        : NotHList.ConvertF[NotHList.ItemInputType[X1, FT1X], NotHList.FGenericInputType[CT1X#toM, FT1X], NotHList.FGenericInputType[
          AppendColType[X1, CT1X]#toM,
          FT1X
        ]] = new NotHList.ConvertF[
        NotHList.ItemInputType[X1, FT1X],
        NotHList.FGenericInputType[CT1X#toM, FT1X],
        NotHList.FGenericInputType[AppendColType[X1, CT1X]#toM, FT1X]
      ] {
        override def from(a: FT1X#toF[X1], b: CT1X#toM[FT1X#toF]): AppendType[FT1X#toF[X1], CT1X#toM[FT1X#toF]] = append(a, b)
        override def takeHead(c: AppendType[FT1X#toF[X1], CT1X#toM[FT1X#toF]]): FT1X#toF[X1]                    = unappendHead(c)
        override def takeTail(c: AppendType[FT1X#toF[X1], CT1X#toM[FT1X#toF]]): CT1X#toM[FT1X#toF]              = unappendTail(c)
        override def next: NotHList.ConvertF[NotHList.ItemInputType[X1, FT1X#Next], NotHList.FGenericInputType[
          CT1X#toM,
          FT1X#Next
        ], NotHList.FGenericInputType[AppendColType[X1, CT1X]#toM, FT1X#Next]] = inSet1[X1, FT1X#Next, CT1X]
      }

      appendMonad.zip(inSet1[T, FT, C], typeGen[T], m)
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
      SelfZeroHListLikeAppender =>

      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[ZeroColType#toM, FT]] = monad.zero[NotHList.FGenericInputType[ZeroColType#toM, FT]]

      override def tailHListLikeAppender: ZeroHListLikeAppender = SelfZeroHListLikeAppender
    }

    object ZeroHListLikeAppender {
      @inline val value: ZeroHListLikeAppender = new ZeroHListLikeAppender {
        ZeroHListLikeAppenderSelf =>
        @inline override lazy val tailHListLikeAppender: ZeroHListLikeAppender = ZeroHListLikeAppenderSelf
      }

      locally {
        value.tailHListLikeAppender
      }
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

    // ===
    trait InputType {
      type toItem
      type AndThen <: InputType
    }

    trait ItemInputType[T, FT <: FType] extends InputType {
      override type toItem  = FT#toF[T]
      override type AndThen = ItemInputType[T, FT#Next]
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
    trait ConvertF[A1 <: InputType, B1 <: InputType, C1 <: InputType] {
      SelfConvertF =>

      def from(a: A1#toItem, b: B1#toItem): C1#toItem
      def takeHead(c: C1#toItem): A1#toItem
      def takeTail(c: C1#toItem): B1#toItem

      def next: ConvertF[A1#AndThen, B1#AndThen, C1#AndThen]
    }

    // ===
    trait AppendMonad[M[_ <: InputType]] {
      def zip[A <: InputType, B <: InputType, C <: InputType](convertF: ConvertF[A, B, C], ma: M[A], mb: M[B]): M[C]
      def zero[N <: InputType]: M[N]
    }

    // ===
    trait TypeGen[M2[_ <: InputType], FT <: FType] {
      def apply[T]: M2[ItemInputType[T, FT]]
    }

    // ===
    trait Appender[F[_[_]]] {
      def toHList[M[_ <: InputType], FT <: FType](monad: AppendMonad[M])(func: TypeGen[M, FT]): M[FGenericInputType[F, FT]]
    }

    /*trait FromOtherAppender[F[_[_]], G[_[_]]] extends Appender[G] {
      def fromModel[X[_]](f: F[X]): G[X]
      def toModel[X[_]](g: G[X]): F[X]
      def appenderF: Appender[F]

      private class InnerMapperHelper[FT <: FType] extends Mapper[FGenericInputType[F, FT], FGenericInputType[G, FT]] {
        SelfInnerMapperHelper =>
        override def map(ia: F[FT#toF]): G[FT#toF]          = fromModel(ia)
        override def reverseMap(ib: G[FT#toF]): F[FT#toF]   = toModel(ib)
        override def nextMapper: InnerMapperHelper[FT#Next] = SelfInnerMapperHelper.asInstanceOf[InnerMapperHelper[FT#Next]]
      }

      override def toHList[M[_ <: InputType], FT <: FType](monad: AppendMonad[M])(func: TypeGen[M, FT]): M[FGenericInputType[G, FT]] = {
        val mModel: M[FGenericInputType[F, FT]]                                 = appenderF.toHList[M, FT](monad)(func)
        val mapperA: Mapper[FGenericInputType[F, FT], FGenericInputType[G, FT]] = new InnerMapperHelper
        monad.to[FGenericInputType[F, FT], FGenericInputType[G, FT]](mModel)(mapperA)
      }
    }*/
  }

}

object SimpleProductXImpl2 extends SimpleProductXImpl2
