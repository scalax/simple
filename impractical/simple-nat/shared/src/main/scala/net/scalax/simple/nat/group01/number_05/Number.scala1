package net.scalax.simple.nat.group01.number_05

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk =
    ghdmzsk(num1Tail =>
      ghdmzsk(num2 =>
        ghdmzsk(num3 =>
          ghdmzsk(num4 =>
            ghdmzsk(num5 =>
              ghdmzsk(num6 =>
                AA(() =>
                  num1Tail().inputGHDMZSK(num2()).inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(num5()).inputGHDMZSK(num6())
                )
              )
            )
          )
        )
      )
    )
  val number1T: ghdmzsk =
    ghdmzsk(num1Tail =>
      ghdmzsk(num2 =>
        ghdmzsk(num3 =>
          ghdmzsk(num4 =>
            ghdmzsk(num5 =>
              ghdmzsk(num6 =>
                num2().inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(num5()).inputGHDMZSK(num6()).inputGHDMZSK(num1Tail())
              )
            )
          )
        )
      )
    )
  val number3S: ghdmzsk =
    ghdmzsk(num2Tail =>
      ghdmzsk(num3 =>
        ghdmzsk(num4 =>
          ghdmzsk(num5 =>
            ghdmzsk(num6 =>
              ghdmzsk(num1 =>
                num1().inputGHDMZSK(num2Tail()).inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(num5()).inputGHDMZSK(num6())
              )
            )
          )
        )
      )
    )
  val number3T: ghdmzsk =
    ghdmzsk(num6Tail =>
      ghdmzsk(num1 =>
        ghdmzsk(num2 =>
          ghdmzsk(num3 =>
            ghdmzsk(num4 =>
              ghdmzsk(num5 =>
                BB(() =>
                  num1().inputGHDMZSK(num2()).inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(num5()).inputGHDMZSK(num6Tail())
                )
              )
            )
          )
        )
      )
    )

  case class AA(cc: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception
  }
  case class BB(cc: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception
  }

  def genNumberImpl(positive: ghdmzsk, zero: ghdmzsk, count: Int): (ghdmzsk, ghdmzsk) = {
    def genNumberImpl2(countImpl: Int): ghdmzsk = if (countImpl > 0) {
      val tailValue = genNumberImpl2(countImpl = countImpl - 1)
      positive.inputGHDMZSK(tailValue)
    } else zeroValue

    lazy val positiveValue: ghdmzsk = genNumberImpl2(count)
    lazy val zeroValue: ghdmzsk     = zero.inputGHDMZSK(positiveValue)

    (positiveValue, zeroValue)
  }

}
