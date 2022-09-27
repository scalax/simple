package net.scalax.simple.nat.injection

trait LengthNumber1 extends Number1S {
  def size: Int
  override def num2: LengthNumber2
}
trait LengthNumber1S extends LengthNumber1 {
  override def num2: LengthNumber2
  override def size: Int = 0
}

trait LengthNumber2 extends Number2S {
  def index: Int = num1.size
  override def num1: LengthNumber1
}

trait LengthNumber extends LengthNumber1 with LengthNumber2 {
  override def num2: LengthNumber2
  override def num1: LengthNumber1
  override def size: Int  = num1.size + 1
  override def index: Int = num2.index - 1
}

trait SimpleLengthNumber extends LengthNumber {
  override def index: Int = size - 1
}
