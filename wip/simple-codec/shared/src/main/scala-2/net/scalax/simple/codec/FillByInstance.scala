package net.scalax.simple.codec

import shapeless._

trait FillByInstance[F[_[_]], I[_]] {
  def model(input: FillByInstance.FillWay[I]): F[I]
}

object FillByInstance {

  trait FillWay[T[_]] {
    def instance[U]: T[U]
    def wrapModel[U]: FillModel[T, U] = FillModel[T, U](instance)
  }
  case class FillModel[F[_], T](model: F[T])

  /*class DerivedApply[
    F[_[_]],
    I[_],
    SymbolModel >: F[SymbolLabelledInstalled.ToNamedSymbol] <: F[SymbolLabelledInstalled.ToNamedSymbol]
  ] {

    def derived[H1 >: H2, H2](implicit generic: Generic.Aux[SymbolModel, H1]): SymbolLabelledInstalled[F] = new SymbolLabelledInstalled[F] {
      override def model: SymbolModel = generic.from(toAnyLabelled.apply())
    }

    object law {
      def apply[Target >: SymbolModel <: SymbolModel]: DerivedApply[F, I, Target] =
        new DerivedApply[F, I, Target]
    }
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I, F[SymbolLabelledInstalled.ToNamedSymbol]] =
    new DerivedApply[F, I, F[SymbolLabelledInstalled.ToNamedSymbol]]*/

}
