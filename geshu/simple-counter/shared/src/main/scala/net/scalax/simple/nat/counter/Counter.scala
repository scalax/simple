package net.scalax.simple.nat.counter

import net.scalax.simple.nat.core._

class Counter {

  val number2Positive: (() => NumberParent) => NumberParent = (v: () => NumberParent) =>
    new NumberParent {
      override val child: () => NumberParent = () => v()
    }

  val number2Zero: (() => NumberParent) => NumberParent = (num2Self: () => NumberParent) => num2Self()

  lazy val number2ZeroEnd: NumberParent = new NumberParent {
    override val child: () => NumberParent = () => number2ZeroEnd
  }

  def buildNumber(i1: Int, i2: Int): NumberParent = {
    def buildZero(ii2: Int): NumberParent = if (ii2 > 0) number2Zero(() => buildPositive(i1, ii2 - 1)) else number2ZeroEnd
    def buildPositive(ii1: Int, ii2: Int): NumberParent =
      if (ii1 > 0) number2Positive(() => buildPositive(ii1 - 1, ii2)) else number2Zero(() => buildZero(ii2))

    buildZero(i2)
  }

}

class Counter1 {

  case class Number1(override val child: () => NumberParent) extends NumberParent

  object Number2 extends ((() => NumberParent) => NumberParent) {
    override def apply(v: () => NumberParent): NumberParent = v()
  }
  case object NumberZero extends NumberParent {
    override val child: () => NumberParent = () => NumberZero
  }

  def buildNumber(i1: Int, i2: Int): NumberParent = {
    def buildZero(ii2: Int): NumberParent = if (ii2 > 0) Number2(() => buildPositive(i1, ii2 - 1)) else NumberZero
    def buildPositive(ii1: Int, ii2: Int): NumberParent =
      if (ii1 > 0) Number1(() => buildPositive(ii1 - 1, ii2)) else Number2(() => buildZero(ii2))

    buildZero(i2)
  }

}

object RunMain {

  def main(arr: Array[String]): Unit = {
    var i                      = 0
    val counter                = new Counter1
    val num1                   = counter.buildNumber(4, 5)
    var countNum: NumberParent = num1
    while ((countNum.child() eq countNum) == false) {
      countNum = countNum.child()
      i += 1
    }
    println(i) // 20
    println(i) // 20
    println(i) // 20
    println(i) // 20
  }

}
