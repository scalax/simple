package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl.NotHList
import NotHList.InputType

object ConvertM3Impl {
  type M3FType[M1[_], M2[_], M3[_]] = NotHList.PositiveFType[M1, ConvertM2Impl.M2FType[M2, M3]]

  type InputType3[T1, T2, T3] = NotHList.PositiveInputType[T1, ConvertM2Impl.InputType2[T2, T3]]

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
    ): SimpleProductXImpl.NotHList.AppendMonad[
      ({
        type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[U]]
        ]]
      })#TA
    ] = new SimpleProductXImpl.NotHList.AppendMonad[
      ({
        type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[U]]
        ]]
      })#TA
    ] {
      override def zip[
        A <: InputType,
        B <: InputType
      ](
        ma: M2[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[A]]
        ]],
        ms: M2[InputType.TakeHead[B], InputType.TakeHead[InputType.TakeTail[B]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[B]]
        ]]
      ): M2[
        InputType.TakeHead[NotHList.ZipInputType[A, B]],
        InputType.TakeHead[InputType.TakeTail[NotHList.ZipInputType[A, B]]],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[NotHList.ZipInputType[A, B]]]
        ]
      ] =
        append.zip(ma, ms).asInstanceOf

      override def to[A <: SimpleProductXImpl.NotHList.InputType, B <: InputType](
        m1: M2[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]], InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[A]]
        ]]
      )(
        in1: NotHList.Mapper[A, B]
      ): M2[InputType.TakeHead[B], InputType.TakeHead[InputType.TakeTail[B]], InputType.TakeHead[
        InputType.TakeTail[InputType.TakeTail[B]]
      ]] =
        append.to[
          InputType.TakeHead[A],
          InputType.TakeHead[InputType.TakeTail[A]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[A]]
          ],
          InputType.TakeHead[B],
          InputType.TakeHead[InputType.TakeTail[B]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[B]]
          ]
        ](m1)(
          in1 = in1.map,
          in2 = in1.nextMapper.map,
          in3 = in1.nextMapper.nextMapper.map
        )(
          in4 = in1.reverseMap,
          in5 = in1.nextMapper.reverseMap,
          in6 = in1.nextMapper.nextMapper.reverseMap
        )

      override def zero: M2[
        InputType.TakeHead[NotHList.ZeroInputType],
        InputType.TakeHead[InputType.TakeTail[NotHList.ZeroInputType]],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[NotHList.ZeroInputType]]
        ]
      ] = append.zero.asInstanceOf
    }
  }

  object Appender {
    def to3[F[_[_]]](append: SimpleProductXImpl.NotHList.Appender[F]): SimpleProduct3.Appender[F] = new SimpleProduct3.Appender[F] {
      override def toHList[M3[_, _, _], M1[_], M2[_], M4[_]](
        monad: SimpleProduct3.AppendMonad[M3],
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

        val typeGen: SimpleProductXImpl.NotHList.TypeGen[
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
