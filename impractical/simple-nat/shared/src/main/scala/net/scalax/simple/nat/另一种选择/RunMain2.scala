package net.scalax.simple.nat.另一种选择

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object `模式2` {

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

  object `乘法` {
    object `被乘数` {
      val zhengshu: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`乘数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`积Impl`: => ghdmzsk): ghdmzsk =
              confirm1.inputGHDMZSK(tail.inputGHDMZSK(`乘数Impl`).inputGHDMZSK(`积Impl`))
          }
        }
      }
      val zero: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`乘数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`积Impl`: => ghdmzsk): ghdmzsk = `乘数Impl`.inputGHDMZSK(tail).inputGHDMZSK(`积Impl`)
          }
        }
      }

      def gen(i: Int): ghdmzsk = {
        def genImpl(i: Int, zero: => ghdmzsk): ghdmzsk = {
          if (i > 0) {
            zhengshu.inputGHDMZSK(genImpl(i - 1, zero))
          } else zero
        }

        lazy val positive: ghdmzsk = genImpl(i, zeroNum)
        lazy val zeroNum: ghdmzsk  = zero.inputGHDMZSK(positive)
        positive
      }
    }

    object `乘数` {
      val zhengshu: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被乘数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`积Impl`: => ghdmzsk): ghdmzsk = `被乘数Impl`.inputGHDMZSK(tail).inputGHDMZSK(`积Impl`)
          }
        }
      }
      val zero: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被乘数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`积Impl`: => ghdmzsk): ghdmzsk = `积Impl`.inputGHDMZSK(`被乘数Impl`).inputGHDMZSK(tail)
          }
        }
      }

      def gen(i: Int): ghdmzsk = {
        def genImpl(i: Int, zero: => ghdmzsk): ghdmzsk = {
          if (i > 0) {
            zhengshu.inputGHDMZSK(genImpl(i - 1, zero))
          } else zero
        }

        lazy val positive: ghdmzsk = genImpl(i, zeroNum)
        lazy val zeroNum: ghdmzsk  = zero.inputGHDMZSK(positive)
        zeroNum
      }
    }

    object `积` {
      val zhengshu: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被乘数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`乘数Impl`: => ghdmzsk): ghdmzsk =
              confirm2.inputGHDMZSK(tail.inputGHDMZSK(`被乘数Impl`).inputGHDMZSK(`乘数Impl`))
          }
        }
      }
      val zero: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被乘数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`乘数Impl`: => ghdmzsk): ghdmzsk = `乘数Impl`.inputGHDMZSK(`被乘数Impl`).inputGHDMZSK(tail)
          }
        }
      }

      def gen(i: Int): ghdmzsk = {
        def genImpl(i: Int, zero: => ghdmzsk): ghdmzsk = {
          if (i > 0) {
            zhengshu.inputGHDMZSK(genImpl(i - 1, zero))
          } else zero
        }

        lazy val positive: ghdmzsk = genImpl(i, zeroNum)
        lazy val zeroNum: ghdmzsk  = zero.inputGHDMZSK(positive)
        positive
      }
    }
  }

  def main(arr: Array[String]): Unit = {
    val num1: Int            = 32
    val num2: Int            = 21
    val num3: Int            = 672
    val num1GHDMZSK: ghdmzsk = `乘法`.`被乘数`.gen(num1)
    val num2GHDMZSK: ghdmzsk = `乘法`.`乘数`.gen(num2)
    val num3GHDMZSK: ghdmzsk = `乘法`.`积`.gen(num3)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    {
      @tailrec
      def forCountExec(forCount: ghdmzsk, long1: Long, long2: Long): Unit = {
        if ((long1 + long2) % 821L == 0L) {
          println(s"long1:$long1, long2: $long2, 临时结果: ${long1 - long2}")
          assert((long1 - long2).abs < 800)
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
