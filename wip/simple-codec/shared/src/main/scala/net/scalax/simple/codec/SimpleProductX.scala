package net.scalax.simple.codec
package to_list_generic

trait SimpleProductX[F[_[_]]] {
  def model: SimpleProductXImpl.NotHList.Appender[F]
}

object SimpleProductX {
  class Builder[F[_[_]]] {
    def derived(from: GenericAuxFrom[F], to: GenericAuxTo[F], modelSize: ModelSize[F]): SimpleProductX[F] =
      AppenderFromSize.tran[F](from, to, modelSize)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
