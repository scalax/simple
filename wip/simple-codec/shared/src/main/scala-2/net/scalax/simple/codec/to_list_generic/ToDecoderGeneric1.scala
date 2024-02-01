package net.scalax.simple.codec
package to_list_generic

import shapeless._

trait ToDecoderGeneric1[F[_[_]]] {
  def toHList1[M1[_], M2[_]](monad: MonadAdd1[M2])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M2[F[M1]]
}

object ToDecoderGeneric1 {

  type IdImpl[T] = T

  trait FuncImpl1[M1[_], M2[_]] {
    def apply[T]: M2[M1[T]]
  }

  trait HListFuncMapGenericX[Source1, Target1, M1[_], M2[_]] {
    def output(monad: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[Target1]
  }
  object HListFuncMapGenericX {
    implicit def implicit1[T1, Source1 <: HList, HL1 <: HList, M1[_], M2[_]](implicit
      tail: HListFuncMapGenericX[Source1, HL1, M1, M2]
    ): HListFuncMapGenericX[T1 :: Source1, M1[T1] :: HL1, M1, M2] = new HListFuncMapGenericX[T1 :: Source1, M1[T1] :: HL1, M1, M2] {
      override def output(o: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[M1[T1] :: HL1] = {
        val tailM1: M2[HL1]         = tail.output(o)(func)
        val headM1: M2[M1[T1]]      = func[T1]
        val zipM: M2[(HL1, M1[T1])] = o.zip(tailM1, headM1)

        o.to(zipM)(
          in1 = t => t._2 :: t._1
        )(
          out1 = t => (t.tail, t.head)
        )
      }
    }

    implicit def implicit2[M1[_], M2[_]]: HListFuncMapGenericX[HNil, HNil, M1, M2] = new HListFuncMapGenericX[HNil, HNil, M1, M2] {
      override def output(o: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[HNil] = o.to(o.zero)(_ => HNil: HNil)(_ => ())
    }
  }

  trait HListFuncMapGenericGenX[Source1, M1[_], M2[_]] {
    def generic[Target1](implicit
      i: HListFuncMapGenericX[Source1, Target1, M1, M2]
    ): HListFuncMapGenericX[Source1, Target1, M1, M2] = i
  }
  object HListFuncMapGenericGenX {
    def apply[Source1, M1[_], M2[_]]: HListFuncMapGenericGenX[Source1, M1, M2] =
      new HListFuncMapGenericGenX[Source1, M1, M2] {
        //
      }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_], M2[_]] {
    self =>
    def derived2[Source1, Target1, Target2](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric3: SimpleFrom[F[M1], Target1] with SimpleTo[F[M1], Target1]
    ): FuncInnerApply1[F, M1, M2, Source1, Target1, Target2] =
      new FuncInnerApply1[F, M1, M2, Source1, Target1, Target2](simpleTo1, simpleGeneric3)
  }

  class FuncInnerApply1[F[_[_]], M1[_], M2[_], Source1, Target1, Target2](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleGeneric3: SimpleFrom[F[M1], Target1] with SimpleTo[F[M1], Target1]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGenX[Source1, M1, M2] => HListFuncMapGenericX[Source1, Target1, M1, M2]
    ): MonadAdd1[M2] => FuncImpl1[M1, M2] => M2[F[M1]] = { monad => func =>
      monad.to(genericFunc(HListFuncMapGenericGenX[Source1, M1, M2]).output(monad)(func))(simpleGeneric3.from)(simpleGeneric3.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric1[F] {
    def impl[M1[_], M2[_]]: SimpleFuncion1Impl[F, M1, M2] => (MonadAdd1[M2] => FuncImpl1[M1, M2] => M2[F[M1]])
    override def toHList1[M1[_], M2[_]](monad: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[F[M1]] =
      impl[M1, M2](new SimpleFuncion1Impl[F, M1, M2])(monad)(func)
  }
}
