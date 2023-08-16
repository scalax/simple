package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 合集 {

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

  object nums {
    val s1: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk =
            confirm1.inputGHDMZSK(n1.inputGHDMZSK(n2).inputGHDMZSK(n3))
        }
      }
    }
    val s2: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk =
            confirm2.inputGHDMZSK(n1.inputGHDMZSK(n2).inputGHDMZSK(n3))
        }
      }
    }

    val s3: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = n3.inputGHDMZSK(n1).inputGHDMZSK(n2)
        }
      }
    }
    val s4: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = n3.inputGHDMZSK(n2).inputGHDMZSK(n1)
        }
      }
    }

    val s5: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = n2.inputGHDMZSK(n3).inputGHDMZSK(n1)
        }
      }
    }
    val s6: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = n2.inputGHDMZSK(n1).inputGHDMZSK(n3)
        }
      }
    }

    val s7: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(n1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(n2: => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(n3: => ghdmzsk): ghdmzsk = confirm2.inputGHDMZSK(n2.inputGHDMZSK(n1).inputGHDMZSK(n3))
        }
      }
    }
  }

  def gen(positive: ghdmzsk, zero: ghdmzsk, len: Int): ghdmzsk = {
    def genImpl(lenImpl: Int, zeroNUM: => ghdmzsk): ghdmzsk = if (lenImpl > 0) {
      positive.inputGHDMZSK(genImpl(lenImpl - 1, zeroNUM))
    } else zeroNUM

    lazy val pos: ghdmzsk  = genImpl(len, zNUM)
    lazy val zNUM: ghdmzsk = zero.inputGHDMZSK(pos)
    pos
  }

}
