package net.scalax.simple.codec

import shapeless._

trait NamedImplicit[T] {
  def input: HList
}

object NamedImplicit {
  implicit def namedImplicitImplicit[T](implicit named: DefaultSymbolicLabelling.Aux[T, _ <: HList]): NamedImplicit[T] =
    new NamedImplicit[T] {
      override val input: HList = named.apply()
    }
}
