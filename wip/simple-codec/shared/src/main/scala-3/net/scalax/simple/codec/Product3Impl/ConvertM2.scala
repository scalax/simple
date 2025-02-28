package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl2.NotHList
import NotHList.InputType

object ConvertM2Impl {

  type M2FType[M1[_], M2[_]] = NotHList.PositiveFType[M1, ConvertM1Impl.M1FType[M2]]

  object TypeGen {
    def from2[M2[_, _], M1[_], M3[_]](
      typeGen: SimpleProduct2.TypeGen[M2, M1, M3]
    ): NotHList.TypeGen[({ type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA, M2FType[
      M1,
      M3
    ]] = new NotHList.TypeGen[
      ({ type TA[U <: InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA,
      M2FType[M1, M3]
    ] {
      override def apply[T]: M2[M1[T], M3[T]] = typeGen[T]
    }

  }

  object AppendMonad {
    def from2[M2[_, _]](append: SimpleProduct2.AppendMonad[M2]): NotHList.AppendMonad[
      ({ type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA
    ] = new NotHList.AppendMonad[
      ({ type TA[U <: NotHList.InputType] = M2[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA
    ] {
      override def zip[A <: InputType, B <: InputType, C <: InputType](
        fromTo: NotHList.ConvertF[A, B, C],
        ma: M2[InputType.TakeHead[A], InputType.TakeHead[InputType.TakeTail[A]]],
        mb: M2[InputType.TakeHead[B], InputType.TakeHead[InputType.TakeTail[B]]]
      ): M2[InputType.TakeHead[C], InputType.TakeHead[InputType.TakeTail[C]]] = {
        val c1: SimpleProduct2.ConvertF2[
          InputType.TakeHead[A],
          InputType.TakeHead[B],
          InputType.TakeHead[C],
          InputType.TakeHead[InputType.TakeTail[A]],
          InputType.TakeHead[InputType.TakeTail[B]],
          InputType.TakeHead[InputType.TakeTail[C]]
        ] =
          new SimpleProduct2.ConvertF2[
            InputType.TakeHead[A],
            InputType.TakeHead[B],
            InputType.TakeHead[C],
            InputType.TakeHead[InputType.TakeTail[A]],
            InputType.TakeHead[InputType.TakeTail[B]],
            InputType.TakeHead[InputType.TakeTail[C]]
          ] {
            override def from1(a: InputType.TakeHead[A], b: InputType.TakeHead[B]): InputType.TakeHead[C] = fromTo.from(a, b)
            override def takeHead1(modelC: InputType.TakeHead[C]): InputType.TakeHead[A]                  = fromTo.takeHead(modelC)
            override def takeTail1(modelC: InputType.TakeHead[C]): InputType.TakeHead[B]                  = fromTo.takeTail(modelC)

            override def from2(
              a: InputType.TakeHead[InputType.TakeTail[A]],
              b: InputType.TakeHead[InputType.TakeTail[B]]
            ): InputType.TakeHead[InputType.TakeTail[C]] = fromTo.next.from(a, b)
            override def takeHead2(modelC: InputType.TakeHead[InputType.TakeTail[C]]): InputType.TakeHead[InputType.TakeTail[A]] =
              fromTo.next.takeHead(modelC)
            override def takeTail2(modelC: InputType.TakeHead[InputType.TakeTail[C]]): InputType.TakeHead[InputType.TakeTail[B]] =
              fromTo.next.takeTail(modelC)
          }

        append.zip(c1, ma, mb)
      }

      override def zero[N1 <: InputType](
        n: NotHList.InputInstance[N1]
      ): M2[InputType.TakeHead[N1], InputType.TakeHead[InputType.TakeTail[N1]]] = append.zero(n.item, n.andThen.item)
    }
  }

  object Appender {
    def to2[F[_[_]]](append: SimpleProductXImpl2.NotHList.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
      override def toHList1[M3[_, _], M1[_], M2[_]](monad: SimpleProduct2.AppendMonad[M3])(
        func: SimpleProduct2.TypeGen[M3, M1, M2]
      ): M3[F[M1], F[M2]] = {
        val appendMonad
          : NotHList.AppendMonad[({ type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA] =
          AppendMonad.from2[M3](monad)

        val typeGen: NotHList.TypeGen[
          ({ type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA,
          M2FType[M1, M2]
        ] = TypeGen.from2[M3, M1, M2](func)

        append.toHList[({ type TA[U <: InputType] = M3[InputType.TakeHead[U], InputType.TakeHead[InputType.TakeTail[U]]] })#TA, M2FType[
          M1,
          M2
        ]](appendMonad)(typeGen)
      }
    }
  }

}
