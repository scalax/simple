package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleName

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.ToNamed]
}

object LabelledInstalled {

  type ToNamed[_] = String

  class DerivedApply[F[_[_]]] {
    def derived2[AnyType, HTypeTemp](labelled: SimpleName[AnyType, HTypeTemp]): InnerApply1[F, HTypeTemp] =
      new InnerApply1[F, HTypeTemp](labelled.names)

    def instance(model: F[ToNamed]): LabelledInstalled[F] = {
      val model1 = model
      new LabelledInstalled[F] {
        override val model: F[ToNamed] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  class InnerApply1[F[_[_]], HTemp](genericType: HTemp) {
    def apply(t: SimpleFrom[F[LabelledInstalled.ToNamed], HTemp]): LabelledInstalled[F] =
      new LabelledInstalled[F] {
        def model: F[LabelledInstalled.ToNamed] = t.from(genericType)
      }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
