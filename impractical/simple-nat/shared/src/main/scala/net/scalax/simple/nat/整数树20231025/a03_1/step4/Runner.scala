package a03_1.step4

object Runner {

  object paramCount {
    def count1(number: Number1): Int = number match {
      case Number1S(tail, head) => count1(tail) + count2(head) + 1
      case Number1T             => 0
    }

    def count2(number: Number2): Int = number match {
      case Number2S(tail, head) => count2(tail) + count1(head) - 1
      case Number2T             => 0
    }
  }

  case class Num(i1: Int, i2: Int)

  object resultCount {
    def count1(number: Number1): Num = number match {
      case Number1S(tail, head) =>
        val m1 = count1(tail)
        val m2 = count2(head)
        Num(i1 = m1.i1 + m2.i1 + 1, i2 = m1.i2 + m2.i2)
      case Number1T => Num(i1 = 0, i2 = 0)
    }

    def count2(number: Number2): Num = number match {
      case Number2S(tail, head) =>
        val m1 = count2(tail)
        val m2 = count1(head)
        Num(i1 = m1.i1 + m2.i1, i2 = m1.i2 + m2.i2 + 1)
      case Number2T => Num(i1 = 0, i2 = 0)
    }
  }

  def randomDeep()   = math.abs(util.Random.nextInt() % 10)
  def randomLength() = math.abs(util.Random.nextInt() % 5)

  def genNumber1(deep: Int): Number1 = {
    if (deep > randomDeep())
      Number1T
    else {
      def genList1(length: Int): Number1 = if (length > 0) Number1S(genList1(length - 1), genNumber2(deep + 1)) else Number1T
      genList1(randomLength())
    }
  }

  def genNumber2(deep: Int): Number2 = {
    if (deep > randomDeep())
      Number2T
    else {
      def genList2(length: Int): Number2 = if (length > 0) Number2S(genList2(length - 1), genNumber1(deep + 1)) else Number2T
      genList2(randomLength())
    }
  }

  def main(): Unit = {
    val number1 = Number1S(
      Number1S(Number1S(Number1S(Number1S(Number1T, Number2T), Number2T), Number2T), Number2T),
      Number2S(Number2S(Number2S(Number2T, Number1S(Number1T, Number2S(Number2T, Number1S(Number1T, Number2T)))), Number1T), Number1T)
    )
    val number2 = Number2S(Number2T, Number1S(Number1T, Number2S(Number2S(Number2S(Number2T, Number1T), Number1T), Number1T)))
    val number3 = number1.method1(number2)
    val number4 = number2.method2(number1)

    val input1  = paramCount.count1(number1)
    val input2  = paramCount.count2(number2)
    val result1 = resultCount.count2(number3)
    val result2 = resultCount.count1(number4)

    assert(input1 == 3)
    assert(input2 == -3)
    assert(input1 + input2 == result1.i1 - result1.i2 + 1)
    assert(input1 + input2 == result2.i1 - result2.i2 - 1)
    assert(input1 + input2 == result1.i1 - result2.i2)
    assert(input1 + input2 == result2.i1 - result1.i2)
    assert((input1 + input2) * 2 == result1.i1 + result2.i1 - result1.i2 - result2.i2)

    for {
      i <- 1 to 15
      _ <- 1 to 3
    } {
      val num1 = genNumber1(-i)
      val num2 = genNumber2(-i - 1)
      val num3 = num1.method1(num2)
      val num4 = num2.method2(num1)

      val n1 = paramCount.count1(num1)
      val n2 = paramCount.count2(num2)
      val n3 = resultCount.count2(num3)
      val n4 = resultCount.count1(num4)

      assert(n1 + n2 == n3.i1 - n3.i2 + 1)
      assert(n1 + n2 == n4.i1 - n4.i2 - 1)
      assert(n1 + n2 == n3.i1 - n4.i2)
      assert(n1 + n2 == n4.i1 - n3.i2)
      assert((n1 + n2) * 2 == n3.i1 + n4.i1 - n3.i2 - n4.i2)
      println(s"$n1 + $n2 = ${n3.i1 - n4.i2} ${n3.i1 - n4.i2 == n1 + n2}")

//38 + 0 = 38 true
//0 + 0 = 0 true
//0 + 264 = 264 true
//1 + 301 = 302 true
//97 + 491 = 588 true
//1 + 0 = 1 true
//291 + 440 = 731 true
//161 + 1929 = 2090 true
//1 + 0 = 1 true
//478 + 0 = 478 true
//1026 + 1545 = 2571 true
//73 + 664 = 737 true
//412 + 1045 = 1457 true
//2370 + 1804 = 4174 true
//3735 + 0 = 3735 true
//2318 + 0 = 2318 true
//2404 + 0 = 2404 true
//110 + 0 = 110 true
//4817 + 4653 = 9470 true
//0 + 2727 = 2727 true
//0 + 9769 = 9769 true
//6228 + 43097 = 49325 true
//2 + 0 = 2 true
//0 + 15387 = 15387 true
//10325 + 37296 = 47621 true
//0 + 0 = 0 true
//0 + 0 = 0 true
//35577 + 76844 = 112421 true
//0 + 26505 = 26505 true
//125240 + 37017 = 162257 true
//50516 + 76906 = 127422 true
//0 + 0 = 0 true
//232847 + 103558 = 336405 true
//59222 + 422781 = 482003 true
//179607 + 0 = 179607 true
//50313 + 128482 = 178795 true
//254557 + 416730 = 671287 true
//1 + 1287130 = 1287131 true
//180805 + 256965 = 437770 true
//200627 + 1176719 = 1377346 true
//85058 + 148224 = 233282 true
//0 + 423756 = 423756 true
//2043445 + 3650304 = 5693749 true
//0 + 695185 = 695185 true
//1834571 + 2100175 = 3934746 true
    }
  }

}
