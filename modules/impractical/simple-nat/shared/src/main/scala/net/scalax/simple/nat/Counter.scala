package net.scalax.simple
package nat

import core.Core2

object NumberImpl {

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2 = Core2(tail => Core2(number => PosotiveCount(() => tail()(() => number()))))
  val T: Core2 = Core2(tail => Core2(number => tail()(() => number())))
  val U: Core2 = Core2(tail => Core2(number => PosotiveCount(() => number()(() => tail()))))
  val V: Core2 = Core2(tail => Core2(number => number()(() => tail())))

  case class PosotiveCount(tail: () => Core2) extends Core2 {
    override def apply(t: () => Core2): Core2 = throw new Exception
  }

}
