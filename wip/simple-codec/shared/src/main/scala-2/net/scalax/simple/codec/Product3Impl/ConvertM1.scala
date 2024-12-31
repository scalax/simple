package net.scalax.simple.codec
package to_list_generic

object ConvertM1 {
  trait M1FType[M1[_]] extends SimpleProduct3.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = SimpleProduct3.NotHList.IdentityFType
  }

  trait InputType1[T1] extends SimpleProduct3.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = SimpleProduct3.NotHList.UnitInputType
  }

  type M1InputType[M1[_], T <: SimpleProduct3.NotHList.InputType] = M1[T#toItem]

  object TypeGen {
    def from1[M2[_], M1[_]](
      typeGen: SimpleProduct1.TypeGen[M2, M1]
    ): SimpleProduct3.NotHList.TypeGen[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]] =
      new SimpleProduct3.NotHList.TypeGen[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]] {
        override def apply[T]: M2[M1[T]] = typeGen[T]
      }

    def to1[M2[_], M1[_]](
      typeGen: SimpleProduct3.NotHList.TypeGen[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]]
    ): SimpleProduct1.TypeGen[M2, M1] = new SimpleProduct1.TypeGen[M2, M1] {
      override def apply[T]: M2[M1[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from1[M2[_]](
      append: SimpleProduct1.AppendMonad[M2]
    ): SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem] })#TA] =
      new SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem] })#TA] {
        override def zip[A <: SimpleProduct3.NotHList.InputType, B <: SimpleProduct3.NotHList.InputType](
          ma: M2[A#toItem],
          ms: M2[B#toItem]
        ): M2[(A#toItem, B#toItem)] = append.zip(ma, ms)

        override def to[A <: SimpleProduct3.NotHList.InputType, B <: SimpleProduct3.NotHList.InputType](m1: M2[A#toItem])(
          in1: SimpleProduct3.NotHList.Mapper[A, B]
        ): M2[B#toItem] =
          append.to[A#toItem, B#toItem](m1)(in1 = in1.map)(out1 = in1.reverseMap)

        override def zero: M2[Unit] = append.zero
      }

    def to1[M2[_]](
      append: SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem] })#TA]
    ): SimpleProduct1.AppendMonad[M2] =
      new SimpleProduct1.AppendMonad[M2] {
        override def zip[A, S](ma: M2[A], ms: M2[S]): M2[(A, S)] = append.zip[InputType1[A], InputType1[S]](ma, ms)
        override def to[A, S](m1: M2[A])(in1: A => S)(in3: S => A): M2[S] =
          append.to[InputType1[A], InputType1[S]](m1)(new SimpleProduct3.NotHList.Mapper[InputType1[A], InputType1[S]] {
            override def map(ia: A): S        = in1(ia)
            override def reverseMap(ib: S): A = in3(ib)
            override def nextMapper
              : SimpleProduct3.NotHList.Mapper[SimpleProduct3.NotHList.UnitInputType, SimpleProduct3.NotHList.UnitInputType] =
              SimpleProduct3.NotHList.Mapper.unitInputType
          })
        override def zero: M2[Unit] = append.zero
      }

  }

  object Appender {
    def to1[F[_[_]]](append: SimpleProduct3.NotHList.Appender[F]): SimpleProduct1.Appender[F] = new SimpleProduct1.Appender[F] {
      override def toHList1[M3[_], M2[_]](monad: SimpleProduct1.AppendMonad[M3])(
        func: SimpleProduct1.TypeGen[M3, M2]
      ): M3[F[M2]] = {
        val appendMonad: SimpleProduct3.NotHList.AppendMonad[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem] })#TA] =
          AppendMonad.from1[M3](monad)

        val typeGen: SimpleProduct3.NotHList.TypeGen[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem] })#TA, M1FType[M2]] =
          TypeGen.from1[M3, M2](func)

        append.toHList[({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem] })#TA, M1FType[M2]](appendMonad)(typeGen)
      }
    }
  }
}
