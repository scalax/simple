package net.scalax.simple.nat.number17

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num3 => AA(() => num1Tail()(num2)(num4)(num3))))))
  val number2S: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => num1()(num2Tail)(num4)(num3)))))
  val number2T: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => num3()(num4)(num2Tail)(num1)))))
  val number2U: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => BB(() => num3()(num4)(num2Tail)(num1))))))

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
