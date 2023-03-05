package net.scalax.simple
package nat
package injection

object ModelLength {

  trait Length[F[_[_]]] {
    def length: Int
  }
  object Length {
    def apply[F[_[_]]](i: Int): Length[F] = new Length[F] {
      override val length: Int = i
    }
  }

  def size[F[_[_]] <: Product](n: NoneModelFiller[F]): Length[F] = Length(n.instance.productArity)

}
