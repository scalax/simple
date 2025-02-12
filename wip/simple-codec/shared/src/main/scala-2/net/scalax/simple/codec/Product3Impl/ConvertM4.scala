package net.scalax.simple.codec
package to_list_generic

object ConvertM4Impl {
  trait M4FType[M1[_], M2[_], M3[_], M4[_]] extends SimpleProductXImpl.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM3Impl.M3FType[M2, M3, M4]
  }

  trait InputType4[T1, T2, T3, T4] extends SimpleProductXImpl.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = ConvertM3Impl.InputType3[T2, T3, T4]
  }

  object TypeGen {
    def from2[M2[_, _, _, _], M1[_], M3[_], M4[_], M5[_]](
      typeGen: SimpleProduct4.TypeGen[M2, M1, M3, M4, M5]
    ): SimpleProductXImpl.NotHList.TypeGen[
      ({
        type TA[U <: SimpleProductXImpl.NotHList.InputType] =
          M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
      })#TA,
      M4FType[M1, M3, M4, M5]
    ] = new SimpleProductXImpl.NotHList.TypeGen[
      ({
        type TA[U <: SimpleProductXImpl.NotHList.InputType] =
          M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
      })#TA,
      M4FType[M1, M3, M4, M5]
    ] {
      override def apply[T]: M2[M1[T], M3[T], M4[T], M5[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _, _, _]](
      append: SimpleProduct4.AppendMonad[M2]
    ): SimpleProductXImpl.NotHList.AppendMonad[
      ({
        type TA[U <: SimpleProductXImpl.NotHList.InputType] =
          M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
      })#TA
    ] = new SimpleProductXImpl.NotHList.AppendMonad[
      ({
        type TA[U <: SimpleProductXImpl.NotHList.InputType] =
          M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
      })#TA
    ] {
      override def zip[
        A <: SimpleProductXImpl.NotHList.InputType,
        B <: SimpleProductXImpl.NotHList.InputType
      ](
        ma: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem, A#AndThen#AndThen#AndThen#toItem],
        ms: M2[B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem, B#AndThen#AndThen#AndThen#toItem]
      ): M2[
        (A#toItem, B#toItem),
        (A#AndThen#toItem, B#AndThen#toItem),
        (A#AndThen#AndThen#toItem, B#AndThen#AndThen#toItem),
        (A#AndThen#AndThen#AndThen#toItem, B#AndThen#AndThen#AndThen#toItem)
      ] = append.zip(ma, ms)

      override def to[A <: SimpleProductXImpl.NotHList.InputType, B <: SimpleProductXImpl.NotHList.InputType](
        m1: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem, A#AndThen#AndThen#AndThen#toItem]
      )(
        in1: SimpleProductXImpl.NotHList.Mapper[A, B]
      ): M2[B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem, B#AndThen#AndThen#AndThen#toItem] =
        append.to[
          A#toItem,
          A#AndThen#toItem,
          A#AndThen#AndThen#toItem,
          A#AndThen#AndThen#AndThen#toItem,
          B#toItem,
          B#AndThen#toItem,
          B#AndThen#AndThen#toItem,
          B#AndThen#AndThen#AndThen#toItem
        ](m1)(
          in1 = in1.map,
          in2 = in1.nextMapper.map,
          in3 = in1.nextMapper.nextMapper.map,
          in4 = in1.nextMapper.nextMapper.nextMapper.map
        )(
          in5 = in1.reverseMap,
          in6 = in1.nextMapper.reverseMap,
          in7 = in1.nextMapper.nextMapper.reverseMap,
          in8 = in1.nextMapper.nextMapper.nextMapper.reverseMap
        )

      override def zero: M2[Unit, Unit, Unit, Unit] = append.zero
    }
  }

  object Appender {
    def to3[F[_[_]]](append: SimpleProductXImpl.NotHList.Appender[F]): SimpleProduct4.Appender[F] = new SimpleProduct4.Appender[F] {
      override def toHList[M3[_, _, _, _], M1[_], M2[_], M4[_], M5[_]](
        monad: SimpleProduct4.AppendMonad[M3]
      )(func: SimpleProduct4.TypeGen[M3, M1, M2, M4, M5]): M3[F[M1], F[M2], F[M4], F[M5]] = {
        val appendMonad: SimpleProductXImpl.NotHList.AppendMonad[
          ({
            type TA[U <: SimpleProductXImpl.NotHList.InputType] =
              M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
          })#TA
        ] =
          AppendMonad.from2[M3](monad)

        val typeGen: SimpleProductXImpl.NotHList.TypeGen[
          ({
            type TA[U <: SimpleProductXImpl.NotHList.InputType] =
              M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
          })#TA,
          M4FType[M1, M2, M4, M5]
        ] =
          TypeGen.from2[M3, M1, M2, M4, M5](func)

        append.toHList[
          ({
            type TA[U <: SimpleProductXImpl.NotHList.InputType] =
              M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem, U#AndThen#AndThen#AndThen#toItem]
          })#TA,
          M4FType[M1, M2, M4, M5]
        ](appendMonad)(typeGen)
      }
    }
  }

}
