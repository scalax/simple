package net.scalax.simple.nat.group01.number_04

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk =
    ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => AA(() => num1Tail()(num2)(num3)(num4)(num5)))))))
  val number1T: ghdmzsk =
    ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => num2()(num3)(num4)(num5)(num1Tail))))))
  val number3S: ghdmzsk =
    ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num1 => num1()(num2Tail)(num3)(num4)(num5))))))
  val number3T: ghdmzsk =
    ghdmzsk(num5Tail => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => BB(() => num1()(num2)(num3)(num4)(num5Tail)))))))

  case class AA(cc: () => ghdmzsk) extends ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }
  case class BB(cc: () => ghdmzsk) extends ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }

  def genNumberImpl(positive: ghdmzsk, zero: ghdmzsk, count: Int): (ghdmzsk, ghdmzsk) = {
    def genNumberImpl2(countImpl: Int): ghdmzsk = if (countImpl > 0) {
      val tailValue = genNumberImpl2(countImpl = countImpl - 1)
      positive(() => tailValue)
    } else zeroValue

    lazy val positiveValue: ghdmzsk = genNumberImpl2(count)
    lazy val zeroValue: ghdmzsk     = zero(() => positiveValue)

    (positiveValue, zeroValue)
  }

}
