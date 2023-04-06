package net.scalax.simple.nat.number15

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object RunMain {

  def count(number: () => ghdmzsk, except: BigDecimal): BigDecimal = {
    @tailrec
    def countImpl(c: () => ghdmzsk, tag1Impl: Long, tag2Impl: Long, initCount: Long): BigDecimal = {
      val (nextTail, tag1Next, tag2Next) = c() match {
        case Number1.AA(tail) =>
          (tail, tag1Impl + 1, tag2Impl)
        case Number1.BB(tail) =>
          (tail, tag1Impl, tag2Impl + 1)
      }
      if (tag1Next + tag2Next < initCount || tag2Next == 0)
        countImpl(nextTail, tag1Next, tag2Next, initCount)
      else {
        val resultBigDecimal: BigDecimal = BigDecimal(tag1Next) / BigDecimal(tag2Next)
        val canOut: Boolean              = (resultBigDecimal - except).abs < BigDecimal("0.00001")
        if (canOut)
          resultBigDecimal
        else
          countImpl(nextTail, tag1Next, tag2Next, initCount + 100000)
      }
    }
    countImpl(number, 0, 0, 10000)
  }

  def numT(i: Int, zero: => ghdmzsk): ghdmzsk = {
    if (i > 0) {
      val num1Result: ghdmzsk = numT(i - 1, zero)
      Number1.number1T(() => num1Result)
    } else
      zero
  }

  def numS(i: Int, zero: => ghdmzsk): ghdmzsk = {
    if (i > 0) {
      val num1Result: ghdmzsk = numS(i - 1, zero)
      Number1.number1S(() => num1Result)
    } else
      zero
  }

  def main(arr: Array[String]): Unit = {
    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } yield {
      lazy val num1Count: ghdmzsk     = numT(i1, num1CountZero)
      lazy val num1CountZero: ghdmzsk = Number1.number1V(() => num1Count)

      lazy val num2Count: ghdmzsk     = numT(i2, num2CountZero)
      lazy val num2CountZero: ghdmzsk = Number1.number1S(() => num2Count)

      val except: BigDecimal = BigDecimal(i1) + BigDecimal(i2)

      val r1 = count(() => num1Count(() => num2CountZero), except)
      val r2 = count(() => num1Count(() => num2Count), except)
      val r3 = count(() => num1CountZero(() => num2CountZero), except)
      val r4 = count(() => num1CountZero(() => num2Count), except)

      println(i1, '+', i2, '=', except, r1, r2, r3, r4)
    }

    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } yield {
      lazy val num1Count: ghdmzsk     = numT(i1, num1CountZero)
      lazy val num1CountZero: ghdmzsk = Number1.number1S(() => num1Count)

      lazy val num2Count: ghdmzsk     = numS(i2, num2CountZero)
      lazy val num2CountZero: ghdmzsk = Number1.number1U(() => num2Count)

      val except: BigDecimal = BigDecimal(i1) * BigDecimal(i2)

      val r1 = count(() => num1Count(() => num2CountZero), except)
      val r2 = count(() => num1Count(() => num2Count), except)
      val r3 = count(() => num1CountZero(() => num2CountZero), except)
      val r4 = count(() => num1CountZero(() => num2Count), except)

      println(i1, '×', i2, '=', except, r1, r2, r3, r4)
    }

    for {
      i1 <- 0 to 20
      i2 <- 1 to 20
    } yield {
      lazy val num1Count: ghdmzsk     = numS(i1, num1CountZero)
      lazy val num1CountZero: ghdmzsk = Number1.number1U(() => num1Count)

      lazy val num2Count: ghdmzsk     = numS(i2, num2CountZero)
      lazy val num2CountZero: ghdmzsk = Number1.number1T(() => num2Count)

      val except: BigDecimal = BigDecimal(i1) / BigDecimal(i2)

      val r1 = count(() => num1Count(() => num2CountZero), except)
      val r2 = count(() => num1Count(() => num2Count), except)
      val r3 = count(() => num1CountZero(() => num2CountZero), except)
      val r4 = count(() => num1CountZero(() => num2Count), except)

      println(i1, '÷', i2, '=', except, r1, r2, r3, r4)
    }
  }

}

/*

+
TV
TS

×
TS
SU

÷
SU
ST

 */
