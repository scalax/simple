package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl.NotHList
import NotHList.InputType

object ConvertM2Impl {
  type M2FType[M1[_], M2[_]] = NotHList.PositiveFType[M1, ConvertM1Impl.M1FType[M2]]

  type InputType2[T1, T2] = NotHList.PositiveInputType[T1, ConvertM1Impl.InputType1[T2]]

  object TypeGen {
    def from2[M2[_, _], M1[_], M3[_]](
      typeGen: SimpleProduct2.TypeGen[M2, M1, M3]
    ): NotHList.TypeGen[({ type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA, M2FType[
      M1,
      M3
    ]] = new NotHList.TypeGen[
      ({ type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA,
      M2FType[M1, M3]
    ] {
      override def apply[T]: M2[M1[T], M3[T]] = typeGen[T]
    }

  }

  object AppendMonad {

    def from2[M2[_, _]](append: SimpleProduct2.AppendMonad[M2]): NotHList.AppendMonad[
      ({ type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA
    ] = new NotHList.AppendMonad[
      ({ type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA
    ] {
      override def zip[A <: InputType, B <: InputType](
        ma: M2[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]]],
        ms: M2[InputType.TakeHead[B], InputType.TakeHead[InputType.TakeTail[B]]]
      ): M2[InputType.TakeHead[NotHList.ZipInputType[A, B]], InputType.TakeHead[InputType.TakeTail[NotHList.ZipInputType[A, B]]]] =
        append.zip(ma, ms).asInstanceOf

      override def to[A <: InputType, B <: InputType](
        m1: M2[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]]]
      )(in1: NotHList.Mapper[A, B]): M2[InputType.TakeHead[B], InputType.TakeHead[InputType.TakeTail[B]]] =
        append.to[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]], InputType.TakeHead[B], InputType.TakeHead[
          InputType.TakeTail[B]
        ]](m1)(in1 = in1.map, in2 = in1.nextMapper.map)(
          in3 = in1.reverseMap,
          in4 = in1.nextMapper.reverseMap
        )

      override def zero: M2[InputType.TakeHead[NotHList.ZeroInputType], InputType.TakeHead[InputType.TakeTail[NotHList.ZeroInputType]]] =
        append.zero.asInstanceOf
    }
  }

  object Appender {
    def to2[F[_[_]]](append: SimpleProductXImpl.NotHList.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
      override def toHList[M3[_, _], M1[_], M2[_]](monad: SimpleProduct2.AppendMonad[M3])(
        func: SimpleProduct2.TypeGen[M3, M1, M2]
      ): M3[F[M1], F[M2]] = {
        val appendMonad
          : NotHList.AppendMonad[({ type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA] =
          AppendMonad.from2[M3](monad)

        val typeGen: NotHList.TypeGen[
          ({ type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA,
          M2FType[M1, M2]
        ] = TypeGen.from2[M3, M1, M2](func)

        append.toHList[({ type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA, M2FType[
          M1,
          M2
        ]](appendMonad)(typeGen)
      }
    }
  }

}
