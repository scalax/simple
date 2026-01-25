package net.scalax.simple
package nat
package number40

import scala.annotation.tailrec

object RunTest1 {

  @tailrec
  def countImpl(
    num: () => Num40.Num0,
    current分子: Long,
    current分母: Long,
    result: Map[Long, Long],
    printlnSum: Int,
    speed: Long
  ): Unit = {
    val needPrintln: Boolean = (current分子 + current分母) % speed == 0

    def countMap: BigInt       = result.to(List).map(t => BigInt(t._1) * BigInt(t._2)).sum
    def countDown: BigInt      = result.values.map(t => BigInt(t)).sum
    def countValue: BigDecimal = BigDecimal(countMap) / BigDecimal(countDown)

    def newResult: Map[Long, Long] = {
      val r1 = current分子 - current分母
      result.get(r1).fold(result + ((r1, 1L)))(v => result.updated(r1, v + 1))
    }

    if (needPrintln) {
      println(s"result: $result, countValue: $countValue")
    }

    val currentNum = num()

    if (printlnSum > 0) {
      currentNum match {
        case Num40.Num0.Append1(tail) =>
          countImpl(
            tail,
            current分子 = current分子,
            current分母 = current分母 + 1,
            result = newResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case Num40.Num0.Append2(tail) =>
          countImpl(
            tail,
            current分子 = current分子 + 1,
            current分母 = current分母,
            result = newResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
      }
    } else {
      println("== finished ==")
    }
  }

  def count(num: () => Num40.Num0, printlnSum: Int, speed: Long = 8000000): Unit =
    countImpl(num = num, current分子 = 1, current分母 = 1, result = Map.empty, printlnSum = printlnSum, speed = speed)

  def main1(arr: Array[String]): Unit = {
    val num1: Num40.Num1 = Num40.Num1.Append2(() =>
      Num40.Num1.Append2(() =>
        Num40.Num1.Append2(() => Num40.Num1.Append2(() => Num40.Num1.Append2(() => Num40.Num1.Append2(() => Num40.Num1.zero1))))
      )
    )
    val num2: Num40.Num1 = Num40.Num1.Append2(() => Num40.Num1.Append2(() => Num40.Num1.Append2(() => Num40.Num1.zero2)))

    count(num = () => num1.append(num2), printlnSum = 25)
    count(num = () => num2.append(num1), printlnSum = 25)
    count(num = () => num1.append(num1), printlnSum = 25)
    count(num = () => num2.append(num2), printlnSum = 25)

    println("== finished 1 ==")
  }

}
