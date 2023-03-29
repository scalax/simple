package net.scalax.simple
package nat
package number12

import ghdmzsk.ghdmzsk

object Number {

  val number1: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => tail()(other)))
  val number2: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => other()(tail)))

}
