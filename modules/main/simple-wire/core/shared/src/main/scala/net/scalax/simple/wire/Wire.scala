package net.scalax.simple
package wire

import core.Core3_1

trait Wire[M[_]] extends Core3_1[M, cats.Id] {
  override def apply[T]: M[T] => T
}

object Wire {

  def apply[M[_]: Wire]: Wire[M] = implicitly[Wire[M]]

  implicit val identityWireImplicit: Wire[cats.Id] = new Wire[cats.Id] {
    override def apply[T]: T => T = t => t
  }

}
