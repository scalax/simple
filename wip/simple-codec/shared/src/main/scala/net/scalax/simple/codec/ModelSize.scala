package net.scalax.simple.codec

trait ModelSize[F[_[_]]] {
  def modelSize: Int
}

object ModelSize {
  class Builder[F[_[_]]] {
    @inline def derived(simpleNamed: CompatLabelled[F]): ModelSize[F] = instance(CompatLabelled[F].toLobelledSize(simpleNamed))

    @inline def instance(sizeN: Int): ModelSize[F] = new ModelSize[F] {
      override val modelSize: Int = sizeN
    }

    @inline def implicitly(implicit modelSize: ModelSize[F]): ModelSize[F] = modelSize
  }

  @inline def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
