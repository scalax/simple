package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.ToDecoderGeneric

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.Named]
}

object LabelledInstalled {

  type Named[_] = String

  private val compatFunc: CompatLabelledInstalled.CompatType => String = CompatLabelledInstalled.compatToString
  private val compatMapper: MapGenerc.MapImpl[CompatLabelledInstalled.CompatNamed, Named] =
    new MapGenerc.MapImpl[CompatLabelledInstalled.CompatNamed, Named] {
      override def map[U]: CompatLabelledInstalled.CompatType => String = compatFunc
    }

  class DerivedApply[F[_[_]]] {
    def derived(implicit basedInstalled: BasedInstalled[F]): LabelledInstalled[F] = {
      val mapG: MapGenerc[F] = MapGenerc[F].derived(basedInstalled)
      val ins                = mapG.map(compatMapper)(basedInstalled.labelled)
      instance(ins)
    }

    def instance(model: F[Named]): LabelledInstalled[F] = {
      val model1 = model
      new LabelledInstalled[F] {
        override val model: F[Named] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
