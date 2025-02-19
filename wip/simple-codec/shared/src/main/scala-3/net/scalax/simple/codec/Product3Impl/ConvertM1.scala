package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl.NotHList
import NotHList.InputType

object ConvertM1Impl {
  type M1FType[M1[_]] = NotHList.PositiveFType[M1, NotHList.ZeroFType]

  type InputType1[T1] = NotHList.PositiveInputType[T1, NotHList.ZeroInputType]

  object TypeGen {
    def from1[M2[_], M1[_]](
      typeGen: SimpleProduct1.TypeGen[M2, M1]
    ): NotHList.TypeGen[({ type TA[U <: InputType] = M2[InputType.TakeHead[U]] })#TA, M1FType[M1]] =
      new NotHList.TypeGen[({ type TA[U <: InputType] = M2[InputType.TakeHead[U]] })#TA, M1FType[M1]] {
        override def apply[T]: M2[M1[T]] = typeGen[T]
      }
  }

  object AppendMonad {

    def from1[M2[_]](
      append: SimpleProduct1.AppendMonad[M2]
    ): NotHList.AppendMonad[({ type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U]] })#TA] =
      new NotHList.AppendMonad[({ type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U]] })#TA] {
        override def zip[A <: NotHList.InputType, B <: NotHList.InputType](
          ma: M2[InputType.TakeHead[A]],
          ms: M2[InputType.TakeHead[B]]
        ): M2[InputType.TakeHead[NotHList.ZipInputType[A, B]]] = append.zip(ma, ms).asInstanceOf

        override def to[A <: NotHList.InputType, B <: NotHList.InputType](m1: M2[InputType.TakeHead[A]])(
          in1: NotHList.Mapper[A, B]
        ): M2[InputType.TakeHead[B]] =
          append.to[InputType.TakeHead[A], InputType.TakeHead[B]](m1)(in1 = in1.map)(out1 = in1.reverseMap)

        override def zero: M2[InputType.TakeHead[NotHList.ZeroInputType]] = append.zero.asInstanceOf
      }

  }

  object Appender {
    def to1[F[_[_]]](append: NotHList.Appender[F]): SimpleProduct1.Appender[F] = new SimpleProduct1.Appender[F] {
      override def toHList1[M3[_], M2[_]](monad: SimpleProduct1.AppendMonad[M3])(
        func: SimpleProduct1.TypeGen[M3, M2]
      ): M3[F[M2]] = {
        val appendMonad: NotHList.AppendMonad[({ type TA[U <: NotHList.InputType] = M3[InputType.TakeHead[U]] })#TA] =
          AppendMonad.from1[M3](monad)

        val typeGen: NotHList.TypeGen[({ type TA[U <: NotHList.InputType] = M3[InputType.TakeHead[U]] })#TA, M1FType[M2]] =
          TypeGen.from1[M3, M2](func)

        append.toHList[({ type TA[U <: InputType] = M3[InputType.TakeHead[U]] })#TA, M1FType[M2]](
          appendMonad
        )(typeGen)
      }
    }
  }
}
