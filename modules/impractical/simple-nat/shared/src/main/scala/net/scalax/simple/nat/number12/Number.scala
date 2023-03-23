package net.scalax.simple
package nat
package number12

import core.ghdmzsk

object Number {

  val number1: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => tail()(other)))
  val number2: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => other()(tail)))

}
