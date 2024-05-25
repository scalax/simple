package net.scalax.simple
package nat
package number7

sealed trait Number1 {
  def method1(num2: Number2): Number2
}
case class Number1S(tail: Number1) extends Number1 {
  override def method1(num2: Number2): Number2 = num2.method2(tail)
}
case object Number1T extends Number1 {
  override def method1(num2: Number2): Number2 = num2
}

sealed trait Number2 {
  def method2(num1: Number1): Number2
}
case class Number2S(tail: Number2) extends Number2 {
  override def method2(num1: Number1): Number2 = num1.method1(tail)
}
case object Number2T extends Number2 {
  override def method2(num1: Number1): Number2 = Number2T
}
