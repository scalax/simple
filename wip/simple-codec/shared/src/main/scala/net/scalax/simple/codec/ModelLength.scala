package net.scalax.simple.codec

import scala.collection.compat._

trait ModelLength[F[_[_]]] {
  def size: Int
}

object ModelLength {
  def generic[F[_[_]] <: Product](implicit p: F[PropertyTag]): ModelLength[F] = {
    val sizeImpl = p.productIterator.to(List)
    new ModelLength[F] {
      override val size: Int = sizeImpl.size
    }
  }
}
