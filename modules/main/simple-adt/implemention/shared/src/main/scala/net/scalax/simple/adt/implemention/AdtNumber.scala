package net.scalax.simple
package adt
package implemention

import net.scalax.simple.core.Core2
import net.scalax.simple.adt.core.AdtCoreFactory

object AdtNumber {

  object NumberA {
    def setPositive(tail: Core2): Core2 = Core2(other => AdtCoreFactory.Number2(() => tail)(other))
    def setZero(doSomething: () => Unit): Core2 = Core2 { other =>
      doSomething()
      AdtCoreFactory.Number2(other)
    }
  }

  object NumberB {
    def setPositive(doSomething: () => Unit, tail: Core2): Core2 = Core2 { other =>
      doSomething()
      AdtCoreFactory.Number2(() => tail)(other)
    }
    val setZero: Core2 = AdtCoreFactory.Number1
  }

}
