package net.scalax.simple.codec

trait ModelLabelled[F[_[_]]] {
  def modelLabelled: F[({ type M1[_] = String })#M1]
}
