package net.scalax.simple.codec

import shapeless._

trait SymbolLabelledInstalled[F[_[_]]] {
  def model: F[SymbolLabelledInstalled.ToNamedSymbol]
}

object SymbolLabelledInstalled {

  type ToNamedSymbol[_] = Symbol

  trait DerivedApplyImpl[F[_[_]], SymbolModel <: F[SymbolLabelledInstalled.ToNamedSymbol], AnyModel] {
    def derived[H1 >: H2, H2](implicit
      generic: Generic.Aux[SymbolModel, H1],
      toAnyLabelled: DefaultSymbolicLabelling.Aux[AnyModel, H2],
      cv: H2 <:< H1
    ): SymbolLabelledInstalled[F] = new SymbolLabelledInstalled[F] {
      override def model: SymbolModel = generic.from(toAnyLabelled.apply())
    }
  }

  class DerivedApply[F[_[_]]] extends DerivedApplyImpl[F, F[ToNamedSymbol], F[ToNamedSymbol]]

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
