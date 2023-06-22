package net.scalax.simple.codec

import scala.collection.compat._

trait ModelLength[F[_[_]]] {
  def size: Int
}

object ModelLength {
  def generic[F[_[_]] <: Product](p: F[PropertyTag], getter: ModelGetter[F]): ModelLength[F] = {
    val sizeImpl = getter.data(p)
    new ModelLength[F] {
      override val size: Int = sizeImpl.size
    }
  }
}
