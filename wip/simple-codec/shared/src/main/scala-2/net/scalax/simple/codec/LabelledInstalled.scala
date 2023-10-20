package net.scalax.simple.codec

import shapeless._

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.ToNamed]
}

object LabelledInstalled {
  trait SymbolHListToStringHList[H1, H2] {
    def to(h1: H1): H2
  }
  object SymbolHListToStringHList {

    implicit def implicit1[H1 <: HList, H2 <: HList](implicit
      cv: SymbolHListToStringHList[H1, H2]
    ): SymbolHListToStringHList[Symbol :: H1, String :: H2] = new SymbolHListToStringHList[Symbol :: H1, String :: H2] {
      override def to(h1: Symbol :: H1): String :: H2 = h1.head.name :: cv.to(h1.tail)
    }
    implicit val implicit2: SymbolHListToStringHList[HNil, HNil] = new SymbolHListToStringHList[HNil, HNil] {
      override def to(h: HNil): HNil = h
    }
  }

  trait DerivedApply[F[_[_]], SymbolModel <: F[SymbolLabelledInstalled.ToNamedSymbol], NamedModel <: F[ToNamed]] {
    def symbolLabelledInstalled: SymbolModel

    def derived[H1, H2](implicit
      generic1: Generic.Aux[SymbolModel, H1],
      generic2: Generic.Aux[NamedModel, H2],
      shTosh: SymbolHListToStringHList[H1, H2]
    ): LabelledInstalled[F] = new LabelledInstalled[F] {
      override def model: NamedModel = generic2.from(shTosh.to(generic1.to(symbolLabelledInstalled)))
    }

    object law {
      def apply[SymbolModelImpl >: SymbolModel <: F[SymbolLabelledInstalled.ToNamedSymbol], NamedModelIml >: NamedModel <: F[ToNamed]]
        : DerivedApply[F, SymbolModelImpl, NamedModelIml] = {
        val symbolLabelledInstalled1 = symbolLabelledInstalled
        new DerivedApply[F, SymbolModelImpl, NamedModelIml] {
          override def symbolLabelledInstalled: SymbolModelImpl = symbolLabelledInstalled1
        }
      }

    }
  }

  type ToNamed[_] = String

  def apply[F[_[_]]](implicit
    symbolLabelledInstalled: SymbolLabelledInstalled[F]
  ): DerivedApply[F, F[SymbolLabelledInstalled.ToNamedSymbol], F[ToNamed]] = {
    val symbolLabelledInstalled1 = symbolLabelledInstalled
    new DerivedApply[F, F[SymbolLabelledInstalled.ToNamedSymbol], F[ToNamed]] {
      override def symbolLabelledInstalled: F[SymbolLabelledInstalled.ToNamedSymbol] = symbolLabelledInstalled1.model
    }
  }

}
