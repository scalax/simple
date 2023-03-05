package net.scalax.simple
package codec

trait ModelLength[F[_[_]]] {
  def length: Int
}
object ModelLength {
  def apply[F[_[_]]](i: Int): ModelLength[F] = new ModelLength[F] {
    override val length: Int = i
  }
  def size[F[_[_]] <: Product](n: NoneModelFiller[F]): ModelLength[F] = ModelLength(n.instance.productArity)
}
