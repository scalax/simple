package net.scalax.simple
package nat

import core.Core2

object RunMain {

  case class PosotiveCount(tail: () => Core2) extends Core2 {
    override def apply(t: () => Core2): Core2 = throw new Exception
  }

  def count(number: () => Core2): Int = {
    val opt =
      try Some(number())
      catch {
        case _: StackOverflowError => None
      }
    opt match {
      case Some(PosotiveCount(tail)) => count(tail) + 1
      case _                         => 0
    }
  }

  val SImpl = NumberImpl.Core2(tail => NumberImpl.Core2(number => PosotiveCount(() => NumberImpl.S(tail)(number))))
  val TImpl = NumberImpl.Core2(tail => NumberImpl.Core2(number => PosotiveCount(() => NumberImpl.T(tail)(number))))

  lazy val number1s: Core2     = NumberImpl.S(() => number1s)
  lazy val number1t: Core2     = NumberImpl.T(() => number1t)
  lazy val number1tImpl: Core2 = TImpl(() => number1tImpl)

  def number1sGen(n: Int, zero: => Core2): Core2 = if (n > 0) SImpl(() => number1sGen(n - 1, zero)) else zero
  def number1vGen(n: Int, zero: => Core2): Core2 = if (n > 0) NumberImpl.T(() => number1vGen(n - 1, zero)) else zero
  def number1uGen(n: Int, zero: => Core2): Core2 = if (n > 0) TImpl(() => number1uGen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1 = number1sGen(i1, number1t)
        locally {
          val number2 = number1sGen(i2, number1t)
          def number3 = number1.apply(() => number2)
          val count1  = count(() => number3)
          assert(count1 == i1 + i2)
        }
        locally {
          val number2 = number1sGen(i2, number1s)
          def number3 = number1.apply(() => number2)
          val count1  = count(() => number3)
          assert(count1 == i1 + i2)
        }
        locally {
          val number2 = number1uGen(i2, number1s)
          def number3 = number1.apply(() => number2)
          val count1  = count(() => number3)
          assert(count1 == i1 + i2)
        }
        locally {
          val number2 = number1uGen(i2, number1t)
          def number3 = number1.apply(() => number2)
          val count1  = count(() => number3)
          assert(count1 == i1 + i2)
        }

        val number4 = number1uGen(i1, number1t)
        locally {
          val number5 = number1sGen(i2, number1t)
          def number6 = number4.apply(() => number5)
          val count1  = count(() => number6)
          assert(count1 == i1 + i2)
        }
        locally {
          val number5 = number1uGen(i2, number1t)
          def number6 = number4.apply(() => number5)
          val count1  = count(() => number6)
          assert(count1 == i1 + i2)
        }
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1 = number1vGen(i1, number1s)
        val number2 = number1vGen(i2, number1tImpl)
        def number3 = number1.apply(() => number2)
        val count1  = count(() => number3)
        val count2  = if (i1 >= i2) i1 - i2 else 0
        assert(count1 == count2)
      }
    }
    locally {
      for {
        i1 <- 0 to 20
        i2 <- 0 to 20
      } {
        val number1                     = number1vGen(i1, number1s)
        lazy val number2Positive: Core2 = number1sGen(i2, number2Zero)
        lazy val number2Zero: Core2     = NumberImpl.T(() => number2Positive)
        locally {
          def number3 = number1.apply(() => number2Positive)
          val count1  = count(() => number3)
          assert(count1 == i1 * i2)
        }
        locally {
          def number3 = number2Zero.apply(() => number1)
          val count1  = count(() => number3)
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
        val number1                     = number1vGen(i1 * i2 + i3, number1s)
        lazy val number2Positive: Core2 = number1vGen(i2, number2Zero)
        lazy val number2Zero: Core2     = SImpl(() => number2Positive)
        locally {
          def number3 = number1.apply(() => number2Zero)
          val count1  = count(() => number3)
          val count2  = if (i3 == 0) i1 else i1 + 1
          assert(count1 == count2)
        }
        locally {
          def number3 = number2Positive.apply(() => number1)
          val count1  = count(() => number3)
          assert(count1 == i1)
        }
      }
    }
  }

}
