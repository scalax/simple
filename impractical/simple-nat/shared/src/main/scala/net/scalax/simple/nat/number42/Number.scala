package net.scalax.simple
package nat
package number42

import ghdmzsk._

object Num42 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  object Append1 {
    val tailToRight: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(appendInnstance: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
              override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk =
                appendInnstance().inputGHDMZSK(() => num2().inputGHDMZSK(num3).inputGHDMZSK(num4).inputGHDMZSK(tail1))
            }
          }
        }
      }
    }

    val tailToRightInstance: ghdmzsk = Append1.tailToRight.inputGHDMZSK(() => Append2.tailToLeft).inputGHDMZSK(() => tailToRightInstance)

    val tailToLeft: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(appendInnstance: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
              override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk =
                appendInnstance().inputGHDMZSK(() => num3().inputGHDMZSK(tail4).inputGHDMZSK(num1).inputGHDMZSK(num2))
            }
          }
        }
      }
    }

    val tailToLeftInstance: ghdmzsk = Append1.tailToLeft.inputGHDMZSK(() => Append2.tailToRight).inputGHDMZSK(() => tailToLeftInstance)
  }

  object Append2 {
    val tailToLeft: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
        override def pre2: ghdmzsk = tail2()

        override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk =
              num1().inputGHDMZSK(tail2).inputGHDMZSK(num3).inputGHDMZSK(num4)
          }
        }
      }
    }

    val tailToRight: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
        override def pre1: ghdmzsk = tail2()

        override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk =
              num3().inputGHDMZSK(num4).inputGHDMZSK(num1).inputGHDMZSK(tail2)
          }
        }
      }
    }
  }

  /*object Append3 {
    val tailToLeft: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
              num2().inputGHDMZSK(tail3).inputGHDMZSK(num4).inputGHDMZSK(num1)
          }
        }
      }
    }

    val tailToRight: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
              num4().inputGHDMZSK(num1).inputGHDMZSK(num2).inputGHDMZSK(tail3)
          }
        }
      }
    }
  }*/

}
