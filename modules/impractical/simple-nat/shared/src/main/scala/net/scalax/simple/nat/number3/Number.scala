package net.scalax.simple
package nat
package number3

object Number {

  type Core2 = core.Core2

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2 = Core2(tail1 => Core2(tail2 => tail1()(() => tail2())))
  val T: Core2 = Core2(tail1 => Core2(tail2 => S(tail2)(tail1)))

  val SImpl: Core2 = Number.Core2(tail => Number.Core2(number => PosotiveCount(() => S(tail)(number))))
  val TImpl: Core2 = Number.Core2(tail => Number.Core2(number => PosotiveCount(() => S(number)(tail))))

  val numbersZero: Core2     = Number.S(() => numbersZero)
  val numbertZero: Core2     = Number.T(() => numbertZero)
  val numbertZeroImpl: Core2 = TImpl(() => numbertZeroImpl)

  case class PosotiveCount(tail: () => Core2) extends Core2 {
    override def apply(t: () => Core2): Core2 = throw new Exception
  }

}
