package net.scalax.simple.codec.generic

import shapeless._

trait SimpleName[+Model, +HList] {
  def names: HList
}

trait SimpleNameGeneric[Model] {

  def generic[H1, H2](implicit
    g: DefaultSymbolicLabelling.Aux[Model, H1],
    inOut: SimpleNameGeneric.SymbolHListToStringHList[H1, H2]
  ): SimpleName[Model, H2] =
    new SimpleName[Model, H2] {
      override def names: H2 = inOut.to(g.apply())
    }

  def law[ModelImpl >: Model <: Model]: SimpleNameGeneric[ModelImpl] = SimpleNameGeneric[ModelImpl]

}

object SimpleNameGeneric {
  trait SymbolHListToStringHList[-H1, +H2] {
    def to(h1: H1): H2
  }

  object SymbolHListToStringHList {
    implicit def implicit1[H1 <: HList, H2 <: HList](implicit
      cv: SymbolHListToStringHList[H1, H2]
    ): SymbolHListToStringHList[Symbol :: H1, String :: H2] = new SymbolHListToStringHList[Symbol :: H1, String :: H2] {
      override def to(in: Symbol :: H1): String :: H2 = in.head.name :: cv.to(in.tail)
    }

    implicit val implicit2: SymbolHListToStringHList[HNil, HNil] = new SymbolHListToStringHList[HNil, HNil] {
      override def to(in: HNil): HNil = in
    }
  }

  def apply[T]: SimpleNameGeneric[T] = new SimpleNameGeneric[T] {
    //
  }
}
