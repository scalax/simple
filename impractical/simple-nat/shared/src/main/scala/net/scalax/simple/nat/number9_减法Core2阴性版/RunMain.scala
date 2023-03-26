package net.scalax.simple
package nat
package number9

object RunMain {

  def countNumber2(number: Number2): Int = number match {
    case Number2S(tail) => countNumber2(tail) + 1
    case Number2T       => 0
  }

  def number1Gen(n: Int): Number1 = if (n > 0) Number1S(number1Gen(n - 1)) else new Number1T
  def number2Gen(n: Int): Number2 = if (n > 0) Number2S(number2Gen(n - 1)) else Number2T

  def main(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 1 to 20
        i2 <- 1 to 20
      } {
        locally {
          val number1: Number1 = number1Gen(i1)
          val number2: Number2 = number2Gen(i2)

          val result1 = countNumber2(number1(() => number2))
          val result2 = math.max(i2 - i1 + 1, 0)

          assert(result1 == result2)
        }
        locally {
          val number1: Number1 = number1Gen(i1)
          val number2: Number2 = number2Gen(i2)

          val result1 = countNumber2(number2(() => number1))
          val result2 = math.max(i2 - i1, 0)

          assert(result1 == result2)
        }
      }
    }
  }

}
