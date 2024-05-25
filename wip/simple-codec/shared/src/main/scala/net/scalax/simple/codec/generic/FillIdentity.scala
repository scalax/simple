package net.scalax.simple
package codec

trait FillIdentity[F[_[_]], I[_]] {
  def model: F[I]
}

object FillIdentity {

  trait FillIdentityGeneric[H1, P] {
    def generic(implicit
      h: utils.impl.FillerId[H1, P]
    ): utils.impl.FillerId[H1, P] = h
  }
  object FillIdentityGeneric {
    def apply[H1, P]: FillIdentityGeneric[H1, P] = new FillIdentityGeneric[H1, P] {
      //
    }
  }

  class DerivedApply[F[_[_]], I[_], Poly] {
    def derived2[H1](generic1: SimpleFrom[F[I], H1]): InnerApply2[F, I, H1, Poly] = new InnerApply2[F, I, H1, Poly](generic1)

    def instance(model: F[I]): FillIdentity[F, I] = {
      val model1 = model
      new FillIdentity[F, I] {
        override val model: F[I] = model1
      }
    }

    def summon(implicit model: FillIdentity[F, I]): FillIdentity[F, I] = model
  }

  class InnerApply2[F[_[_]], I[_], H1, P](simpleFrom: SimpleFrom[F[I], H1]) {
    def apply(f: FillIdentityGeneric[H1, P] => utils.impl.FillerId[H1, P]): F[I] = simpleFrom.from(f(FillIdentityGeneric[H1, P]).value)
  }

  def applyPoly[F[_[_]], I[_], Poly]: DerivedApply[F, I, Poly]             = new DerivedApply[F, I, Poly]
  def apply[F[_[_]], I[_]]: DerivedApply[F, I, DefaultModelImplement.type] = applyPoly[F, I, DefaultModelImplement.type]

}
