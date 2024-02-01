package net.scalax.simple.codec
package to_list_generic

trait ToListGeneric[F[_[_]]] {
  def toList[TA](input: F[({ type U1[_] = TA })#U1]): List[TA]
}

object ToListGeneric {

  type IdImpl[T] = T

  trait MonadAddImpl1[ProType, ModelType] {
    def toList(model: ModelType): List[ProType] => List[ProType]
  }

  def monadImpl[Protype]: MonadAdd1[({ type U1[X] = MonadAddImpl1[Protype, X] })#U1] =
    new MonadAdd1[({ type U1[X] = MonadAddImpl1[Protype, X] })#U1] {
      override def zip[U, X](
        m1: MonadAddImpl1[Protype, U],
        m2: MonadAddImpl1[Protype, X]
      ): MonadAddImpl1[Protype, (U, X)] = new MonadAddImpl1[Protype, (U, X)] {
        override def toList(model: (U, X)): List[Protype] => List[Protype] = {
          val tolist1 = m1.toList(model._1)
          val tolist2 = m2.toList(model._2)
          l => tolist2(tolist1(l))
        }
      }
      override def to[U, X](param: MonadAddImpl1[Protype, U])(m: U => X)(n: X => U): MonadAddImpl1[Protype, X] =
        new MonadAddImpl1[Protype, X] {
          override def toList(model: X): List[Protype] => List[Protype] = param.toList(n(model))
        }
      override val zero: MonadAddImpl1[Protype, Unit] = new MonadAddImpl1[Protype, Unit] {
        override def toList(model: Unit): List[Protype] => List[Protype] = identity _
      }
    }

  class ToListGenericApply[F[_[_]]] {
    def derived(basedInstalled: BasedInstalled[F]): ToListGeneric[F] = fromOther(basedInstalled.decode1, basedInstalled.funcion50)

    def fromOther(o1: ToDecoderGeneric1[F], o2: Function50Generic[F]): ToListGeneric[F] = new ToListGeneric[F] {
      override def toList[TA](input: F[({ type U1[_] = TA })#U1]): List[TA] = {
        val gouzao: F[({ type U1[NI] = MonadAddImpl1[TA, TA] })#U1] =
          o2.function1[({ type U1[NI] = TA })#U1, ({ type U1[NI] = MonadAddImpl1[TA, TA] })#U1](
            new Function1Apply[({ type U1[NI] = TA })#U1, ({ type U1[NI] = MonadAddImpl1[TA, TA] })#U1] {
              override def apply[AX](i1: TA): MonadAddImpl1[TA, TA] = new MonadAddImpl1[TA, TA] {
                override def toList(model: TA): List[TA] => List[TA] = list => i1 :: list
              }
            }
          )(input)

        val func = new ToDecoderGeneric1.FuncImpl1[
          ({ type U1[NI] = TA })#U1,
          ({ type U1[NI] = MonadAddImpl1[TA, NI] })#U1
        ] {
          override def apply[T]: MonadAddImpl1[TA, TA] = new MonadAddImpl1[TA, TA] {
            override def toList(model: TA): List[TA] => List[TA] = l => model :: l
          }
        }

        val u = o1.toHList1[({ type U1[NI] = TA })#U1, ({ type U1[NI] = MonadAddImpl1[TA, NI] })#U1](
          monadImpl[TA]
        )(func)

        u.toList(input)(List.empty)
      }
    }
  }

  def apply[F[_[_]]] = new ToListGenericApply[F]

}
