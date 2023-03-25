package net.scalax.simple
package nat
package number5

sealed trait Number1 {
  def method1(num2: Number2): Number3
}

case class Number1S(tail: Number1) extends Number1 {
  override def method1(num2: Number2): Number3 = num2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(num2: Number2): Number3 = Number3T
}

sealed trait Number2 {
  def method2(num1: Number1): Number3
}

case class Number2S(tail: () => Number2) extends Number2 {
  override def method2(num1: Number1): Number3 = num1.method1(tail())
}
case class Number2T(tail: () => Number2) extends Number2 {
  override def method2(num1: Number1): Number3 = Number3S(tail().method2(num1))
}

sealed trait Number3
case class Number3S(tail: Number3) extends Number3
case object Number3T               extends Number3
