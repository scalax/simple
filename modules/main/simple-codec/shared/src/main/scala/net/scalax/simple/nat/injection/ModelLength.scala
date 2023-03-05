package net.scalax.simple
package codec

trait ModelLength[F[_[_]]] {
  def length: Int
}
object ModelLength {
  def apply[F[_[_]]](i: Int): ModelLength[F] = new ModelLength[F] {
    override val length: Int = i
  }
  def fill[F[_[_]]](implicit n: NoneModelFiller[F], u: ContextO[F]#NoneF <:< Product): ModelLength[F] = ModelLength(n.instance.productArity)
}
