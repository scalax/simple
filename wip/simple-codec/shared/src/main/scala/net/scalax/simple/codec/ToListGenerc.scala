package net.scalax.simple.codec
package to_list_generic

trait ToListGenerc[F[_[_]]] {
  def toList[TA](input: F[({ type U1[_] = TA })#U1]): List[TA]
}

object ToListGenerc {
  type IdImpl[T] = T

  trait MonadAddImpl1[ProType, ModelType] {
    def toList(list: List[ProType]): List[ProType]
  }

  def monadImpl[Protype]: MonadAdd[({ type U1[X] = MonadAddImpl1[Protype, X] })#U1] =
    new MonadAdd[({ type U1[X] = MonadAddImpl1[Protype, X] })#U1] {
      override def zip[U, X](
        m1: MonadAddImpl1[Protype, U],
        m2: MonadAddImpl1[Protype, X]
      ): MonadAddImpl1[Protype, (U, X)] = new MonadAddImpl1[Protype, (U, X)] {
        override def toList(list: List[Protype]): List[Protype] = m2.toList(m1.toList(list))
      }
      override def map[U, X](param: MonadAddImpl1[Protype, U])(m: U => X): MonadAddImpl1[Protype, X] = new MonadAddImpl1[Protype, X] {
        def toList(list: List[Protype]): List[Protype] = param.toList(list)
      }
      override val unit: MonadAddImpl1[Protype, Unit] = new MonadAddImpl1[Protype, Unit] {
        def toList(list: List[Protype]): List[Protype] = list
      }
    }

  def fromOther[F[_[_]]](o1: ToDecoderGeneric[F], o2: Function50Generic[F]): ToListGenerc[F] = new ToListGenerc[F] {
    override def toList[TA](input: F[({ type U1[_] = TA })#U1]): List[TA] = {
      val gouzao: F[({ type U1[NI] = MonadAddImpl1[TA, TA] })#U1] =
        o2.function1[({ type U1[NI] = TA })#U1, ({ type U1[NI] = MonadAddImpl1[TA, TA] })#U1](
          new Function1Apply[({ type U1[NI] = TA })#U1, ({ type U1[NI] = MonadAddImpl1[TA, TA] })#U1] {
            override def apply[AX](i1: TA): MonadAddImpl1[TA, TA] = new MonadAddImpl1[TA, TA] {
              override def toList(list: List[TA]): List[TA] = i1 :: list
            }
          }
        )(input)

      val u = o1.toHList[({ type U1[NI] = MonadAddImpl1[TA, NI] })#U1, ({ type U1[NI] = TA })#U1](monadImpl[TA])(gouzao)

      u.toList(List.empty)
    }
  }

  /*trait HListFuncMapGeneric[Target1, Target2, T] {
    def output(o: Target2): List[T]
  }
  object HListFuncMapGeneric {
    implicit def implicit1[T1, T2, HL1 <: HList, HL2 <: HList](implicit
      tail: HListFuncMapGeneric[HL1, HL2, T2]
    ): HListFuncMapGeneric[T1 :: HL1, T2 :: HL2, T2] = new HListFuncMapGeneric[T1 :: HL1, T2 :: HL2, T2] {
      override def output(o: T2 :: HL2): List[T2] = o.head :: tail.output(o.tail)
    }
    implicit def implicit2[T2]: HListFuncMapGeneric[HNil, HNil, T2] = new HListFuncMapGeneric[HNil, HNil, T2] {
      override def output(o: HNil): List[T2] = List.empty
    }
  }

  trait HListFuncMapGenericGen[Target1, Target2, T] {
    def generic(implicit i: HListFuncMapGeneric[Target1, Target2, T]): HListFuncMapGeneric[Target1, Target2, T] = i
  }
  object HListFuncMapGenericGen {
    def apply[Target1, Target2, T]: HListFuncMapGenericGen[Target1, Target2, T] = new HListFuncMapGenericGen[Target1, Target2, T] {
      //
    }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], U] {
    self =>
    def derived2[Target1](
      simpleTo: SimpleTo[F[({ type U1[_] = U })#U1], Target1]
    ): FuncInnerApply1[F, U, Target1] = new FuncInnerApply1[F, U, Target1](simpleTo)
  }

  class FuncInnerApply1[F[_[_]], U, Target1](simpleTo: SimpleTo[F[({ type U1[_] = U })#U1], Target1]) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Target1, Target1, U] => HListFuncMapGeneric[Target1, Target1, U]
    ): F[({ type U1[_] = U })#U1] => List[U] = fu => genericFunc(HListFuncMapGenericGen[Target1, Target1, U]).output(simpleTo.to(fu))
  }

  trait Impl[F[_[_]]] extends ToListGenerc[F] {
    def impl[U]: SimpleFuncion1Impl[F, U] => F[({ type U1[_] = U })#U1] => List[U]
    override def toList[T](input: F[({ type U1[_] = T })#U1]): List[T] = impl[T](new SimpleFuncion1Impl[F, T])(input)
  }*/
}
