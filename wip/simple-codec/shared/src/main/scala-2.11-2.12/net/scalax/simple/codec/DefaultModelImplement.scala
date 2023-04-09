package net.scalax.simple
package codec

import shapeless.Lazy

object DefaultModelImplement {
  implicit def aaI[T](implicit v: Lazy[T]): ModelImplement[DefaultModelImplement.type, T] =
    new ModelImplement[DefaultModelImplement.type, T](v.value)
}
