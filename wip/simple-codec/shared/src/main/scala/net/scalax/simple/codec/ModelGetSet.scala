package net.scalax.simple.codec

/*trait ModelGetSet[F[_[_]], Model] extends ModelGet[F, Model] with ModelSet[F, Model] {
  override def toIdentity(t: Model): F[({ type U1[X] = X })#U1]
  override def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model
}*/

@FunctionalInterface
trait ModelGet[F[_[_]], Model] {
  def toIdentity(t: Model): F[({ type U1[X] = X })#U1]
}

@FunctionalInterface
trait ModelSet[F[_[_]], Model] {
  def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model
}
