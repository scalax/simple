package net.scalax.simple
package wire

import core.Core3

trait Wire[M[_]] extends Core3[M] {
  override def from[T](i2: T): M[T]
  override def to[T](i1: M[T]): T
}

object Wire {

  def apply[M[_]: Wire]: Wire[M] = implicitly[Wire[M]]

  trait WireImpl[M[_]] {
    def wireInstance: Wire [M]
    def lift[T](t: T):M[T]
  }

  implicit val identityWireImplicit: Wire[cats.Id] = new Wire[cats.Id] {
    override def from[T](i2: T): T = i2
    override def to[T](i1: T): T   = i1
  }

}
