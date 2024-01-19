package `整数树20240120`

class Number1(next: () => Number2, val pre: () => Number1) extends Number2(next = next) {
  override def method1(number2: () => Number2): Number1 = new Number1(number2, () => pre().method1(next))
}
object Number1 {
  def zero(num2: () => Number2): Number1 = new Number1(next = num2, pre = () => zero(num2))
}

class Number2(val next: () => Number2) {
  def method1(number1: () => Number2): Number2 = number1().method1(next)
}
object Number2 {
  lazy val value: Number2 = new Number2(() => value)
}
