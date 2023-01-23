package net.scalax.simple
package nat
package number4

object Number {

  type Core2 = core.Core2

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2      = Core2(tail1 => Core2(tail2 => Core2(tail3 => tail1()(() => tail2())(() => tail3()))))
  val T: Core2      = Core2(tail1 => Core2(tail2 => Core2(tail3 => S(tail2)(tail1)(tail3))))
  val U: Core2      = Core2(tail1 => Core2(tail2 => Core2(tail3 => S(tail3)(tail2)(tail1))))
  val SCount: Core2 = Core2(tail1 => Core2(tail2 => Core2(tail3 => NumberPositive(() => S(tail1)(tail2)(tail3)))))

  val numbersZero: Number.Core2 = Number.S(() => numbersZero)

  case class NumberPositive(tail: () => Core2) extends Core2 {
    override def apply(f: () => Core2): Core2 = throw new Exception
  }

}
