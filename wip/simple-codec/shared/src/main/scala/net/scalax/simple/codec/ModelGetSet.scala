package net.scalax.simple.codec

trait ModelGetSet[F[_[_]], Model] {
  def toIdentity(t: Model): F[({ type U1[X] = X })#U1]
  def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model
}
