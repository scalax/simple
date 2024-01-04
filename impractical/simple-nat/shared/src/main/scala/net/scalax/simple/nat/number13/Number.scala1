package net.scalax.simple
package nat
package number13

sealed trait Number1 {
  def method(other: Number1): Number2
}
case class Number1S(tail: () => Number1) extends Number1 {
  override def method(other: Number1): Number2 = other.method(tail())
}
case class Number1T(tail: () => Number1) extends Number1 {
  override def method(other: Number1): Number2 = Number2A(() => tail().method(other))
}
case class Number1U(tail: () => Number1) extends Number1 {
  override def method(other: Number1): Number2 = Number2B(() => tail().method(other))
}
case class Number1V(tail: () => Number1) extends Number1 {
  override def method(other: Number1): Number2 = Number2B(() => other.method(tail()))
}

sealed trait Number2
case class Number2A(tail: () => Number2) extends Number2
case class Number2B(tail: () => Number2) extends Number2
