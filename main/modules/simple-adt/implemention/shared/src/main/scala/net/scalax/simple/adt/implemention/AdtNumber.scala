package net.scalax.simple
package adt
package implemention

import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.factory.AdtCoreFactory

object AdtNumber {

  object NumberA {
    val Positive: ghdmzsk = AdtCoreFactory.Number2
    def setZero(doSomething: () => Unit): ghdmzsk = ghdmzsk { other =>
      doSomething()
      AdtCoreFactory.Number1(other)
    }
    val Zero: ghdmzsk = AdtCoreFactory.Number1
  }

  object NumberB {
    def setPositive(doSomething: () => Unit): ghdmzsk = ghdmzsk(tail =>
      ghdmzsk { other =>
        doSomething()
        AdtCoreFactory.Number2(tail)(other)
      }
    )
    val Zero: ghdmzsk = AdtCoreFactory.Number1
  }

}
