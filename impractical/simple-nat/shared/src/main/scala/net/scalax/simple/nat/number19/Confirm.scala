package net.scalax.simple.nat.number19

import net.scalax.simple.ghdmzsk.ghdmzsk

object Confirm {

  def main(arr: Array[String]): Unit = {
    val oldSelector: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = t
    }

    val testorLeft: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(t2: => ghdmzsk): ghdmzsk = t1
      }
    }

    val testorRight: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t1: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(t2: => ghdmzsk): ghdmzsk = t2
      }
    }

    val confirm1 = new ghdmzsk {
      override def inputGHDMZSK(selector: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(targetNumber: => ghdmzsk): ghdmzsk = {
          lazy val tempConfirmObject: ghdmzsk = new ghdmzsk {
            override def inputGHDMZSK(testor: => ghdmzsk): ghdmzsk = {
              lazy val leftTemp1: ghdmzsk  = testor.inputGHDMZSK(tempConfirmObject)
              lazy val rightTemp1: ghdmzsk = leftTemp1.inputGHDMZSK(targetNumber)
              selector.inputGHDMZSK(rightTemp1)
            }
          }
          tempConfirmObject
        }
      }
    }

    trait GetValue {
      def value: AnyRef
    }

    lazy val uu: ghdmzsk = new ghdmzsk with GetValue {
      override lazy val value: AnyRef                   = uu
      override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = t
    }

    val uauaua: ghdmzsk = confirm1.inputGHDMZSK(oldSelector).inputGHDMZSK(uu)
    uauaua.inputGHDMZSK(testorLeft)
    uauaua.inputGHDMZSK(testorRight)
    assert(uauaua eq uauaua.inputGHDMZSK(testorLeft))
    println(uauaua eq uauaua.inputGHDMZSK(testorLeft))
    println(uauaua eq uauaua.inputGHDMZSK(testorLeft))
    println(uauaua eq uauaua.inputGHDMZSK(testorLeft))
    println(uauaua eq uauaua.inputGHDMZSK(testorLeft))
    println(uauaua eq uauaua.inputGHDMZSK(testorLeft))
    println("====")
    assert(uauaua ne uauaua.inputGHDMZSK(testorRight))
    println(uauaua eq uauaua.inputGHDMZSK(testorRight))
    println(uauaua eq uauaua.inputGHDMZSK(testorRight))
    println(uauaua eq uauaua.inputGHDMZSK(testorRight))
    println(uauaua eq uauaua.inputGHDMZSK(testorRight))
    println(uauaua eq uauaua.inputGHDMZSK(testorRight))
    println("====")
    if (uauaua ne uauaua.inputGHDMZSK(testorRight)) {
      assert(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
      println(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
    }
    if (uauaua ne uauaua.inputGHDMZSK(testorRight)) {
      assert(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
      println(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
    }
    if (uauaua ne uauaua.inputGHDMZSK(testorRight)) {
      assert(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
      println(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
    }
    if (uauaua ne uauaua.inputGHDMZSK(testorRight)) {
      assert(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
      println(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
    }
    if (uauaua ne uauaua.inputGHDMZSK(testorRight)) {
      assert(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
      println(uu eq uauaua.inputGHDMZSK(testorRight).asInstanceOf[GetValue].value)
    }
  }

}
