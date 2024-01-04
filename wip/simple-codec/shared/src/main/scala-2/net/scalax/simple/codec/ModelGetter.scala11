package net.scalax.simple.codec

trait IdentityGetter[U] {
  def model[F[_]](gen: IdentityGetter.FGen[F]): F[U]
}

object IdentityGetter {

  trait FGen[F[_]] {
    def gen[U]: F[U]
  }

  implicit def implicit1[U]: IdentityGetter[U] = new IdentityGetter[U] {
    override def model[F[_]](gen: IdentityGetter.FGen[F]): F[U] = gen.gen
  }

}
