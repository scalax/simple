package net.scalax.simple.nat.number15

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object RunMain {

  println("喵呜呜" * 100)
  println("58795-" * 100)

  val anythingNumber: ghdmzsk = ghdmzsk(t => t())

  def count(number: => ghdmzsk, except: BigDecimal): BigDecimal = {
    Number1.count1 = 0
    Number1.count2 = 0
    @tailrec
    def countImpl(c: => ghdmzsk, initCount: Long): BigDecimal = {
      val nextTail = c.inputGHDMZSK(anythingNumber)
      if (Number1.count1 + Number1.count2 < initCount || Number1.count2 == 0)
        countImpl(nextTail, initCount)
      else {
        val resultBigDecimal: BigDecimal = BigDecimal(Number1.count1) / BigDecimal(Number1.count2)
        val canOut: Boolean              = (resultBigDecimal - except).abs < BigDecimal("0.00001")
        if (canOut)
          resultBigDecimal
        else
          countImpl(nextTail, initCount + 100000)
      }
    }
    countImpl(number, initCount = 10000)
  }

  def numT(i: Int, zero: => ghdmzsk): ghdmzsk = {
    if (i > 0) {
      val num1Result: ghdmzsk = numT(i - 1, zero)
      Number1.number1T.inputGHDMZSK(num1Result)
    } else
      zero
  }

  def numS(i: Int, zero: => ghdmzsk): ghdmzsk = {
    if (i > 0) {
      val num1Result: ghdmzsk = numS(i - 1, zero)
      Number1.number1S.inputGHDMZSK(num1Result)
    } else
      zero
  }

  def main1(arr: Array[String]): Unit = {
    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } yield {
      lazy val num1Count: ghdmzsk     = numT(i1, num1CountZero)
      lazy val num1CountZero: ghdmzsk = Number1.number1V.inputGHDMZSK(num1Count)

      lazy val num2Count: ghdmzsk     = numT(i2, num2CountZero)
      lazy val num2CountZero: ghdmzsk = Number1.number1S.inputGHDMZSK(num2Count)

      val except: BigDecimal = BigDecimal(i1) + BigDecimal(i2)

      val r1 = count(num1Count.inputGHDMZSK(num2CountZero), except)
      val r2 = count(num1Count.inputGHDMZSK(num2Count), except)
      val r3 = count(num1CountZero.inputGHDMZSK(num2CountZero), except)
      val r4 = count(num1CountZero.inputGHDMZSK(num2Count), except)

      println(i1, '+', i2, '=', except, r1, r2, r3, r4)
    }

    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } yield {
      lazy val num1Count: ghdmzsk     = numT(i1, num1CountZero)
      lazy val num1CountZero: ghdmzsk = Number1.number1S.inputGHDMZSK(num1Count)

      lazy val num2Count: ghdmzsk     = numS(i2, num2CountZero)
      lazy val num2CountZero: ghdmzsk = Number1.number1U.inputGHDMZSK(num2Count)

      val except: BigDecimal = BigDecimal(i1) * BigDecimal(i2)

      val r1 = count(num1Count.inputGHDMZSK(num2CountZero), except)
      val r2 = count(num1Count.inputGHDMZSK(num2Count), except)
      val r3 = count(num1CountZero.inputGHDMZSK(num2CountZero), except)
      val r4 = count(num1CountZero.inputGHDMZSK(num2Count), except)

      println(i1, '×', i2, '=', except, r1, r2, r3, r4)
    }

    for {
      i1 <- 0 to 20
      i2 <- 1 to 20
    } yield {
      lazy val num1Count: ghdmzsk     = numS(i1, num1CountZero)
      lazy val num1CountZero: ghdmzsk = Number1.number1U.inputGHDMZSK(num1Count)

      lazy val num2Count: ghdmzsk     = numS(i2, num2CountZero)
      lazy val num2CountZero: ghdmzsk = Number1.number1T.inputGHDMZSK(num2Count)

      val except: BigDecimal = BigDecimal(i1) / BigDecimal(i2)

      val r1 = count(num1Count.inputGHDMZSK(num2CountZero), except)
      val r2 = count(num1Count.inputGHDMZSK(num2Count), except)
      val r3 = count(num1CountZero.inputGHDMZSK(num2CountZero), except)
      val r4 = count(num1CountZero.inputGHDMZSK(num2Count), except)

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
