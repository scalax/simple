package net.scalax.simple.codec
package to_list_generic

import java.security.DrbgParameters.NextBytes

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

    trait LastMapHListLikeAppender[U[_[_]], A, X <: ColType] extends NotHList.Appender[U] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[U, FT]] = {
        val tailModel: M[NotHList.FGenericInputType[X#toM, FT]] = tailHListLikeAppender.toHList(monad)(func)

        class AB[FT111 <: NotHList.FType]
            extends NotHList.ConvertF[
              NotHList.ItemInputType[A, FT111],
              NotHList.FGenericInputType[X#toM, FT111],
              NotHList.FGenericInputType[U, FT111]
            ] {
          override def from(a: FT111#toF[A], b: X#toM[FT111#toF]): U[FT111#toF] = append1In(a, b)
          override def takeHead(c: U[FT111#toF]): FT111#toF[A]                  = takeHead1In(c)
          override def takeTail(c: U[FT111#toF]): X#toM[FT111#toF]              = takeTail1In(c)
          override def next: AB[FT111#Next]                                     = new AB[FT111#Next]
        }

        val abInstance: AB[FT] = new AB[FT] {
          SelfABInstance =>
          override def next: AB[FT#Next] = SelfABInstance.asInstanceOf[AB[FT#Next]]
        }

        monad.zip(abInstance, func[A], tailModel)
      }

      def append1In[M[_]](a1: M[A], a2: X#toM[M]): U[M]
      def takeHead1In[M[_]](a1: U[M]): M[A]
      def takeTail1In[M[_]](a1: U[M]): X#toM[M]

      def tailHListLikeAppender: HListLikeAppender[X]
    }

    trait ZeroHListLikeAppender extends HListLikeAppender[ZeroColType] {
      SelfZeroHListLikeAppender =>

      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[ZeroColType#toM, FT]] =
        monad.zero[NotHList.FGenericInputType[ZeroColType#toM, FT]](ZeroHListLikeAppender.instanceA[FT])

      override def tailHListLikeAppender: ZeroHListLikeAppender = SelfZeroHListLikeAppender
    }

    object ZeroHListLikeAppender {
      @inline val value: ZeroHListLikeAppender = new ZeroHListLikeAppender {
        @inline override lazy val tailHListLikeAppender: ZeroHListLikeAppender = super.tailHListLikeAppender
      }

      locally {
        value.tailHListLikeAppender
      }

      private class NInU[FUU <: NotHList.FType] extends NotHList.InputInstance[NotHList.FGenericInputType[ZeroColType#toM, FUU]] {
        override val item: ZeroType          = AppendContextSelf.zero
        override def andThen: NInU[FUU#Next] = new NInU[FUU#Next]
      }

      private val anyInstance: NInU[NotHList.FType] = new NInU[NotHList.FType] {
        SelfNInU =>
        override lazy val andThen: NInU[NotHList.FType#Next] = SelfNInU.asInstanceOf[NInU[NotHList.FType#Next]]
      }
      private def instanceA[FUU <: NotHList.FType]: NInU[FUU] = anyInstance.asInstanceOf[NInU[FUU]]
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

    trait InputInstance[I <: InputType] {
      def item: I#toItem
      def andThen: InputInstance[I#AndThen]
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
      def zero[N <: InputType](i: InputInstance[N]): M[N]
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

object SimpleProductXImpl2 extends SimpleProductXImpl2
