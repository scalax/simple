package net.scalax.simple.nat.number14

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {
  val number1S: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => num1Tail()(num2)(num3)(num4)))))
  val number1T: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => num2()(num3)(num4)(num1Tail)))))

  val number2S: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num1 => num1()(num2Tail)(num3)(num4)))))
  val number2T: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num1 => num3()(num4)(num1)(num2Tail)))))

  val number3S: ghdmzsk = ghdmzsk(num3Tail => ghdmzsk(num4 => ghdmzsk(num1 => ghdmzsk(num2 => num2()(num3Tail)(num4)(num1)))))
  val number3T: ghdmzsk = ghdmzsk(num3Tail => ghdmzsk(num4 => ghdmzsk(num1 => ghdmzsk(num2 => num4()(num1)(num2)(num3Tail)))))

  val number4S: ghdmzsk = ghdmzsk(num4Tail => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => num3()(num4Tail)(num1)(num2)))))
  val number4T: ghdmzsk = ghdmzsk(num4Tail => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => num1()(num2)(num3)(num4Tail)))))

  var tag1: Int = 0
  var tag2: Int = 0

  val num1Builder: ghdmzsk =
    ghdmzsk { num2 =>
      ghdmzsk { num3 =>
        ghdmzsk { num4 =>
          val tailPos  = ghdmzsk(num1Tail => number1S(num1Tail)(num2)(num3)(num4))
          val tailZero = ghdmzsk(num1Tail => number1T(num1Tail)(num2)(num3)(num4))
          lazy val nPos: ghdmzsk = tailPos { () =>
            tag1 = tag1 + 1
            tailPos { () =>
              tag1 = tag1 + 1
              tailPos { () =>
                tag1 = tag1 + 1
                tailPos(() => nZero)
              }
            }
          }
          lazy val nZero: ghdmzsk = tailZero(() => nPos)
          nPos
        }
      }
    }

  val num2Builder: ghdmzsk =
    ghdmzsk { num3 =>
      ghdmzsk { num4 =>
        ghdmzsk { num1 =>
          val tailPos             = ghdmzsk(num2Tail => number2S(num2Tail)(num3)(num4)(num1))
          val tailZero            = ghdmzsk(num2Tail => number2T(num2Tail)(num3)(num4)(num1))
          lazy val nPos: ghdmzsk  = tailPos(() => tailPos(() => tailPos)(() => tailPos(() => nZero)))
          lazy val nZero: ghdmzsk = tailZero(() => nPos)
          nPos
        }
      }
    }

  val num3Builder: ghdmzsk =
    ghdmzsk { num4 =>
      ghdmzsk { num1 =>
        ghdmzsk { num2 =>
          val tailPos             = ghdmzsk(num3Tail => number3S(num3Tail)(num4)(num1)(num2))
          val tailZero            = ghdmzsk(num3Tail => number3T(num3Tail)(num4)(num1)(num2))
          lazy val nPos: ghdmzsk  = tailPos(() => tailPos(() => tailPos)(() => tailPos(() => nZero)))
          lazy val nZero: ghdmzsk = tailZero(() => nPos)
          nPos
        }
      }
    }

  val num4Builder: ghdmzsk =
    ghdmzsk { num1 =>
      ghdmzsk { num2 =>
        ghdmzsk { num3 =>
          val tailPos  = ghdmzsk(num4Tail => number4S(num4Tail)(num1)(num2)(num3))
          val tailZero = ghdmzsk(num4Tail => number4T(num4Tail)(num1)(num2)(num3))
          lazy val nPos: ghdmzsk = tailPos { () =>
            println("11" * 100)
            tailPos(() => tailPos)(() => tailPos(() => nZero))
          }
          lazy val nZero: ghdmzsk = tailZero { () =>
            tag2 = tag2 + 1
            nPos
          }
          nPos
        }
      }
    }

}
