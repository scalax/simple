package net.scalax.simple
package codec

import shapeless._
import to_list_generic.{SimpleProduct, SimpleProduct1}

trait NamedImplicit[T] {
  def input[F[_[_]]](cv: F[NamedImplicit.Named] =:= T, appender: SimpleProduct.Appender[F]): List[String]
}

object NamedImplicit {
  type Named[_] = String

  implicit def namedImplicitImplicit[T](implicit named: DefaultSymbolicLabelling.Aux[T, _ <: HList]): NamedImplicit[T] =
    new NamedImplicit[T] {
      override def input[F[_[_]]](cv: F[NamedImplicit.Named] =:= T, appender: SimpleProduct.Appender[F]): List[String] =
        toNamedModel(named.apply())
    }

  private def toNamedModel[F[_[_]]](n: HList): List[String] = {
    def toList(l: HList): List[String] = l match {
      case s: shapeless.::[_, HList] => s.head.asInstanceOf[Symbol].name :: toList(s.tail)
      case HNil                      => List.empty
    }

    toList(n)
  }
}
