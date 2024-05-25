package net.scalax.simple.codec

import to_list_generic._

trait NamedImplicit[T] {
  def input[F[_[_]]](cv: F[NamedImplicit.Named] =:= T, appender: SimpleProduct.Appender[F]): List[String]
}

object NamedImplicit {
  type Named[_] = String

  implicit def getImplicit[T <: Product]: NamedImplicit[T] = new NamedImplicit[T] {
    override def input[F[_[_]]](cv: F[NamedImplicit.Named] =:= T, appender: SimpleProduct.Appender[F]): List[String] = {
      val simpleFill: SimpleFill[F] = SimpleFill[F].derived(appender)
      val fill = new SimpleFill.FillI[Named] {
        override def fill[T]: String = "Empty"
      }
      val model = cv(simpleFill.fill[Named](fill))
      model.productElementNames.to(List)
    }
  }
}
