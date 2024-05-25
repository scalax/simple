package net.scalax.simple
package nat
package number1

import core.Core2

object Number {

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2 = Core2(tail => Core2(number => tail()(() => number())))
  val T: Core2 = Core2(tail => Core2(number => number()(() => tail())))

}
