package `整数树20240120`

abstract class Number1(next: () => Number2, val pre: () => Number1) extends Number2(next = next) {
  override def method1(number2: () => Number2): Number1
}
class Number1S(next: () => Number2, override val pre: () => Number1) extends Number1(next = next, pre = pre) {
  override def method1(number2: () => Number2): Number1 = new Number1S(number2, () => pre().method1(next))
}
object Number1 {
  def zero(num2: () => Number2): Number1S = new Number1S(next = num2, pre = () => zero(num2))
}

abstract class Number2(val next: () => Number2) {
  def method1(number1: () => Number2): Number2
}
class Number2S(override val next: () => Number2) extends Number2(next = next) {
  override def method1(number1: () => Number2): Number2 = new Number2S(() => number1().method1(next))
}
object Number2T {
  lazy val value: Number2 = new Number2(() => value) {
    override def method1(number1: () => Number2): Number2 = number1().method1(next)
  }
}
