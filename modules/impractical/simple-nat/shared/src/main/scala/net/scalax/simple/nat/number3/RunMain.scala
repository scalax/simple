package net.scalax.simple
package nat
package number3

object RunMain {

  def run(num: () => Number.Core2): Unit = try
    num()
  catch {
    case _: StackOverflowError =>
  }

  trait Count {
    def up: Unit
    def value: Int
  }

  object Count {
    private class CountInstanceImpl extends Count {
      private var num: Int    = 0
      override def up: Unit   = num = num + 1
      override def value: Int = num
    }
    def newInstance: Count = new CountInstanceImpl
  }

  val SImpl: Count => Number.Core2 = count =>
    Number.Core2(tail =>
      Number.Core2 { number =>
        count.up
        tail()(number)
      }
    )
  val TImpl: Count => Number.Core2 = count =>
    Number.Core2(tail =>
      Number.Core2 { number =>
        count.up
        number()(tail)
      }
    )
  val numbertZeroImpl: Count => Number.Core2 = count =>
    Number.Core2 { number =>
      count.up
      number()(() => numbertZeroImpl(count))
    }

  def numbersImplGen(n: Int, count: Count, zero: => Number.Core2): Number.Core2 =
    if (n > 0) SImpl(count)(() => numbersImplGen(n - 1, count, zero)) else zero
  def numbertImplGen(n: Int, count: Count, zero: => Number.Core2): Number.Core2 =
    if (n > 0) TImpl(count)(() => numbertImplGen(n - 1, count, zero)) else zero
  def numbertGen(n: Int, zero: => Number.Core2): Number.Core2 = if (n > 0) Number.T(() => numbertGen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        locally {
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbersImplGen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbersImplGen(i2, count, Number.numbertZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbersImplGen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbersImplGen(i2, count, Number.numbersZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbersImplGen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbertImplGen(i2, count, Number.numbersZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbersImplGen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbertImplGen(i2, count, Number.numbersZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
        }

        locally {
          locally {
            val count: Count                = Count.newInstance
            val number4: Number.Core2       = numbertImplGen(i1, count, Number.numbertZero)
            val number5: Number.Core2       = numbersImplGen(i2, count, Number.numbertZero)
            val number6: () => Number.Core2 = () => number4(() => number5)
            run(number6)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number4: Number.Core2       = numbertImplGen(i1, count, Number.numbertZero)
            val number5: Number.Core2       = numbertImplGen(i2, count, Number.numbertZero)
            val number6: () => Number.Core2 = () => number4(() => number5)
            run(number6)
            val result = count.value
            assert(result == i1 + i2)
          }
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val count: Count                = Count.newInstance
        val number1: Number.Core2       = numbertGen(i1, Number.numbersZero)
        val number2: Number.Core2       = numbertGen(i2, numbertZeroImpl(count))
        val number3: () => Number.Core2 = () => number1(() => number2)
        run(number3)
        val result = count.value
        val count2 = if (i1 >= i2) i1 - i2 else 0
        assert(result == count2)
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        locally {
          val count: Count                       = Count.newInstance
          val number1                            = numbertGen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = numbersImplGen(i2, count, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.T(() => number2Positive)
          val number3: () => Number.Core2        = () => number1(() => number2Positive)
          run(number3)
          val result = count.value
          assert(result == i1 * i2)
        }
        locally {
          val count: Count                       = Count.newInstance
          val number1                            = numbertGen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = numbersImplGen(i2, count, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.T(() => number2Positive)
          val number3: () => Number.Core2        = () => number2Zero(() => number1)
          run(number3)
          val result = count.value
          assert(result == i1 * i2)
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 5
        i2 <- 1 to 20
        i3 <- 0 to i2 - 1
      } {
        locally {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = numbertGen(i1 * i2 + i3, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = numbertGen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = SImpl(count)(() => number2Positive)
          val number3: () => Number.Core2        = () => number1(() => number2Zero)
          val count2                             = if (i3 == 0) i1 else i1 + 1
          run(number3)
          val result = count.value
          assert(result == count2)
        }
        locally {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = numbertGen(i1 * i2 + i3, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = numbertGen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = SImpl(count)(() => number2Positive)
          val number3: () => Number.Core2        = () => number2Positive(() => number1)
          run(number3)
          val result = count.value
          assert(result == i1)
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        locally {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = numbertGen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = numbertGen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = SImpl(count)(() => number2Positive)
          val number3: () => Number.Core2        = () => number2Positive(() => number1)
          run(number3)
          val count1 = if (i2 == 0) Option.empty else Option(i1 / i2)
          val result = Some(count.value).filter(_ < 1000)
          assert(result == count1)
        }
        locally {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = numbertGen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = numbertGen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = SImpl(count)(() => number2Positive)
          val number3: () => Number.Core2        = () => number1(() => number2Zero)
          run(number3)
          val count1 = Some(count.value).filter(_ < 1000)
          val result = if (i1 == 0 && i2 == 0) Option(0) else if (i2 == 0) Option.empty else Option((i1 + i2 - 1) / i2)
          assert(result == count1)
        }
      }
    }
  }

}
