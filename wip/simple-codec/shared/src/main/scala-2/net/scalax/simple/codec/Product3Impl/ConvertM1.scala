package net.scalax.simple.codec
package to_list_generic

object ConvertM1Impl {
  trait M1FType[M1[_]] extends SimpleProductX.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = SimpleProductX.NotHList.IdentityFType
  }

  trait InputType1[T1] extends SimpleProductX.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = SimpleProductX.NotHList.UnitInputType
  }

  type M1InputType[M1[_], T <: SimpleProductX.NotHList.InputType] = M1[T#toItem]

  object TypeGen {
    def from1[M2[_], M1[_]](
      typeGen: SimpleProduct1.TypeGen[M2, M1]
    ): SimpleProductX.NotHList.TypeGen[({ type TA[U <: SimpleProductX.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]] =
      new SimpleProductX.NotHList.TypeGen[({ type TA[U <: SimpleProductX.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]] {
        override def apply[T]: M2[M1[T]] = typeGen[T]
      }

    def to1[M2[_], M1[_]](
      typeGen: SimpleProductX.NotHList.TypeGen[({ type TA[U <: SimpleProductX.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]]
    ): SimpleProduct1.TypeGen[M2, M1] = new SimpleProduct1.TypeGen[M2, M1] {
      override def apply[T]: M2[M1[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from1[M2[_]](
      append: SimpleProduct1.AppendMonad[M2]
    ): SimpleProductX.NotHList.AppendMonad[({ type TA[U <: SimpleProductX.NotHList.InputType] = M2[U#toItem] })#TA] =
      new SimpleProductX.NotHList.AppendMonad[({ type TA[U <: SimpleProductX.NotHList.InputType] = M2[U#toItem] })#TA] {
        override def zip[A <: SimpleProductX.NotHList.InputType, B <: SimpleProductX.NotHList.InputType](
          ma: M2[A#toItem],
          ms: M2[B#toItem]
        ): M2[(A#toItem, B#toItem)] = append.zip(ma, ms)

        override def to[A <: SimpleProductX.NotHList.InputType, B <: SimpleProductX.NotHList.InputType](m1: M2[A#toItem])(
          in1: SimpleProductX.NotHList.Mapper[A, B]
        ): M2[B#toItem] =
          append.to[A#toItem, B#toItem](m1)(in1 = in1.map)(out1 = in1.reverseMap)

        override def zero: M2[Unit] = append.zero
      }

    def to1[M2[_]](
      append: SimpleProductX.NotHList.AppendMonad[({ type TA[U <: SimpleProductX.NotHList.InputType] = M2[U#toItem] })#TA]
    ): SimpleProduct1.AppendMonad[M2] =
      new SimpleProduct1.AppendMonad[M2] {
        override def zip[A, S](ma: M2[A], ms: M2[S]): M2[(A, S)] = append.zip[InputType1[A], InputType1[S]](ma, ms)
        override def to[A, S](m1: M2[A])(in1: A => S)(in3: S => A): M2[S] =
          append.to[InputType1[A], InputType1[S]](m1)(new SimpleProductX.NotHList.Mapper[InputType1[A], InputType1[S]] {
            override def map(ia: A): S        = in1(ia)
            override def reverseMap(ib: S): A = in3(ib)
            override def nextMapper
              : SimpleProductX.NotHList.Mapper[SimpleProductX.NotHList.UnitInputType, SimpleProductX.NotHList.UnitInputType] =
              SimpleProductX.NotHList.Mapper.unitInputType
          })
        override def zero: M2[Unit] = append.zero
      }

  }

  object Appender {
    def to1[F[_[_]]](append: SimpleProductX.NotHList.Appender[F]): SimpleProduct1.Appender[F] = new SimpleProduct1.Appender[F] {
      override def toHList1[M3[_], M2[_]](monad: SimpleProduct1.AppendMonad[M3])(
        func: SimpleProduct1.TypeGen[M3, M2]
      ): M3[F[M2]] = {
        val appendMonad: SimpleProductX.NotHList.AppendMonad[({ type TA[U <: SimpleProductX.NotHList.InputType] = M3[U#toItem] })#TA] =
          AppendMonad.from1[M3](monad)

        val typeGen: SimpleProductX.NotHList.TypeGen[({ type TA[U <: SimpleProductX.NotHList.InputType] = M3[U#toItem] })#TA, M1FType[M2]] =
          TypeGen.from1[M3, M2](func)

        append.toHList[({ type TA[U <: SimpleProductX.NotHList.InputType] = M3[U#toItem] })#TA, M1FType[M2]](appendMonad)(typeGen)
      }
    }
  }
}
