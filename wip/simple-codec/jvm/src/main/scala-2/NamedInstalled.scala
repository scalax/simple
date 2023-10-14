package net.scalax.simple.codec

import shapeless._

trait NamedInstalled[F[_[_]]] {
  def model: F[NamedInstalled.ToNamedSymbol]
}

object NamedInstalled {
  type ToAny[_]         = Any
  type ToNamed[_]       = String
  type ToNamedSymbol[_] = Symbol

  implicit def derived[F[_[_]], H1 <: HList, H2](implicit
    generic: Generic.Aux[F[ToNamedSymbol], H1],
    toAnyLabelled: DefaultSymbolicLabelling.Aux[F[ToAny], H2],
    cv: H2 <:< H1
  ): NamedInstalled[F] = new NamedInstalled[F] {
    override def model: F[NamedInstalled.ToNamedSymbol] = generic.from(toAnyLabelled.apply())
  }
}
