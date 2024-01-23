package net.scalax.simple.codec
package to_list_generic

import shapeless._

trait ToDecoderGeneric[F[_[_]]] {
  def toHList[M1[_], M2[_, _], M3[_]](monad: MonadAdd[M2])(func: ToDecoderGeneric.FuncImpl[M1, M2, M3]): M2[F[M1], F[M3]]
}

object ToDecoderGeneric {

  type IdImpl[T] = T

  trait FuncImpl[M1[_], M2[_, _], M3[_]] {
    def apply[T]: M2[M1[T], M3[T]]
  }

  trait HListFuncMapGeneric[Source1, Target1, Target2, M1[_], M2[_, _], M3[_]] {
    def output(monad: MonadAdd[M2])(func: FuncImpl[M1, M2, M3]): M2[Target1, Target2]
  }
  object HListFuncMapGeneric {
    implicit def implicit1[T1, Source1 <: HList, HL1 <: HList, HL2 <: HList, M1[_], M2[_, _], M3[_]](implicit
      tail: HListFuncMapGeneric[Source1, HL1, HL2, M1, M2, M3]
    ): HListFuncMapGeneric[T1 :: Source1, M1[T1] :: HL1, M3[T1] :: HL2, M1, M2, M3] =
      new HListFuncMapGeneric[T1 :: Source1, M1[T1] :: HL1, M3[T1] :: HL2, M1, M2, M3] {
        override def output(o: MonadAdd[M2])(func: FuncImpl[M1, M2, M3]): M2[M1[T1] :: HL1, M3[T1] :: HL2] = {
          val tailM1: M2[HL1, HL2]                   = tail.output(o)(func)
          val headM1: M2[M1[T1], M3[T1]]             = func[T1]
          val zipM: M2[(HL1, M1[T1]), (HL2, M3[T1])] = o.zip(tailM1, headM1)

          o.to(zipM)(
            in1 = t => t._2 :: t._1,
            in2 = t => t._2 :: t._1
          )(
            in3 = t => (t.tail, t.head),
            in4 = t => (t.tail, t.head)
          )
        }
      }

    implicit def implicit2[M1[_], M2[_, _], M3[_]]: HListFuncMapGeneric[HNil, HNil, HNil, M1, M2, M3] =
      new HListFuncMapGeneric[HNil, HNil, HNil, M1, M2, M3] {
        override def output(o: MonadAdd[M2])(func: FuncImpl[M1, M2, M3]): M2[HNil, HNil] =
          o.to(o.zero)(
            _ => HNil: HNil,
            _ => HNil: HNil
          )(
            _ => (),
            _ => ()
          )
      }
  }

  trait HListFuncMapGenericGen[Source1, M1[_], M2[_, _], M3[_]] {
    def generic[Target1, Target2](implicit
      i: HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3] = i
  }
  object HListFuncMapGenericGen {
    def apply[Source1, M1[_], M2[_, _], M3[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3] =
      new HListFuncMapGenericGen[Source1, M1, M2, M3] {
        //
      }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_], M2[_, _], M3[_]] {
    self =>
    def derived2[Source1, Target1, Target2](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric2: SimpleFrom[F[M1], Target1] with SimpleTo[F[M1], Target1],
      simpleGeneric3: SimpleFrom[F[M3], Target2] with SimpleTo[F[M3], Target2]
    ): FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2] =
      new FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2](simpleTo1, simpleGeneric2, simpleGeneric3)
  }

  class FuncInnerApply1[F[_[_]], M1[_], M2[_, _], M3[_], Source1, Target1, Target2](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleGeneric2: SimpleFrom[F[M1], Target1] with SimpleTo[F[M1], Target1],
    simpleGeneric3: SimpleFrom[F[M3], Target2] with SimpleTo[F[M3], Target2]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3] => HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): MonadAdd[M2] => FuncImpl[M1, M2, M3] => M2[F[M1], F[M3]] = { monad => func =>
      monad.to(genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3]).output(monad)(func))(
        simpleGeneric2.from,
        simpleGeneric3.from
      )(simpleGeneric2.to, simpleGeneric3.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric[F] {
    def impl[M1[_], M2[_, _], M3[_]]: SimpleFuncion1Impl[F, M1, M2, M3] => (MonadAdd[M2] => FuncImpl[M1, M2, M3] => M2[F[M1], F[M3]])
    override def toHList[M1[_], M2[_, _], M3[_]](monad: MonadAdd[M2])(func: FuncImpl[M1, M2, M3]): M2[F[M1], F[M3]] =
      impl[M1, M2, M3](new SimpleFuncion1Impl[F, M1, M2, M3])(monad)(func)
  }
}
