package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{SimpleProduct, SimpleProduct1}

trait FromListGeneric[F[_[_]]] {
  def fromList[TA](input: List[TA]): F[({ type U1[_] = TA })#U1]
}

object FromListGeneric {

  type IdImpl[T] = T

  private def toNamed[T]: SimpleProduct1.TypeGen[({ type T1[U] = List[T] => (List[T], U) })#T1, ({ type T1[_] = T })#T1] =
    new SimpleProduct1.TypeGen[({ type T1[U] = List[T] => (List[T], U) })#T1, ({ type T1[_] = T })#T1] {
      override def apply[U]: List[T] => (List[T], T) = l => (l.tail, l.head)
    }

  private def monadAdd[ItType]: SimpleProduct1.AppendMonad[({ type T1[U] = List[ItType] => (List[ItType], U) })#T1] =
    new SimpleProduct1.AppendMonad[({ type T1[U] = List[ItType] => (List[ItType], U) })#T1] {
      override def zip[A, B](
        ma: List[ItType] => (List[ItType], A),
        ms: List[ItType] => (List[ItType], B)
      ): List[ItType] => (List[ItType], (A, B)) = { l =>
        val ra = ma(l)
        val rb = ms(ra._1)

        (rb._1, (ra._2, rb._2))
      }

      override def to[A, B](m1: List[ItType] => (List[ItType], A))(in1: A => B)(out1: B => A): List[ItType] => (List[ItType], B) = { l =>
        val temp = m1(l)

        (temp._1, in1(temp._2))
      }

      override val zero: List[ItType] => (List[ItType], Unit) = l => (l, ())
    }

  class ToListGenericApply[F[_[_]]] {
    def derived(basedInstalled: SimpleProduct.Appender[F]): FromListGeneric[F] = fromOther(
      SimpleProduct1.Appender[F].derived(basedInstalled)
    )

    def fromOther(o1: SimpleProduct1.Appender[F]): FromListGeneric[F] = new FromListGeneric[F] {
      override def fromList[TA](input: List[TA]): F[({ type U1[_] = TA })#U1] = {
        val u = o1.toHList1[({ type ModelF[M] = List[TA] => (List[TA], M) })#ModelF, ({ type T1[_] = TA })#T1](monadAdd)(toNamed[TA])
        u(input)._2
      }
    }
  }

  def apply[F[_[_]]] = new ToListGenericApply[F]

}
