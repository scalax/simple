package net.scalax.simple.nat.合集1

import java.util.Date
import scala.annotation.tailrec
import scala.util.Random

object 统计 {

  sealed trait NumCount
  case class NumCountLeft(tail: () => NumCount)  extends NumCount
  case class NumCountRight(tail: () => NumCount) extends NumCount

  def gen(
    leftBuilder: (() => 合集.InputNum) => 合集.InputNum,
    rightBuilder: (() => 合集.InputNum) => 合集.InputNum
  )(leftLength: Int, rightLength: Int)(selfNumber: => 合集.InputNum): 合集.InputNum = {
    lazy val leftNumInstance: 合集.InputNum =
      gen(leftBuilder = leftBuilder, rightBuilder = rightBuilder)(leftLength = leftLength - 1, rightLength = rightLength)(selfNumber)
    lazy val useLeftNum: 合集.InputNum = leftBuilder(() => leftNumInstance)

    lazy val rightNumInstance: 合集.InputNum =
      gen(leftBuilder = leftBuilder, rightBuilder = rightBuilder)(leftLength = leftLength, rightLength = rightLength - 1)(selfNumber)
    lazy val useRightNum: 合集.InputNum = rightBuilder(() => rightNumInstance)

    if (leftLength == 0 && rightLength == 0) {
      selfNumber
    } else if (leftLength == 0) {
      useRightNum
    } else if (rightLength == 0) {
      useLeftNum
    } else {
      val useLeft = Random.nextLong(new Date().getTime) % 2L == 1L
      if (useLeft) useLeftNum else useRightNum
    }
  }

  def confirm(forConfirm: () => 统计.NumCount, brokeNum: Long = 2000): Unit = {
    @tailrec
    def confirmImpl(forCount: () => 统计.NumCount, long1: Long, long2: Long): Unit = {
      if ((long1 + long2) % 821L == 0L) {
        println(s"long1:$long1, long2:$long2, 临时结果: ${long1 - long2}")
        if (long2 != 0) {
          println(BigDecimal(long1) / BigDecimal(long2))
        }
        assert((long1 - long2).abs < brokeNum)
      }

      forCount() match {
        case 统计.NumCountLeft(tail) =>
          confirmImpl(tail, long1 = long1 + 1, long2 = long2)
        case 统计.NumCountRight(tail) =>
          confirmImpl(tail, long1 = long1, long2 = long2 + 1)
      }
    }

    confirmImpl(forConfirm, 1, 1)
  }

}
