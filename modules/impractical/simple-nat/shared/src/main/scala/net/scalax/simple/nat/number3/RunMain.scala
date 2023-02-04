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

  def count(number: () => Number.Core2): Option[Int] =
    (try
      number() match {
        case Number.PosotiveCount(tail) => for (nextInt <- count(tail)) yield nextInt + 1
      }
    catch {
      case _: StackOverflowError => Some(0)
    }).filter(_ < 500)

  val SImpl1: Count => Number.Core2 = count =>
    Number.Core2(tail =>
      Number.Core2 { number =>
        count.up
        tail()(number)
      }
    )
  val TImpl1: Count => Number.Core2 = count =>
    Number.Core2(tail =>
      Number.Core2 { number =>
        count.up
        number()(tail)
      }
    )

  val numbertZeroImpl1: Count => Number.Core2 = count => TImpl1(count)(() => numbertZeroImpl1(count))

  def numbers1Gen(n: Int, count: Count, zero: => Number.Core2): Number.Core2 =
    if (n > 0) SImpl1(count)(() => numbers1Gen(n - 1, count, zero)) else zero

  def numbertImpl1Gen(n: Int, count: Count, zero: => Number.Core2): Number.Core2 =
    if (n > 0) TImpl1(count)(() => numbertImpl1Gen(n - 1, count, zero)) else zero

  def numbersGen(n: Int, zero: => Number.Core2): Number.Core2     = if (n > 0) Number.SImpl(() => numbersGen(n - 1, zero)) else zero
  def numbertGen(n: Int, zero: => Number.Core2): Number.Core2     = if (n > 0) Number.T(() => numbertGen(n - 1, zero)) else zero
  def numbertImplGen(n: Int, zero: => Number.Core2): Number.Core2 = if (n > 0) Number.TImpl(() => numbertImplGen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        locally {
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbers1Gen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbers1Gen(i2, count, Number.numbertZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbers1Gen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbers1Gen(i2, count, Number.numbersZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbers1Gen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbertImpl1Gen(i2, count, Number.numbersZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number1: Number.Core2       = numbers1Gen(i1, count, Number.numbertZero)
            val number2: Number.Core2       = numbertImpl1Gen(i2, count, Number.numbersZero)
            val number3: () => Number.Core2 = () => number1(() => number2)
            run(number3)
            val result = count.value
            assert(result == i1 + i2)
          }
        }

        locally {
          locally {
            val count: Count                = Count.newInstance
            val number4: Number.Core2       = numbertImpl1Gen(i1, count, Number.numbertZero)
            val number5: Number.Core2       = numbers1Gen(i2, count, Number.numbertZero)
            val number6: () => Number.Core2 = () => number4(() => number5)
            run(number6)
            val result = count.value
            assert(result == i1 + i2)
          }
          locally {
            val count: Count                = Count.newInstance
            val number4: Number.Core2       = numbertImpl1Gen(i1, count, Number.numbertZero)
            val number5: Number.Core2       = numbertImpl1Gen(i2, count, Number.numbertZero)
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
        val number2: Number.Core2       = numbertGen(i2, numbertZeroImpl1(count))
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
        val number1                            = numbertGen(i1, Number.numbersZero)
        lazy val number2Positive: Number.Core2 = numbersGen(i2, number2Zero)
        lazy val number2Zero: Number.Core2     = Number.T(() => number2Positive)
        locally {
          def number3: Number.Core2 = number1.apply(() => number2Positive)
          val count1                = count(() => number3)
          assert(count1 == Some(i1 * i2))
        }
        locally {
          def number3: Number.Core2 = number2Zero.apply(() => number1)
          val count1                = count(() => number3)
          assert(count1 == Some(i1 * i2))
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 5
        i2 <- 1 to 20
        i3 <- 0 to i2 - 1
      } {
        val number1: Number.Core2              = numbertGen(i1 * i2 + i3, Number.numbersZero)
        lazy val number2Positive: Number.Core2 = numbertGen(i2, number2Zero)
        lazy val number2Zero: Number.Core2     = Number.SImpl(() => number2Positive)
        locally {
          def number3: Number.Core2 = number1.apply(() => number2Zero)
          val count1                = count(() => number3)
          val count2                = Some(if (i3 == 0) i1 else i1 + 1)
          assert(count1 == count2)
        }
        locally {
          def number3: Number.Core2 = number2Positive.apply(() => number1)
          val count1                = count(() => number3)
          assert(count1 == Some(i1))
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1: Number.Core2              = numbertGen(i1, Number.numbersZero)
        lazy val number2Positive: Number.Core2 = numbertGen(i2, number2Zero)
        lazy val number2Zero: Number.Core2     = Number.SImpl(() => number2Positive)
        locally {
          def number3: Number.Core2 = number2Positive.apply(() => number1)
          val count1                = count(() => number3)
          val result1               = if (i2 == 0) Option.empty else Option(i1 / i2)
          assert(count1 == result1)
        }
        locally {
          def number3: Number.Core2 = number1.apply(() => number2Zero)
          val count1                = count(() => number3)
          val result1               = if (i1 == 0 && i2 == 0) Option(0) else if (i2 == 0) Option.empty else Option((i1 + i2 - 1) / i2)
          println(i1, i2, count1, result1)
          assert(count1 == result1)
        }
      }
    }
  }

}
