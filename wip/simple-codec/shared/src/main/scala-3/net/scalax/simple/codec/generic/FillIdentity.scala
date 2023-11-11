package net.scalax.simple.codec

trait FillIdentity[F[_[_]], I[_]] {
  def model: F[I]
}

object FillIdentity {

  class DerivedApply[F[_[_]], I[_]] {
    /*object law {
      def apply[Model >: ModelMode <: ModelMode]: DerivedApply[F, I, Model] = new DerivedApply[F, I, Model]
    }*/

    def derived1[H1](
      generic1: SimpleFrom[F[I], H1]
    )(implicit generic2: utils.impl.GenericBuilder.Aux[H1, DefaultModelImplement.type]): FillIdentity[F, I] =
      new FillIdentity[F, I] {
        override def model: F[I] = generic1.from(generic2.value)
      }

    def instance(model: F[I]): FillIdentity[F, I] = {
      val model1 = model
      new FillIdentity[F, I] {
        override def model: F[I] = model1
      }
    }

    def summon(implicit model: FillIdentity[F, I]): FillIdentity[F, I] = model
  }

  def apply[F[_[_]], I[_]]: DerivedApply[F, I] = new DerivedApply[F, I]

}
