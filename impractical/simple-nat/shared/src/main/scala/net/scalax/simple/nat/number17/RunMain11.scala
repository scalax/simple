trait ghdmzsk {
  def inputGHDMZSK(t: => ghdmzsk): ghdmzsk
}

object ghdmzsk {
  implicit class Extra(private val ghd: ghdmzsk) {
    def apply(t: () => ghdmzsk): ghdmzsk = ghd.inputGHDMZSK(t())
  }

  def apply(func: (() => ghdmzsk) => ghdmzsk): ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = func(() => t)
  }
}

object Number1 {

  class Number1Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = tail()
  }
  class Number2Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = tail()
  }
  class Number3Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = tail()
  }
  class Number4Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = tail()
  }
  class Number5Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = tail()
  }
  class Number6Count(tail: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = tail()
  }

  val Number1S: ghdmzsk = ghdmzsk(tail1 =>
    ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => num2()(tail1)(num3)(num4)(num5)(num6))))))
  )
  val Number1T: ghdmzsk = ghdmzsk(tail1 =>
    ghdmzsk(num2 =>
      ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => new Number1Count(() => tail1()(num2)(num3)(num4)(num5)(num6))))))
    )
  )

  val Number2S: ghdmzsk = ghdmzsk(tail2 =>
    ghdmzsk(num1 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => num3()(num1)(tail2)(num4)(num5)(num6))))))
  )
  val Number2T: ghdmzsk = ghdmzsk(tail2 =>
    ghdmzsk(num1 =>
      ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => new Number2Count(() => tail2()(num1)(num3)(num4)(num5)(num6))))))
    )
  )

  val Number3S: ghdmzsk = ghdmzsk(tail3 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => num4()(num1)(num2)(tail3)(num5)(num6))))))
  )
  val Number3T: ghdmzsk = ghdmzsk(tail3 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num4 => ghdmzsk(num5 => ghdmzsk(num6 => new Number3Count(() => tail3()(num1)(num2)(num4)(num5)(num6))))))
    )
  )

  val Number4S: ghdmzsk = ghdmzsk(tail4 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num5 => ghdmzsk(num6 => num5()(num1)(num2)(num3)(tail4)(num6))))))
  )
  val Number4T: ghdmzsk = ghdmzsk(tail4 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num5 => ghdmzsk(num6 => new Number4Count(() => tail4()(num1)(num2)(num3)(num5)(num6))))))
    )
  )

  val Number5S: ghdmzsk = ghdmzsk(tail5 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num6 => num6()(num1)(num2)(num3)(num4)(tail5))))))
  )
  val Number5T: ghdmzsk = ghdmzsk(tail5 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num6 => new Number5Count(() => tail5()(num1)(num2)(num3)(num4)(num6))))))
    )
  )

  val Number6S: ghdmzsk = ghdmzsk(tail6 =>
    ghdmzsk(num1 => ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => num1()(num2)(num3)(num4)(num5)(tail6))))))
  )
  val Number6T: ghdmzsk = ghdmzsk(tail6 =>
    ghdmzsk(num1 =>
      ghdmzsk(num2 => ghdmzsk(num3 => ghdmzsk(num4 => ghdmzsk(num5 => new Number6Count(() => tail6()(num1)(num2)(num3)(num4)(num5))))))
    )
  )

  def build1(count: Int): (ghdmzsk, ghdmzsk) = {
    def build1ImplS(count: Int): ghdmzsk =
      if (count > 0) Number1S(() => build1ImplS(count - 1)) else numberZero

    lazy val numberPositive = build1ImplS(count)
    lazy val numberZero     = Number1T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build2(count: Int): (ghdmzsk, ghdmzsk) = {
    def build2ImplS(count: Int): ghdmzsk =
      if (count > 0) Number2S(() => build2ImplS(count - 1)) else numberZero

    lazy val numberPositive = build2ImplS(count)
    lazy val numberZero     = Number2T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build3(count: Int): (ghdmzsk, ghdmzsk) = {
    def build3ImplS(count: Int): ghdmzsk =
      if (count > 0) Number3S(() => build3ImplS(count - 1)) else numberZero

    lazy val numberPositive = build3ImplS(count)
    lazy val numberZero     = Number3T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build4(count: Int): (ghdmzsk, ghdmzsk) = {
    def build4ImplS(count: Int): ghdmzsk =
      if (count > 0) Number4S(() => build4ImplS(count - 1)) else numberZero

    lazy val numberPositive = build4ImplS(count)
    lazy val numberZero     = Number4T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build5(count: Int): (ghdmzsk, ghdmzsk) = {
    def build5ImplS(count: Int): ghdmzsk =
      if (count > 0) Number5S(() => build5ImplS(count - 1)) else numberZero

    lazy val numberPositive = build5ImplS(count)
    lazy val numberZero     = Number5T(() => numberPositive)

    (numberPositive, numberZero)
  }

  def build6(count: Int): (ghdmzsk, ghdmzsk) = {
    def build6ImplS(count: Int): ghdmzsk =
      if (count > 0) Number6S(() => build6ImplS(count - 1)) else numberZero

    lazy val numberPositive = build6ImplS(count)
    lazy val numberZero     = Number6T(() => numberPositive)

    (numberPositive, numberZero)
  }

}

object MainApp {

  lazy val emptyGHDMZSK: ghdmzsk = ghdmzsk(t => emptyGHDMZSK(t))

  import Number1._

  def count(number: => ghdmzsk, p: BigDecimal): Boolean = {
    var long1: Long = 0
    var long2: Long = 0
    var long3: Long = 0
    var long4: Long = 0
    var long5: Long = 0
    var long6: Long = 0

    def canStop: Boolean = {
      val pNum = long4 + long5 + long6
      if (pNum == 0 || long1 < 500)
        false
      else {
        val cNum =
          BigDecimal(long1 + long2 + long3) / BigDecimal(long4 + long5 + long6)
        val sum = long1 + long2 + long3 + long4 + long5 + long6
        if (sum % 100000 == 0) println(cNum)
        (cNum - BigDecimal(1)).abs < p
      }
    }

    @scala.annotation.tailrec
    def countImpl(numImpl: () => ghdmzsk): Boolean = {
      numImpl() match {
        case n: Number1Count =>
          long1 += 1
          if (canStop) true else countImpl(() => n(() => emptyGHDMZSK))
        case n: Number2Count =>
          long2 += 1
          if (canStop) true else countImpl(() => n(() => emptyGHDMZSK))
        case n: Number3Count =>
          long3 += 1
          if (canStop) true else countImpl(() => n(() => emptyGHDMZSK))
        case n: Number4Count =>
          long4 += 1
          if (canStop) true else countImpl(() => n(() => emptyGHDMZSK))
        case n: Number5Count =>
          long5 += 1
          if (canStop) true else countImpl(() => n(() => emptyGHDMZSK))
        case n: Number6Count =>
          long6 += 1
          if (canStop) true else countImpl(() => n(() => emptyGHDMZSK))
      }
    }

    countImpl(() => number)
  }

  def main1(arr: Array[String]): Unit = {

    for {
      avg <- 8 to 8
      i1  <- 8 to 8
      i2  <- 8 to 8
      i3  <- 9 to 9
    } {
      val avgNum = i1 + i2 + i3
      val avgSum = avg + avg + avg

      val (number1S, number1T) = build1(avg)
      val (number2S, number2T) = build2(avg)
      val (number3S, number3T) = build3(avg)
      val (number4S, number4T) = build4(i1)
      val (number5S, number5T) = build5(i2)
      val (number6S, number6T) = build6(i3)

      def r: ghdmzsk =
        number1S(() => number2S)(() => number3S)(() => number4S)(() => number5S)(() => number6S)

      val isAvg = avgNum == avgSum
      // if (isAvg) {
      val isAvgGhdmzsk = count(r, BigDecimal("0.01"))
      println((avg, i1, i2, i3))
      assert(isAvg == isAvgGhdmzsk)
      // }

    }

    println("匹配成功")
  }

}
