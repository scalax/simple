package net.scalax.simple.nat.number14

import scala.annotation.tailrec

object RunMain extends App {

  def count(numberA: Number1, numberB: Number1, except: BigDecimal): BigDecimal = {
    var tag1: Long = 0
    var tag2: Long = 0
    @tailrec
    def countImpl(c: () => Number3, initCount: Long): BigDecimal = {
      val next: () => Number3 = c() match {
        case Number3A(tail) =>
          tag1 = tag1 + 1
          tail
        case Number3B(tail) =>
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

  def numZeroRound(zero: () => Number1): Number1 = Number1T(() => Number1T(() => Number1T(() => Number1T(zero))))
  def num1Round(num1: () => Number1): Number1 = {
    class Number1X(val tail: () => Number1) extends Number1 {
      override def method(other: Number1 => Number1): Number2 = Cut
    }

  }

}
