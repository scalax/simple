package a03_1.step3

trait Number1 {
  def method1(number2: Number2): Number2
}
case class Number1S(tail: Number1, head: Number2) extends Number1 {
  override def method1(number2: Number2): Number2 = Number2S(head, number2.method2(tail))
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number2 = Number2S(number2, Number1T)
}

trait Number2 {
  def method2(number1: Number1): Number1
}
case class Number2S(tail: Number2, head: Number1) extends Number2 {
  override def method2(number1: Number1): Number1 = Number1S(head, number1.method1(tail))
}
case object Number2T extends Number2 {
  override def method2(number1: Number1): Number1 = Number1S(number1, Number2T)
}
