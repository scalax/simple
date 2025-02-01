package net.scalax.simple.codec

trait ModelLabelled[F[_[_]]] {
  def modelLabelled: F[({ type M1[_] = String })#M1]
}

object ModelLabelled {
  class Builder[F[_[_]]] {
    def derived(simpleNamed: CompatLabelled[F], simpleProduct1: FromListByTheSameTypeGeneric[F]): ModelLabelled[F] = new ModelLabelled[F] {
      override val modelLabelled: F[({ type M1[_] = String })#M1] = CompatLabelled[F].toLabelled(simpleProduct1, simpleNamed)
    }

    def instance(n: F[({ type M1[_] = String })#M1]): ModelLabelled[F] = new ModelLabelled[F] {
      override val modelLabelled: F[({ type M1[_] = String })#M1] = n
    }

    @inline def implicitly(implicit modelSize: ModelLabelled[F]): ModelLabelled[F] = modelSize
  }

  @inline def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
