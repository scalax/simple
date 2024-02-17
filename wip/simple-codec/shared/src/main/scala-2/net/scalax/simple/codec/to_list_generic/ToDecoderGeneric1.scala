package net.scalax.simple.codec
package to_list_generic

import shapeless._

trait ToDecoderGeneric1[F[_[_]]] {
  def toHList1[M2[_], M1[_]](monad: MonadAdd1[M2])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M2[F[M1]]
}

object ToDecoderGeneric1 {

  def fromGeneric2[F[_[_]]](generic2: ToDecoderGeneric[F], modelStr: F[StrImpl]): ToDecoderGeneric1[F] = new ToDecoderGeneric1[F] {
    def toHList1[M2[_], M1[_]](monad: MonadAdd1[M2])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M2[F[M1]] = {
      type X[A, B] = A => M2[B]
      val mAdd: MonadAdd[X] = new MonadAdd[X] {
        override def zip[A, B, S, T](ma: A => M2[B], ms: S => M2[T]): ((A, S)) => M2[(B, T)] = { t =>
          val t1 = ma(t._1)
          val t2 = ms(t._2)
          monad.zip(t1, t2)
        }
        override def to[A, B, S, T](m1: A => M2[B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): S => M2[T] = s =>
          monad.to[B, T](m1(in3(s)))(in2)(in4)
        override def zero: Unit => M2[Unit] = _ => monad.zero
      }
      val funcImpl: ToDecoderGeneric.FuncImpl[X, StrImpl, M1] = new ToDecoderGeneric.FuncImpl[X, StrImpl, M1] {
        override def apply[T]: StrImpl[T] => M2[M1[T]] = _ => func[T]
      }
      val to = generic2.toHList[X, StrImpl, M1](mAdd)(funcImpl)
      to(modelStr)
    }
  }

  type IdImpl[T]  = T
  type StrImpl[T] = String

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
    def impl11[M1[_], M2[_]]: SimpleFuncion1Impl[F, M1, M2] => (MonadAdd1[M2] => FuncImpl1[M1, M2] => M2[F[M1]])
    override def toHList1[M2[_], M1[_]](monad: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[F[M1]] =
      impl11[M1, M2](new SimpleFuncion1Impl[F, M1, M2])(monad)(func)
  }
}
