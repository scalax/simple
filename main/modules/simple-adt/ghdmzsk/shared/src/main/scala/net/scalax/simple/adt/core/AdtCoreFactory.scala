package net.scalax.simple
package adt
package factory

import net.scalax.simple.ghdmzsk.ghdmzsk

object AdtCoreFactory {

  val Number1: ghdmzsk = ghdmzsk(other => other())
  val Number2: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => other()(tail)))

}
