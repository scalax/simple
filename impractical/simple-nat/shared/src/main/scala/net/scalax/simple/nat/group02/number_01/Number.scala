package net.scalax.simple.nat.group02.number_01

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number {

  val number1S: ghdmzsk = ghdmzsk(head => ghdmzsk(tail => AA(() => head()(tail))))
  val number1T: ghdmzsk = ghdmzsk(head => ghdmzsk(tail => tail()(head)))
  val number3S: ghdmzsk = ghdmzsk(head => ghdmzsk(tail => tail()(head)))
  val number3T: ghdmzsk = ghdmzsk(head => ghdmzsk(tail => BB(() => tail()(head))))

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
