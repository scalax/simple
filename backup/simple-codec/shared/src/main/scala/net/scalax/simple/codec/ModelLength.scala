package net.scalax.simple
package codec

import scala.collection.compat._

trait ModelLength[F[_[_]]] {
  def length: Int
}

object ModelLength {
  def apply[F[_[_]]]: ModelLengthImpl[F] = new ModelLengthImpl[F]

  class ModelLengthImpl[F[_[_]]] {
    def generic(implicit n: EmptyTagModelFiller[F], getter: Getter[F]): ModelLength[F] = new ModelLength[F] {
      override val length: Int = getter.output[ContextI#EmptyTagF](n.instance).size
    }
  }
}
