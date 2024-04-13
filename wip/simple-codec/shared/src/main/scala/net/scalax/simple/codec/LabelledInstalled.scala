package net.scalax.simple.codec

object LabelledInstalled {

  type Named[_] = String

  private val compatFunc: CompatLabelledInstalled.CompatType => String = CompatLabelledInstalled.compatToString
  private val compatMapper: MapGenerc.MapImpl[CompatLabelledInstalled.CompatNamed, Named] =
    new MapGenerc.MapImpl[CompatLabelledInstalled.CompatNamed, Named] {
      override def map[U]: CompatLabelledInstalled.CompatType => String = compatFunc
    }

  class DerivedApply[F[_[_]]] {
    def derived(implicit m: BasedInstalled[F], n: NamedImplicit[F[Named]]): F[Named] = {
      val namedModel: F[Named] = NamedImplicit.toNamedModel[F](m.decode2222, n)
      val mapper               = MapGenerc[F].derived(m)
      mapper.map(compatMapper)(m.labelled)
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
