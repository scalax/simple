package net.scalax.simple.codec

trait ModelSize[F[_[_]]] {
  def modelSize: Int
}

object ModelSize {

  class DerivedApply[F[_[_]]] {

    def derived(size: Int): ModelSize[F] = new ModelSize[F] {
      override val modelSize: Int = size
    }

  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F] {
    //
  }

}
