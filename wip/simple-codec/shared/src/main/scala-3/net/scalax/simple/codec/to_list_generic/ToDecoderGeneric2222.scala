package net.scalax.simple.codec
package to_list_generic

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

  type MatchTuple1[T, M1[_]] <: Tuple = T match {
    case h *: tail  => M1[h] *: MatchTuple1[tail, M1]
    case EmptyTuple => EmptyTuple
  }

  trait HListFuncMapGeneric[Source1, Target1, Target2, Target3, M1[_, _, _], M2[_], M3[_], M4[_]] {
    def output(monad: MonadAdd[M1])(func: FuncImpl[M1, M2, M3, M4]): M1[Target1, Target2, Target3]
  }
  object HListFuncMapGeneric {
    private def instanceAny(
      count: Int
    ): HListFuncMapGeneric[Tuple, Tuple, Tuple, Tuple, [x1, x2, x3] =>> Any, [x] =>> Any, [x] =>> Any, [x] =>> Any] =
      new HListFuncMapGeneric[Tuple, Tuple, Tuple, Tuple, [x1, x2, x3] =>> Any, [x] =>> Any, [x] =>> Any, [x] =>> Any] {
        self =>
        override def output(
          o: MonadAdd[[x1, x2, x3] =>> Any]
        )(func: FuncImpl[[x1, x2, x3] =>> Any, [x] =>> Any, [x] =>> Any, [x] =>> Any]): Any = if (count > 0) {
          val tail   = instanceAny(count - 1)
          val tailM1 = tail.output(o)(func)
          val headM1 = func[Any]
          val zipM   = o.zip(tailM1, headM1)

          o.to(zipM)(
            in1 = t => t.asInstanceOf[Tuple2[_, _]]._2 *: t.asInstanceOf[Tuple2[_, _]]._1.asInstanceOf[Tuple],
            in2 = t => t.asInstanceOf[Tuple2[_, _]]._2 *: t.asInstanceOf[Tuple2[_, _]]._1.asInstanceOf[Tuple],
            in3 = t => t.asInstanceOf[Tuple2[_, _]]._2 *: t.asInstanceOf[Tuple2[_, _]]._1.asInstanceOf[Tuple]
          )(
            in4 = t => (t.asInstanceOf[Any *: Tuple].tail, t.asInstanceOf[Any *: Tuple].head),
            in5 = t => (t.asInstanceOf[Any *: Tuple].tail, t.asInstanceOf[Any *: Tuple].head),
            in6 = t => (t.asInstanceOf[Any *: Tuple].tail, t.asInstanceOf[Any *: Tuple].head)
          )
        } else {
          o.to(o.zero)(
            _ => EmptyTuple,
            _ => EmptyTuple,
            _ => EmptyTuple
          )(
            _ => (),
            _ => (),
            _ => ()
          )
        }
      }

    def instance[Source1 <: Tuple, M1[_, _, _], M2[_], M3[_], M4[_]](using
      v: ValueOf[Tuple.Size[Source1]]
    ): HListFuncMapGeneric[Source1, MatchTuple1[Source1, M2], MatchTuple1[Source1, M3], MatchTuple1[Source1, M4], M1, M2, M3, M4] =
      instanceAny(summon[ValueOf[Tuple.Size[Source1]]].value).asInstanceOf
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
