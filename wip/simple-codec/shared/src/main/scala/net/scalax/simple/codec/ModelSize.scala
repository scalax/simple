package net.scalax.simple.codec

trait ModelLabelled[F[_[_]]] {
  def modelLabelled: List[String]
}
