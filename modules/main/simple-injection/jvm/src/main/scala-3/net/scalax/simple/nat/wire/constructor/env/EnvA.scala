package net.scalax.simple.nat.wire
package constructor
package env

case class EnvA[T](value: T)

object EnvA:

  given [T]: Getter[EnvA] = new Getter[EnvA]:
    override def get[T](model: EnvA[T]): T = model.value
    override def lift[T](m: T): EnvA[T]    = EnvA(m)

end EnvA
