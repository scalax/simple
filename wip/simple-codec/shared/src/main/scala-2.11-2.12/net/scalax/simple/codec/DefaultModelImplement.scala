package net.scalax.simple
package codec

import shapeless.Lazy

object DefaultModelImplement {
  implicit def aaII[P, T](implicit v: Lazy[T]): ModelImplement[P, T] = new ModelImplement[P, T](v.value)
}
