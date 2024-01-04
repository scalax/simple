package net.scalax.simple.nat.乘除法20231026

import java.util.Date
import scala.annotation.tailrec
import scala.util.Random

import net.scalax.simple.adt.{TypeAdt => Adt}

object 统计 {

  import 合集._

  def genLeft(leftLength: Int, rightLength: Int)(
    selfNumber: () => Adt.CoProduct2[InputNum1Left, InputNum2Left]
  ): Adt.CoProduct2[InputNum1Left, InputNum2Left] = {
    def nextLeft  = setterLeft(new InputNum1Left(() => genLeft(leftLength = leftLength - 1, rightLength = rightLength)(selfNumber)))
    def nextRight = setterLeft(new InputNum2Left(() => genLeft(leftLength = leftLength, rightLength = rightLength - 1)(selfNumber)))

    if (leftLength == 0 && rightLength == 0) {
      selfNumber()
    } else if (leftLength == 0) {
      nextRight
    } else if (rightLength == 0) {
      nextLeft
    } else {
      val useLeft = Random.nextLong(new Date().getTime) % 2L == 1L
      if (useLeft) nextLeft else nextRight
    }
  }

  def genRight(leftLength: Int, rightLength: Int)(
    selfNumber: () => Adt.CoProduct2[InputNum1Right, InputNum2Right]
  ): Adt.CoProduct2[InputNum1Right, InputNum2Right] = {
    def nextLeft  = setterRight(new InputNum1Right(() => genRight(leftLength = leftLength - 1, rightLength = rightLength)(selfNumber)))
    def nextRight = setterRight(new InputNum2Right(() => genRight(leftLength = leftLength, rightLength = rightLength - 1)(selfNumber)))

    if (leftLength == 0 && rightLength == 0) {
      selfNumber()
    } else if (leftLength == 0) {
      nextRight
    } else if (rightLength == 0) {
      nextLeft
    } else {
      val useLeft = Random.nextLong(new Date().getTime) % 2L == 1L
      if (useLeft) nextLeft else nextRight
    }
  }

  def confirm(
    forConfirm: () => Adt.CoProduct2[NumCountLeft, NumCountRight],
    except: BigDecimal,
    maxCount: Long = 6000000
  ): Boolean = {
    @tailrec
    def confirmImpl(forCount: () => Adt.CoProduct2[NumCountLeft, NumCountRight], long1: Long, long2: Long, maxC: Long): Boolean = {
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
          case Adt.CoProduct1(NumCountLeft(tail)) =>
            confirmImpl(tail, long1 = long1 + 1, long2 = long2, maxC = maxC + 1)
          case Adt.CoProduct2(NumCountRight(tail)) =>
            confirmImpl(tail, long1 = long1, long2 = long2 + 1, maxC = maxC + 1)
          case Adt.CoProduct3(t) =>
            t.matchErrorAndThrowException
        }
      }
    }

    confirmImpl(forConfirm, 1, 1, 0)
  }

}
