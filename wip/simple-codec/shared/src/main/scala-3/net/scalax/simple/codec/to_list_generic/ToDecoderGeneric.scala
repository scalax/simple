package net.scalax.simple.codec
package to_list_generic

trait ToDecoderGeneric[F[_[_]]] {
  def toHList[M1[_], M2[_], M3[_]](monad: MonadAdd[M2])(func: ToDecoderGeneric.FuncImpl[M1, M2, M3])(input: F[M1]): M2[F[M3]]
}

object ToDecoderGeneric {
  type IdImpl[T] = T
  trait FuncImpl[M1[_], M2[_], M3[_]] {
    def apply[T](input: M1[T]): M2[M3[T]]
  }

  type MatchTuple1[T, M1[_]] <: Tuple = T match {
    case h *: tail  => M1[h] *: MatchTuple1[tail, M1]
    case EmptyTuple => EmptyTuple
  }

  trait HListFuncMapGeneric[Source1, Target1, Target2, M1[_], M2[_], M3[_]] {
    def output(monad: MonadAdd[M2])(func: FuncImpl[M1, M2, M3])(o1: Target1): M2[Target2]
  }
  object HListFuncMapGeneric {
    private val instanceAny: HListFuncMapGeneric[Tuple, Tuple, Tuple, [x] =>> Any, [x] =>> Any, [x] =>> Any] =
      new HListFuncMapGeneric[Tuple, Tuple, Tuple, [x] =>> Any, [x] =>> Any, [x] =>> Any] {
        self =>
        override def output(monad: MonadAdd[[x] =>> Any])(func: FuncImpl[[x] =>> Any, [x] =>> Any, [x] =>> Any])(o1: Tuple): Any = o1.match
          case head *: tail =>
            val m1 = monad.zip(self.output(monad)(func)(tail), func(head))
            monad.reverse_map(m1)(_.match
              case h1 *: t1 => t1 -> h1
            )
          case EmptyTuple => monad.reverse_map(monad.unit)(_ => ())
      }

    def instance[Source1, M1[_], M2[_], M3[_]]
      : HListFuncMapGeneric[Source1, MatchTuple1[Source1, M1], MatchTuple1[Source1, M3], M1, M2, M3] = instanceAny.asInstanceOf
  }

  trait HListFuncMapGenericGen[Source1, M1[_], M2[_], M3[_]] {
    def generic: HListFuncMapGeneric[Source1, MatchTuple1[Source1, M1], MatchTuple1[Source1, M3], M1, M2, M3] =
      HListFuncMapGeneric.instance[Source1, M1, M2, M3]
  }
  object HListFuncMapGenericGen {
    def apply[Source1, M1[_], M2[_], M3[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3] = new HListFuncMapGenericGen[Source1, M1, M2, M3] {
      //
    }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_], M2[_], M3[_]] {
    self =>
    def derived2[Source1, Target1, Target2](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleFrom2: SimpleTo[F[M3], Target2],
      simpleTo3: SimpleTo[F[M1], Target1]
    ): FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2] =
      new FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2](simpleTo1, simpleFrom2, simpleTo3)
  }

  class FuncInnerApply1[F[_[_]], M1[_], M2[_], M3[_], Source1, Target1, Target2](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleFrom2: SimpleTo[F[M3], Target2],
    simpleTo3: SimpleTo[F[M1], Target1]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3] => HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): MonadAdd[M2] => FuncImpl[M1, M2, M3] => F[M1] => M2[F[M3]] = { monad => func => model =>
      monad.reverse_map(genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3]).output(monad)(func)(simpleTo3.to(model)))(simpleFrom2.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric[F] {
    def impl[M1[_], M2[_], M3[_]]: SimpleFuncion1Impl[F, M1, M2, M3] => (MonadAdd[M2] => FuncImpl[M1, M2, M3] => F[M1] => M2[F[M3]])
    override def toHList[M1[_], M2[_], M3[_]](monad: MonadAdd[M2])(func: FuncImpl[M1, M2, M3])(input: F[M1]): M2[F[M3]] =
      impl[M1, M2, M3](new SimpleFuncion1Impl[F, M1, M2, M3])(monad)(func)(input)
  }
}
