package net.scalax.simple.codec
package to_list_generic

trait ToDecoderGeneric1[F[_[_]]] {
  def toHList1[M2[_], M1[_]](monad: MonadAdd1[M2])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M2[F[M1]]
}

object ToDecoderGeneric1 {

  type IdImpl[T] = T

  trait FuncImpl1[M1[_], M2[_]] {
    def apply[T]: M2[M1[T]]
  }

  type MatchTuple1[T, M1[_]] <: Tuple = T match {
    case h *: tail  => M1[h] *: MatchTuple1[tail, M1]
    case EmptyTuple => EmptyTuple
  }

  trait HListFuncMapGenericX[Source1, Target1, M1[_], M2[_]] {
    def output(monad: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[Target1]
  }
  object HListFuncMapGenericX {

    private def instanceImpl(count: Int): HListFuncMapGenericX[Tuple, Tuple, [x] =>> Any, [x] =>> Any] = if (count > 0) {
      new HListFuncMapGenericX[Tuple, Tuple, [x] =>> Any, [x] =>> Any] {
        override def output(o: MonadAdd1[[x] =>> Any])(func: FuncImpl1[[x] =>> Any, [x] =>> Any]): Any = {
          val tail        = instanceImpl(count - 1)
          val tailM1: Any = tail.output(o)(func)
          val headM1: Any = func[Any]
          val zipM: Any   = o.zip(tailM1, headM1)

          o.to(zipM)(
            in1 = t => t.asInstanceOf[Tuple2[_, _]]._2 *: t.asInstanceOf[Tuple2[_, _]]._1.asInstanceOf[Tuple]
          )(
            out1 = t => (t.asInstanceOf[Any *: Tuple].tail, t.asInstanceOf[Any *: Tuple].head)
          )
        }
      }
    } else
      new HListFuncMapGenericX[Tuple, Tuple, [x] =>> Any, [x] =>> Any] {
        override def output(o: MonadAdd1[[x] =>> Any])(func: FuncImpl1[[x] =>> Any, [x] =>> Any]): Any =
          o.to(o.zero)(_ => EmptyTuple: EmptyTuple)(_ => ())
      }

    def instance[Source1 <: Tuple, M1[_], M2[_]](using
      ValueOf[Tuple.Size[Source1]]
    ): HListFuncMapGenericX[Source1, MatchTuple1[Source1, M1], M1, M2] = instanceImpl(
      summon[ValueOf[Tuple.Size[Source1]]].value
    ).asInstanceOf

  }

  trait HListFuncMapGenericGenX[Source1 <: Tuple, M1[_], M2[_]] {
    def generic(using ValueOf[Tuple.Size[Source1]]): HListFuncMapGenericX[Source1, MatchTuple1[Source1, M1], M1, M2] =
      HListFuncMapGenericX.instance
  }
  object HListFuncMapGenericGenX {
    def apply[Source1 <: Tuple, M1[_], M2[_]]: HListFuncMapGenericGenX[Source1, M1, M2] =
      new HListFuncMapGenericGenX[Source1, M1, M2] {
        //
      }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_], M2[_]] {
    self =>
    def derived2[Source1 <: Tuple, Target1, Target2](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric3: SimpleFrom[F[M1], MatchTuple1[Source1, M1]] with SimpleTo[F[M1], MatchTuple1[Source1, M1]]
    ): FuncInnerApply1[F, M1, M2, Source1] = new FuncInnerApply1[F, M1, M2, Source1](simpleTo1, simpleGeneric3)
  }

  class FuncInnerApply1[F[_[_]], M1[_], M2[_], Source1 <: Tuple](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleGeneric3: SimpleFrom[F[M1], MatchTuple1[Source1, M1]] with SimpleTo[F[M1], MatchTuple1[Source1, M1]]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGenX[Source1, M1, M2] => HListFuncMapGenericX[Source1, MatchTuple1[Source1, M1], M1, M2]
    ): MonadAdd1[M2] => FuncImpl1[M1, M2] => M2[F[M1]] = { monad => func =>
      monad.to(genericFunc(HListFuncMapGenericGenX[Source1, M1, M2]).output(monad)(func))(simpleGeneric3.from)(simpleGeneric3.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric1[F] {
    def impl[M1[_], M2[_]]: SimpleFuncion1Impl[F, M1, M2] => (MonadAdd1[M2] => FuncImpl1[M1, M2] => M2[F[M1]])
    override def toHList1[M2[_], M1[_]](monad: MonadAdd1[M2])(func: FuncImpl1[M1, M2]): M2[F[M1]] =
      impl[M1, M2](new SimpleFuncion1Impl[F, M1, M2])(monad)(func)
  }
}
