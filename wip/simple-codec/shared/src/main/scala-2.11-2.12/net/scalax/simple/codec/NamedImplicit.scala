package net.scalax.simple
package codec

import shapeless._
import to_list_generic._

trait NamedImplicit[T] {
  def names: HList
}

object NamedImplicit {
  type Named[_] = String

  implicit def getImplicit[T](implicit named: DefaultSymbolicLabelling.Aux[T, _ <: HList]): NamedImplicit[T] =
    new NamedImplicit[T] {
      override val names: HList = named.apply()
    }

  private val toNamed: ToDecoderGeneric1.FuncImpl1[({ type T1[U] = List[String] => (List[String], U) })#T1, ({ type T1[_] = String })#T1] =
    new ToDecoderGeneric1.FuncImpl1[({ type T1[U] = List[String] => (List[String], U) })#T1, ({ type T1[_] = String })#T1] {
      override def apply[T]: List[String] => (List[String], String) = l => (l.tail, l.head)
    }

  private val monadAdd: MonadAdd1[({ type T1[U] = List[String] => (List[String], U) })#T1] =
    new MonadAdd1[({ type T1[U] = List[String] => (List[String], U) })#T1] {
      override def zip[A, B](
        ma: List[String] => (List[String], A),
        ms: List[String] => (List[String], B)
      ): List[String] => (List[String], (A, B)) = { l =>
        val ra = ma(l)
        val rb = ms(ra._1)

        (rb._1, (ra._2, rb._2))
      }

      override def to[A, B](m1: List[String] => (List[String], A))(in1: A => B)(out1: B => A): List[String] => (List[String], B) = { l =>
        val temp = m1(l)

        (temp._1, in1(temp._2))
      }

      override val zero: List[String] => (List[String], Unit) = l => (l, ())
    }

  def toNamedModel[F[_[_]]](m: ToDecoderGeneric2222[F], n: NamedImplicit[F[Named]]): F[Named] = {
    def toList(l: HList): List[String] = l match {
      case s: shapeless.::[_, HList] => s.head.asInstanceOf[Symbol].name :: toList(s.tail)
      case HNil                      => List.empty
    }

    val names: List[String] = toList(n.names)

    val de1: ToDecoderGeneric[F]  = ToDecoderGeneric[F].derived(m)
    val de2: ToDecoderGeneric1[F] = ToDecoderGeneric1[F].derived(de1)

    val func = de2.toHList1[({ type T1[U] = List[String] => (List[String], U) })#T1, ({ type T1[_] = String })#T1](monadAdd)(toNamed)

    func(names)._2
  }
}
