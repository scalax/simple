package net.scalax.simple.codec
package to_list_generic

trait ToDecoderGeneric[F[_[_]]] {
  def toHList[M1[_, _], M2[_], M3[_]](monad: MonadAdd1111[M1])(func: ToDecoderGeneric.FuncImpl[M1, M2, M3]): M1[F[M2], F[M3]]
}

object ToDecoderGeneric {
  type IdImpl[T] = T
  trait FuncImpl[M1[_, _], M2[_], M3[_]] {
    def apply[T]: M1[M2[T], M3[T]]
  }

  type MatchTuple1[T, M1[_]] <: Tuple = T match {
    case h *: tail  => M1[h] *: MatchTuple1[tail, M1]
    case EmptyTuple => EmptyTuple
  }

  trait HListFuncMapGeneric[Source1, Target1, Target2, M1[_, _], M2[_], M3[_]] {
    def output(monad: MonadAdd1111[M1])(func: FuncImpl[M1, M2, M3]): M1[Target1, Target2]
  }
  object HListFuncMapGeneric {
    private def instanceAny(count: Int): HListFuncMapGeneric[Tuple, Tuple, Tuple, [x1, x2] =>> Any, [x] =>> Any, [x] =>> Any] =
      new HListFuncMapGeneric[Tuple, Tuple, Tuple, [x1, x2] =>> Any, [x] =>> Any, [x] =>> Any] {
        self =>
        override def output(o: MonadAdd1111[[x1, x2] =>> Any])(func: FuncImpl[[x1, x2] =>> Any, [x] =>> Any, [x] =>> Any]): Any = if (
          count > 0
        ) {
          val tail   = instanceAny(count - 1)
          val tailM1 = tail.output(o)(func)
          val headM1 = func[Any]
          val zipM   = o.zip(tailM1, headM1)

          o.to(zipM)(
            in1 = t => t.asInstanceOf[Tuple2[_, _]]._2 *: t.asInstanceOf[Tuple2[_, _]]._1.asInstanceOf[Tuple],
            in2 = t => t.asInstanceOf[Tuple2[_, _]]._2 *: t.asInstanceOf[Tuple2[_, _]]._1.asInstanceOf[Tuple]
          )(
            in3 = t => (t.asInstanceOf[Any *: Tuple].tail, t.asInstanceOf[Any *: Tuple].head),
            in4 = t => (t.asInstanceOf[Any *: Tuple].tail, t.asInstanceOf[Any *: Tuple].head)
          )
        } else {
          o.to(o.zero)(
            _ => EmptyTuple,
            _ => EmptyTuple
          )(
            _ => (),
            _ => ()
          )
        }
      }

    def instance[Source1 <: Tuple, M1[_, _], M2[_], M3[_]](using
      v: ValueOf[Tuple.Size[Source1]]
    ): HListFuncMapGeneric[Source1, MatchTuple1[Source1, M2], MatchTuple1[Source1, M3], M1, M2, M3] = instanceAny(
      summon[ValueOf[Tuple.Size[Source1]]].value
    ).asInstanceOf
  }

  trait HListFuncMapGenericGen[Source1 <: Tuple, M1[_, _], M2[_], M3[_]] {
    def generic(using
      ValueOf[Tuple.Size[Source1]]
    ): HListFuncMapGeneric[Source1, MatchTuple1[Source1, M2], MatchTuple1[Source1, M3], M1, M2, M3] =
      HListFuncMapGeneric.instance[Source1, M1, M2, M3]
  }
  object HListFuncMapGenericGen {
    def apply[Source1 <: Tuple, M1[_, _], M2[_], M3[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3] =
      new HListFuncMapGenericGen[Source1, M1, M2, M3] {
        //
      }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_, _], M2[_], M3[_]] {
    self =>
    def derived2[Source1 <: Tuple](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleGeneric2: SimpleFrom[F[M2], MatchTuple1[Source1, M2]] with SimpleTo[F[M2], MatchTuple1[Source1, M2]],
      simpleGeneric3: SimpleFrom[F[M3], MatchTuple1[Source1, M3]] with SimpleTo[F[M3], MatchTuple1[Source1, M3]]
    ): FuncInnerApply1[F, M1, M2, M3, Source1] = FuncInnerApply1[F, M1, M2, M3, Source1](simpleTo1, simpleGeneric2, simpleGeneric3)
  }

  class FuncInnerApply1[F[_[_]], M1[_, _], M2[_], M3[_], Source1 <: Tuple](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleGeneric2: SimpleFrom[F[M2], MatchTuple1[Source1, M2]] with SimpleTo[F[M2], MatchTuple1[Source1, M2]],
    simpleGeneric3: SimpleFrom[F[M3], MatchTuple1[Source1, M3]] with SimpleTo[F[M3], MatchTuple1[Source1, M3]]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3] => HListFuncMapGeneric[
        Source1,
        MatchTuple1[Source1, M2],
        MatchTuple1[Source1, M3],
        M1,
        M2,
        M3
      ]
    ): MonadAdd1111[M1] => FuncImpl[M1, M2, M3] => M1[F[M2], F[M3]] = { monad => func =>
      val hlistM = genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3]).output(monad)(func)
      monad.to(hlistM)(simpleGeneric2.from, simpleGeneric3.from)(simpleGeneric2.to, simpleGeneric3.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric[F] {
    def impl[M1[_, _], M2[_], M3[_]]: SimpleFuncion1Impl[F, M1, M2, M3] => (MonadAdd1111[M1] => FuncImpl[M1, M2, M3] => M1[F[M2], F[M3]])
    override def toHList[M1[_, _], M2[_], M3[_]](monad: MonadAdd1111[M1])(func: FuncImpl[M1, M2, M3]): M1[F[M2], F[M3]] =
      impl[M1, M2, M3](SimpleFuncion1Impl[F, M1, M2, M3])(monad)(func)
  }
}
