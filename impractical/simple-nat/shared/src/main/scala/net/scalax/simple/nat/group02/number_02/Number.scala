package net.scalax.simple.nat.group02.number_02

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => AA(() => num1().inputGHDMZSK(num2()).inputGHDMZSK(num3())))))
  val number1T: ghdmzsk = ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => num2().inputGHDMZSK(num3()).inputGHDMZSK(num1()))))
  val number3S: ghdmzsk = ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => num3().inputGHDMZSK(num1()).inputGHDMZSK(num2()))))
  val number3T: ghdmzsk = ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => BB(() => num2().inputGHDMZSK(num3()).inputGHDMZSK(num1())))))

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
