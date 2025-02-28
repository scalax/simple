package net.scalax.simple.codec
package to_list_generic
import net.scalax.simple.codec

object ConvertM2Impl {

  trait M2FType2[M1[_], M2[_]] extends SimpleProductXImpl2.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM1Impl.M1FType2[M2]
  }

  object TypeGen {
    def from2[M2[_, _], M1[_], M3[_]](
      typeGen: SimpleProduct2.TypeGen[M2, M1, M3]
    ): SimpleProductXImpl2.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA,
      M2FType2[M1, M3]
    ] = new SimpleProductXImpl2.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA,
      M2FType2[M1, M3]
    ] {
      override def apply[T]: M2[M1[T], M3[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _]](append: SimpleProduct2.AppendMonad[M2]): SimpleProductXImpl2.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA
    ] = new SimpleProductXImpl2.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem] })#TA
    ] {
      override def zip[
        A <: SimpleProductXImpl2.NotHList.InputType,
        B <: SimpleProductXImpl2.NotHList.InputType,
        C <: SimpleProductXImpl2.NotHList.InputType
      ](
        fromTo: SimpleProductXImpl2.NotHList.ConvertF[A, B, C],
        ma: M2[A#toItem, A#AndThen#toItem],
        mb: M2[B#toItem, B#AndThen#toItem]
      ): M2[C#toItem, C#AndThen#toItem] = append.zip(
        new SimpleProduct2.ConvertF2[A#toItem, B#toItem, C#toItem, A#AndThen#toItem, B#AndThen#toItem, C#AndThen#toItem] {
          override def from1(a: A#toItem, b: B#toItem): C#toItem = fromTo.from(a, b)
          override def takeHead1(modelC: C#toItem): A#toItem     = fromTo.takeHead(modelC)
          override def takeTail1(modelC: C#toItem): B#toItem     = fromTo.takeTail(modelC)

          override def from2(a: A#AndThen#toItem, b: B#AndThen#toItem): C#AndThen#toItem = fromTo.next.from(a, b)
          override def takeHead2(modelC: C#AndThen#toItem): A#AndThen#toItem             = fromTo.next.takeHead(modelC)
          override def takeTail2(modelC: C#AndThen#toItem): B#AndThen#toItem             = fromTo.next.takeTail(modelC)
        },
        ma,
        mb
      )

      override def zero[N <: codec.to_list_generic.SimpleProductXImpl2.NotHList.InputType](
        i: codec.to_list_generic.SimpleProductXImpl2.NotHList.InputInstance[N]
      ): M2[N#toItem, N#AndThen#toItem] = append.zero(i.item, i.andThen.item)
    }
  }

  object Appender {
    def to2[F[_[_]]](append: SimpleProductXImpl2.NotHList.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
      override def toHList1[M3[_, _], M1[_], M2[_]](monad: SimpleProduct2.AppendMonad[M3])(
        func: SimpleProduct2.TypeGen[M3, M1, M2]
      ): M3[F[M1], F[M2]] = {
        val appendMonad: SimpleProductXImpl2.NotHList.AppendMonad[
          ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA
        ] =
          AppendMonad.from2[M3](monad)

        val typeGen: SimpleProductXImpl2.NotHList.TypeGen[
          ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA,
          M2FType2[M1, M2]
        ] =
          TypeGen.from2[M3, M1, M2](func)

        append.toHList[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem] })#TA, M2FType2[M1, M2]](
          appendMonad
        )(typeGen)
      }
    }
  }

}
