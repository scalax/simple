package net.scalax.simple.nat.不是合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 统计 {

  val testorLeft: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(leftSelf: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(rightSelf: () => ghdmzsk): ghdmzsk = leftSelf()
    }
  }

  val testorRight: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(leftSelf: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(rightSelf: () => ghdmzsk): ghdmzsk = rightSelf()
    }
  }

  val confirm1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(targetNumber: () => ghdmzsk): ghdmzsk = {
      lazy val tempConfirmObject: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(testor: () => ghdmzsk): ghdmzsk =
          testor().inputGHDMZSK(() => tempConfirmObject).inputGHDMZSK(targetNumber)
      }
      tempConfirmObject
    }
  }

  val confirm2: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(targetNumber: () => ghdmzsk): ghdmzsk = {
      lazy val tempConfirmObject: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(testor: () => ghdmzsk): ghdmzsk =
          testor().inputGHDMZSK(targetNumber).inputGHDMZSK(() => tempConfirmObject)
      }
      tempConfirmObject
    }
  }

  def gen(selfPos: ghdmzsk, other: () => ghdmzsk)(numberLen: Int): ghdmzsk = if (numberLen > 0)
    selfPos.inputGHDMZSK(() => gen(selfPos, other)(numberLen - 1))
  else other()

  def confirm(forConfirm: ghdmzsk, brokeNum: Long = 2000, maxCount: Long = 60000000): Boolean = {
    @tailrec
    def confirmImpl(forCount: ghdmzsk, long1: Long, long2: Long, maxC: Long): Boolean = if (maxC > maxCount) true
    else {
      if ((long1 + long2) % 821L == 0L) {
        println(s"long1:$long1, long2:$long2, 临时结果: ${long1 - long2} (count: $maxC, maxCount: $maxCount)")
        assert((long1 - long2).abs < brokeNum)
      }

      val temp1: ghdmzsk = forCount.inputGHDMZSK(() => 统计.testorLeft)

      if (forCount eq temp1) {
        confirmImpl(temp1.inputGHDMZSK(() => 统计.testorRight), long1 = long1 + 1, long2 = long2, maxC = maxC + 1)
      } else {
        confirmImpl(temp1, long1 = long1, long2 = long2 + 1, maxC = maxC + 1)
      }
    }

    confirmImpl(forConfirm, 1, 1, 0)
  }

}
