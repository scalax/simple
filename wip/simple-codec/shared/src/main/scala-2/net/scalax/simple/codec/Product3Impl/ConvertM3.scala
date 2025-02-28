package net.scalax.simple.codec
package to_list_generic
import net.scalax.simple.codec

object ConvertM3Impl {
  trait M3FType2[M1[_], M2[_], M3[_]] extends SimpleProductXImpl2.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = ConvertM2Impl.M2FType2[M2, M3]
  }

  object TypeGen {
    def from2[M2[_, _, _], M1[_], M3[_], M4[_]](
      typeGen: SimpleProduct3.TypeGen[M2, M1, M3, M4]
    ): SimpleProductXImpl2.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
      M3FType2[M1, M3, M4]
    ] = new SimpleProductXImpl2.NotHList.TypeGen[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
      M3FType2[M1, M3, M4]
    ] {
      override def apply[T]: M2[M1[T], M3[T], M4[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _, _]](
      append: SimpleProduct3.AppendMonad[M2]
    ): SimpleProductXImpl2.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
    ] = new SimpleProductXImpl2.NotHList.AppendMonad[
      ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
    ] {
      override def zip[
        A <: SimpleProductXImpl2.NotHList.InputType,
        B <: SimpleProductXImpl2.NotHList.InputType,
        C <: SimpleProductXImpl2.NotHList.InputType
      ](
        fromTo: SimpleProductXImpl2.NotHList.ConvertF[A, B, C],
        ma: M2[A#toItem, A#AndThen#toItem, A#AndThen#AndThen#toItem],
        mb: M2[B#toItem, B#AndThen#toItem, B#AndThen#AndThen#toItem]
      ): M2[C#toItem, C#AndThen#toItem, C#AndThen#AndThen#toItem] =
        append.zip(
          new SimpleProduct3.ConvertF3[
            A#toItem,
            B#toItem,
            C#toItem,
            A#AndThen#toItem,
            B#AndThen#toItem,
            C#AndThen#toItem,
            A#AndThen#AndThen#toItem,
            B#AndThen#AndThen#toItem,
            C#AndThen#AndThen#toItem
          ] {
            override def from1(a: A#toItem, b: B#toItem): C#toItem                         = fromTo.from(a, b)
            override def takeHead1(c: C#toItem): A#toItem                                  = fromTo.takeHead(c)
            override def takeTail1(c: C#toItem): B#toItem                                  = fromTo.takeTail(c)
            override def from2(a: A#AndThen#toItem, b: B#AndThen#toItem): C#AndThen#toItem = fromTo.next.from(a, b)
            override def takeHead2(c: C#AndThen#toItem): A#AndThen#toItem                  = fromTo.next.takeHead(c)
            override def takeTail2(c: C#AndThen#toItem): B#AndThen#toItem                  = fromTo.next.takeTail(c)
            override def from3(a: A#AndThen#AndThen#toItem, b: B#AndThen#AndThen#toItem): C#AndThen#AndThen#toItem =
              fromTo.next.next.from(a, b)
            override def takeHead3(c: C#AndThen#AndThen#toItem): A#AndThen#AndThen#toItem = fromTo.next.next.takeHead(c)
            override def takeTail3(c: C#AndThen#AndThen#toItem): B#AndThen#AndThen#toItem = fromTo.next.next.takeTail(c)
          },
          ma,
          mb
        )

      override def zero[N <: codec.to_list_generic.SimpleProductXImpl2.NotHList.InputType](
        i: codec.to_list_generic.SimpleProductXImpl2.NotHList.InputInstance[N]
      ): M2[N#toItem, N#AndThen#toItem, N#AndThen#AndThen#toItem] = append.zero(i.item, i.andThen.item, i.andThen.andThen.item)
    }
  }

  object Appender {
    def to3[F[_[_]]](append: SimpleProductXImpl2.NotHList.Appender[F]): SimpleProduct3.Appender[F] = new SimpleProduct3.Appender[F] {
      override def toHList1[M3[_, _, _], M1[_], M2[_], M4[_]](monad: SimpleProduct3.AppendMonad[M3])(
        func: SimpleProduct3.TypeGen[M3, M1, M2, M4]
      ): M3[F[M1], F[M2], F[M4]] = {
        val appendMonad: SimpleProductXImpl2.NotHList.AppendMonad[
          ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA
        ] =
          AppendMonad.from2[M3](monad)

        val typeGen: SimpleProductXImpl2.NotHList.TypeGen[
          ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
          M3FType2[M1, M2, M4]
        ] =
          TypeGen.from2[M3, M1, M2, M4](func)

        append.toHList[
          ({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem, U#AndThen#toItem, U#AndThen#AndThen#toItem] })#TA,
          M3FType2[M1, M2, M4]
        ](appendMonad)(typeGen)
      }

    }
  }

}
