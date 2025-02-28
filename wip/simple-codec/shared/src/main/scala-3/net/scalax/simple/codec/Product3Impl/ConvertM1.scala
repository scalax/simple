package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl2.NotHList
import NotHList.InputType

object ConvertM1Impl {

  type M1FType[M1[_]] = NotHList.PositiveFType[M1, NotHList.ZeroFType]

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
        override def zip[A <: NotHList.InputType, B <: NotHList.InputType, C <: NotHList.InputType](
          fromTo: NotHList.ConvertF[A, B, C],
          ma: M2[InputType.TakeHead[A]],
          mb: M2[InputType.TakeHead[B]]
        ): M2[InputType.TakeHead[C]] = {
          val c1: SimpleProduct1.ConvertF1[InputType.TakeHead[A], InputType.TakeHead[B], InputType.TakeHead[C]] =
            new SimpleProduct1.ConvertF1[InputType.TakeHead[A], InputType.TakeHead[B], InputType.TakeHead[C]] {
              override def from1(a: InputType.TakeHead[A], b: InputType.TakeHead[B]): InputType.TakeHead[C] = fromTo.from(a, b)
              override def takeHead1(modelC: InputType.TakeHead[C]): InputType.TakeHead[A]                  = fromTo.takeHead(modelC)
              override def takeTail1(modelC: InputType.TakeHead[C]): InputType.TakeHead[B]                  = fromTo.takeTail(modelC)
            }

          append.zip(c1, ma, mb)
        }

        override def zero[N1 <: NotHList.InputType](n: NotHList.InputInstance[N1]): M2[InputType.TakeHead[N1]] =
          append.zero[InputType.TakeHead[N1]](n.item)
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
