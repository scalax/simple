package net.scalax.simple.nat.number13

import scala.annotation.tailrec

object RunMain1 extends App {

  def count(numberA: Number1, numberB: Number1, except: BigDecimal): Boolean = {
    var tag1: Long = 0
    var tag2: Long = 0
    @tailrec
    def countImpl(c: () => Number2): Boolean = {
      val next: () => Number2 = c() match {
        case Number2A(tail) =>
          tag1 = tag1 + 1
          tail
        case Number2B(tail) =>
          tag2 = tag2 + 1
          tail
      }
      if (tag1 + tag2 < 10000)
        countImpl(next)
      else {
        val resultBigDecimal: BigDecimal = BigDecimal(tag1) / BigDecimal(tag2)
        val canOut: Boolean              = (resultBigDecimal - except).abs < BigDecimal("0.0001")
        if (canOut)
          true
        else
          countImpl(next)
      }
    }
    countImpl(() => numberA.method(numberB))
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
    count(num1Count, num2CountZero, except)
    count(num1Count, num2Count, except)
    count(num1CountZero, num2CountZero, except)
    count(num1CountZero, num2Count, except)
    println(i1, i2, except)
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
    count(num1Count, num2CountZero, except)
    count(num1Count, num2Count, except)
    count(num1CountZero, num2CountZero, except)
    count(num1CountZero, num2Count, except)
    println(i1, i2, except)
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
    count(num1Count, num2CountZero, except)
    count(num1Count, num2Count, except)
    count(num1CountZero, num2CountZero, except)
    count(num1CountZero, num2Count, except)
    println(i1, i2, except)
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
