package net.scalax.simple.nat.number13

import net.scalax.simple.core.App_1

import scala.annotation.tailrec

object RunMain extends App_1 {

  def count(numberA: Number1, numberB: Number1, except: BigDecimal): BigDecimal = {
    var tag1: Long = 0
    var tag2: Long = 0
    @tailrec
    def countImpl(c: () => Number2, initCount: Long): BigDecimal = {
      val next: () => Number2 = c() match {
        case Number2A(tail) =>
          tag1 = tag1 + 1
          tail
        case Number2B(tail) =>
          tag2 = tag2 + 1
          tail
      }
      if (tag1 + tag2 < initCount)
        countImpl(next, initCount)
      else {
        val resultBigDecimal: BigDecimal = BigDecimal(tag1) / BigDecimal(tag2)
        val canOut: Boolean              = (resultBigDecimal - except).abs < BigDecimal("0.00001")
        if (canOut)
          resultBigDecimal
        else
          countImpl(next, initCount + 100000)
      }
    }
    countImpl(() => numberA.method(numberB), 10000)
  }

  def numT(i: Int, zero: => Number1): Number1 = {
    if (i > 0) {
      val num1Result: Number1 = numT(i - 1, zero)
      Number1T(() => num1Result)
    } else
      zero
  }

  def numS(i: Int, zero: => Number1): Number1 = {
    if (i > 0) {
      val num1Result: Number1 = numS(i - 1, zero)
      Number1S(() => num1Result)
    } else
      zero
  }

  for {
    i1 <- 0 to 20
    i2 <- 0 to 20
  } yield {
    lazy val num1Count: Number1     = numT(i1, num1CountZero)
    lazy val num1CountZero: Number1 = Number1V(() => num1Count)

    lazy val num2Count: Number1     = numT(i2, num2CountZero)
    lazy val num2CountZero: Number1 = Number1S(() => num2Count)

    val except: BigDecimal = BigDecimal(i1) + BigDecimal(i2)

    val r1 = count(num1Count, num2CountZero, except)
    val r2 = count(num1Count, num2Count, except)
    val r3 = count(num1CountZero, num2CountZero, except)
    val r4 = count(num1CountZero, num2Count, except)

    println(i1, '+', i2, '=', except, r1, r2, r3, r4)
  }

  for {
    i1 <- 0 to 20
    i2 <- 0 to 20
  } yield {
    lazy val num1Count: Number1     = numT(i1, num1CountZero)
    lazy val num1CountZero: Number1 = Number1S(() => num1Count)

    lazy val num2Count: Number1     = numS(i2, num2CountZero)
    lazy val num2CountZero: Number1 = Number1U(() => num2Count)

    val except: BigDecimal = BigDecimal(i1) * BigDecimal(i2)

    val r1 = count(num1Count, num2CountZero, except)
    val r2 = count(num1Count, num2Count, except)
    val r3 = count(num1CountZero, num2CountZero, except)
    val r4 = count(num1CountZero, num2Count, except)

    println(i1, '×', i2, '=', except, r1, r2, r3, r4)
  }

  for {
    i1 <- 0 to 20
    i2 <- 1 to 20
  } yield {
    lazy val num1Count: Number1     = numS(i1, num1CountZero)
    lazy val num1CountZero: Number1 = Number1U(() => num1Count)

    lazy val num2Count: Number1     = numS(i2, num2CountZero)
    lazy val num2CountZero: Number1 = Number1T(() => num2Count)

    val except: BigDecimal = BigDecimal(i1) / BigDecimal(i2)

    val r1 = count(num1Count, num2CountZero, except)
    val r2 = count(num1Count, num2Count, except)
    val r3 = count(num1CountZero, num2CountZero, except)
    val r4 = count(num1CountZero, num2Count, except)

    println(i1, '÷', i2, '=', except, r1, r2, r3, r4)
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
