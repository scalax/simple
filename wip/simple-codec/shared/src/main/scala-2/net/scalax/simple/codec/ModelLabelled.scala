package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct1

trait ModelLabelled[F[_[_]]] {
  def modelLabelled: F[({ type M1[_] = String })#M1]
}

object ModelLabelled {
  class Builder[F[_[_]]] {
    def derived(simpleNamed: CompatLabelled[F], simpleProduct1: SimpleProduct1.Appender[F]): ModelLabelled[F] = new ModelLabelled[F] {
      override def modelLabelled: F[({ type M1[_] = String })#M1] = CompatLabelled.toLabelled[F](simpleProduct1, simpleNamed)
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
