package net.scalax.simple
package nat
package number8

import core.Core2

sealed trait Number1 extends Core2 {
  override def input(num2: => Core2): Number2
}
case class Number1S(tail: Number1) extends Number1 {
  override def input(num2: => Core2): Number2 = num2.asInstanceOf[Number2].input(tail)
}
case object Number1T extends Number1 {
  override def input(num2: => Core2): Number2 = num2.asInstanceOf[Number2]
}

sealed trait Number2 extends Core2 {
  override def input(num1: => Core2): Number2
}
case class Number2S(tail: Number2) extends Number2 {
  override def input(num1: => Core2): Number2 = num1.input(tail).asInstanceOf[Number2]
}
case object Number2T extends Number2 {
  override def input(num1: => Core2): Number2 = Number2T
}
trait Number2U extends Number2 {
  override def input(num1: => Core2): Number2 = this
}
