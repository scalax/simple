package net.scalax.simple.nat.group02.number_05

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk =
    ghdmzsk(head =>
      ghdmzsk(num1 =>
        ghdmzsk(num2 =>
          ghdmzsk(num3 =>
            ghdmzsk(num4 =>
              ghdmzsk(tail =>
                AA(() => head().inputGHDMZSK(num1()).inputGHDMZSK(num2()).inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(tail()))
              )
            )
          )
        )
      )
    )
  val number1T: ghdmzsk =
    ghdmzsk(head =>
      ghdmzsk(num1 =>
        ghdmzsk(num2 =>
          ghdmzsk(num3 =>
            ghdmzsk(num4 =>
              ghdmzsk(tail =>
                num1().inputGHDMZSK(num2()).inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(tail()).inputGHDMZSK(head())
              )
            )
          )
        )
      )
    )
  val number3S: ghdmzsk =
    ghdmzsk(head =>
      ghdmzsk(num1 =>
        ghdmzsk(num2 =>
          ghdmzsk(num3 =>
            ghdmzsk(num4 =>
              ghdmzsk(tail =>
                tail().inputGHDMZSK(head()).inputGHDMZSK(num1()).inputGHDMZSK(num2()).inputGHDMZSK(num3()).inputGHDMZSK(num4())
              )
            )
          )
        )
      )
    )
  val number3T: ghdmzsk =
    ghdmzsk(head =>
      ghdmzsk(num1 =>
        ghdmzsk(num2 =>
          ghdmzsk(num3 =>
            ghdmzsk(num4 =>
              ghdmzsk(tail =>
                BB(() => num1().inputGHDMZSK(num2()).inputGHDMZSK(num3()).inputGHDMZSK(num4()).inputGHDMZSK(tail()).inputGHDMZSK(head()))
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
