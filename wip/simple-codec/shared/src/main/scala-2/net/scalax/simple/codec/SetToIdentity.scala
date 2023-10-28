package net.scalax.simple.codec

import shapeless._

trait SetToIdentity[F[_[_]], I[_]] {
  def model(gen: IdentityGetter.FGen[I]): F[I]
}

object SetToIdentity {

  type ToNamedSymbol[_] = Symbol

  trait SetTo[I[_], From, To] {
    def setTo(gen: IdentityGetter.FGen[I])(from: From): To
  }
  object SetTo {
    implicit def implicit1[I[_], Head1, From1 <: HList, To2 <: HList](implicit
      tailImplicit: SetTo[I, From1, To2]
    ): SetTo[I, IdentityGetter[Head1] :: From1, I[Head1] :: To2] = new SetTo[I, IdentityGetter[Head1] :: From1, I[Head1] :: To2] {
      override def setTo(gen: IdentityGetter.FGen[I])(from: IdentityGetter[Head1] :: From1): I[Head1] :: To2 =
        from.head.model(gen) :: tailImplicit.setTo(gen)(from.tail)
    }

    implicit def implicit2[I[_]]: SetTo[I, HNil, HNil] = new SetTo[I, HNil, HNil] {
      override def setTo(gen: IdentityGetter.FGen[I])(from: HNil): HNil = HNil
    }
  }

  class DerivedApply[
    F[_[_]],
    I[_],
    SymbolModel >: F[IdentityGetter] <: F[IdentityGetter],
    IdModel >: F[I] <: F[I]
  ] {
    def derivedWithContext[H1, H2, H3 <: H2](fim: FillIdentity[F, IdentityGetter])(implicit
      generic: Generic.Aux[SymbolModel, H1],
      setTo: SetTo[I, H1, H3],
      inFromGeneric: Generic.Aux[IdModel, H2]
    ): SetToIdentity[F, I] = new SetToIdentity[F, I] {
      override def model(gen: IdentityGetter.FGen[I]): IdModel = inFromGeneric.from(setTo.setTo(gen)(generic.to(fim.model)))
    }

    object law {
      def apply[Target >: SymbolModel <: SymbolModel, IdModelImpl >: IdModel <: IdModel]: DerivedApply[F, I, Target, IdModelImpl] =
        new DerivedApply[F, I, Target, IdModelImpl]
    }
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I, F[IdentityGetter], F[I]] = new DerivedApply[F, I, F[IdentityGetter], F[I]]

}
