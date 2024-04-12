package net.scalax.simple.codec
package to_list_generic

import shapeless._
import utils._

trait ToDecoderGeneric2222[F[_[_]]] {
  def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: MonadAdd[M1])(
    func: ToDecoderGeneric2222.FuncImpl[M1, M2, M3, M4]
  ): M1[F[M2], F[M3], F[M4]]
}

object ToDecoderGeneric2222 {

  type IdImpl[T] = T

  trait FuncImpl[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

  trait HListFuncMapGeneric[Source1, Target1, Target2, Target3, M1[_, _, _], M2[_], M3[_], M4[_]] {
    def output(monad: MonadAdd[M1])(func: FuncImpl[M1, M2, M3, M4]): M1[Target1, Target2, Target3]
  }
  object HListFuncMapGeneric {
    private val appender: HListUtils[HList, ({ type Ad[Head, TU <: HList] = Head :: TU })#Ad, HNil] =
      new HListUtils[HList, ({ type Ad[Head, TU <: HList] = Head :: TU })#Ad, HNil] {
        override def appendData[Head, Tail <: HList](h: Head, t: Tail): Head :: Tail = h :: t
        override def takeHead[Head, Tail <: HList](dataList: Head :: Tail): Head     = dataList.head
        override def takeTail[Head, Tail <: HList](dataList: Head :: Tail): Tail     = dataList.tail
        override val takeZero: HNil                                                  = HNil
      }

    implicit def implicit1[T1, Source1 <: HList, HL1 <: HList, HL2 <: HList, HL3 <: HList, M1[_, _, _], M2[_], M3[_], M4[_]](implicit
      tail: HListFuncMapGeneric[Source1, HL1, HL2, HL3, M1, M2, M3, M4]
    ): HListFuncMapGeneric[T1 :: Source1, M2[T1] :: HL1, M3[T1] :: HL2, M4[T1] :: HL3, M1, M2, M3, M4] = appender.append(tail)

    implicit def implicit2[M1[_, _, _], M2[_], M3[_], M4[_]]: HListFuncMapGeneric[HNil, HNil, HNil, HNil, M1, M2, M3, M4] = appender.zero
  }

  trait HListFuncMapGenericGen[Source1, M1[_, _, _], M2[_], M3[_], M4[_]] {
    def generic[Target1, Target2, Target3](implicit
      i: HListFuncMapGeneric[Source1, Target1, Target2, Target3, M1, M2, M3, M4]
    ): HListFuncMapGeneric[Source1, Target1, Target2, Target3, M1, M2, M3, M4] = i
  }
  object HListFuncMapGenericGen {
    def apply[Source1, M1[_, _, _], M2[_], M3[_], M4[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3, M4] =
      new HListFuncMapGenericGen[Source1, M1, M2, M3, M4] {
        //
      }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_, _, _], M2[_], M3[_], M4[_]] {
    self =>
    def derived2[Source1, Target1, Target2, Target3](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric2: SimpleFrom[F[M2], Target1] with SimpleTo[F[M2], Target1],
      simpleGeneric3: SimpleFrom[F[M3], Target2] with SimpleTo[F[M3], Target2],
      simpleGeneric4: SimpleFrom[F[M4], Target3] with SimpleTo[F[M4], Target3]
    ): FuncInnerApply1[F, M1, M2, M3, M4, Source1, Target1, Target2, Target3] =
      new FuncInnerApply1[F, M1, M2, M3, M4, Source1, Target1, Target2, Target3](simpleTo1, simpleGeneric2, simpleGeneric3, simpleGeneric4)
  }

  class FuncInnerApply1[F[_[_]], M1[_, _, _], M2[_], M3[_], M4[_], Source1, Target1, Target2, Target3](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleGeneric2: SimpleFrom[F[M2], Target1] with SimpleTo[F[M2], Target1],
    simpleGeneric3: SimpleFrom[F[M3], Target2] with SimpleTo[F[M3], Target2],
    simpleGeneric4: SimpleFrom[F[M4], Target3] with SimpleTo[F[M4], Target3]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3, M4] => HListFuncMapGeneric[
        Source1,
        Target1,
        Target2,
        Target3,
        M1,
        M2,
        M3,
        M4
      ]
    ): MonadAdd[M1] => FuncImpl[M1, M2, M3, M4] => M1[F[M2], F[M3], F[M4]] = { monad => func =>
      monad.to(genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3, M4]).output(monad)(func))(
        simpleGeneric2.from,
        simpleGeneric3.from,
        simpleGeneric4.from
      )(simpleGeneric2.to, simpleGeneric3.to, simpleGeneric4.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric2222[F] {
    def impl[M1[_, _, _], M2[_], M3[_], M4[_]]
      : SimpleFuncion1Impl[F, M1, M2, M3, M4] => (MonadAdd[M1] => FuncImpl[M1, M2, M3, M4] => M1[F[M2], F[M3], F[M4]])
    override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: MonadAdd[M1])(func: FuncImpl[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]] =
      impl[M1, M2, M3, M4](new SimpleFuncion1Impl[F, M1, M2, M3, M4])(monad)(func)
  }
}
