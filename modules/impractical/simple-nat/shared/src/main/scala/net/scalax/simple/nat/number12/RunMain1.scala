package net.scalax.simple.nat.number12

import net.scalax.simple.core.Core2

object RunMain1 extends App{

  val list1: List[Int] = List.empty
  for (_ <- 1 to 10000) {
    for {
      i1 <- 1 to 20
      i2 <- 1 to 20
    } yield {
      var tag1: Int = 0
      var tag2: Int = 0

      def num1(n1: Int): Core2 = {
        lazy val numPositive: Core2 =
          if (n1 > 0) Core2(tail => Core2(other => other()(tail)))(() => num1(n1 - 1))
          else numZero
        lazy val numZero: Core2 = Core2(tail =>
          Core2 { other =>
            tag1 = tag1 + 1
            tail()(other)
          }
        )(() => numPositive)
        numPositive
      }
      val number1: Core2 = num1(i1)

      def num2(n2: Int): Core2 = {
        lazy val numPositive: Core2 =
          if (n2 > 0) Core2(tail => Core2(other => other()(tail)))(() => num2(n2 - 1))
          else numZero
        lazy val numZero: Core2 = Core2(tail =>
          Core2 { other =>
            tag2 = tag2 + 1
            tail()(other)
          }
        )(() => numPositive)
        numPositive
      }
      val number2: Core2 = num2(i2)


    }
  }

}
