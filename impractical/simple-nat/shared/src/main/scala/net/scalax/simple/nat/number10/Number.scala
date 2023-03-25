package net.scalax.simple
package nat
package number10

import core.Core2

object Number extends App {

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  object JiShu {
    private var init = 0
    def reset: Unit = this.synchronized {
      init = 0
    }
    def up: Unit = this.synchronized {
      init = init + 1
    }
    def get: Int = init
  }

  val otherNumberPositive: Core2 = Core2(tail => Core2(otherNumber => otherNumber()(tail)))
  val otherNumberZero: Core2     = Core2(otherNumberPositive => otherNumberPositive())

  val SPositive1: Core2 = Core2(tail =>
    Core2 { otherNumber =>
      otherNumber()(tail)
    }
  )
  val SPositive2: Core2 = Core2(tail =>
    Core2 { otherNumber =>
      otherNumber()(tail)
    }
  )
  val SPositive3: Core2 = Core2(tail =>
    Core2 { otherNumber =>
      otherNumber()(tail)
    }
  )
  val SPositive4: Core2 = Core2(tail =>
    Core2 { otherNumber =>
      otherNumber()(tail)
    }
  )
  val SPositiveZero: Core2 = Core2(tail =>
    Core2 { otherNumber =>
      JiShu.up
      tail()(otherNumber)
    }
  )

  lazy val number2: Core2     = SPositive1(() => SPositive2(() => SPositive3(() => SPositive4(() => number2Impl))))
  lazy val number2Impl: Core2 = SPositiveZero(() => number2)

  for (i <- 1 to 100) {
    var num1 = otherNumberZero
    for (_ <- 1 to i) {
      val num1Temp = num1
      num1 = otherNumberPositive(() => num1Temp)
    }
    JiShu.reset
    number2(() => num1)
    val bb = JiShu.get
    println((i, 4, bb, i / 4))
    assert(bb == i / 4)
  }

}
