package net.scalax.simple
package nat
package number4

object RunMain1 {

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

  val SCount: Count => Number.Core2 = count =>
    Number.Core2(tail1 =>
      Number.Core2(tail2 =>
        Number.Core2 { tail3 =>
          count.up
          tail1()(tail2)(tail3)
        }
      )
    )

  def number2Gen(n: Int, zero: => Number.Core2): Number.Core2 = if (n > 0) Number.T(() => number2Gen(n - 1, zero)) else zero
  def number3Gen(n: Int, zero: => Number.Core2): Number.Core2 = if (n > 0) Number.U(() => number3Gen(n - 1, zero)) else zero

  def confirm(type1: Int, type2: Int, type3: Int, num2TakePositive: Boolean, num3TakePositive: Boolean): (Int, Int, Int) => Option[Int] = {
    (i1, i2, i3) =>
      val count: Count                       = Count.newInstance
      val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
      lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
      lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
      lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
      lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)

      val num2 = if (num2TakePositive) number2Positive else number2Zero
      val num3 = if (num3TakePositive) number3Positive else number3Zero

      def takeNum(n: Int): Number.Core2 = n match {
        case 1 => number1
        case 2 => num2
        case 3 => num3
      }

      def numResult = () => takeNum(type1)(() => takeNum(type2))(() => takeNum(type3))

      run(numResult)
      Some(count.value).filter(_ < 500)
  }

  def main1(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 0 to 15
        i2 <- 0 to 15
        i3 <- 0 to 15
      } {
        val result1: Option[Int] = {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
          lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
          lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)
          val r1                                 = () => number2Positive(() => number3Positive)(() => number1)
          run(r1)
          Some(count.value).filter(_ < 500)
        }

        val result2: Option[Int] = {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
          lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
          lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)
          val r2                                 = () => number3Positive(() => number1)(() => number2Positive)
          run(r2)
          count.value
          Some(count.value).filter(_ < 500)
        }

        val result3: Option[Int] = {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
          lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
          lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)
          val r3                                 = () => number2Zero(() => number1)(() => number3Positive)
          run(r3)
          count.value
          Some(count.value).filter(_ < 500)
        }

        val countInt1: Option[Int] = {
          if (i1 == 0 && i2 == 0) Option(0)
          else if (i2 == 0 || i3 == 0) Option.empty
          else Option(i1 / (i2 * i3))
        }
        assert(countInt1 == result1)

        if (i2 > 0 && i3 > 0) {
          val countIntPositive1: Option[Int] = Some(i1 / i2 / i3)
          val countIntPositive2: Option[Int] = Some(i1 / (i2 * i3))
          assert(countIntPositive1 == result1)
          assert(countIntPositive1 == result2)
          assert(countIntPositive1 == result3)
          assert(countIntPositive1 == countIntPositive2)
        }
      }
    }

    println("Step 1, all 3 steps.")

    locally {
      for {
        i1 <- 0 to 15
        i2 <- 1 to 15
        i3 <- 1 to 15
      } {
        val result1: Option[Int] = {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
          lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
          lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)
          val r1: () => Number.Core2             = () => number1(() => number3Zero)(() => number2Positive)
          run(r1)
          Some(count.value).filter(_ < 500)
        }

        val result2: Option[Int] = {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
          lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
          lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)
          val r2: () => Number.Core2             = () => number1(() => number2Zero)(() => number3Zero)
          run(r2)
          Some(count.value).filter(_ < 500)
        }

        val result3: Option[Int] = {
          val count: Count                       = Count.newInstance
          val number1: Number.Core2              = number2Gen(i1, Number.numbersZero)
          lazy val number2Positive: Number.Core2 = number2Gen(i2, number2Zero)
          lazy val number2Zero: Number.Core2     = Number.U(() => number2Positive)
          lazy val number3Positive: Number.Core2 = number3Gen(i3, number3Zero)
          lazy val number3Zero: Number.Core2     = SCount(count)(() => number3Positive)
          val r3: () => Number.Core2             = () => number2Zero(() => number3Zero)(() => number1)
          run(r3)
          Some(count.value).filter(_ < 500)
        }

        val countIntPositive1: Option[Int] = Some((((i1 + i2 - 1) / i2) + i3 - 1) / i3)
        val countIntPositive2: Option[Int] = Some((i1 + i2 * i3 - 1) / (i2 * i3))

        assert(countIntPositive1 == result1)
        assert(countIntPositive1 == result2)
        assert(countIntPositive1 == result3)
        assert(countIntPositive1 == countIntPositive2)
      }
    }

    println("Step 2, all 3 steps.")

    locally { () =>
      val testCol = for {
        i1 <- 1 to 3
        i2 <- 1 to 3
        i3 <- 1 to 3
      } yield ((i1, i2, i3), Set(i1, i2, i3))
      val dataCol = testCol.filter(_._2.size == 3).map(_._1)

      for {
        num2TakePositive      <- List(true, false)
        num3TakePositive      <- List(true, false)
        (type1, type2, type3) <- dataCol
      } {
        val confirmListData = for {
          i1 <- 0 to 15
          i2 <- 1 to 8
          i3 <- 1 to 8
        } yield {
          val yunsuan =
            confirm(type1 = type1, type2 = type2, type3 = type3, num2TakePositive = num2TakePositive, num3TakePositive = num3TakePositive)
          yunsuan(i1, i2, i3) == Some((i1 + i2 * i3 - 1) / (i2 * i3))
        }
        val confirmYunsuan = confirmListData.forall(identity)
        if (confirmYunsuan) {
          println(s"Confirm: ($type1, $type2, $type3), num2TakePositive: $num2TakePositive, num3TakePositive: $num3TakePositive")
        }
      }
    }

    println("Step 3, all 3 steps.")

  }

}
