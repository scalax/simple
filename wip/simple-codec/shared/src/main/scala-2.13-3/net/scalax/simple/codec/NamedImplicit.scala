package net.scalax.simple.codec

import to_list_generic._

trait NamedImplicit[T] {
  def cv: T <:< Product
}

object NamedImplicit {
  type Named[_] = String

  implicit def getImplicit[T <: Product]: NamedImplicit[T] = new NamedImplicit[T] {
    override val cv: T <:< Product = implicitly
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
    val simpleFill: SimpleFill[F] = SimpleFill[F].derived(m)
    val fill = new SimpleFill.FillI[Named] {
      override def fill[T]: String = "Empty"
    }
    val model = simpleFill.fill[Named](fill)

    val names: List[String] = n.cv(model).productElementNames.to(List)

    val de1: ToDecoderGeneric[F]  = ToDecoderGeneric[F].derived(m)
    val de2: ToDecoderGeneric1[F] = ToDecoderGeneric1[F].derived(de1)

    val func = de2.toHList1[({ type T1[U] = List[String] => (List[String], U) })#T1, ({ type T1[_] = String })#T1](monadAdd)(toNamed)

    func(names)._2
  }
}
