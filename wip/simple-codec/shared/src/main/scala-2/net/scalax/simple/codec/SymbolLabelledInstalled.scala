package net.scalax.simple.codec

import shapeless._

trait SymbolLabelledInstalled[F[_[_]]] {
  def model: F[SymbolLabelledInstalled.ToNamedSymbol]
}

object SymbolLabelledInstalled {

  type ToAny[_]         = Any
  type ToNamedSymbol[_] = Symbol

  trait DerivedApply[F[_[_]]] {
    def derived[H1, H2](implicit
      generic: Generic.Aux[F[ToNamedSymbol], H1],
      toAnyLabelled: DefaultSymbolicLabelling.Aux[F[ToAny], H2],
      cv: H2 <:< H1
    ): SymbolLabelledInstalled[F] = new SymbolLabelledInstalled[F] {
      override def model: F[SymbolLabelledInstalled.ToNamedSymbol] = generic.from(toAnyLabelled.apply())
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F] {
    //
  }

}
