package net.scalax.simple
package wire

import core.Core3

trait Wire[M[_]] extends Core3[M] {
  override def from[T](i2: T): M[T]
  override def to[T](i1: M[T]): T
}

object Wire {

  def apply[M[_]: Wire]: WireImpl[M] = new WireImplInstance[M]

  trait WireImpl[M[_]] {
    def lift[T](t: T): M[T]
    def unlift[T](mt: M[T]): T
  }
  private class WireImplInstance[M[_]](implicit wireInstance: Wire[M]) extends WireImpl[M] {
    override def lift[T](t: T): M[T]    = wireInstance.from(t)
    override def unlift[T](mt: M[T]): T = wireInstance.to(mt)
  }

  implicit val identityWireImplicit: Wire[cats.Id] = new Wire[cats.Id] {
    override def from[T](i2: T): T = i2
    override def to[T](i1: T): T   = i1
  }

}
