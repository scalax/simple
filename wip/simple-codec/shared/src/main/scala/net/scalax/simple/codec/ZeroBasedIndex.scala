package net.scalax.simple.codec

import scala.collection.compat._

trait ZeroBasedIndex[F[_[_]]] {
  def instance: ContextO[F]#IntegerF
}

object ZeroBasedIndex {
  def apply[F[_[_]]]: ZeroBasedIndexImpl[F] = new ZeroBasedIndexImpl[F]

  class ZeroBasedIndexImpl[F[_[_]]] {
    def generic(implicit sizeI: ModelLength[F], setter: Setter[F]): ZeroBasedIndex[F] = new ZeroBasedIndex[F] {
      override val instance: ContextO[F]#IntegerF = setter.input[ContextI#Integer](list = 0 to sizeI.length - 1)
    }
  }
}
