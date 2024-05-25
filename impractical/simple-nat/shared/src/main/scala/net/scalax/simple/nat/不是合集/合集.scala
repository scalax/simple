package net.scalax.simple.nat.不是合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 合集 {

  object x {
    def a: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: () => ghdmzsk): ghdmzsk =
            统计.confirm1.inputGHDMZSK(() => n1().inputGHDMZSK(n2).inputGHDMZSK(n3))
        }
      }
    }
    def b: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: () => ghdmzsk): ghdmzsk =
            统计.confirm2.inputGHDMZSK(() => n1().inputGHDMZSK(n2).inputGHDMZSK(n3))
        }
      }
    }
  }
  object y {
    val a: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n1: () => ghdmzsk): ghdmzsk = n1().inputGHDMZSK(n2).inputGHDMZSK(n3)
        }
      }
    }
    val b: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: () => ghdmzsk): ghdmzsk = n1().inputGHDMZSK(n2).inputGHDMZSK(n3)
        }
      }
    }
  }

}
