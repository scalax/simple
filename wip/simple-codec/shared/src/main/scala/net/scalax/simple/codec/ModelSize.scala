package net.scalax.simple.codec

trait ModelSize[F[_[_]]] {
  def modelSize: Int
}

object ModelSize {
  class Builder[F[_[_]]] {
    def derived(simpleNamed: CompatLabelled[F]): ModelSize[F] = new ModelSize[F] {
      override def modelSize: Int = CompatLabelled.toLobelledSize[F](simpleNamed)
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
