package net.scalax.simple.nat.group02.number_03

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(head => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(tail => AA(() => head()(num1)(num2)(tail))))))
  val number2T: ghdmzsk = ghdmzsk(head => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(tail => num1()(num2)(tail)(head)))))
  val number2S: ghdmzsk = ghdmzsk(head => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(tail => tail()(head)(num1)(num2)))))
  val number2U: ghdmzsk = ghdmzsk(head => ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(tail => BB(() => num1()(num2)(tail)(head))))))

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
