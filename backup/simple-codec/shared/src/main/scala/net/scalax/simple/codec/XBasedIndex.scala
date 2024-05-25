package net.scalax.simple.codec

trait XBasedIndex[F[_[_]]] {
  def instance: XBasedIndex.Model[ContextO[F]#IntF]
}

object XBasedIndex {
  trait Model[T] {
    def based(i: Int): T
  }

  def apply[F[_[_]]]: ZeroBasedIndexImpl[F] = new ZeroBasedIndexImpl[F]

  class ZeroBasedIndexImpl[F[_[_]]] {
    def generic(implicit sizeI: ModelLength[F], setter: Setter[F]): XBasedIndex[F] = new XBasedIndex[F] {
      override val instance: Model[ContextO[F]#IntF] = new Model[ContextO[F]#IntF] {
        override def based(i: Int): ContextO[F]#IntF = setter.input[ContextI#IntF](list = i to sizeI.length + i - 1)
      }
    }
  }
}
