package net.scalax.simple.nat.number18

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object `嘻嘻嘻` {

  def main1(arr: Array[String]): Unit = {
    var count1: Long = 0
    var count2: Long = 0

    lazy val countGhdmzsk1: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(anything: => ghdmzsk): ghdmzsk = {
            val tailImpl = tail
            if (tailImpl == b0) {
              count1 += 1
            }
            if ((tailImpl == a1) || (tailImpl == a2) || (tailImpl == a3) || (tailImpl == a4) || (tailImpl == a5) || (tailImpl == a6)) {
              count2 += 1
            }
            tailImpl.inputGHDMZSK(other)
          }
        }
      }
    }

    lazy val a6: ghdmzsk = countGhdmzsk1.inputGHDMZSK(a5)
    lazy val a5: ghdmzsk = countGhdmzsk1.inputGHDMZSK(a4)
    lazy val a4: ghdmzsk = countGhdmzsk1.inputGHDMZSK(a3)
    lazy val a3: ghdmzsk = countGhdmzsk1.inputGHDMZSK(a2)
    lazy val a2: ghdmzsk = countGhdmzsk1.inputGHDMZSK(a1)
    lazy val a1: ghdmzsk = countGhdmzsk1.inputGHDMZSK(a0)
    lazy val a0: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(a6)
    }

    lazy val b6: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(b5)
    }
    lazy val b5: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(b4)
    }
    lazy val b4: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(b3)
    }
    lazy val b3: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(b2)
    }
    lazy val b2: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(b1)
    }
    lazy val b1: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(next: => ghdmzsk): ghdmzsk = countGhdmzsk1.inputGHDMZSK(next).inputGHDMZSK(b0)
    }
    lazy val b0: ghdmzsk = countGhdmzsk1.inputGHDMZSK(b6)

    val ghdmzskAny = new ghdmzsk {
      override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = t
    }

    var u: Long              = 1000000000
    var tempGhdmzsk: ghdmzsk = b3.inputGHDMZSK(a6)
    while (u > 0) {
      tempGhdmzsk = tempGhdmzsk.inputGHDMZSK(ghdmzskAny)
      if (u % 10000000 == 0) {
        if (count1 > 0) {
          println(BigDecimal(count2) / BigDecimal(count1))
        }
      }
      u += 1
    }
  }

}
