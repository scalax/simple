package net.scalax.simple.codec
package to_list_generic

object ConvertM2Impl {
  trait M2FType[M1[_], M2[_]] extends SimpleProductXImpl.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM1Impl.M1FType[M2]
  }

  trait InputType2[T1, T2] extends SimpleProductXImpl.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = ConvertM1Impl.InputType1[T2]
  }

  object TypeGen {
    def from2[M2[_, _], M1[_], M3[_]](
      typeGen: SimpleProduct2.TypeGen[M2, M1, M3]
    ): SimpleProductXImpl.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA,
      M2FType[M1, M3]
    ] = new SimpleProductXImpl.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA,
      M2FType[M1, M3]
    ] {
      override def apply[T]: M2[M1[T], M3[T]] = typeGen[T]
    }

  }

  object AppendMonad {

    def from2[M2[_, _]](append: SimpleProduct2.AppendMonad[M2]): SimpleProductXImpl.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA
    ] = new SimpleProductXImpl.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA
    ] {
      override def zip[A <: SimpleProductXImpl.NotHList.InputType, B <: SimpleProductXImpl.NotHList.InputType](
        ma: M2[A#toItem, A#AndThen#toItem],
        ms: M2[B#toItem, B#AndThen#toItem]
      ): M2[(A#toItem, B#toItem), (A#AndThen#toItem, B#AndThen#toItem)] = append.zip(ma, ms)

      override def to[A <: SimpleProductXImpl.NotHList.InputType, B <: SimpleProductXImpl.NotHList.InputType](
        m1: M2[A#toItem, A#AndThen#toItem]
      )(
        in1: SimpleProductXImpl.NotHList.Mapper[A, B]
      ): M2[B#toItem, B#AndThen#toItem] =
        append.to[A#toItem, A#AndThen#toItem, B#toItem, B#AndThen#toItem](m1)(in1 = in1.map, in2 = in1.nextMapper.map)(
          in3 = in1.reverseMap,
          in4 = in1.nextMapper.reverseMap
        )

      override def zero: M2[Unit, Unit] = append.zero
    }
  }

  object Appender {
    def to2[F[_[_]]](append: SimpleProductXImpl.NotHList.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
      override def toHList[M3[_, _], M1[_], M2[_]](monad: SimpleProduct2.AppendMonad[M3])(
        func: SimpleProduct2.TypeGen[M3, M1, M2]
      ): M3[F[M1], F[M2]] = {
        val appendMonad: SimpleProductXImpl.NotHList.AppendMonad[
          ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA
        ] =
          AppendMonad.from2[M3](monad)

        val typeGen: SimpleProductXImpl.NotHList.TypeGen[
          ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA,
          M2FType[M1, M2]
        ] =
          TypeGen.from2[M3, M1, M2](func)

        append.toHList[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA, M2FType[M1, M2]](
          appendMonad
        )(typeGen)
      }
    }
  }

}
