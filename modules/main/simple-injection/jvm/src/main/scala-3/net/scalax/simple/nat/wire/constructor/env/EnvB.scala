package net.scalax.simple.nat.wire
package constructor
package env

case class EnvB[T](value: T)

object EnvB:

  given [T]: Getter[EnvB] = new Getter[EnvB]:
    override def get[T](model: EnvB[T]): T = model.value
    override def lift[T](m: T): EnvB[T]    = EnvB(m)

end EnvB
