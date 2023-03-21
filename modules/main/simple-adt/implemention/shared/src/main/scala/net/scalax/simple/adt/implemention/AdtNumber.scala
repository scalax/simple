package net.scalax.simple
package adt
package implemention

import net.scalax.simple.core.Core2
import net.scalax.simple.adt.core.AdtCoreFactory

object AdtNumber {

  object NumberA {
    val Positive: Core2 = AdtCoreFactory.Number2
    def setZero(doSomething: () => Unit): Core2 = Core2 { other =>
      doSomething()
      AdtCoreFactory.Number1(other)
    }
    val Zero: Core2 = AdtCoreFactory.Number1
  }

  object NumberB {
    def setPositive(doSomething: () => Unit): Core2 = Core2(tail =>
      Core2 { other =>
        doSomething()
        AdtCoreFactory.Number2(tail)(other)
      }
    )
    val Zero: Core2 = AdtCoreFactory.Number1
  }

}
