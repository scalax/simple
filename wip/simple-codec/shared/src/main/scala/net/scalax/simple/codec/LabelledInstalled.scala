package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.ToDecoderGeneric2222

object LabelledInstalled {

  type Named[_] = String

  /*private val compatFunc: CompatLabelledInstalled.CompatType => String = CompatLabelledInstalled.compatToString
  private val compatMapper: MapGenerc.MapImpl[CompatLabelledInstalled.CompatNamed, Named] =
    new MapGenerc.MapImpl[CompatLabelledInstalled.CompatNamed, Named] {
      override def map[U]: CompatLabelledInstalled.CompatType => String = compatFunc
    }*/

  class DerivedApply[F[_[_]]] {
    def derived(implicit m: ToDecoderGeneric2222[F], n: NamedImplicit[F[Named]]): F[Named] = NamedImplicit.toNamedModel[F](m, n)
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
