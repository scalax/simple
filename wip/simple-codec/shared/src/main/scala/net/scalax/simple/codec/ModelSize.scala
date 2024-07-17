package net.scalax.simple.codec

trait ModelSize[F[_[_]]] {
  def modelSize: Int
}

object ModelSize {

  class DerivedApply[F[_[_]]] {

    def caseClass(model: F[CompatLabelled.CompatNamed])(implicit cv: F[CompatLabelled.CompatNamed] <:< Product): ModelSize[F] =
      new ModelSize[F] {
        override val modelSize: Int = model.productArity
      }

  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F] {
    //
  }

}
