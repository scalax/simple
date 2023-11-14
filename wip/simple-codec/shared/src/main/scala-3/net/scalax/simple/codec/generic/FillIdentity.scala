package net.scalax.simple.codec

trait FillIdentity[F[_[_]], I[_]] {
  def model: F[I]
}

object FillIdentity {

  trait FillIdentityGeneric[H1] {
    def generic(implicit
      h: utils.impl.GenericBuilder.Aux[H1, DefaultModelImplement.type]
    ): utils.impl.GenericBuilder.Aux[H1, DefaultModelImplement.type] = h
  }
  object FillIdentityGeneric {
    def apply[H1]: FillIdentityGeneric[H1] = new FillIdentityGeneric[H1] {
      //
    }
  }

  class DerivedApply[F[_[_]], I[_]] {
    /*object law {
      def apply[Model >: ModelMode <: ModelMode]: DerivedApply[F, I, Model] = new DerivedApply[F, I, Model]
    }*/

    def derived2[H1](generic1: SimpleFrom[F[I], H1]): InnerApply2[F, I, H1] = new InnerApply2(generic1)

    def instance(model: F[I]): FillIdentity[F, I] = {
      val model1 = model
      new FillIdentity[F, I] {
        override val model: F[I] = model1
      }
    }

    def summon(implicit model: FillIdentity[F, I]): FillIdentity[F, I] = model
  }

  class InnerApply2[F[_[_]], I[_], H1](simpleFrom: SimpleFrom[F[I], H1]) {
    def apply(f: FillIdentityGeneric[H1] => utils.impl.GenericBuilder.Aux[H1, DefaultModelImplement.type]): FillIdentity[F, I] =
      new FillIdentity[F, I] {
        override val model: F[I] = simpleFrom.from(f(FillIdentityGeneric[H1]).value)
      }
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I] = new DerivedApply[F, I]

}
