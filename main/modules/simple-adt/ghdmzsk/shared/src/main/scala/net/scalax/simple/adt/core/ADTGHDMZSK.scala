package net.scalax.simple.adt
package implemention

import net.scalax.simple.ghdmzsk.ghdmzsk

object ADTGHDMZSK {

  lazy val throwExceptionGhdmzsk: () => ghdmzsk = () => throwExceptionGhdmzsk()

  val identityGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = t()
  }

  object TakePropertyUtils {
    val takeTail: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(numTail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(func: () => ghdmzsk): ghdmzsk = tail().inputGHDMZSK(numTail)
        }
      }
    }
    val takeHead: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(func: () => ghdmzsk): ghdmzsk = func()
      }
    }

    val cutADTListByIndex: ghdmzsk         = takeHead
    val cutInputFunctionByADTList: ghdmzsk = takeTail.inputGHDMZSK(() => takeHead)
    val findADTData: ghdmzsk = {
      val temp1: ghdmzsk = takeTail.inputGHDMZSK(() => takeHead)
      takeTail.inputGHDMZSK(() => temp1)
    }
  }

  val takeProperty: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(func: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(selector: () => ghdmzsk): ghdmzsk = {
          val temp1 = selector().inputGHDMZSK(tail)
          temp1.inputGHDMZSK(func)
        }
      }
    }
  }

  val a1Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(selector: () => ghdmzsk): ghdmzsk = {
        val tailFunc = tail().inputGHDMZSK(selector)
        val func1: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(data: () => ghdmzsk): ghdmzsk = tailFunc.inputGHDMZSK(data)
        }
        val func2: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(() => tailFunc)
        }
        val func3: ghdmzsk = func2
        val num2: ghdmzsk  = takeProperty.inputGHDMZSK(throwExceptionGhdmzsk).inputGHDMZSK(() => func1)
        val num1: ghdmzsk  = takeProperty.inputGHDMZSK(() => num2).inputGHDMZSK(() => func2)
        val num0: ghdmzsk  = takeProperty.inputGHDMZSK(() => num1).inputGHDMZSK(() => func3)
        num0.inputGHDMZSK(selector)
      }
    }
  }

  def a1VImpl(value: Any): ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(selector: () => ghdmzsk): ghdmzsk = {
        lazy val tailFunc: ghdmzsk = tail().inputGHDMZSK(selector)
        val func2: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
        }
        val func3: ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = {
            val value1: Any = value
            other().inputGHDMZSK(() =>
              new GetValue with ghdmzsk {
                override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = tailFunc.inputGHDMZSK(t)
                override def value: Any                              = value1
              }
            )
          }
        }
        val num2: ghdmzsk = takeProperty.inputGHDMZSK(throwExceptionGhdmzsk).inputGHDMZSK(() => aZero(value))
        val num1: ghdmzsk = takeProperty.inputGHDMZSK(() => num2).inputGHDMZSK(() => func2)
        val num0: ghdmzsk = takeProperty.inputGHDMZSK(() => num1).inputGHDMZSK(() => func3)
        num0.inputGHDMZSK(selector)
      }
    }
  }

  def aZero(value: Any): ghdmzsk = {
    val value1: Any = value
    def aZeroImpl: ghdmzsk = new ghdmzsk with GetValue {
      override def value: Any                              = value1
      override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = t().inputGHDMZSK(() => aZeroImpl)
    }
    aZeroImpl
  }

  trait GetValue {
    def value: Any
  }

  def genImpl1(value: Any): ghdmzsk = {
    val value1: Any = value
    new ghdmzsk {
      override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with GetValue {
        override def value: Any                                  = value1
        override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
      }
    }
  }

  val numData: ghdmzsk =
    a1Impl1.inputGHDMZSK(() =>
      a1Impl1.inputGHDMZSK(() =>
        a1Impl1.inputGHDMZSK(() =>
          a1Impl1.inputGHDMZSK(() =>
            a1Impl1.inputGHDMZSK { () =>
              lazy val mmee: ghdmzsk = a1VImpl("呜呜呜").inputGHDMZSK(() => mmee)
              mmee
            }
          )
        )
      )
    )

  def genImpl2(i: Int): ghdmzsk = genImpl1(i).inputGHDMZSK(() => genImpl2(i + 2))

  val genNum: ghdmzsk = genImpl2(1)

  val func1ToUse: ghdmzsk = numData.inputGHDMZSK(() => TakePropertyUtils.findADTData)
  val func2ToUse: ghdmzsk = numData.inputGHDMZSK(() => TakePropertyUtils.cutInputFunctionByADTList)

  lazy val uk: ghdmzsk = a1VImpl("我爱你").inputGHDMZSK(() => uk)
  val aa: ghdmzsk = a1Impl1.inputGHDMZSK(() =>
    a1Impl1.inputGHDMZSK(() =>
      a1Impl1.inputGHDMZSK(() =>
        a1Impl1.inputGHDMZSK(() =>
          a1Impl1.inputGHDMZSK(() => a1VImpl("呜呜呜").inputGHDMZSK(() => a1Impl1.inputGHDMZSK(() => a1Impl1.inputGHDMZSK(() => uk))))
        )
      )
    )
  )
  val tempPositive: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
    }
  }
  val zeroPositive: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
  }
  def genMinus(n: Int): ghdmzsk = if (n > 0)
    tempPositive.inputGHDMZSK(() => genMinus(n - 1))
  else
    zeroPositive

  def main(arr: Array[String]): Unit = {
    val r1: ghdmzsk    = func1ToUse.inputGHDMZSK(() => identityGhdmzsk)
    val valueGet1: Any = r1.asInstanceOf[GetValue].value
    val r2: ghdmzsk    = func2ToUse.inputGHDMZSK(() => genNum)
    val valueGet2: Int = r2.asInstanceOf[GetValue].value.asInstanceOf[Int]
    println(valueGet1)
    println(valueGet2)
    val hh: ghdmzsk = aa.inputGHDMZSK(() => TakePropertyUtils.cutADTListByIndex)
    println(hh.inputGHDMZSK(() => genMinus(4)) match {
      case u: GetValue => Some(u.value)
      case _           => Option.empty
    })
    println(hh.inputGHDMZSK(() => genMinus(5)) match {
      case u: GetValue => Some(u.value)
      case _           => Option.empty
    })
    println(hh.inputGHDMZSK(() => genMinus(6)) match {
      case u: GetValue => Some(u.value)
      case _           => Option.empty
    })
    println(hh.inputGHDMZSK(() => genMinus(7)) match {
      case u: GetValue => Some(u.value)
      case _           => Option.empty
    })
    println(hh.inputGHDMZSK(() => genMinus(8)) match {
      case u: GetValue => Some(u.value)
      case _           => Option.empty
    })
    println(hh.inputGHDMZSK(() => genMinus(9)) match {
      case u: GetValue => Some(u.value)
      case _           => Option.empty
    })
  }

}
