package net.scalax.simple
package nat
package number43

import ghdmzsk._

object Num43 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  object Append1 {
    val tailToLeft: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(appendInnstance: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
              override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
                override def inputGHDMZSK(num5: () => ghdmzsk): ghdmzsk = new ghdmzsk {
                  override def inputGHDMZSK(num6: () => ghdmzsk): ghdmzsk =
                    appendInnstance().inputGHDMZSK(() =>
                      num6().inputGHDMZSK(num1).inputGHDMZSK(num2).inputGHDMZSK(num3).inputGHDMZSK(num4).inputGHDMZSK(num5)
                    )
                }
              }
            }
          }
        }
      }
    }

    val tailToLeftInstance: ghdmzsk = Append1.tailToLeft.inputGHDMZSK(() => Append2.tailToRight).inputGHDMZSK(() => tailToLeftInstance)

    val tailToRight: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(appendInnstance: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
              override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
                override def inputGHDMZSK(num5: () => ghdmzsk): ghdmzsk = new ghdmzsk {
                  override def inputGHDMZSK(num6: () => ghdmzsk): ghdmzsk =
                    appendInnstance().inputGHDMZSK(() =>
                      num2().inputGHDMZSK(num3).inputGHDMZSK(num4).inputGHDMZSK(num5).inputGHDMZSK(num6).inputGHDMZSK(num1)
                    )
                }
              }
            }
          }
        }
      }
    }

    val tailToRightInstance: ghdmzsk = Append1.tailToRight.inputGHDMZSK(() => Append2.tailToLeft).inputGHDMZSK(() => tailToRightInstance)
  }

  object Append2 {
    val tailToLeft: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
        override def pre2: ghdmzsk = num1()

        override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
              override def inputGHDMZSK(num5: () => ghdmzsk): ghdmzsk = new ghdmzsk {
                override def inputGHDMZSK(num6: () => ghdmzsk): ghdmzsk =
                  num6().inputGHDMZSK(num1).inputGHDMZSK(num2).inputGHDMZSK(num3).inputGHDMZSK(num4).inputGHDMZSK(num5)
              }
            }
          }
        }
      }
    }

    val tailToRight: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
        override def pre1: ghdmzsk = num1()

        override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk = new ghdmzsk {
              override def inputGHDMZSK(num5: () => ghdmzsk): ghdmzsk = new ghdmzsk {
                override def inputGHDMZSK(num6: () => ghdmzsk): ghdmzsk =
                  num2().inputGHDMZSK(num3).inputGHDMZSK(num4).inputGHDMZSK(num5).inputGHDMZSK(num6).inputGHDMZSK(num1)
              }
            }
          }
        }
      }
    }
  }

}
