package net.scalax.simple.codec
package to_list_generic

object ConvertM2 {
  trait M2FType[M1[_], M2[_]] extends SimpleProduct3.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM1.M1FType[M2]
  }

  trait InputType2[T1, T2] extends SimpleProduct3.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = ConvertM1.InputType1[T2]
  }

  object TypeGen {
    def from2[M2[_, _], M1[_], M3[_]](
      typeGen: SimpleProduct2.TypeGen[M2, M1, M3]
    ): SimpleProduct3.NotHList.TypeGen[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA, M2FType[
      M1,
      M3
    ]] =
      new SimpleProduct3.NotHList.TypeGen[
        ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA,
        M2FType[M1, M3]
      ] {
        override def apply[T]: M2[M1[T], M3[T]] = typeGen[T]
      }

    def to2[M2[_, _], M1[_], M3[_]](
      typeGen: SimpleProduct3.NotHList.TypeGen[
        ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA,
        M2FType[M1, M3]
      ]
    ): SimpleProduct2.TypeGen[M2, M1, M3] = new SimpleProduct2.TypeGen[M2, M1, M3] {
      override def apply[T]: M2[M1[T], M3[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _]](
      append: SimpleProduct2.AppendMonad[M2]
    ): SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA] =
      new SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA] {
        override def zip[A <: SimpleProduct3.NotHList.InputType, B <: SimpleProduct3.NotHList.InputType](
          ma: M2[A#toItem, A#AndThen#toItem],
          ms: M2[B#toItem, B#AndThen#toItem]
        ): M2[(A#toItem, B#toItem), (A#AndThen#toItem, B#AndThen#toItem)] = append.zip(ma, ms)

        override def to[A <: SimpleProduct3.NotHList.InputType, B <: SimpleProduct3.NotHList.InputType](m1: M2[A#toItem, A#AndThen#toItem])(
          in1: SimpleProduct3.NotHList.Mapper[A, B]
        ): M2[B#toItem, B#AndThen#toItem] =
          append.to[A#toItem, A#AndThen#toItem, B#toItem, B#AndThen#toItem](m1)(in1 = in1.map, in2 = in1.nextMapper.map)(
            in3 = in1.reverseMap,
            in4 = in1.nextMapper.reverseMap
          )

        override def zero: M2[Unit, Unit] = append.zero
      }

    def to2[M2[_, _]](
      append: SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA]
    ): SimpleProduct2.AppendMonad[M2] =
      new SimpleProduct2.AppendMonad[M2] {
        override def zip[A, B, S, T](ma: M2[A, B], ms: M2[S, T]): M2[(A, S), (B, T)] =
          append.zip[InputType2[A, B], InputType2[S, T]](ma, ms)
        override def to[A, B, S, T](m1: M2[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M2[S, T] =
          append.to[InputType2[A, B], InputType2[S, T]](m1)(new SimpleProduct3.NotHList.Mapper[InputType2[A, B], InputType2[S, T]] {
            override def map(ia: A): S        = in1(ia)
            override def reverseMap(ib: S): A = in3(ib)
            override def nextMapper: SimpleProduct3.NotHList.Mapper[ConvertM1.InputType1[B], ConvertM1.InputType1[T]] =
              new SimpleProduct3.NotHList.Mapper[ConvertM1.InputType1[B], ConvertM1.InputType1[T]] {
                override def map(ia: B): T        = in2(ia)
                override def reverseMap(ib: T): B = in4(ib)
                override def nextMapper
                  : SimpleProduct3.NotHList.Mapper[SimpleProduct3.NotHList.UnitInputType, SimpleProduct3.NotHList.UnitInputType] =
                  SimpleProduct3.NotHList.Mapper.unitInputType
              }
          })
        override def zero: M2[Unit, Unit] = append.zero
      }

    object Appender {
      def to2[F[_[_]]](append: SimpleProduct3.NotHList.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
        override def toHList[M3[_, _], M1[_], M2[_]](monad: SimpleProduct2.AppendMonad[M3])(
          func: SimpleProduct2.TypeGen[M3, M1, M2]
        ): M3[F[M1], F[M2]] = {
          val appendMonad: SimpleProduct3.NotHList.AppendMonad[
            ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA
          ] =
            AppendMonad.from2[M3](monad)

          val typeGen: SimpleProduct3.NotHList.TypeGen[
            ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA,
            M2FType[M1, M2]
          ] =
            TypeGen.from2[M3, M1, M2](func)

          append.toHList[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA, M2FType[M1, M2]](
            appendMonad
          )(typeGen)
        }
      }
    }

  }
}
