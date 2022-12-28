package net.scalax.simple.wire
package constructor
package env

case class EnvB[T](value: T)

object EnvB {

  implicit val wireEnvB: Wire[EnvB] = new Wire[EnvB] {
    override def apply[T]: EnvB[T] => T = i1 => i1.value
  }

}
