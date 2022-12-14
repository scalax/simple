package net.scalax.simple.wire
package constructor
package env

case class EnvA[T](value: T)

object EnvA:

  given [T]: Wire[EnvA] = new Wire[EnvA] {
    override def from[T](i2: T): EnvA[T] = EnvA(i2)
    override def to[T](i1: EnvA[T]): T   = i1.value
  }

end EnvA
