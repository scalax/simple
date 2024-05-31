package net.scalax.simple.nat
package 整数树20240531

object Runner {

  import ZeroInstance._

  def count(num: Num1 | Num2): Int = num match {
    case Num1Impl1(tail1, tail2)              => count(tail1()) + count(tail2()) + 1
    case Num2Impl1(tail1, tail2)              => count(tail1()) + count(tail2()) - 1
    case Num1Impl2(tail1) if tail1() eq zero1 => 0
    case Num2Impl2(tail2) if tail2() eq zero2 => 0
  }

  def main(arr: Array[String]): Unit = {
    val num1: Num1 =
      Num1Impl1(() => Num1Impl1(() => Num1Impl1(() => zero1, () => Num2Impl1(() => zero1, () => zero2)), () => zero2), () => zero2)
    println(count(num1))

    val num2: Num2 = Num2Impl1(
      () =>
        Num1Impl1(
          () =>
            Num1Impl1(
              () =>
                Num1Impl1(
                  () => Num1Impl1(() => Num1Impl1(() => zero1, () => zero2), () => zero2),
                  () => Num2Impl1(() => zero1, () => zero2)
                ),
              () => zero2
            ),
          () => zero2
        ),
      () => zero2
    )
    println(count(num2))

    println(count(num1.input(() => zero1, () => num2)))

    val num3: Num1 =
      Num1Impl1(() => zero1, () => Num2Impl1(() => zero1, () => Num2Impl1(() => zero1, () => Num2Impl1(() => zero1, () => zero2))))
    println(count(num3))

    val num4: Num2 =
      Num2Impl1(() => num3, () => Num2Impl1(() => Num1Impl1(() => Num1Impl1(() => zero1, () => zero2), () => zero2), () => zero2))
    println("xx" + count(num4))

    val num5: Num1 = num3.input(() => zero1, () => num4)
    val num6: Num1 = num5.input(() => zero1, () => num4)
    val num7: Num1 = num6.input(() => zero1, () => num4)
    println(count(num5))

  }

}
