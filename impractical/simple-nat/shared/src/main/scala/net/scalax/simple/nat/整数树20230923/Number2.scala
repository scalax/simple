package net.scalax.simple.nat.整数树20230923

import scala.util.Random

object 整数树Runnersdfsdfwaerwerwer {

  def randomGen: Int = math.abs(Random.nextInt() % 10)

  object GenNumber1 {
    def gen1(n1: Int, n2: Int, deep: Int, tail1: => Number1_1, tail2: => Number1_2): Number1_1 = {
      if (deep > 0 && n1 > 0) {
        val m1    = randomGen
        val m2    = randomGen
        val left1 = if (n1 - 1 - m1 > 0) n1 - 1 - m1 else 0
        val left2 = if (n2 - m1 > 0) n2 - m1 else 0
        Number1_1T(gen1(n1 - left1 - 1 + m2, n2 - left2 + m2, deep - 1, tail1, tail2), gen2(left1 + m2, left2 + m2, deep - 1, tail1, tail2))
      } else {
        if (n1 > 0)
          Number1_1S(gen1(n1 - 1, n2, deep, tail1, tail2))
        else if (n2 > 0)
          Number1_1T(tail1, Number1_2S(gen2(n1, n2, deep, tail1, tail2)))
        else
          tail1
      }
    }

    def gen2(n1: Int, n2: Int, deep: Int, tail1: => Number1_1, tail2: => Number1_2): Number1_2 = {
      if (deep > 0 && n2 > 0) {
        val m1    = randomGen
        val m2    = randomGen
        val left1 = if (n1 - m1 > 0) n1 - m1 else 0
        val left2 = if (n2 - 1 - m1 > 0) n2 - 1 - m1 else 0
        Number1_2T(gen2(n1 - left1 + m2, n2 - left2 - 1 + m2, deep - 1, tail1, tail2), gen1(left1 + m2, left2 + m2, deep - 1, tail1, tail2))
      } else {
        if (n2 > 0)
          Number1_2S(gen2(n1, n2 - 1, deep, tail1, tail2))
        else if (n1 > 0)
          Number1_2T(tail2, Number1_1S(gen1(n1, n2, deep, tail1, tail2)))
        else
          tail2
      }
    }
  }

  object GenNumber2 {
    def gen1(n1: Int, n2: Int, deep: Int, tail1: => Number2_1, tail2: => Number2_2): Number2_1 = {
      if (deep > 0 && n1 > 0) {
        val m1    = randomGen
        val m2    = randomGen
        val left1 = if (n1 - 1 - m1 > 0) n1 - 1 - m1 else 0
        val left2 = if (n2 - m1 > 0) n2 - m1 else 0
        Number2_1T(gen1(n1 - left1 - 1 + m2, n2 - left2 + m2, deep - 1, tail1, tail2), gen2(left1 + m2, left2 + m2, deep - 1, tail1, tail2))
      } else {
        if (n1 > 0)
          Number2_1S(gen1(n1 - 1, n2, deep, tail1, tail2))
        else if (n2 > 0)
          Number2_1T(tail1, Number2_2S(gen2(n1, n2, deep, tail1, tail2)))
        else
          tail1
      }
    }

    def gen2(n1: Int, n2: Int, deep: Int, tail1: => Number2_1, tail2: => Number2_2): Number2_2 = {
      if (deep > 0 && n2 > 0) {
        val m1    = randomGen
        val m2    = randomGen
        val left1 = if (n1 - m1 > 0) n1 - m1 else 0
        val left2 = if (n2 - 1 - m1 > 0) n2 - 1 - m1 else 0
        Number2_2T(gen2(n1 - left1 + m2, n2 - left2 - 1 + m2, deep - 1, tail1, tail2), gen1(left1 + m2, left2 + m2, deep - 1, tail1, tail2))
      } else {
        if (n2 > 0)
          Number2_2S(gen2(n1, n2 - 1, deep, tail1, tail2))
        else if (n1 > 0)
          Number2_2T(tail2, Number2_1S(gen1(n1, n2, deep, tail1, tail2)))
        else
          tail2
      }
    }
  }

  case class Num(i1: Int, i2: Int) {
    def plus(other: Num): Num = Num(i1 = i1 + other.i1, i2 = i2 + other.i2)
    def upI1: Num             = Num(i1 = i1 + 1, i2 = i2)
    def upI2: Num             = Num(i1 = i1, i2 = i2 + 1)
    def value: Int            = i1 - i2
  }

