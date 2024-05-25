package net.scalax.simple.codec

import io.circe.Encoder

object CirceAlias {
  type JsonObjectEncoder[T] = Encoder.AsObject[T]
  val JsonObjectEncoder: Encoder.AsObject.type = Encoder.AsObject
}
