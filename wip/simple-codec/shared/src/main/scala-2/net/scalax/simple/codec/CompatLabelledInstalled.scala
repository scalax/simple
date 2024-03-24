package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleName

object CompatLabelledInstalled {

  type CompatType     = Symbol
  type CompatNamed[_] = CompatType

  def compatToString(n: CompatType): String = n.name

  class DerivedApply[F[_[_]]] {
    def derived[HTypeTemp](labelled: SimpleName[F[CompatNamed], HTypeTemp] with SimpleFrom[F[CompatNamed], HTypeTemp]): F[CompatNamed] =
      labelled.from(labelled.names)
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
