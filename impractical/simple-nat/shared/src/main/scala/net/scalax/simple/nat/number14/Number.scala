package net.scalax.simple.nat.number14

trait Number1 {
  def method(other: Number2): Number3
}
case class Number1S(tail: () => Number1) extends Number1 {
  override def method(other: Number2): Number3 = other.method(tail())
}
case class Number1T(tail: () => Number1) extends Number1 {
  override def method(other: Number2): Number3 = Number3A(() => tail().method(other))
}

trait Number2 {
  def method(other: Number1): Number3
}
case class Number2S(tail: () => Number1) extends Number2 {
  override def method(other: Number1): Number3 = other.method(tail())
}
case class Number2T(tail: () => Number1) extends Number2 {
  override def method(other: Number1): Number3 = Number2A(() => tail().method(other))
}
case class Number2U(tail: () => Number1) extends Number2 {
  override def method(other: Number1): Number3 = Number2B(() => tail().method(other))
}
case class Number2V(tail: () => Number1) extends Number2 {
  override def method(other: Number1): Number3 = Number2B(() => other.method(tail()))
}

sealed trait Number3
case class Number3A(tail: () => Number3) extends Number3
case class Number3B(tail: () => Number3) extends Number3
