package net.scalax.simple.codec

object CirceAlias {
  type JsonObjectEncoder[T] = io.circe.ObjectEncoder[T]
  val JsonObjectEncoder: io.circe.ObjectEncoder.type = io.circe.ObjectEncoder
}
