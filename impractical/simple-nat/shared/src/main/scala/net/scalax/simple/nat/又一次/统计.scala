package net.scalax.simple.nat.又一次

import net.scalax.simple.ghdmzsk.ghdmzsk

import java.util.Date
import scala.annotation.tailrec
import scala.util.Random

object CountFunction {

  val testorLeft: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(leftSelf: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(rightSelf: => ghdmzsk): ghdmzsk = leftSelf
    }
  }

  val testorRight: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(leftSelf: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(rightSelf: => ghdmzsk): ghdmzsk = rightSelf
    }
  }

  val confirm1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(targetNumber: => ghdmzsk): ghdmzsk = {
      lazy val tempConfirmObject: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(testor: => ghdmzsk): ghdmzsk = testor.inputGHDMZSK(tempConfirmObject).inputGHDMZSK(targetNumber)
      }
      tempConfirmObject
    }
  }

  val confirm2: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(targetNumber: => ghdmzsk): ghdmzsk = {
      lazy val tempConfirmObject: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(testor: => ghdmzsk): ghdmzsk = testor.inputGHDMZSK(targetNumber).inputGHDMZSK(tempConfirmObject)
      }
      tempConfirmObject
    }
  }

  def gen(leftBuilder: ghdmzsk, rightBuilder: ghdmzsk)(leftLength: Int, rightLength: Int)(selfNumber: => ghdmzsk): ghdmzsk = {
    lazy val leftNumInstance: ghdmzsk =
      gen(leftBuilder = leftBuilder, rightBuilder = rightBuilder)(leftLength = leftLength - 1, rightLength = rightLength)(selfNumber)
    lazy val useLeftNum: ghdmzsk = leftBuilder.inputGHDMZSK(leftNumInstance)

    lazy val rightNumInstance: ghdmzsk =
      gen(leftBuilder = leftBuilder, rightBuilder = rightBuilder)(leftLength = leftLength, rightLength = rightLength - 1)(selfNumber)
    lazy val useRightNum: ghdmzsk = rightBuilder.inputGHDMZSK(rightNumInstance)

    if (leftLength == 0 && rightLength == 0) {
      selfNumber
    } else if (leftLength == 0) {
      useRightNum
    } else if (rightLength == 0) {
      useLeftNum
    } else {
      val useLeft = Random.nextInt(new Date().getTime.toInt) % 2 == 1
      if (useLeft) useLeftNum else useRightNum
    }
  }

  def confirm(forConfirm: ghdmzsk, brokeNum: Long = 2000, maxCount: Long = 60000000): Boolean = {
    @tailrec
    def confirmImpl(forCount: ghdmzsk, long1: Long, long2: Long, maxC: Long): Boolean = if (maxC > maxCount) true
    else {
      if ((long1 + long2) % 821L == 0L) {
        println(s"long1:$long1, long2:$long2, 临时结果: ${long1 - long2} (count: $maxC, maxCount: $maxCount)")
        assert((long1 - long2).abs < brokeNum)
      }

      val temp1: ghdmzsk = forCount.inputGHDMZSK(CountFunction.testorLeft)

      if (forCount eq temp1) {
        confirmImpl(temp1.inputGHDMZSK(CountFunction.testorRight), long1 = long1 + 1, long2 = long2, maxC = maxC + 1)
      } else {
        confirmImpl(temp1, long1 = long1, long2 = long2 + 1, maxC = maxC + 1)
      }
    }

    confirmImpl(forConfirm, 1, 1, 0)
  }

}
