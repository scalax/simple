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

  type ToNamed[_] = String

  implicit def derived[F[_[_]], H1, H2](implicit
    symbolLabelledInstalled: SymbolLabelledInstalled[F],
    generic1: Generic.Aux[F[SymbolLabelledInstalled.ToNamedSymbol], H1],
    generic2: Generic.Aux[F[ToNamed], H2],
    shTosh: SymbolHListToStringHList[H1, H2]
  ): LabelledInstalled[F] = new LabelledInstalled[F] {
    override def model: F[LabelledInstalled.ToNamed] = generic2.from(shTosh.to(generic1.to(symbolLabelledInstalled.model)))
  }
}
