package net.scalax.simple
package nat
package number12

import net.scalax.simple.core.Core2

object Number1 {

  val number1: Core2 = Core2(tail => tail())
  val number2: Core2 = Core2(tail => Core2(other => other()(tail)))
  val number3: Core2 = Core2(tail => Core2(other => tail()(other)))

}
