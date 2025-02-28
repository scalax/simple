package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl2.NotHList
import NotHList.InputType

object ConvertM3Impl {
  type M3FType[M1[_], M2[_], M3[_]] = NotHList.PositiveFType[M1, ConvertM2Impl.M2FType[M2, M3]]

  object TypeGen {
    def from2[M2[_, _, _], M1[_], M3[_], M4[_]](
      typeGen: SimpleProduct3.TypeGen[M2, M1, M3, M4]
    ): NotHList.TypeGen[
      ({
        type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[U]]
        ]]
      })#TA,
      M3FType[M1, M3, M4]
    ] = new NotHList.TypeGen[
      ({
        type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[U]]
        ]]
      })#TA,
      M3FType[M1, M3, M4]
    ] {
      override def apply[T]: M2[M1[T], M3[T], M4[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _, _]](
      append: SimpleProduct3.AppendMonad[M2]
    ): SimpleProductXImpl2.NotHList.AppendMonad[
      ({
        type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[U]]
        ]]
      })#TA
    ] = new SimpleProductXImpl2.NotHList.AppendMonad[
      ({
        type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[U]]
        ]]
      })#TA
    ] {
      override def zip[
        A <: InputType,
        B <: InputType,
        C <: InputType
      ](
        fromTo: NotHList.ConvertF[A, B, C],
        ma: M2[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[A]]
        ]],
        mb: M2[InputType.TakeHead[B], InputType.TakeHead[InputType.TakeTail[B]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[B]]
        ]]
      ): M2[InputType.TakeHead[C], InputType.TakeHead[InputType.TakeTail[C]], InputType.TakeHead[
        InputType.TakeTail[InputType.TakeTail[C]]
      ]] = {
        val c1: SimpleProduct3.ConvertF3[
          InputType.TakeHead[A],
          InputType.TakeHead[B],
          InputType.TakeHead[C],
          InputType.TakeHead[InputType.TakeTail[A]],
          InputType.TakeHead[InputType.TakeTail[B]],
          InputType.TakeHead[InputType.TakeTail[C]],
          InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[A]]],
          InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[B]]],
          InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[C]]]
        ] =
          new SimpleProduct3.ConvertF3[
            InputType.TakeHead[A],
            InputType.TakeHead[B],
            InputType.TakeHead[C],
            InputType.TakeHead[InputType.TakeTail[A]],
            InputType.TakeHead[InputType.TakeTail[B]],
            InputType.TakeHead[InputType.TakeTail[C]],
            InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[A]]],
            InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[B]]],
            InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[C]]]
          ] {
            override def from1(a: InputType.TakeHead[A], b: InputType.TakeHead[B]): InputType.TakeHead[C] = fromTo.from(a, b)
            override def takeHead1(modelC: InputType.TakeHead[C]): InputType.TakeHead[A]                  = fromTo.takeHead(modelC)
            override def takeTail1(modelC: InputType.TakeHead[C]): InputType.TakeHead[B]                  = fromTo.takeTail(modelC)

            override def from2(
              a: InputType.TakeHead[InputType.TakeTail[A]],
              b: InputType.TakeHead[InputType.TakeTail[B]]
            ): InputType.TakeHead[InputType.TakeTail[C]] = fromTo.next.from(a, b)
            override def takeHead2(modelC: InputType.TakeHead[InputType.TakeTail[C]]): InputType.TakeHead[InputType.TakeTail[A]] =
              fromTo.next.takeHead(modelC)
            override def takeTail2(modelC: InputType.TakeHead[InputType.TakeTail[C]]): InputType.TakeHead[InputType.TakeTail[B]] =
              fromTo.next.takeTail(modelC)

            override def from3(
              a: InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[A]]],
              b: InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[B]]]
            ): InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[C]]] = fromTo.next.next.from(a, b)
            override def takeHead3(
              modelC: InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[C]]]
            ): InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[A]]] =
              fromTo.next.next.takeHead(modelC)
            override def takeTail3(
              modelC: InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[C]]]
            ): InputType.TakeHead[InputType.TakeTail[InputType.TakeTail[B]]] =
              fromTo.next.next.takeTail(modelC)
          }

        append.zip(c1, ma, mb)
      }

      override def zero[N1 <: InputType](
        n1: NotHList.InputInstance[N1]
      ): M2[InputType.TakeHead[N1], InputType.TakeHead[InputType.TakeTail[N1]], InputType.TakeHead[
        InputType.TakeTail[InputType.TakeTail[N1]]
      ]] = append.zero(n1.item, n1.andThen.item, n1.andThen.andThen.item)
    }
  }

  object Appender {
    def to3[F[_[_]]](append: SimpleProductXImpl2.NotHList.Appender[F]): SimpleProduct3.Appender[F] = new SimpleProduct3.Appender[F] {
      override def toHList1[M3[_, _, _], M1[_], M2[_], M4[_]](monad: SimpleProduct3.AppendMonad[M3])(
        func: SimpleProduct3.TypeGen[M3, M1, M2, M4]
      ): M3[F[M1], F[M2], F[M4]] = {
        val appendMonad: NotHList.AppendMonad[
          ({
            type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ]]
          })#TA
        ] =
          AppendMonad.from2[M3](monad)

        val typeGen: SimpleProductXImpl2.NotHList.TypeGen[
          ({
            type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ]]
          })#TA,
          M3FType[M1, M2, M4]
        ] =
          TypeGen.from2[M3, M1, M2, M4](func)

        append.toHList[
          ({
            type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ]]
          })#TA,
          M3FType[M1, M2, M4]
        ](appendMonad)(typeGen)
      }
    }
  }

}
