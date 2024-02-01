package net.scalax.simple.nat.group01.number_01

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => AA(() => num1Tail().inputGHDMZSK(num2))))
  val number1T: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => num2().inputGHDMZSK(num1Tail)))
  val number3S: ghdmzsk = ghdmzsk(num3Tail => ghdmzsk(num2 => num2().inputGHDMZSK(num3Tail)))
  val number3T: ghdmzsk = ghdmzsk(num3Tail => ghdmzsk(num1 => BB(() => num1().inputGHDMZSK(num3Tail))))

  case class AA(cc: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }
  case class BB(cc: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }

  def genNumberImpl(positive: ghdmzsk, zero: ghdmzsk, count: Int): (() => ghdmzsk, () => ghdmzsk) = {
    def genNumberImpl2(countImpl: Int): () => ghdmzsk = if (countImpl > 0) {
      val tailValue = genNumberImpl2(countImpl = countImpl - 1)
      () => positive.inputGHDMZSK(tailValue)
    } else zeroValue

    lazy val positiveValue: () => ghdmzsk = genNumberImpl2(count)
    lazy val zeroValue: () => ghdmzsk     = () => zero.inputGHDMZSK(positiveValue)

    (positiveValue, zeroValue)
  }

}
