package net.scalax.simple
package nat
package number2

object RunMain {

  def count(number: () => Number.Core2): Option[Int] =
    (try
      number() match {
        case Number.PosotiveCount(tail) => for (nextInt <- count(tail)) yield nextInt + 1
      }
    catch {
      case _: StackOverflowError => Some(0)
    }).filter(_ < 500)

  def numbersGen(n: Int): Number.Core2 = if (n > 0) Number.SCount(() => numbersGen(n - 1)) else Number.SZero

  def main(arr: Array[String]): Unit = {
    locally {
      for (i1 <- 0 to 200) {
        def i1Value: Number.Core2 = numbersGen(i1)
        val r1                    = count(() => i1Value)
        assert(r1 == Some(i1))
      }
    }
  }

}
