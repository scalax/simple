package a03_2.step2

trait Number1 {
  def method1(number2: Number2): Number1
}
case class Number1S(tail: Number1, head: Number2) extends Number1 {
  override def method1(number2: Number2): Number1 = Number1S(tail.method1(number2), head)
}
case object Number1T extends Number1 {
  override def method1(number2: Number2): Number1 = Number1S(Number1T, number2)
}

trait Number2 {
  def method2(number2: Number1): Number2
}
case class Number2S(tail: Number2, head: Number1) extends Number2 {
  override def method2(number2: Number1): Number2 = Number2S(tail.method2(head), number2)
}
case object Number2T extends Number2 {
  override def method2(number2: Number1): Number2 = Number2S(Number2T, number2)
}
