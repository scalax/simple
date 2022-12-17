package net.scalax.simple.wire
package constructor
package env

case class EnvB[T](value: T)

object EnvB:

  given [T]: Wire[EnvB] = new Wire[EnvB] {
    override def lift[T](i2: T): EnvB[T]   = EnvB(i2)
    override def unlift[T](i1: EnvB[T]): T = i1.value
  }

end EnvB
