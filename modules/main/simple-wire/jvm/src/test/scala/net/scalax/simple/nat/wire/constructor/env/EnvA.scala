package net.scalax.simple.wire
package constructor
package env

case class EnvA[T](value: T)

object EnvA {

  implicit val wireEnvA: Wire[EnvA] = new Wire[EnvA] {
    override def unlift[T](i1: EnvA[T]): T = i1.value
  }

}
