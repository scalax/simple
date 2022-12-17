package net.scalax.simple
package wire

import core.Core3_1

trait Wire[M[_]] {
  val fromM: Core3_1[M, cats.Id] = new Core3_1[M, cats.Id] {
    override def apply[T]: M[T] => T = s => unlift(s)
  }
  val toM: Core3_1[cats.Id, M] = new Core3_1[cats.Id, M] {
    override def apply[T]: T => M[T] = s => lift(s)
  }
  def lift[T](i1: T): M[T]
  def unlift[T](i1: M[T]): T
}

object Wire {

  def apply[M[_]: Wire]: Wire[M] = implicitly[Wire[M]]

  implicit val identityWireImplicit: Wire[cats.Id] = new Wire[cats.Id] {
    override def lift[T](i2: T): T   = i2
    override def unlift[T](i1: T): T = i1
  }

}
