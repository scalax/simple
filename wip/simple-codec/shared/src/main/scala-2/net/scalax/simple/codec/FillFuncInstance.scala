package net.scalax.simple.codec

import shapeless._

trait FillFuncInstance[F[_[_]]] {
  def fill[I[_]](identityGetter: IdentityGetter.FGen[I]): F[I]
}

object FillFuncInstance {
  trait SetToIdentity[F[_[_]], I[_]] {
    def model(gen: IdentityGetter.FGen[I]): F[I]
  }

  trait SetTo[I[_], -From, +Target] {
    def setTo(gen: IdentityGetter.FGen[I])(from: From): Target
  }

  trait SetToGeneric[I[_], From] {
    def generic[To](implicit s: SetTo[I, From, To]): SetTo[I, From, To] = s
  }
  object SetToGeneric {
    def apply[I[_], From]: SetToGeneric[I, From] = new SetToGeneric[I, From] {
      //
    }
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

  trait Impl1[F[_[_]]] extends FillFuncInstance[F] {
    def gen[I[_]]: DerivedApply[F, I] => IdentityGetter.FGen[I] => F[I]
    override def fill[I[_]](identityGetter: IdentityGetter.FGen[I]): F[I] = gen(FillFuncInstance[F, I])(identityGetter)
  }

  trait FillIdentityGeneric[F[_[_]]] {
    def generic(implicit fim: FillIdentity[F, IdentityGetter]): F[IdentityGetter] = justInstance(fim.model)
    def justInstance(f: F[IdentityGetter]): F[IdentityGetter]                     = f
  }
  object FillIdentityGeneric {
    def apply[F[_[_]]]: FillIdentityGeneric[F] = new FillIdentityGeneric[F] {
      //
    }
  }

  class DerivedApply[F[_[_]], I[_]] {
    def derived4(g: FillIdentityGeneric[F] => F[IdentityGetter]): ApplyImpl2 = new ApplyImpl2(c = g(FillIdentityGeneric[F]))

    class ApplyImpl2(c: F[IdentityGetter]) {
      def apply[H1](generic: SimpleToGeneric[F[IdentityGetter]] => F[IdentityGetter] => H1): ApplyImpl3[H1] =
        new ApplyImpl3[H1](generic(SimpleToGeneric[F[IdentityGetter]])(c))
    }

    class ApplyImpl3[H1](h1: H1) {
      def apply[H2](t: SetToGeneric[I, H1] => SetTo[I, H1, H2]): ApplyImpl4[H1, H2] = new ApplyImpl4(h1, t(SetToGeneric[I, H1]))
    }

    class ApplyImpl4[H1, H2](h1: H1, to2: SetTo[I, H1, H2]) {
      def apply(fc: SimpleFromGeneric[F[I]] => H2 => F[I]): IdentityGetter.FGen[I] => F[I] = { idenModel =>
        val tempModel = to2.setTo(idenModel)(h1)
        fc(SimpleFromGeneric[F[I]])(tempModel)
      }
    }

  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I] = new DerivedApply[F, I]
}
