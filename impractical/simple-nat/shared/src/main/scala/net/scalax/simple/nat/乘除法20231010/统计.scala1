package net.scalax.simple.nat.乘除法20231010

import java.util.Date
import scala.annotation.tailrec
import scala.util.Random

import net.scalax.simple.adt.{TypeAdt => Adt}

object 统计 {

  def gen(
    leftBuilder: (() => 合集.InputNum) => 合集.InputNumLeft,
    rightBuilder: (() => 合集.InputNum) => 合集.InputNumRight
  )(leftLength: Int, rightLength: Int)(selfNumber: => 合集.InputNum): 合集.InputNum = {
    lazy val leftNumInstance: 合集.InputNum =
      gen(leftBuilder = leftBuilder, rightBuilder = rightBuilder)(leftLength = leftLength - 1, rightLength = rightLength)(selfNumber)
    lazy val useLeftNum: 合集.InputNum = 合集.setter2(leftBuilder(() => leftNumInstance))

    lazy val rightNumInstance: 合集.InputNum =
      gen(leftBuilder = leftBuilder, rightBuilder = rightBuilder)(leftLength = leftLength, rightLength = rightLength - 1)(selfNumber)
    lazy val useRightNum: 合集.InputNum = 合集.setter2(rightBuilder(() => rightNumInstance))

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
    forConfirm: () => Adt.CoProduct2[合集.NumCountLeft, 合集.NumCountRight],
    except: BigDecimal,
    maxCount: Long = 6000000
  ): Boolean = {
    @tailrec
    def confirmImpl(forCount: () => Adt.CoProduct2[合集.NumCountLeft, 合集.NumCountRight], long1: Long, long2: Long, maxC: Long): Boolean = {
      if (maxC > maxCount) {
        true
      } else {
        if ((long1 + long2) % 8210L == 0L) {
          if (long2 != 0L) {
            val currentResult: BigDecimal = BigDecimal(long2) / BigDecimal(long1)
            println(s"current: $currentResult, except: $except, cha: ${currentResult - except}, maxCount: $maxC/$maxCount")
          }
        }

        forCount() match {
          case Adt.CoProduct1(合集.NumCountLeft(tail)) =>
            confirmImpl(tail, long1 = long1 + 1, long2 = long2, maxC = maxC + 1)
          case Adt.CoProduct2(合集.NumCountRight(tail)) =>
            confirmImpl(tail, long1 = long1, long2 = long2 + 1, maxC = maxC + 1)
          case Adt.CoProduct3(t) =>
            t.matchErrorAndThrowException
        }
      }
    }

    confirmImpl(forConfirm, 1, 1, 0)
  }

}
