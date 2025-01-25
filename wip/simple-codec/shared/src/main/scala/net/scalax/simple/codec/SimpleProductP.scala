package net.scalax.simple.codec
package to_list_generic
import net.scalax.simple.codec

trait SimpleProductX[F[_[_]]] {
  def model: SimpleProductXImpl.NotHList.Appender[F]
}

object SimpleProductX {
  class Builder[F[_[_]]] {
    def derived(t: AppenderFromSize[F], modelSize: ModelSize[F]): SimpleProductX[F] = t.inputModelSizeF(modelSize)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
