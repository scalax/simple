package net.scalax.simple.nat.number17

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object `跑我跑我` {

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
        val cNum = BigDecimal(long1 + long2 + long3) / BigDecimal(long4 + long5 + long6)
        (cNum - BigDecimal(1)).abs < p
      }
    }

    @tailrec
    def countImpl(numImpl: () => ghdmzsk): Boolean = {
      numImpl() match {
        case Number1Count(tail) =>
          long1 += 1
          if (canStop) true else countImpl(tail)
        case Number2Count(tail) =>
          long2 += 1
          if (canStop) true else countImpl(tail)
        case Number3Count(tail) =>
          long3 += 1
          if (canStop) true else countImpl(tail)
        case Number4Count(tail) =>
          long4 += 1
          if (canStop) true else countImpl(tail)
        case Number5Count(tail) =>
          long5 += 1
          if (canStop) true else countImpl(tail)
        case Number6Count(tail) =>
          long6 += 1
          if (canStop) true else countImpl(tail)
      }
    }

    countImpl(() => number)
  }

  def main1(arr: Array[String]): Unit = {
    def countAction(numAvg: Int, num1Value: Int, num2Value: Int, num3Value: Int): ghdmzsk = {
      val (number1S, number1T) = build1(numAvg)
      val (number2S, number2T) = build2(numAvg)
      val (number3S, number3T) = build3(numAvg)
      val (number4S, number4T) = build4(num1Value)
      val (number5S, number5T) = build5(num2Value)
      val (number6S, number6T) = build6(num3Value)

      val num1: List[(ghdmzsk, String)] = List((number1S, "number1S"), (number1T, "number1T"))
      val num2: List[(ghdmzsk, String)] = List((number2S, "number2S"), (number2T, "number2T"))
      val num3: List[(ghdmzsk, String)] = List((number3S, "number3S"), (number3T, "number3T"))
      val num4: List[(ghdmzsk, String)] = List((number4S, "number4S"), (number4T, "number4T"))
      val num5: List[(ghdmzsk, String)] = List((number5S, "number5S"), (number5T, "number5T"))
      val num6: List[(ghdmzsk, String)] = List((number6S, "number6S"), (number6T, "number6T"))

      number1S(() => number2S)(() => number3S)(() => number4S)(() => number5S)(() => number6S)
    }

    val testAction = for {
      i1 <- 49 to 51
      i2 <- 47 to 52
      i3 <- 47 to 52
      i4 <- 47 to 52
    } yield {
      val sum1  = i1 + i1 + i1
      val sum2  = i2 + i3 + i4
      val r     = countAction(numAvg = i1, num1Value = i2, num2Value = i3, num3Value = i4)
      val isAvg = sum1 == sum2
      if (isAvg) {
        val isAvgGhdmzsk = count(r, BigDecimal("0.001"))
        assert(isAvg == isAvgGhdmzsk)
        Some((isAvg, isAvgGhdmzsk, isAvg == isAvgGhdmzsk))
      } else Option.empty

    }

    println(testAction.collect { case Some(s) => s }.mkString("\n"))
  }

}
