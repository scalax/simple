package net.scalax.simple
package nat
package number2

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

  def numbersGen(n: Int, count: Count): Number.Core2 = if (n > 0) Number.S { () =>
    count.up
    numbersGen(n - 1, count)
  }
  else Number.SZero

  def main(arr: Array[String]): Unit = {
    locally {
      for (i1 <- 0 to 200) {
        val count: Count                = Count.newInstance
        val i1Value: () => Number.Core2 = () => numbersGen(i1, count)
        run(i1Value)
        val result = count.value
        assert(result == i1)
      }
    }
  }

}
