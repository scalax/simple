package net.scalax.simple.adt
package implemention

import net.scalax.simple.ghdmzsk.ghdmzsk

object Disscure {

  val emptyGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = throw new Exception("xuejd")
  }

  val identityGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = t
  }

  val takeProperty: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(func: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(selector: => ghdmzsk): ghdmzsk = selector.inputGHDMZSK(tail).inputGHDMZSK(func)
      }
    }
  }

  val takeTail: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(numTail: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(func: => ghdmzsk): ghdmzsk = tail.inputGHDMZSK(numTail)
      }
    }
  }
  val takeHead: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(func: => ghdmzsk): ghdmzsk = func
    }
  }

  val a1Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(selector: => ghdmzsk): ghdmzsk = {
        val tailFunc = tail.inputGHDMZSK(selector)
        val func1: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(data: => ghdmzsk): ghdmzsk = tailFunc.inputGHDMZSK(data)
        }
        val func2: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = other.inputGHDMZSK(tailFunc)
        }
        val func3: ghdmzsk = func2
        val num2: ghdmzsk  = takeProperty.inputGHDMZSK(emptyGhdmzsk).inputGHDMZSK(func1)
        val num1: ghdmzsk  = takeProperty.inputGHDMZSK(num2).inputGHDMZSK(func2)
        val num0: ghdmzsk  = takeProperty.inputGHDMZSK(num1).inputGHDMZSK(func3)
        num0.inputGHDMZSK(selector)
      }
    }
  }

  def a1VImpl(value: Any): ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(selector: => ghdmzsk): ghdmzsk = {
        lazy val tailFunc: ghdmzsk = tail.inputGHDMZSK(selector)
        val func2: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = other
        }
        val func3: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = other.inputGHDMZSK(tailFunc)
        }
        val num2: ghdmzsk = takeProperty.inputGHDMZSK(emptyGhdmzsk).inputGHDMZSK(aZero(value))
        val num1: ghdmzsk = takeProperty.inputGHDMZSK(num2).inputGHDMZSK(func2)
        val num0: ghdmzsk = takeProperty.inputGHDMZSK(num1).inputGHDMZSK(func3)
        num0.inputGHDMZSK(selector)
      }
    }
  }

  def aZero(value: Any): ghdmzsk = {
    val value1: Any = value
    def aZeroImpl: ghdmzsk = new ghdmzsk with GetValue {
      override def value: Any                           = value1
      override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = t.inputGHDMZSK(aZeroImpl)
    }
    aZeroImpl
  }

  trait GetValue {
    def value: Any
  }

  def genImpl1(value: Any): ghdmzsk = {
    val value1: Any = value
    new ghdmzsk {
      override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk with GetValue {
        override def value: Any                               = value1
        override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = other.inputGHDMZSK(tail)
      }
    }
  }

  /*val numData: ghdmzsk =
    a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1VImpl("呜呜呜"))))))

  def genImpl2(i: Int): ghdmzsk = genImpl1(i).inputGHDMZSK(genImpl2(i + 2))

  val genNum: ghdmzsk = genImpl2(1)

  val func1ToUse: ghdmzsk = numData.inputGHDMZSK(takeTail.inputGHDMZSK(takeHead))
  val func2ToUse: ghdmzsk = numData.inputGHDMZSK(takeHead)

  def main(arr: Array[String]): Unit = {
    val r1: ghdmzsk    = func1ToUse.inputGHDMZSK(identityGhdmzsk)
    val valueGet1: Any = r1.asInstanceOf[GetValue].value
    val r2: ghdmzsk    = func2ToUse.inputGHDMZSK(genNum)
    val valueGet2: Int = r2.asInstanceOf[GetValue].value.asInstanceOf[Int]
    println(valueGet1)
    println(valueGet2)
  }*/

}
