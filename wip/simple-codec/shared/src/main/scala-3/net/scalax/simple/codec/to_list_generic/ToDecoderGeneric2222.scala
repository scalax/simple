package net.scalax.simple.codec
package to_list_generic

import utils._

object SimpleProduct {

  trait AppendMonad[M[_, _, _]] {
    def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[(A, S), (B, T), (C, U)]
    def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
    def zero: M[Unit, Unit, Unit]
  }

  trait TypeGen[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(
      func: TypeGen[M1, M2, M3, M4]
    ): M1[F[M2], F[M3], F[M4]]
  }

  object Appender {
    type IdImpl[X] = X

    type MatchTuple1[T, M1[_]] <: Tuple = T match {
      case h *: tail  => M1[h] *: MatchTuple1[tail, M1]
      case EmptyTuple => EmptyTuple
    }

    trait HListFuncMapGeneric[Source1, Target1, Target2, Target3, M1[_, _, _], M2[_], M3[_], M4[_]] {
      def size: Int

      def output(monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[Target1, Target2, Target3]
    }
    object HListFuncMapGeneric {
      val appender: HListUtils[Tuple, ({ type Ad[Head, TU <: Tuple] = Head *: TU })#Ad, EmptyTuple] =
        new HListUtils[Tuple, ({ type Ad[Head, TU <: Tuple] = Head *: TU })#Ad, EmptyTuple] {
          override def appendData[Head, Tail <: Tuple](h: Head, t: Tail): Head *: Tail = h *: t
          override def takeHead[Head, Tail <: Tuple](dataList: Head *: Tail): Head     = dataList.head
          override def takeTail[Head, Tail <: Tuple](dataList: Head *: Tail): Tail     = dataList.tail
          override val takeZero: EmptyTuple                                            = EmptyTuple
        }

      def instance[Source1 <: Tuple, M1[_, _, _], M2[_], M3[_], M4[_]](using
        v: ValueOf[Tuple.Size[Source1]]
      ): HListFuncMapGeneric[Source1, MatchTuple1[Source1, M2], MatchTuple1[Source1, M3], MatchTuple1[Source1, M4], M1, M2, M3, M4] =
        HListUtilsImpl
          .get(v.value)
          .asInstanceOf[HListFuncMapGeneric[
            Source1,
            MatchTuple1[Source1, M2],
            MatchTuple1[Source1, M3],
            MatchTuple1[Source1, M4],
            M1,
            M2,
            M3,
            M4
          ]]

    }

    trait HListFuncMapGenericGen[Source1 <: Tuple, M1[_, _, _], M2[_], M3[_], M4[_]] {
      def generic(using
        ValueOf[Tuple.Size[Source1]]
      ): HListFuncMapGeneric[Source1, MatchTuple1[Source1, M2], MatchTuple1[Source1, M3], MatchTuple1[Source1, M4], M1, M2, M3, M4] =
        HListFuncMapGeneric.instance[Source1, M1, M2, M3, M4]
    }
    object HListFuncMapGenericGen {
      def apply[Source1 <: Tuple, M1[_, _, _], M2[_], M3[_], M4[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3, M4] =
        new HListFuncMapGenericGen[Source1, M1, M2, M3, M4] {
          //
        }
    }

    // ===
    class SimpleFuncion1Impl[F[_[_]], M1[_, _, _], M2[_], M3[_], M4[_]] {
      self =>
      def derived2[Source1 <: Tuple](
        simpleTo1: SimpleTo[F[IdImpl], Source1],
        simpleGeneric2: SimpleFrom[F[M2], MatchTuple1[Source1, M2]] with SimpleTo[F[M2], MatchTuple1[Source1, M2]],
        simpleGeneric3: SimpleFrom[F[M3], MatchTuple1[Source1, M3]] with SimpleTo[F[M3], MatchTuple1[Source1, M3]],
        simpleGeneric4: SimpleFrom[F[M4], MatchTuple1[Source1, M4]] with SimpleTo[F[M4], MatchTuple1[Source1, M4]]
      ): FuncInnerApply1[F, M1, M2, M3, M4, Source1] =
        new FuncInnerApply1[F, M1, M2, M3, M4, Source1](
          simpleTo1,
          simpleGeneric2,
          simpleGeneric3,
          simpleGeneric4
        )
    }

    class FuncInnerApply1[F[_[_]], M1[_, _, _], M2[_], M3[_], M4[_], Source1 <: Tuple](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric2: SimpleFrom[F[M2], MatchTuple1[Source1, M2]] with SimpleTo[F[M2], MatchTuple1[Source1, M2]],
      simpleGeneric3: SimpleFrom[F[M3], MatchTuple1[Source1, M3]] with SimpleTo[F[M3], MatchTuple1[Source1, M3]],
      simpleGeneric4: SimpleFrom[F[M4], MatchTuple1[Source1, M4]] with SimpleTo[F[M4], MatchTuple1[Source1, M4]]
    ) {
      def apply(
        genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3, M4] => HListFuncMapGeneric[
          Source1,
          MatchTuple1[Source1, M2],
          MatchTuple1[Source1, M3],
          MatchTuple1[Source1, M4],
          M1,
          M2,
          M3,
          M4
        ]
      ): AppendMonad[M1] => TypeGen[M1, M2, M3, M4] => M1[F[M2], F[M3], F[M4]] = { monad => func =>
        monad.to(genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3, M4]).output(monad)(func))(
          simpleGeneric2.from,
          simpleGeneric3.from,
          simpleGeneric4.from
        )(simpleGeneric2.to, simpleGeneric3.to, simpleGeneric4.to)
      }
    }

    trait Impl[F[_[_]]] extends Appender[F] {
      def impl[M1[_, _, _], M2[_], M3[_], M4[_]]
        : SimpleFuncion1Impl[F, M1, M2, M3, M4] => (AppendMonad[M1] => TypeGen[M1, M2, M3, M4] => M1[F[M2], F[M3], F[M4]])
      override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(
        func: TypeGen[M1, M2, M3, M4]
      ): M1[F[M2], F[M3], F[M4]] =
        impl[M1, M2, M3, M4](new SimpleFuncion1Impl[F, M1, M2, M3, M4])(monad)(func)
    }
  }

}
