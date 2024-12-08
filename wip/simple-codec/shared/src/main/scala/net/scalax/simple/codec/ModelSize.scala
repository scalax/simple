package net.scalax.simple.codec

trait ModelSize[F[_[_]]] {
  def modelSize: Int
}
