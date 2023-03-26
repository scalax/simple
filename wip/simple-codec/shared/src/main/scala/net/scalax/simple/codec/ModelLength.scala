package net.scalax.simple
package codec

import scala.collection.compat._

trait ModelLength[F[_[_]]] {
  def length: Int
}

object ModelLength {
  def apply[F[_[_]]]: ModelLengthImpl[F] = new ModelLengthImpl[F]

  class ModelLengthImpl[F[_[_]]] {
    def generic(implicit n: EmptyTagModelFiller[F], cv: F[ContextI#Tag] <:< Product): ModelLength[F] = new ModelLength[F] {
      override val length: Int = n.instance.productIterator.to(List).size
    }
  }
}
