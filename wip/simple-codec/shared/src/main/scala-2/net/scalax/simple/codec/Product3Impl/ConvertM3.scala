package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.utils.SimpleP

object ConvertM3 {
  trait M3FType[M1[_], M2[_], M3[_]] extends SimpleProduct3.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM2.M2FType[M2, M3]
  }

  trait InputType3[T1, T2, T3] extends SimpleProduct3.NotHList.InputType {
    override type toItem  = T1
    override type AndThen = ConvertM2.InputType2[T2, T3]
  }

  object TypeGen {
    def from2[M2[_, _, _], M1[_], M3[_], M4[_]](
      typeGen: SimpleP.TypeGen[M2, M1, M3, M4]
    ): SimpleProduct3.NotHList.TypeGen[
      ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
      M3FType[
        M1,
        M3,
        M4
      ]
    ] =
      new SimpleProduct3.NotHList.TypeGen[
        ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
        M3FType[M1, M3, M4]
      ] {
        override def apply[T]: M2[M1[T], M3[T], M4[T]] = typeGen[T]
      }

    def to2[M2[_, _, _], M1[_], M3[_], M4[_]](
      typeGen: SimpleProduct3.NotHList.TypeGen[
        ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
        M3FType[M1, M3, M4]
      ]
    ): SimpleP.TypeGen[M2, M1, M3, M4] = new SimpleP.TypeGen[M2, M1, M3, M4] {
      override def apply[T]: M2[M1[T], M3[T], M4[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _, _]](
      append: SimpleP.AppendMonad[M2]
    ): SimpleProduct3.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
    ] =
      new SimpleProduct3.NotHList.AppendMonad[
        ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
      ] {
        override def zip[
          A <: SimpleProduct3.NotHList.InputType,
          B <: SimpleProduct3.NotHList.InputType
        ](
          ma: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem],
          ms: M2[B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem]
        ): M2[(A#toItem, B#toItem), (A#AndThen#toItem, B#AndThen#toItem), (A#AndThen#AndThen#toItem, B#AndThen#AndThen#toItem)] =
          append.zip(ma, ms)

        override def to[A <: SimpleProduct3.NotHList.InputType, B <: SimpleProduct3.NotHList.InputType](
          m1: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem]
        )(
          in1: SimpleProduct3.NotHList.Mapper[A, B]
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
      append: SimpleProduct3.NotHList.AppendMonad[
        ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
      ]
    ): SimpleP.AppendMonad[M2] =
      new SimpleP.AppendMonad[M2] {
        override def zip[A, B, C, S, T, U](ma: M2[A, B, C], ms: M2[S, T, U]): M2[(A, S), (B, T), (C, U)] =
          append.zip[InputType3[A, B, C], InputType3[S, T, U]](ma, ms)
        override def to[A, B, C, S, T, U](
          m1: M2[A, B, C]
        )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M2[S, T, U] =
          append.to[InputType3[A, B, C], InputType3[S, T, U]](m1)(
            new SimpleProduct3.NotHList.Mapper[InputType3[A, B, C], InputType3[S, T, U]] {
              override def map(ia: A): S        = in1(ia)
              override def reverseMap(ib: S): A = in4(ib)
              override def nextMapper: SimpleProduct3.NotHList.Mapper[ConvertM2.InputType2[B, C], ConvertM2.InputType2[T, U]] =
                new SimpleProduct3.NotHList.Mapper[ConvertM2.InputType2[B, C], ConvertM2.InputType2[T, U]] {
                  override def map(ia: B): T        = in2(ia)
                  override def reverseMap(ib: T): B = in5(ib)
                  override def nextMapper: SimpleProduct3.NotHList.Mapper[ConvertM1.InputType1[C], ConvertM1.InputType1[U]] =
                    new SimpleProduct3.NotHList.Mapper[ConvertM1.InputType1[C], ConvertM1.InputType1[U]] {
                      override def map(ia: C): U        = in3(ia)
                      override def reverseMap(ib: U): C = in6(ib)
                      override def nextMapper
                        : SimpleProduct3.NotHList.Mapper[SimpleProduct3.NotHList.UnitInputType, SimpleProduct3.NotHList.UnitInputType] =
                        SimpleProduct3.NotHList.Mapper.unitInputType
                    }
                }
            }
          )
        override def zero: M2[Unit, Unit, Unit] = append.zero
      }

    object Appender {
      def to2[F[_[_]]](append: SimpleProduct3.NotHList.Appender[F]): SimpleP.Appender[F] = new SimpleP.Appender[F] {
        override def toHList[M3[_, _, _], M1[_], M2[_], M4[_]](monad: SimpleP.AppendMonad[M3])(
          func: SimpleP.TypeGen[M3, M1, M2, M4]
        ): M3[F[M1], F[M2], F[M4]] = {
          val appendMonad: SimpleProduct3.NotHList.AppendMonad[
            ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
          ] =
            AppendMonad.from2[M3](monad)

          val typeGen: SimpleProduct3.NotHList.TypeGen[
            ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
            M3FType[M1, M2, M4]
          ] =
            TypeGen.from2[M3, M1, M2, M4](func)

          append.toHList[
            ({ type TA[U <: SimpleProduct3.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
            M3FType[M1, M2, M4]
          ](appendMonad)(typeGen)
        }
      }
    }

  }
}
