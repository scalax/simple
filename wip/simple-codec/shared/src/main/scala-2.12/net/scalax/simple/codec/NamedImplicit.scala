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
    def addToList(t: List[String], n: String): List[String] = n :: t

    def toList(l: HList): List[String] = l match {
      case (s: Symbol) :: tail => addToList(toList(tail), s.name)
      case HNil                => List.empty
    }

    toList(n)
  }
}
