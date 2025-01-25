package net.scalax.simple.codec
package to_list_generic

object ConvertM3Impl {
  trait M3FType[M1[_], M2[_], M3[_]] extends SimpleProductXImpl.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM2Impl.M2FType[M2, M3]
  }

  trait InputType3[T1, T2, T3] extends SimpleProductXImpl.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = ConvertM2Impl.InputType2[T2, T3]
  }

  object TypeGen {
    def from2[M2[_, _, _], M1[_], M3[_], M4[_]](
      typeGen: SimpleProduct3.TypeGen[M2, M1, M3, M4]
    ): SimpleProductXImpl.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
      M3FType[
        M1,
        M3,
        M4
      ]
    ] =
      new SimpleProductXImpl.NotHList.TypeGen[
        ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
        M3FType[M1, M3, M4]
      ] {
        override def apply[T]: M2[M1[T], M3[T], M4[T]] = typeGen[T]
      }

    def to2[M2[_, _, _], M1[_], M3[_], M4[_]](
      typeGen: SimpleProductXImpl.NotHList.TypeGen[
        ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
        M3FType[M1, M3, M4]
      ]
    ): SimpleProduct3.TypeGen[M2, M1, M3, M4] = new SimpleProduct3.TypeGen[M2, M1, M3, M4] {
      override def apply[T]: M2[M1[T], M3[T], M4[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _, _]](
      append: SimpleProduct3.AppendMonad[M2]
    ): SimpleProductXImpl.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
    ] =
      new SimpleProductXImpl.NotHList.AppendMonad[
        ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
      ] {
        override def zip[
          A <: SimpleProductXImpl.NotHList.InputType,
          B <: SimpleProductXImpl.NotHList.InputType
        ](
          ma: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem],
          ms: M2[B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem]
        ): M2[(A#toItem, B#toItem), (A#AndThen#toItem, B#AndThen#toItem), (A#AndThen#AndThen#toItem, B#AndThen#AndThen#toItem)] =
          append.zip(ma, ms)

        override def to[A <: SimpleProductXImpl.NotHList.InputType, B <: SimpleProductXImpl.NotHList.InputType](
          m1: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem]
        )(
          in1: SimpleProductXImpl.NotHList.Mapper[A, B]
        ): M2[B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem] =
          append.to[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem, B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem](m1)(
            in1 = in1.map,
            in2 = in1.nextMapper.map,
            in3 = in1.nextMapper.nextMapper.map
          )(
            in4 = in1.reverseMap,
            in5 = in1.nextMapper.reverseMap,
            in6 = in1.nextMapper.nextMapper.reverseMap
          )

        override def zero: M2[Unit, Unit, Unit] = append.zero
      }

    def to2[M2[_, _, _]](
      append: SimpleProductXImpl.NotHList.AppendMonad[
        ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
      ]
    ): SimpleProduct3.AppendMonad[M2] = new SimpleProduct3.AppendMonad[M2] {
      override def zip[A, B, C, S, T, U](ma: M2[A, B, C], ms: M2[S, T, U]): M2[(A, S), (B, T), (C, U)] =
        append.zip[InputType3[A, B, C], InputType3[S, T, U]](ma, ms)
      override def to[A, B, C, S, T, U](
        m1: M2[A, B, C]
      )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M2[S, T, U] =
        append.to[InputType3[A, B, C], InputType3[S, T, U]](m1)(
          new SimpleProductXImpl.NotHList.Mapper[InputType3[A, B, C], InputType3[S, T, U]] {
            override def map(ia: A): S        = in1(ia)
            override def reverseMap(ib: S): A = in4(ib)
            override def nextMapper: SimpleProductXImpl.NotHList.Mapper[ConvertM2Impl.InputType2[B, C], ConvertM2Impl.InputType2[T, U]] =
              new SimpleProductXImpl.NotHList.Mapper[ConvertM2Impl.InputType2[B, C], ConvertM2Impl.InputType2[T, U]] {
                override def map(ia: B): T        = in2(ia)
                override def reverseMap(ib: T): B = in5(ib)
                override def nextMapper: SimpleProductXImpl.NotHList.Mapper[ConvertM1Impl.InputType1[C], ConvertM1Impl.InputType1[U]] =
                  new SimpleProductXImpl.NotHList.Mapper[ConvertM1Impl.InputType1[C], ConvertM1Impl.InputType1[U]] {
                    override def map(ia: C): U        = in3(ia)
                    override def reverseMap(ib: U): C = in6(ib)
                    override def nextMapper: SimpleProductXImpl.NotHList.Mapper[
                      SimpleProductXImpl.NotHList.UnitInputType,
                      SimpleProductXImpl.NotHList.UnitInputType
                    ] =
                      SimpleProductXImpl.NotHList.Mapper.unitInputType
                  }
              }
          }
        )
      override def zero: M2[Unit, Unit, Unit] = append.zero
    }

    object Appender {
      def to3[F[_[_]]](append: SimpleProductXImpl.NotHList.Appender[F]): SimpleProduct3.Appender[F] = new SimpleProduct3.Appender[F] {
        override def toHList[M3[_, _, _], M1[_], M2[_], M4[_]](
          monad: SimpleProduct3.AppendMonad[M3]
        )(func: SimpleProduct3.TypeGen[M3, M1, M2, M4]): M3[F[M1], F[M2], F[M4]] = {
          val appendMonad: SimpleProductXImpl.NotHList.AppendMonad[
            ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
          ] =
            AppendMonad.from2[M3](monad)

          val typeGen: SimpleProductXImpl.NotHList.TypeGen[
            ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
            M3FType[M1, M2, M4]
          ] =
            TypeGen.from2[M3, M1, M2, M4](func)

          append.toHList[
            ({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
            M3FType[M1, M2, M4]
          ](appendMonad)(typeGen)
        }
      }
    }

  }
}
