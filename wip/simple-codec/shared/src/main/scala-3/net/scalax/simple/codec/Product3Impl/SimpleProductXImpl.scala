package net.scalax.simple.codec
package to_list_generic

class SimpleProductXImpl[AppendFunc[_, _]] {
  SimpleProduct3Self =>

  trait AppendContext[HListLike, ZeroType <: HListLike, AppendType[_, _ <: HListLike] <: HListLike] {
    AppendContextSelf =>

    def zero: ZeroType
    def append[H, T <: HListLike](h: AppendFunc[H, T]): AppendType[H, T]
    def unappend[H, T <: HListLike](a: AppendType[H, T]): AppendFunc[H, T]

    trait ColType
    trait AppendColType[T, TailType <: ColType] extends ColType
    trait ZeroColType                           extends ColType

    object ColType {
      type toM[M[_], Col <: ColType] <: HListLike = Col match {
        case ZeroColType            => ZeroType
        case AppendColType[t, tail] => AppendType[M[t], toM[M, tail]]
      }

      type TakeTail[Col <: ColType] <: ColType = Col match {
        case ZeroColType            => ZeroColType
        case AppendColType[t, tail] => tail
      }
    }

    // ===
    trait GetSet[Item, HL <: ColType, FT <: NotHList.FType]
        extends NotHList.Mapper[
          NotHList.ZipInputType[NotHList.ItemInputType[Item, FT], NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, HL], FT]],
          NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, AppendColType[Item, HL]], FT]
        ] {
      type type1 = NotHList.ZipInputType[NotHList.ItemInputType[Item, FT], NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, HL], FT]]
      type type2 = NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, AppendColType[Item, HL]], FT]
      type head1 = NotHList.InputType.TakeHead[type1]
      type head2 = NotHList.InputType.TakeHead[type2]
      type tail1 = NotHList.InputType.TakeTail[type1]
      type tail2 = NotHList.InputType.TakeTail[type2]

      override def map(n: head1): head2        = append(n.asInstanceOf).asInstanceOf
      override def reverseMap(n: head2): head1 = unappend(n.asInstanceOf).asInstanceOf
    }

    object GetSet {
      @inline private val getsetModel: GetSet[Any, ColType, NotHList.FType] = new GetSet[Any, ColType, NotHList.FType] {
        GetSetImplSelf =>
        @inline override lazy val nextMapper = GetSetImplSelf.asInstanceOf
      }

      locally {
        getsetModel.nextMapper
      }

      @inline def value[Item, HL <: ColType, FT <: NotHList.FType]: GetSet[Item, HL, FT] =
        getsetModel.asInstanceOf[GetSet[Item, HL, FT]]
    }

    trait ZeroUnitMapper[FT <: NotHList.FType]
        extends NotHList.Mapper[NotHList.ZeroInputType, NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, ZeroColType], FT]] {
      type type1 = NotHList.ZeroInputType
      type type2 = NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, ZeroColType], FT]
      type head1 = NotHList.InputType.TakeHead[type1]
      type head2 = NotHList.InputType.TakeHead[type2]
      type tail1 = NotHList.InputType.TakeTail[type1]
      type tail2 = NotHList.InputType.TakeTail[type2]

      override def map(ia: head1)        = AppendContextSelf.zero.asInstanceOf
      override def reverseMap(ib: head2) = ().asInstanceOf
    }

    object ZeroUnitMapper {
      @inline private val zeroUnitMapperProductImplImpl: ZeroUnitMapper[NotHList.FType] = new ZeroUnitMapper[NotHList.FType] {
        thisSelf =>
        @inline override lazy val nextMapper = thisSelf.asInstanceOf
      }

      locally {
        zeroUnitMapperProductImplImpl.nextMapper
      }

      @inline def zeroAppender[FT <: NotHList.FType]: ZeroUnitMapper[FT] = zeroUnitMapperProductImplImpl.asInstanceOf
    }

    def positiveAppender[M1[_ <: NotHList.InputType], C <: ColType, FT <: NotHList.FType, T](
      appendMonad: NotHList.AppendMonad[M1],
      typeGen: NotHList.TypeGen[M1, FT],
      m: M1[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, C], FT]]
    ): M1[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, AppendColType[T, C]], FT]] = {
      val x1: M1[NotHList.ZipInputType[NotHList.ItemInputType[T, FT], NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, C], FT]]] =
        appendMonad.zip(typeGen[T], m)

      val mapper: GetSet[T, C, FT] = GetSet.value[T, C, FT]

      appendMonad.to[
        NotHList.ZipInputType[
          NotHList.ItemInputType[T, FT],
          NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, C], FT]
        ],
        NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, AppendColType[T, C]], FT]
      ](x1)(mapper)
    }

    // ===
    trait HListLikeAppender[X <: ColType] extends NotHList.Appender[[x[_]] =>> ColType.toM[x, X]] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, X], FT]]

      def tailHListLikeAppender: HListLikeAppender[ColType.TakeTail[X]]
    }

    trait PositiveHListLikeAppender[A, X <: ColType] extends HListLikeAppender[AppendColType[A, X]] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, AppendColType[A, X]], FT]] = {
        val tailModel: M[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, ColType.TakeTail[AppendColType[A, X]]], FT]] =
          tailHListLikeAppender.toHList[M, FT](monad)(func)
        positiveAppender[M, X, FT, A](monad, func, tailModel.asInstanceOf)
      }

      override def tailHListLikeAppender: HListLikeAppender[ColType.TakeTail[AppendColType[A, X]]]
    }

    trait ZeroHListLikeAppender extends HListLikeAppender[ZeroColType] {
      override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
        func: NotHList.TypeGen[M, FT]
      ): M[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, ZeroColType], FT]]

      override def tailHListLikeAppender: ZeroHListLikeAppender
    }

    object ZeroHListLikeAppender {
      @inline val value: ZeroHListLikeAppender = new ZeroHListLikeAppender {
        ZeroHListLikeAppenderSelf =>
        override def toHList[M[_ <: NotHList.InputType], FT <: NotHList.FType](monad: NotHList.AppendMonad[M])(
          func: NotHList.TypeGen[M, FT]
        ): M[NotHList.FGenericInputType[[x[_]] =>> ColType.toM[x, ZeroColType], FT]] = monad.to(monad.zero)(ZeroUnitMapper.zeroAppender[FT])

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
    trait FType
    trait PositiveFType[toF[_], Next <: FType] extends FType
    trait ZeroFType                            extends FType

    // ===
    trait InputType
    trait PositiveInputType[Item, AndThen <: InputType] extends InputType
    trait ZeroInputType                                 extends InputType
    object InputType {
      type TakeHead[t <: InputType] <: Any = t match {
        case PositiveInputType[i, u] => i
      }
      type TakeTail[t <: InputType] <: InputType = t match {
        case PositiveInputType[i, u] => u
      }
    }

    type ItemInputType[T, FT <: FType] <: InputType = FT match {
      case PositiveFType[u, n] => PositiveInputType[u[T], ItemInputType[T, n]]
      case ZeroFType           => ZeroInputType
    }

    type ZipInputType[In1 <: InputType, In2 <: InputType] <: InputType = (In1, In2) match {
      case (PositiveInputType[item1, tail1], PositiveInputType[item2, tail2]) =>
        PositiveInputType[AppendFunc[item1, item2], ZipInputType[tail1, tail2]]
      case (ZeroInputType, ZeroInputType) => ZeroInputType
    }

    type FGenericInputType[F[_[_]], FT <: FType] <: InputType = FT match {
      case PositiveFType[u, tail] => PositiveInputType[F[u], FGenericInputType[F, tail]]
      case ZeroFType              => ZeroInputType
    }

    // ===
    trait Mapper[InputA <: InputType, InputB <: InputType] {
      def map(ia: InputType.TakeHead[InputA]): InputType.TakeHead[InputB]
      def reverseMap(ib: InputType.TakeHead[InputB]): InputType.TakeHead[InputA]

      def nextMapper: Mapper[InputType.TakeTail[InputA], InputType.TakeTail[InputB]]
    }

    object Mapper {
      /*val unitInputType: Mapper[ZeroInputType, ZeroInputType] = new Mapper[ZeroInputType, ZeroInputType] {
        SelfUnitInputType =>
        override def map(ia: Unit): Unit        = ia
        override def reverseMap(ib: Unit): Unit = ib
        override lazy val nextMapper: Mapper[InputType.TakeTail[ZeroInputType], InputType.TakeTail[ZeroInputType]] =
          SelfUnitInputType.asInstanceOf
      }

      locally {
        unitInputType.nextMapper
      }*/
    }

    // ===
    trait AppendMonad[M[_ <: InputType]] {
      def zip[A <: InputType, B <: InputType](ma: M[A], ms: M[B]): M[ZipInputType[A, B]]
      def to[A <: InputType, B <: InputType](m1: M[A])(in1: Mapper[A, B]): M[B]
      def zero: M[ZeroInputType]
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
        SelfInnerMapperHelper =>
        type type1 = FGenericInputType[F, FT]
        type type2 = FGenericInputType[G, FT]
        type head1 = NotHList.InputType.TakeHead[type1]
        type head2 = NotHList.InputType.TakeHead[type2]
        type tail1 = NotHList.InputType.TakeTail[type1]
        type tail2 = NotHList.InputType.TakeTail[type2]

        override def map(ia: head1)        = fromModel(ia.asInstanceOf).asInstanceOf
        override def reverseMap(ib: head2) = toModel(ib.asInstanceOf).asInstanceOf
        override def nextMapper            = SelfInnerMapperHelper.asInstanceOf
      }

      private val value1 = new InnerMapperHelper[FType]

      override def toHList[M[_ <: InputType], FT <: FType](
        monad: AppendMonad[M]
      )(func: TypeGen[M, FT]): M[FGenericInputType[G, FT]] = {
        val mModel: M[FGenericInputType[F, FT]]                                 = appenderF.toHList[M, FT](monad)(func)
        val mapperA: Mapper[FGenericInputType[F, FT], FGenericInputType[G, FT]] = value1.asInstanceOf
        monad.to[FGenericInputType[F, FT], FGenericInputType[G, FT]](mModel)(mapperA)
      }
    }
  }

}

object SimpleProductXImpl extends SimpleProductXImpl[Tuple2]
