package `整数树20240120`

class Number3(pre: () => Number2, next: () => Number1) extends Number2(next = next) with Number1(pre = pre) {
  override def method2(other: () => Number1): Number2 => Number3 = { num2 =>
    //
    ???
  }

  override def method1(other: () => Number1): Number1 = {
    //
    ???
  }

  override def size: Int = pre().size + 1
}

trait Number2(next: () => Number1) {
  def method2(other: () => Number1): Number2 => Number1 = {
    //
    ???
  }

  def size: Int = 0
}

trait Number1(pre: () => Number2) {
  def method1(other: () => Number1): Number1 = {
    lazy val num1: Number2 => Number1 = pre().method2(other)

    ???
  }

  def size: Int = pre().size + 1
}
