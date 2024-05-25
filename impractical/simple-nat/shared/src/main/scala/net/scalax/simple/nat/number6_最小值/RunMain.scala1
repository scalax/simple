package net.scalax.simple
package nat
package number6

object RunMain {

  def countNumber3(number: Number3): Int = number match {
    case Number3S(tail) => countNumber3(tail) + 1
    case Number3T       => 0
  }

  def number1Gen(n: Int): Number1 = if (n > 0) Number1S(number1Gen(n - 1)) else Number1T
  def number2Gen(n: Int): Number2 = if (n > 0) Number2S(() => number2Gen(n - 1)) else Number2T

  def main1(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 1 to 20
        i2 <- 1 to 20
      } {
        locally {
          val number1: Number1 = number1Gen(i1)
          val number2: Number2 = number2Gen(i2)

          val result1 = countNumber3(number1.method1(number2))
          val result2 = math.min(i1, i2)

          assert(result1 == result2)
        }
        locally {
          val number1: Number1 = number1Gen(i1)
          val number2: Number2 = number2Gen(i2)

          val result1 = countNumber3(number2.method2(number1))
          val result2 = math.min(i1 + 1, i2)

          assert(result1 == result2)
        }
      }
    }
  }

}