  object paramCount1 {
    def count1(num1_1: Number1_1): Num = num1_1 match {
      case Number1_1S(tail1) =>
        val n1 = count1(tail1)
        n1.upI1
      case Number1_1T(tail1, tail2) =>
        val n1 = count1(tail1)
        val n2 = count2(tail2)
        n1.plus(n2).upI1
      case Number1_1U.Value => Num(i1 = 0, i2 = 0)
    }

    def count2(num1_2: Number1_2): Num = num1_2 match {
      case Number1_2S(tail2) =>
        val n2 = count2(tail2)
        n2.upI2
      case Number1_2T(tail2, tail1) =>
        val n1 = count1(tail1)
        val n2 = count2(tail2)
        n1.plus(n2).upI2
      case Number1_2U.Value => Num(i1 = 0, i2 = 0)
    }
  }

  object paramCount2 {
    def count1(num2: Number2_1): Num = num2 match {
      case Number2_1S(tail1) =>
        val n1 = count1(tail1)
        n1.upI1
      case Number2_1T(tail1, tail2) =>
        val n1 = count1(tail1)
        val n2 = count2(tail2)
        n1.plus(n2).upI1
      case Number2_1U.Value => Num(i1 = 0, i2 = 0)
    }

    def count2(num2: Number2_2): Num = num2 match {
      case Number2_2S(tail2) =>
        val n2 = count2(tail2)
        n2.upI2
      case Number2_2T(tail2, tail1) =>
        val n1 = count1(tail1)
        val n2 = count2(tail2)
        n1.plus(n2).upI2
      case Number2_2U.Value => Num(i1 = 0, i2 = 0)
    }
  }

  object resultCount {
    def count1(num1: Number3_1): Num = num1 match {
      case Number3_1S(tail) =>
        val n1 = count1(tail())
        n1.upI1
      case Number3_1T(tail1, tail2) =>
        val (n1, n2) = (count1(tail1()), count2(tail2()))
        n1.plus(n2).upI1
      case Number3_1U.Value => Num(i1 = 0, i2 = 0)
    }

    def count2(num2: Number3_2): Num = num2 match {
      case Number3_2S(tail) =>
        val n1 = count2(tail())
        n1.upI2
      case Number3_2T(tail2, tail1) =>
        val (n1, n2) = (count1(tail1()), count2(tail2()))
        n1.plus(n2).upI2
      case Number3_2U.Value => Num(i1 = 0, i2 = 0)
    }
  }

  def main(arr: Array[String]): Unit = {
    for {
      i1 <- -20 to 20
      i2 <- -20 to 20
      i5 <- 1 to 5
    } {
      val m1 = randomGen
      val m2 = randomGen
      val m3 = randomGen
      val m4 = randomGen

      val num1_1: Number1_1 =
        if (i1 > 0) GenNumber1.gen1(m1 + i1, m1, i5, Number1_1U.Value, Number1_2U.Value)
        else GenNumber1.gen1(m1, m1 - i1, i5, Number1_1U.Value, Number1_2U.Value)
      val num1_2: Number1_2 =
        if (i1 > 0) GenNumber1.gen2(m2 + i1, m2, i5, Number1_1U.Value, Number1_2U.Value)
        else GenNumber1.gen2(m2, m2 - i1, i5, Number1_1U.Value, Number1_2U.Value)

      val num2_1: Number2_1 =
        if (i2 > 0) GenNumber2.gen1(m3 + i2, m3, i5, Number2_1U.Value, Number2_2U.Value)
        else GenNumber2.gen1(m3, m3 - i2, i5, Number2_1U.Value, Number2_2U.Value)
      val num2_2: Number2_2 =
        if (i2 > 0) GenNumber2.gen2(m4 + i2, m4, i5, Number2_1U.Value, Number2_2U.Value)
        else GenNumber2.gen2(m4, m4 - i2, i5, Number2_1U.Value, Number2_2U.Value)

      val count1 = paramCount1.count1(num1_1)
      val count2 = paramCount2.count1(num2_1)

      val count3 = resultCount.count1(num1_1.method1(num2_1))

      val count4 = paramCount1.count2(num1_2)
      val count5 = paramCount2.count2(num2_2)

      val count6 = resultCount.count2(num2_2.method4(num1_2))

      assert(count1.value == i1)
      assert(count2.value == i2)
      assert(count3.value == count1.value + count2.value)

      assert(count4.value == i1)
      assert(count5.value == i2)
      assert(count6.value == count4.value + count5.value)
    }

  }

}
