package net.scalax.simple
package nat
package number3

object Number {

  type Core2 = core.Core2

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2 = Core2(tail1 => Core2(tail2 => tail1()(tail2)))
  val T: Core2 = Core2(tail1 => Core2(tail2 => tail2()(tail1)))

  val numbersZero: Core2 = Core2(tail1 => numbersZero(tail1))
  val numbertZero: Core2 = Core2(tail1 => tail1()(() => numbertZero))

}
