package net.scalax.simple
package codec

object DefaultModelImplement {
  implicit def aaII[PolyInstance, T](implicit v: => T): ModelImplement[PolyInstance, T] =
    new ModelImplement[PolyInstance, T](v)
}
