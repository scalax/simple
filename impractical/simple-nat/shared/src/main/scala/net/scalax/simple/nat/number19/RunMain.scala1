package net.scalax.simple.nat.number19

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object `啊呜` {

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

  object chufa {
    val zhengshu: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = other.inputGHDMZSK(tail)
      }
    }
    val zero: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(confirmX: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk =
            confirmX.inputGHDMZSK(tail.inputGHDMZSK(other))
        }
      }
    }
    def gen(i: Int, confirmX: ghdmzsk): ghdmzsk = {
      def genImpl(i: Int, zero: => ghdmzsk): ghdmzsk = {
        if (i > 0) {
          zhengshu.inputGHDMZSK(genImpl(i - 1, zero))
        } else zero
      }

      lazy val positive: ghdmzsk = genImpl(i, zeroNum)
      lazy val zeroNum: ghdmzsk  = zero.inputGHDMZSK(confirmX).inputGHDMZSK(positive)
      positive
    }
  }

  def main1(arr: Array[String]): Unit = {
    val num1: Int            = 281
    val num2: Int            = 68
    val result1: BigDecimal  = BigDecimal(num1) / BigDecimal(num2)
    val num1GHDMZSK: ghdmzsk = chufa.gen(num1, confirmX = confirm1)
    val num2GHDMZSK: ghdmzsk = chufa.gen(num2, confirmX = confirm2)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK)

    {
      @tailrec
      def forCountExec(forCount: ghdmzsk, long1: Long, long2: Long): Unit = {
        if ((long1 + long2) % 100000L == 0L) {
          println(s"except:$result1, now: ${BigDecimal(long2) / BigDecimal(long1)}")
        }

        val temp1: ghdmzsk = forCount.inputGHDMZSK(testorLeft)

        if (forCount eq temp1) {
          forCountExec(temp1.inputGHDMZSK(testorRight), long1 = long1 + 1, long2 = long2)
        } else {
          forCountExec(temp1, long1 = long1, long2 = long2 + 1)
        }
      }

      forCountExec(execResultForInput, 1, 1)
    }
  }

}
