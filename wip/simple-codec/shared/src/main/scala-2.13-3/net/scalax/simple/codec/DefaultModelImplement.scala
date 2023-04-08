package net.scalax.simple
package codec

object DefaultModelImplement {
  implicit def aaI[T](implicit v: => T): ModelImplement[DefaultModelImplement.type, T] =
    new ModelImplement[DefaultModelImplement.type, T](v)
}
