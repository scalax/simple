package net.scalax.simple.nat.number14

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num3 => AA(() => num1Tail()(num2)(num4)(num3))))))
  // val number1T: ghdmzsk = ghdmzsk(num1Tail => ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num3 => num2()(num3)(num1Tail)(num4)))))

  val number2S: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => num1()(num2Tail)(num4)(num3)))))
  val number2T: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => num3()(num4)(num2Tail)(num1)))))
  val number2U: ghdmzsk = ghdmzsk(num2Tail => ghdmzsk(num3 => ghdmzsk(num1 => ghdmzsk(num4 => BB(() => num3()(num4)(num2Tail)(num1))))))

  /*val number3S: ghdmzsk = ghdmzsk(num3Tail => ghdmzsk(num4 => ghdmzsk(num2 => ghdmzsk(num1 => num2()(num3Tail)(num1)(num4)))))
  val number3T: ghdmzsk = ghdmzsk(num3Tail => ghdmzsk(num4 => ghdmzsk(num2 => ghdmzsk(num1 => num4()(num1)(num3Tail)(num2)))))

  val number4S: ghdmzsk = ghdmzsk(num4Tail => ghdmzsk(num1 => ghdmzsk(num3 => ghdmzsk(num2 => num3()(num4Tail)(num2)(num1)))))
  val number4T: ghdmzsk = ghdmzsk(num4Tail => ghdmzsk(num1 => ghdmzsk(num3 => ghdmzsk(num2 => num1()(num2)(num4Tail)(num3)))))*/

  case class AA(cc: () => ghdmzsk) extends ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }
  case class BB(cc: () => ghdmzsk) extends ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = throw new Exception
  }

  lazy val (n1Pos, _): (ghdmzsk, ghdmzsk) = genNumber(positive = number1S, zero = number2T, count = 6)
  lazy val (n2Pos, _): (ghdmzsk, ghdmzsk) = genNumber(positive = number2S, zero = number2T, count = 7)
  lazy val (n3Pos, _): (ghdmzsk, ghdmzsk) = genNumber(positive = number2S, zero = number2T, count = 7)
  lazy val (n4Pos, _): (ghdmzsk, ghdmzsk) = genNumber(positive = number2S, zero = number2U, count = 7)

  def genNumber(positive: ghdmzsk, zero: ghdmzsk, count: Int): (ghdmzsk, ghdmzsk) = {
    def genNumberImpl(countImpl: Int): ghdmzsk = if (countImpl > 0) {
      val tailValue = genNumberImpl(countImpl = countImpl - 1)
      positive(() => tailValue)
    } else zeroValue

    lazy val positiveValue: ghdmzsk = genNumberImpl(count)
    lazy val zeroValue: ghdmzsk     = zero(() => positiveValue)

    (positiveValue, zeroValue)
  }

}
