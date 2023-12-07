package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleName

trait CompatLabelledInstalled[F[_[_]]] {
  def model: F[CompatLabelledInstalled.ToNamed]
}

object CompatLabelledInstalled {

  type ToNamed[_] = Symbol

  class DerivedApply[F[_[_]]] {
    def derived[HTypeTemp](labelled: SimpleName[F[ToNamed], HTypeTemp] with SimpleFrom[F[ToNamed], HTypeTemp]): CompatLabelledInstalled[F] =
      instance(labelled.from(labelled.names))

    def instance(model: F[ToNamed]): CompatLabelledInstalled[F] = {
      val model1 = model
      new CompatLabelledInstalled[F] {
        override val model: F[ToNamed] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
