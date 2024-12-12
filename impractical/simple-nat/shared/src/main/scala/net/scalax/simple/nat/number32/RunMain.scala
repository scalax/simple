package net.scalax.simple
package nat
package number32

import scala.annotation.tailrec
import ghdmzsk._

object RunTest1 {

  case class AA(v1: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = v1().inputGHDMZSK(t)
  }

  case class BB(v2: () => ghdmzsk) extends ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = v2().inputGHDMZSK(t)
  }

  val leftZero: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(down: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(up: () => ghdmzsk): ghdmzsk =
          AA(() => 乘除1.toUp.inputGHDMZSK(tail).inputGHDMZSK(down).inputGHDMZSK(up))
      }
    }
  }
  val leftZeroInstance: ghdmzsk = leftZero.inputGHDMZSK(() => leftZeroInstance)
  /*val leftZeroInstance2: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = leftZeroInstance.inputGHDMZSK(t).inputGHDMZSK(() => leftZeroInstance2)
  }*/
  val leftZeroInstance2: ghdmzsk = leftZeroInstance.inputGHDMZSK(() => leftZeroInstance2)

  val rithtZero: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(down: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(up: () => ghdmzsk): ghdmzsk =
          BB(() => 乘除1.toUp.inputGHDMZSK(tail).inputGHDMZSK(down).inputGHDMZSK(up))
      }
    }
  }
  val rightZeroInstance: ghdmzsk  = rithtZero.inputGHDMZSK(() => rightZeroInstance)
  val rightZeroInstance2: ghdmzsk = rightZeroInstance.inputGHDMZSK(() => rightZeroInstance2)

  def build(分子: Long, 分母: Long): ghdmzsk = {
    def buildImpl(isFenmu: Boolean, numLong: Long, zero: () => ghdmzsk): ghdmzsk = {
      if (numLong > 0) {
        if (isFenmu) {
          乘除1.toUp.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        } else {
          乘除1.toDown.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        }
      } else {
        zero()
      }
    }

    lazy val build1: ghdmzsk = buildImpl(isFenmu = false, numLong = 分子, zero = () => build2)
    lazy val build2: ghdmzsk = buildImpl(isFenmu = true, numLong = 分母, zero = () => build1)

    build1
  }

  @tailrec
  def countImpl(
    num: () => ghdmzsk,
    current分子: Long,
    current分母: Long,
    exceptResult: BigDecimal,
    printlnSum: Int,
    speed: Long
  ): Unit = {
    val needPrintln: Boolean = (current分子 + current分母) % speed == 0

    val current: BigDecimal = BigDecimal(current分子) / BigDecimal(current分母)

    if (needPrintln) {
      println(s"except: $exceptResult, current: $current分子 / $current分母 = $current")
    }

    val currentNum = num()

    if (printlnSum > 0) {
      currentNum match {
        case AA(v1) =>
          countImpl(
            v1,
            current分子 = current分子,
            current分母 = current分母 + 1,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case BB(v2) =>
          countImpl(
            v2,
            current分子 = current分子 + 1,
            current分母 = current分母,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case _: 乘除1.Num3 =>
          println("num3")
          ???
        case _: 乘除1.Num4 =>
          println("num4")
          ???
        case _: 乘除1.Num5 =>
          println("num5")
          ???
      }
    } else {
      println("== finished ==")
    }
  }

  def count(num: () => ghdmzsk, except: BigDecimal, printlnSum: Int, speed: Long = 8000000): Unit =
    countImpl(num = num, current分子 = 1, current分母 = 1, exceptResult = except, printlnSum = printlnSum, speed = speed)

  def main1(arr: Array[String]): Unit = {

    {
      val 分子1: Long = 123
      val 分母1: Long = 4342
      val 分子2: Long = 328
      val 分母2: Long = 15

      val except1: BigDecimal = BigDecimal(分子1) / BigDecimal(分母1)
      val except2: BigDecimal = BigDecimal(分子2) / BigDecimal(分母2)

      val num1: ghdmzsk = build(分子 = 分子1, 分母 = 分母1)
      val num2: ghdmzsk = build(分子 = 分子2, 分母 = 分母2)

      val result1: ghdmzsk = leftZeroInstance2.inputGHDMZSK(() => num1.inputGHDMZSK(() => num2.inputGHDMZSK(() => rightZeroInstance2)))

      count(() => result1, except = except1 * except2, printlnSum = 10)
    }

    {
      val 分子1: Long = 9
      val 分母1: Long = 2

      val except1: BigDecimal = (BigDecimal(分子1) / BigDecimal(分母1)).pow(4)

      val num1: ghdmzsk = build(分子 = 分子1, 分母 = 分母1)

      val result1: ghdmzsk = leftZeroInstance2.inputGHDMZSK(() =>
        num1.inputGHDMZSK(() => num1.inputGHDMZSK(() => num1.inputGHDMZSK(() => num1.inputGHDMZSK(() => rightZeroInstance2))))
      )

      count(() => result1, except = except1, printlnSum = 10)
    }

  }

}
