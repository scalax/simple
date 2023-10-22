package net.scalax.simple.codec

import cats._
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

  class DerivedApply[F[_[_]], SymbolModel >: F[SymbolLabelledInstalled.ToNamedSymbol] <: F[
    SymbolLabelledInstalled.ToNamedSymbol
  ], NamedModel >: F[ToNamed] <: F[ToNamed]] {

    def derived[H1, H2](implicit
      symbolLabelledInstalled: SymbolLabelledInstalled[F],
      generic1: Generic.Aux[SymbolModel, H1],
      generic2: Generic.Aux[NamedModel, H2],
      shTosh: SymbolHListToStringHList[H1, H2]
    ): LabelledInstalled[F] = derivedWithContext(implicitly)

    def derivedWithContext[H1, H2](symbolLabelledInstalled: SymbolLabelledInstalled[F])(implicit
      generic1: Generic.Aux[SymbolModel, H1],
      generic2: Generic.Aux[NamedModel, H2],
      shTosh: SymbolHListToStringHList[H1, H2]
    ): LabelledInstalled[F] = new LabelledInstalled[F] {
      override def model: NamedModel = generic2.from(shTosh.to(generic1.to(symbolLabelledInstalled.model)))
    }

    def instance(model: NamedModel): LabelledInstalled[F] = {
      val model1 = model
      new LabelledInstalled[F] {
        override def model: NamedModel = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model

    object law {
      def apply[SymbolModelImpl >: SymbolModel <: SymbolModel, NamedModelIml >: NamedModel <: NamedModel]
        : DerivedApply[F, SymbolModelImpl, NamedModelIml] = new DerivedApply[F, SymbolModelImpl, NamedModelIml]
    }
  }

  type ToNamed[_] = String

  def apply[F[_[_]]]: DerivedApply[F, F[SymbolLabelledInstalled.ToNamedSymbol], F[ToNamed]] =
    new DerivedApply[F, F[SymbolLabelledInstalled.ToNamedSymbol], F[ToNamed]]

}
