package net.scalax.simple
package nat
package number4

object Number {

  type Core2 = core.Core2

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2 = Core2(tail1 => Core2(tail2 => Core2(tail3 => tail1()(tail2)(tail3))))
  val T: Core2 = Core2(tail1 => Core2(tail2 => Core2(tail3 => tail2()(tail1)(tail3))))
  val U: Core2 = Core2(tail1 => Core2(tail2 => Core2(tail3 => tail3()(tail2)(tail1))))

  val numbersZero: Number.Core2 = Core2(tail2 => Core2(tail3 => numbersZero(tail2)(tail3)))

}
