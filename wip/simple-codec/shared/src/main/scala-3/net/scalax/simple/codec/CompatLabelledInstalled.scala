package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleName

trait CompatLabelledInstalled[F[_[_]]] {
  def model: F[CompatLabelledInstalled.CompatNamed]
}

object CompatLabelledInstalled {

  type CompatType     = String
  type CompatNamed[_] = CompatType

  def compatToString(n: CompatType): String = n

  class DerivedApply[F[_[_]]] {
    def derived[HTypeTemp](
      labelled: SimpleName[F[CompatNamed], HTypeTemp] with SimpleFrom[F[CompatNamed], HTypeTemp]
    ): CompatLabelledInstalled[F] =
      instance(labelled.from(labelled.names))

    def instance(model: F[CompatNamed]): CompatLabelledInstalled[F] = {
      val model1 = model
      new CompatLabelledInstalled[F] {
        override val model: F[CompatNamed] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
