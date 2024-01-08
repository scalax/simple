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

  class ToListGenercApply[F[_[_]]] {
    def derived(basedInstalled: BasedInstalled[F]): ToListGenerc[F] = fromOther(basedInstalled.decode, basedInstalled.funcion50)

    def fromOther(o1: ToDecoderGeneric[F], o2: Function50Generic[F]): ToListGenerc[F] = new ToListGenerc[F] {
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
  }

  def apply[F[_[_]]] = new ToListGenercApply[F]

}
