package net.scalax.simple.nat.geshu

trait Number extends ((() => Number) => Number)

object Number {

  private var innerState: Int = null.asInstanceOf[Int]
  def 当前状态: Int               = innerState
  def 更新状态: Unit = this.synchronized {
    innerState = innerState + 1
  }
  def 重置状态: Unit = this.synchronized {
    innerState = 0
  }

  val S: Number = (tail: () => Number) =>
    (number: () => Number) => {
      def tail1   = tail()
      def number1 = number()
      Append(() => tail1(() => number1))
    }

  val T: Number = (tail: () => Number) =>
    (number: () => Number) => {
      def tail1   = tail()
      def number1 = number()
      tail1(() => number1)
    }

  val U: Number = (tail: () => Number) =>
    (number: () => Number) => {
      def tail1   = tail()
      def number1 = number()
      Append(() => number1(() => tail1))
    }

  val V: Number = (tail: () => Number) =>
    (number: () => Number) => {
      def tail1   = tail()
      def number1 = number()
      number1(() => tail1)
    }

  val Append: Number = (v: () => Number) => {
    更新状态
    v()
  }

}
