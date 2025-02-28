package net.scalax.simple.codec
package to_list_generic
import net.scalax.simple.codec

object ConvertM1Impl {

  trait M1FType2[M1[_]] extends SimpleProductXImpl2.NotHList.FType {
    override type toF[T] = M1[T]
    override type Next   = SimpleProductXImpl2.NotHList.IdentityFType
  }

  object TypeGen {
    def from2[M2[_], M1[_]](
      typeGen: SimpleProduct1.TypeGen[M2, M1]
    ): SimpleProductXImpl2.NotHList.TypeGen[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem] })#TA, M1FType2[M1]] =
      new SimpleProductXImpl2.NotHList.TypeGen[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem] })#TA, M1FType2[M1]] {
        override def apply[T]: M2[M1[T]] = typeGen[T]
      }
  }

  object AppendMonad {
    def from1[M2[_]](
      append: SimpleProduct1.AppendMonad[M2]
    ): SimpleProductXImpl2.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem] })#TA] =
      new SimpleProductXImpl2.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M2[U#toItem] })#TA] {
        override def zip[
          A <: SimpleProductXImpl2.NotHList.InputType,
          B <: SimpleProductXImpl2.NotHList.InputType,
          C <: SimpleProductXImpl2.NotHList.InputType
        ](
          fromTo: SimpleProductXImpl2.NotHList.ConvertF[A, B, C],
          ma: M2[A#toItem],
          mb: M2[B#toItem]
        ): M2[C#toItem] = append.zip(
          new SimpleProduct1.ConvertF1[A#toItem, B#toItem, C#toItem] {
            override def from1(a: A#toItem, b: B#toItem): C#toItem = fromTo.from(a, b)
            override def takeHead1(modelC: C#toItem): A#toItem     = fromTo.takeHead(modelC)
            override def takeTail1(modelC: C#toItem): B#toItem     = fromTo.takeTail(modelC)
          },
          ma,
          mb
        )

        override def zero[N <: codec.to_list_generic.SimpleProductXImpl2.NotHList.InputType](
          i: codec.to_list_generic.SimpleProductXImpl2.NotHList.InputInstance[N]
        ): M2[N#toItem] = append.zero(i.item)
      }
  }

  object Appender {
    def to1[F[_[_]]](append: SimpleProductXImpl2.NotHList.Appender[F]): SimpleProduct1.Appender[F] = new SimpleProduct1.Appender[F] {
      override def toHList1[M3[_], M2[_]](monad: SimpleProduct1.AppendMonad[M3])(
        func: SimpleProduct1.TypeGen[M3, M2]
      ): M3[F[M2]] = {
        val appendMonad
          : SimpleProductXImpl2.NotHList.AppendMonad[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem] })#TA] =
          AppendMonad.from1[M3](monad)

        val typeGen
          : SimpleProductXImpl2.NotHList.TypeGen[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem] })#TA, M1FType2[
            M2
          ]] =
          TypeGen.from2[M3, M2](func)

        append.toHList[({ type TA[U <: SimpleProductXImpl2.NotHList.InputType] = M3[U#toItem] })#TA, M1FType2[M2]](appendMonad)(typeGen)
      }
    }
  }

}
