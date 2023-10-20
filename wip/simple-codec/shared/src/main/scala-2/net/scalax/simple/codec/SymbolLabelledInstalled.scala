package net.scalax.simple.codec

import shapeless._

trait SymbolLabelledInstalled[F[_[_]]] {
  def model: F[SymbolLabelledInstalled.ToNamedSymbol]
}

object SymbolLabelledInstalled {

  type ToNamedSymbol[_] = Symbol

  class DerivedApply[F[_[_]], SymbolModel <: F[SymbolLabelledInstalled.ToNamedSymbol], AnyModel] {
    def derived[H1 >: H2, H2](implicit
      generic: Generic.Aux[SymbolModel, H1],
      toAnyLabelled: DefaultSymbolicLabelling.Aux[AnyModel, H2]
    ): SymbolLabelledInstalled[F] = new SymbolLabelledInstalled[F] {
      override def model: SymbolModel = generic.from(toAnyLabelled.apply())
    }

    object law {
      def apply[Target <: F[SymbolLabelledInstalled.ToNamedSymbol]]: DerivedApply[F, Target, Target] =
        new DerivedApply[F, Target, Target]
    }
  }

  def apply[F[_[_]]]: DerivedApply[F, F[SymbolLabelledInstalled.ToNamedSymbol], F[SymbolLabelledInstalled.ToNamedSymbol]] =
    new DerivedApply[F, F[SymbolLabelledInstalled.ToNamedSymbol], F[SymbolLabelledInstalled.ToNamedSymbol]]

}
