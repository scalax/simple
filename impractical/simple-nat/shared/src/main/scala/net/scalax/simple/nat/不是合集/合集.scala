package net.scalax.simple.nat.不是合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 合集 {

  val s1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk =
          统计.confirm1.inputGHDMZSK(n1.inputGHDMZSK(n2).inputGHDMZSK(n3))
      }
    }
  }
  val s2: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk =
          统计.confirm2.inputGHDMZSK(n1.inputGHDMZSK(n2).inputGHDMZSK(n3))
      }
    }
  }
  val s4: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = n1.inputGHDMZSK(n2).inputGHDMZSK(n3)
      }
    }
  }
  val s3: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = n2.inputGHDMZSK(n1).inputGHDMZSK(n3)
      }
    }
  }

}
