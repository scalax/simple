package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleNamed
import net.scalax.simple.codec.to_list_generic.SimpleProduct

trait CompatLabelled[F[_[_]]] {
  def modelLabelled: F[CompatLabelled.CompatNamed]
}

object CompatLabelled {
  type CompatNamed[_] = String

  def toLabelled[F[_[_]]](simpleProduct: SimpleProduct.Appender[F], compat: CompatLabelled[F]): ModelLabelled[F] = new ModelLabelled[F] {
    override def modelLabelled: F[({ type M1[_] = String })#M1] = compat.modelLabelled
  }

  trait Apply[F[_[_]]] {
    def derived(
      simpleNamed: SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]] with SimpleFrom[F[({ type AnyF[_] = Any })#AnyF]]
    ): CompatLabelled[F] = new CompatLabelled[F] {
      override val modelLabelled: F[CompatNamed] = simpleNamed.from(simpleNamed.labelled).asInstanceOf[F[CompatNamed]]
    }
  }

  def apply[F[_[_]]]: Apply[F] = new Apply[F] {
    //
  }
}
