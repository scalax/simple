package net.scalax.simple.codec

import scala.collection.compat._

trait ModelGetter[F[_[_]]] {
  def data[U[_]](model: F[U]): List[Any]
}

object ModelGetter {
  def generic[F[_[_]] <: Product]: ModelGetter[F] = {
    new ModelGetter[F] {
      override def data[U[_]](model: F[U]): List[Any] = model.productIterator.to(List)
    }
  }
}
