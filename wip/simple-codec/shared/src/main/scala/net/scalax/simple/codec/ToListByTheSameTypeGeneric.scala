package net.scalax.simple.codec
package to_list_generic

import utils.SimpleP

trait ToListByTheSameTypeGeneric[F[_[_]]] {
  def toListByTheSameType[TA, SeqType](
    zero: SeqType,
    append: (SeqType, TA) => SeqType
  ): F[({ type U1[_] = TA })#U1] => SeqType
}

object ToListByTheSameTypeGeneric {

  type IdImpl[T] = T

  trait MonadAddImpl1[ProType, ModelType, SeqType] {
    def toList(model: ModelType): SeqType => SeqType
  }

  def monadImpl[Protype, SeqType]: SimpleProduct1.AppendMonad[({ type U1[X] = MonadAddImpl1[Protype, X, SeqType] })#U1] = {
    val identityFunction: SeqType => SeqType = identity

    new SimpleProduct1.AppendMonad[({ type U1[X] = MonadAddImpl1[Protype, X, SeqType] })#U1] {
      override def zip[U, X](
        m1: MonadAddImpl1[Protype, U, SeqType],
        m2: MonadAddImpl1[Protype, X, SeqType]
      ): MonadAddImpl1[Protype, (U, X), SeqType] = new MonadAddImpl1[Protype, (U, X), SeqType] {
        override def toList(model: (U, X)): SeqType => SeqType = {
          val tolist1 = m1.toList(model._1)
          val tolist2 = m2.toList(model._2)
          l => tolist2(tolist1(l))
        }
      }
      override def to[U, X](param: MonadAddImpl1[Protype, U, SeqType])(m: U => X)(n: X => U): MonadAddImpl1[Protype, X, SeqType] =
        new MonadAddImpl1[Protype, X, SeqType] {
          override def toList(model: X): SeqType => SeqType = param.toList(n(model))
        }
      override val zero: MonadAddImpl1[Protype, Unit, SeqType] = new MonadAddImpl1[Protype, Unit, SeqType] {
        override def toList(model: Unit): SeqType => SeqType = identityFunction
      }
    }
  }

  class ToListGenericApply[F[_[_]]] {
    def derived(basedInstalled: SimpleP.Appender[F]): ToListByTheSameTypeGeneric[F] = fromOther(
      SimpleProduct1.Appender[F].derived(basedInstalled)
    )

    def fromOther(o1: SimpleProduct1.Appender[F]): ToListByTheSameTypeGeneric[F] = new ToListByTheSameTypeGeneric[F] {
      override def toListByTheSameType[TA, SeqType](
        zero: SeqType,
        append: (SeqType, TA) => SeqType
      ): F[({ type U1[_] = TA })#U1] => SeqType = { input =>
        val func = new SimpleProduct1.TypeGen[({ type U1[NI] = MonadAddImpl1[TA, NI, SeqType] })#U1, ({ type U1[NI] = TA })#U1] {
          override def apply[T]: MonadAddImpl1[TA, TA, SeqType] = new MonadAddImpl1[TA, TA, SeqType] {
            override def toList(model: TA): SeqType => SeqType = l => append(l, model)
          }
        }

        val u = o1.toHList1[({ type U1[NI] = MonadAddImpl1[TA, NI, SeqType] })#U1, ({ type U1[NI] = TA })#U1](
          monadImpl[TA, SeqType]
        )(func)

        u.toList(input)(zero)
      }
    }
  }

  def apply[F[_[_]]] = new ToListGenericApply[F]

}
