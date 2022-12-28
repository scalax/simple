package net.scalax.simple.wire
package constructor
package env

case class EnvA[T](value: T)

object EnvA {

  implicit val wireEnvA: Wire[EnvA] = new Wire[EnvA] {
    override def apply[T]: EnvA[T] => T = i1 => i1.value
  }

}
