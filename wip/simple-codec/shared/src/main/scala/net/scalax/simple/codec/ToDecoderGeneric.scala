package net.scalax.simple.codec
package to_list_generic

trait ToDecoderGeneric[F[_[_]]] {
  def toHList[M3[_, _], M1[_], M2[_]](monad: MonadAdd1111[M3])(func: ToDecoderGeneric.FuncImpl[M3, M1, M2]): M3[F[M1], F[M2]]
}

object ToDecoderGeneric {

  trait FuncImpl[M2[_, _], M1[_], M3[_]] {
    def apply[T]: M2[M1[T], M3[T]]
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

  class ApplyImpl[F[_[_]]] {
    def derived(basedInstalled: BasedInstalled[F]): ToDecoderGeneric[F] = fromInstance(basedInstalled.decode2222)

    def fromInstance(generic3: ToDecoderGeneric2222[F]): ToDecoderGeneric[F] = new ToDecoderGeneric[F] {
      def toHList[M1[_, _], M2[_], M3[_]](monad: MonadAdd1111[M1])(func: ToDecoderGeneric.FuncImpl[M1, M2, M3]): M1[F[M2], F[M3]] = {
        type X[A, B, C] = M1[B, C]

        val mAdd: MonadAdd[X] = new MonadAdd[X] {
          override def zip[A, B, C, S, T, U](ma: M1[B, C], ms: M1[T, U]): M1[(B, T), (C, U)] = monad.zip(ma, ms)
          override def to[A, B, C, S, T, U](
            m1: M1[B, C]
          )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M1[T, U] = monad.to(m1)(in2, in3)(in5, in6)
          override def zero: M1[Unit, Unit] = monad.zero
        }

        def funcImpl[MMX[_]]: ToDecoderGeneric2222.FuncImpl[X, MMX, M2, M3] = new ToDecoderGeneric2222.FuncImpl[X, MMX, M2, M3] {
          override def apply[T]: M1[M2[T], M3[T]] = func[T]
        }

        def to[MMX[_]]: M1[F[M2], F[M3]] = generic3.toHList[X, MMX, M2, M3](mAdd)(funcImpl)

        to
      }
    }
  }

  /*trait HListFuncMapGeneric[Source1, Target1, Target2, M1[_, _], M2[_], M3[_]] {
    def output(monad: MonadAdd1111[M1])(func: FuncImpl[M1, M2, M3]): M1[Target1, Target2]
  }
  object HListFuncMapGeneric {
    implicit def implicit1[T1, Source1 <: HList, HL1 <: HList, HL2 <: HList, M1[_, _], M2[_], M3[_]](implicit
      tail: HListFuncMapGeneric[Source1, HL1, HL2, M1, M2, M3]
    ): HListFuncMapGeneric[T1 :: Source1, M2[T1] :: HL1, M3[T1] :: HL2, M1, M2, M3] =
      new HListFuncMapGeneric[T1 :: Source1, M2[T1] :: HL1, M3[T1] :: HL2, M1, M2, M3] {
        override def output(o: MonadAdd1111[M1])(func: FuncImpl[M1, M2, M3]): M1[M2[T1] :: HL1, M3[T1] :: HL2] = {
          val tailM1: M1[HL1, HL2]                   = tail.output(o)(func)
          val headM1: M1[M2[T1], M3[T1]]             = func[T1]
          val zipM: M1[(HL1, M2[T1]), (HL2, M3[T1])] = o.zip(tailM1, headM1)

          o.to(zipM)(
            in1 = t => t._2 :: t._1,
            in2 = t => t._2 :: t._1
          )(
            in3 = t => (t.tail, t.head),
            in4 = t => (t.tail, t.head)
          )
        }
      }

    implicit def implicit2[M1[_, _], M2[_], M3[_]]: HListFuncMapGeneric[HNil, HNil, HNil, M1, M2, M3] =
      new HListFuncMapGeneric[HNil, HNil, HNil, M1, M2, M3] {
        override def output(o: MonadAdd1111[M1])(func: FuncImpl[M1, M2, M3]): M1[HNil, HNil] =
          o.to(o.zero)(
            _ => HNil: HNil,
            _ => HNil: HNil
          )(
            _ => (),
            _ => ()
          )
      }
  }

  trait HListFuncMapGenericGen[Source1, M1[_, _], M2[_], M3[_]] {
    def generic[Target1, Target2](implicit
      i: HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3] = i
  }
  object HListFuncMapGenericGen {
    def apply[Source1, M1[_, _], M2[_], M3[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3] =
      new HListFuncMapGenericGen[Source1, M1, M2, M3] {
        //
      }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_, _], M2[_], M3[_]] {
    self =>
    def derived2[Source1, Target1, Target2](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric2: SimpleFrom[F[M2], Target1] with SimpleTo[F[M2], Target1],
      simpleGeneric3: SimpleFrom[F[M3], Target2] with SimpleTo[F[M3], Target2]
    ): FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2] =
      new FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2](simpleTo1, simpleGeneric2, simpleGeneric3)
  }

  class FuncInnerApply1[F[_[_]], M1[_, _], M2[_], M3[_], Source1, Target1, Target2](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleGeneric2: SimpleFrom[F[M2], Target1] with SimpleTo[F[M2], Target1],
    simpleGeneric3: SimpleFrom[F[M3], Target2] with SimpleTo[F[M3], Target2]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3] => HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): MonadAdd1111[M1] => FuncImpl[M1, M2, M3] => M1[F[M2], F[M3]] = { monad => func =>
      monad.to(genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3]).output(monad)(func))(
        simpleGeneric2.from,
        simpleGeneric3.from
      )(simpleGeneric2.to, simpleGeneric3.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric[F] {
    def impl[M1[_, _], M2[_], M3[_]]: SimpleFuncion1Impl[F, M1, M2, M3] => (MonadAdd1111[M1] => FuncImpl[M1, M2, M3] => M1[F[M2], F[M3]])
    override def toHList[M1[_, _], M2[_], M3[_]](monad: MonadAdd1111[M1])(func: FuncImpl[M1, M2, M3]): M1[F[M2], F[M3]] =
      impl[M1, M2, M3](new SimpleFuncion1Impl[F, M1, M2, M3])(monad)(func)
  }*/
}
