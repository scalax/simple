package net.scalax.simple.adt
package test

import scala.collection.compat._

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
    override def inputGHDMZSK(tail: => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(func: => ghdmzsk): ghdmzsk = tail
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
        val num2: ghdmzsk = takeProperty.inputGHDMZSK(emptyGhdmzsk).inputGHDMZSK(func2)
        val num1: ghdmzsk = takeProperty.inputGHDMZSK(num2).inputGHDMZSK(func1)
        num1.inputGHDMZSK(selector)
      }
    }
  }

  val a1VImpl: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(selector: => ghdmzsk): ghdmzsk = {
      val func2: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = other
      }
      val num2: ghdmzsk = takeProperty.inputGHDMZSK(emptyGhdmzsk).inputGHDMZSK(func2)
      val num1: ghdmzsk = takeProperty.inputGHDMZSK(num2).inputGHDMZSK(aZero)
      num1.inputGHDMZSK(selector)
    }
  }

  val aZero: ghdmzsk = new ghdmzsk with GetValue {
    override def value: Any                           = "wowowower爱爱啊"
    override def inputGHDMZSK(t: => ghdmzsk): ghdmzsk = t.inputGHDMZSK(aZero)
  }

  val numData: ghdmzsk =
    a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1Impl1.inputGHDMZSK(a1VImpl)))))

  val func1ToUse = numData.inputGHDMZSK(takeHead)

  trait GetValue {
    def value: Any
  }

  def main(arr: Array[String]): Unit = {
    val r        = func1ToUse.inputGHDMZSK(identityGhdmzsk)
    val valueGet = r.asInstanceOf[GetValue].value
    println(valueGet)
  }

}
