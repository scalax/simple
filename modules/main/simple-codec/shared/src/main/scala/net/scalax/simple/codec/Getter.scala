package net.scalax.simple
package codec

import scala.collection.compat._

trait Getter[F[_[_]]] {
  def output[H[_]](model: F[H]): List[Any]
}

object Getter {
  def get[F[_[_]] <: Product]: Getter[F] = new Getter[F] {
    override def output[H[_]](model: F[H]): List[Any] = model.productIterator.to(List)
  }
}
