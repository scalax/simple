package net.scalax.simple.codec
package to_list_generic

object ConvertM1Impl {
  trait M1FType[M1[_]] extends SimpleProductXImpl.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = SimpleProductXImpl.NotHList.IdentityFType
  }

  trait InputType1[T1] extends SimpleProductXImpl.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = SimpleProductXImpl.NotHList.UnitInputType
  }

  object TypeGen {
    def from1[M2[_], M1[_]](
      typeGen: SimpleProduct1.TypeGen[M2, M1]
    ): SimpleProductXImpl.NotHList.TypeGen[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]] =
      new SimpleProductXImpl.NotHList.TypeGen[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem] })#TA, M1FType[M1]] {
        override def apply[T]: M2[M1[T]] = typeGen[T]
      }
  }

  object AppendMonad {

    def from1[M2[_]](
      append: SimpleProduct1.AppendMonad[M2]
    ): SimpleProductXImpl.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem] })#TA] =
      new SimpleProductXImpl.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M2[U#toItem] })#TA] {
        override def zip[A <: SimpleProductXImpl.NotHList.InputType, B <: SimpleProductXImpl.NotHList.InputType](
          ma: M2[A#toItem],
          ms: M2[B#toItem]
        ): M2[(A#toItem, B#toItem)] = append.zip(ma, ms)

        override def to[A <: SimpleProductXImpl.NotHList.InputType, B <: SimpleProductXImpl.NotHList.InputType](m1: M2[A#toItem])(
          in1: SimpleProductXImpl.NotHList.Mapper[A, B]
        ): M2[B#toItem] =
          append.to[A#toItem, B#toItem](m1)(in1 = in1.map)(out1 = in1.reverseMap)

        override def zero: M2[SimpleZero] = append.zero
      }

    def from2[M2[_]](
      append: SimpleProductF1.AppendMonad[M2]
    ): SimpleProductXImpl2.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem] })#TA] =
      new SimpleProductXImpl2.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem] })#TA] {
        override def zip[
          A <: SimpleProductXImpl2.NotHList.InputType,
          B <: SimpleProductXImpl2.NotHList.InputType,
          C <: SimpleProductXImpl2.NotHList.InputType
        ](
          fromtTo: SimpleProductXImpl2.NotHList.ConvertF[A, B, C],
          ma: M2[A#toItem],
          mb: M2[B#toItem]
        ): M2[C#toItem] = append.zip(
          new SimpleProductF1.ConvertF1[A#toItem, B#toItem, C#toItem] {
            override def from1(a: A#toItem, b: B#toItem): C#toItem = fromtTo.from(a, b)
            override def takeHead1(modelC: C#toItem): A#toItem     = fromtTo.takeHead(modelC)
            override def takeHead2(modelC: C#toItem): B#toItem     = fromtTo.takeTail(modelC)
          },
          ma,
          mb
        )

        override def zero[N <: SimpleProductXImpl2.NotHList.InputType]: M2[N#toItem] = append.zero[N#toItem]
      }

  }

  object Appender {
    def to1[F[_[_]]](append: SimpleProductXImpl.NotHList.Appender[F]): SimpleProduct1.Appender[F] = new SimpleProduct1.Appender[F] {
      override def toHList1[M3[_], M2[_]](monad: SimpleProduct1.AppendMonad[M3])(
        func: SimpleProduct1.TypeGen[M3, M2]
      ): M3[F[M2]] = {
        val appendMonad
          : SimpleProductXImpl.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem] })#TA] =
          AppendMonad.from1[M3](monad)

        val typeGen
          : SimpleProductXImpl.NotHList.TypeGen[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem] })#TA, M1FType[M2]] =
          TypeGen.from1[M3, M2](func)

        append.toHList[({ type TA[U <: SimpleProductXImpl.NotHList.InputType] = M3[U#toItem] })#TA, M1FType[M2]](appendMonad)(typeGen)
      }
    }
  }
}
