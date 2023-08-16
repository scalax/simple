package net.scalax.simple.nat.另一种选择

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object `贤者2` {

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

  object `加法` {
    object `被加数` {
      val zhengshu: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`加数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`和Impl`: => ghdmzsk): ghdmzsk =
              confirm1.inputGHDMZSK(`和Impl`.inputGHDMZSK(`加数Impl`).inputGHDMZSK(tail))
          }
        }
      }
      val zero: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`加数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`和Impl`: => ghdmzsk): ghdmzsk = tail.inputGHDMZSK(`加数Impl`).inputGHDMZSK(`和Impl`)
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

    object `加数` {
      val zhengshu: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被加数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`和Impl`: => ghdmzsk): ghdmzsk =
              confirm1.inputGHDMZSK(`和Impl`.inputGHDMZSK(`被加数Impl`).inputGHDMZSK(tail))
          }
        }
      }
      val zero: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被加数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`和Impl`: => ghdmzsk): ghdmzsk = tail.inputGHDMZSK(`被加数Impl`).inputGHDMZSK(`和Impl`)
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

    object `和` {
      val zhengshu: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被加数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`加数Impl`: => ghdmzsk): ghdmzsk =
              confirm2.inputGHDMZSK(`被加数Impl`.inputGHDMZSK(`加数Impl`).inputGHDMZSK(tail))
          }
        }
      }
      val zero: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(`被加数Impl`: => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(`加数Impl`: => ghdmzsk): ghdmzsk = tail.inputGHDMZSK(`被加数Impl`).inputGHDMZSK(`加数Impl`)
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
    val num1: Int            = 281
    val num2: Int            = 68
    val num3: Int            = 349
    val num1GHDMZSK: ghdmzsk = `加法`.`被加数`.gen(num1)
    val num2GHDMZSK: ghdmzsk = `加法`.`加数`.gen(num2)
    val num3GHDMZSK: ghdmzsk = `加法`.`和`.gen(num3)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    {
      @tailrec
      def forCountExec(forCount: ghdmzsk, long1: Long, long2: Long): Unit = {
        if ((long1 + long2) % 871L == 0L) {
          println(s"long1:$long1, long2: $long2, 临时结果: ${long1 - long2}")
          // assert((long1 - long2).abs < 900)
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
