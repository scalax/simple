package net.scalax.simple
package nat
package number2

import core.Core2

object RunMain {

  case class PosotiveCount(tail: () => Core2) extends Core2 {
    override def apply(t: () => Core2): Core2 = throw new Exception
  }

  def countStackoverflow(number: () => Core2): Int = {
    val opt =
      try Some(number())
      catch {
        case _: StackOverflowError => None
      }
    opt match {
      case Some(PosotiveCount(tail)) => countStackoverflow(tail) + 1
      case _                         => 0
    }
  }

  def count(number: () => Core2): Option[Int] = Option(countStackoverflow(number)).filter(_ < 500)

  val T: Core2 = Number.Core2(tail => Number.Core2(number => Number.S(number)(tail)))

  val SImpl: Core2 = Number.Core2(tail => Number.Core2(number => PosotiveCount(() => Number.S(tail)(number))))
  val TImpl: Core2 = Number.Core2(tail => Number.Core2(number => PosotiveCount(() => T(tail)(number))))

  val numbersZero: Core2     = Number.S(() => numbersZero)
  val numbertZero: Core2     = T(() => numbertZero)
  val numbertZeroImpl: Core2 = TImpl(() => numbertZeroImpl)

  def numbersGen(n: Int, zero: => Core2): Core2     = if (n > 0) SImpl(() => numbersGen(n - 1, zero)) else zero
  def numbertGen(n: Int, zero: => Core2): Core2     = if (n > 0) T(() => numbertGen(n - 1, zero)) else zero
  def numbertImplGen(n: Int, zero: => Core2): Core2 = if (n > 0) TImpl(() => numbertImplGen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {
    locally {

      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1: Core2 = numbersGen(i1, numbertZero)
        locally {
          val number2: Core2 = numbersGen(i2, numbertZero)
          def number3: Core2 = number1.apply(() => number2)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1 + i2)
        }
        locally {
          val number2: Core2 = numbersGen(i2, numbersZero)
          def number3: Core2 = number1.apply(() => number2)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1 + i2)
        }
        locally {
          val number2: Core2 = numbertImplGen(i2, numbersZero)
          def number3: Core2 = number1.apply(() => number2)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1 + i2)
        }
        locally {
          val number2: Core2 = numbertImplGen(i2, numbertZero)
          def number3: Core2 = number1.apply(() => number2)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1 + i2)
        }

        val number4: Core2 = numbertImplGen(i1, numbertZero)
        locally {
          val number5: Core2 = numbersGen(i2, numbertZero)
          def number6: Core2 = number4.apply(() => number5)
          val count1         = countStackoverflow(() => number6)
          assert(count1 == i1 + i2)
        }
        locally {
          val number5: Core2 = numbertImplGen(i2, numbertZero)
          def number6: Core2 = number4.apply(() => number5)
          val count1         = countStackoverflow(() => number6)
          assert(count1 == i1 + i2)
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1: Core2 = numbertGen(i1, numbersZero)
        val number2: Core2 = numbertGen(i2, numbertZeroImpl)
        def number3: Core2 = number1.apply(() => number2)
        val count1         = countStackoverflow(() => number3)
        val count2         = if (i1 >= i2) i1 - i2 else 0
        assert(count1 == count2)
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1                     = numbertGen(i1, numbersZero)
        lazy val number2Positive: Core2 = numbersGen(i2, number2Zero)
        lazy val number2Zero: Core2     = T(() => number2Positive)
        locally {
          def number3: Core2 = number1.apply(() => number2Positive)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1 * i2)
        }
        locally {
          def number3: Core2 = number2Zero.apply(() => number1)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1 * i2)
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 5
        i2 <- 1 to 20
        i3 <- 0 to i2 - 1
      } {
        val number1: Core2              = numbertGen(i1 * i2 + i3, numbersZero)
        lazy val number2Positive: Core2 = numbertGen(i2, number2Zero)
        lazy val number2Zero: Core2     = SImpl(() => number2Positive)
        locally {
          def number3: Core2 = number1.apply(() => number2Zero)
          val count1         = countStackoverflow(() => number3)
          val count2         = if (i3 == 0) i1 else i1 + 1
          assert(count1 == count2)
        }
        locally {
          def number3: Core2 = number2Positive.apply(() => number1)
          val count1         = countStackoverflow(() => number3)
          assert(count1 == i1)
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1: Core2              = numbertGen(i1, numbersZero)
        lazy val number2Positive: Core2 = numbertGen(i2, number2Zero)
        lazy val number2Zero: Core2     = SImpl(() => number2Positive)
        locally {
          def number3: Core2 = number2Positive.apply(() => number1)
          val count1         = count(() => number3)
          val result1        = if (i2 == 0) Option.empty else Option(i1 / i2)
          assert(count1 == result1)
        }
        locally {
          def number3: Core2 = number1.apply(() => number2Zero)
          val count1         = count(() => number3)
          val result1        = if (i1 == 0 && i2 == 0) Option(0) else if (i2 == 0) Option.empty else Option((i1 + i2 - 1) / i2)
          assert(count1 == result1)
        }
      }
    }
  }

}
