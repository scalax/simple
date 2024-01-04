package net.scalax.simple.nat.number17

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number1 {

  implicit class Extra(private val ghd: ghdmzsk) {
    def apply(t: () => ghdmzsk): ghdmzsk = ghd.inputGHDMZSK(t())
  }

  case class Number1Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }
  case class Number2Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }
  case class Number3Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }
  case class Number4Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }
  case class Number5Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }
  case class Number6Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }
  case object NumberZeroCount extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("Nothing")
  }

  val Number1S: ghdmzsk = ghdmzsk(tail1 =>
    ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => num2()(tail1)(num3)(num4)(num5)(num6))))))
  )
  val Number1T: ghdmzsk = ghdmzsk(tail1 =>
    ghdmzsk(num2 =>
      ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => Number1Count(() => tail1()(num2)(num3)(num4)(num5)(num6))))))
    )
  )

  val Number2S: ghdmzsk = ghdmzsk(tail2 =>
    ghdmzsk(num1 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => num3()(num1)(tail2)(num4)(num5)(num6))))))
  )
  val Number2T: ghdmzsk = ghdmzsk(tail2 =>
    ghdmzsk(num1 =>
      ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => Number2Count(() => tail2()(num1)(num3)(num4)(num5)(num6))))))
    )
  )

  val Number3S: ghdmzsk = ghdmzsk(tail3 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => num4()(num1)(num2)(tail3)(num5)(num6))))))
  )
  val Number3T: ghdmzsk = ghdmzsk(tail3 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => Number3Count(() => tail3()(num1)(num2)(num4)(num5)(num6))))))
    )
  )

  val Number4S: ghdmzsk = ghdmzsk(tail4 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num5 => ghdmzsk(num6 => num5()(num1)(num2)(num3)(tail4)(num6))))))
  )
  val Number4T: ghdmzsk = ghdmzsk(tail4 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num5 => ghdmzsk(num6 => Number4Count(() => tail4()(num1)(num2)(num3)(num5)(num6))))))
    )
  )

  val Number5S: ghdmzsk = ghdmzsk(tail5 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num6 => num6()(num1)(num2)(num3)(num4)(tail5))))))
  )
  val Number5T: ghdmzsk = ghdmzsk(tail5 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num6 => Number5Count(() => tail5()(num1)(num2)(num3)(num4)(num6))))))
    )
  )

  val Number6S: ghdmzsk = ghdmzsk(tail6 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => num1()(num2)(num3)(num4)(num5)(tail6))))))
  )
  val Number6T: ghdmzsk = ghdmzsk(tail6 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => Number6Count(() => tail6()(num1)(num2)(num3)(num4)(num5))))))
    )
  )

  def build1(count: Int): (ghdmzsk, ghdmzsk) = {
    def build1ImplS(count: Int): ghdmzsk = if (count > 0) Number1S(() => build1ImplS(count - 1)) else numberZero

    lazy val numberPositive = build1ImplS(count)
    lazy val numberZero     = Number1T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build2(count: Int): (ghdmzsk, ghdmzsk) = {
    def build2ImplS(count: Int): ghdmzsk = if (count > 0) Number2S(() => build2ImplS(count - 1)) else numberZero

    lazy val numberPositive = build2ImplS(count)
    lazy val numberZero     = Number2T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build3(count: Int): (ghdmzsk, ghdmzsk) = {
    def build3ImplS(count: Int): ghdmzsk = if (count > 0) Number3S(() => build3ImplS(count - 1)) else numberZero

    lazy val numberPositive = build3ImplS(count)
    lazy val numberZero     = Number3T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build4(count: Int): (ghdmzsk, ghdmzsk) = {
    def build4ImplS(count: Int): ghdmzsk = if (count > 0) Number4S(() => build4ImplS(count - 1)) else numberZero

    lazy val numberPositive = build4ImplS(count)
    lazy val numberZero     = Number4T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build5(count: Int): (ghdmzsk, ghdmzsk) = {
    def build5ImplS(count: Int): ghdmzsk = if (count > 0) Number5S(() => build5ImplS(count - 1)) else numberZero

    lazy val numberPositive = build5ImplS(count)
    lazy val numberZero     = Number5T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build6(count: Int): (ghdmzsk, ghdmzsk) = {
    def build6ImplS(count: Int): ghdmzsk = if (count > 0) Number6S(() => build6ImplS(count - 1)) else numberZero

    lazy val numberPositive = build6ImplS(count)
    lazy val numberZero     = Number6T(() => numberPositive)

    (numberPositive, numberZero)
  }

}
