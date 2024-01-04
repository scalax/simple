package a03_3.step1

trait Number1 {
  def method1(number1: Number1): Number1
}
case class Number1S(tail: Number1, head: Number2) extends Number1 {
  override def method1(number1: Number1): Number1 = Number1S(number1.method1(tail), head)
}
case object Number1T extends Number1 {
  override def method1(number1: Number1): Number1 = number1
}

trait Number2
case class Number2S(tail: Number2, head: Number1) extends Number2
case object Number2T                              extends Number2
