package net.scalax.simple.nat.number14

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {
  val number1S: ghdmzsk = ghdmzsk(tail0 => ghdmzsk(tail1 => ghdmzsk(tail2 => ghdmzsk(tail3 => tail0()(tail1)(tail2)(tail3)))))

  val number2S: ghdmzsk = ghdmzsk(tail0 => ghdmzsk(tail1 => ghdmzsk(tail2 => ghdmzsk(tail3 => tail2()(tail0)(tail3)(tail1)))))
  val number2T: ghdmzsk = ghdmzsk(tail0 => ghdmzsk(tail1 => ghdmzsk(tail2 => ghdmzsk(tail3 => tail1()(tail3)(tail0)(tail2)))))

  var tag1: Int = 0
  var tag2: Int = 0

  val numberPosImpl: ghdmzsk  = ghdmzsk(zero => number2S(() => number2S(() => number2S(() => number2S(() => number2S(zero))))))
  val numberZeroImpl: ghdmzsk = ghdmzsk(zero => number2T(zero))

  lazy val n1Pos: ghdmzsk = number1S { () =>
    tag1 = tag1 + 1
    number1S { () =>
      tag1 = tag1 + 1
      number1S { () =>
        tag1 = tag1 + 1
        number1S { () =>
          tag1 = tag1 + 1
          n1Zero
        }
      }
    }
  }
  lazy val n1Zero: ghdmzsk = numberZeroImpl(() => n1Pos)

  lazy val n2Pos: ghdmzsk  = numberPosImpl(() => n2Zero)
  lazy val n2Zero: ghdmzsk = numberZeroImpl(() => n2Pos)

  lazy val n4Pos: ghdmzsk = numberPosImpl(() => n4Zero)
  lazy val n4Zero: ghdmzsk = numberZeroImpl { () =>
    tag2 = tag2 + 1
    n4Pos
  }

}
