package net.scalax.simple.nat.合集1

import java.util.Date
import scala.annotation.tailrec
import scala.util.Random

import net.scalax.simple.adt.{TypeAdt => Adt}

object 统计 {

  def gen(
    leftBuilder: (() => 合集.InputNum) => 合集.InputNum with 合集.CLeft,
    rightBuilder: (() => 合集.InputNum) => 合集.InputNum with 合集.CRight
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

  def confirm(
    forConfirm: () => Adt.Option2[合集.NumCountLeft, 合集.NumCountRight],
    except: BigDecimal,
    brokeNum: Long = 2000,
    maxCount: Long = 60000000
  ): Boolean = {
    @tailrec
    def confirmImpl(forCount: () => Adt.Option2[合集.NumCountLeft, 合集.NumCountRight], long1: Long, long2: Long, maxC: Long): Boolean = if (
      maxC > maxCount
    ) true
    else {
      if ((long1 + long2) % 8210L == 0L) {
        if (long2 != 0L) {
          val currentResult: BigDecimal = BigDecimal(long2) / BigDecimal(long1)
          println(s"current: $currentResult, except: $except, cha: ${currentResult - except}")
        }
      }

      forCount() match {
        case Adt.Option1(合集.NumCountLeft(tail)) =>
          confirmImpl(tail, long1 = long1 + 1, long2 = long2, maxC = maxC + 1)
        case Adt.Option2(合集.NumCountRight(tail)) =>
          confirmImpl(tail, long1 = long1, long2 = long2 + 1, maxC = maxC + 1)
        case Adt.Option3(t) =>
          t.matchErrorAndNothing
      }

    }

    confirmImpl(forConfirm, 1, 1, 0)
  }

}
