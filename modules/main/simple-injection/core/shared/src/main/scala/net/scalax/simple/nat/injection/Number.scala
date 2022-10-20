package net.scalax.simple.nat.injection

trait Number1S
class Number1T(tail: () => Number1S) extends Number1S

trait Number2S {
  def numt: Number2T
}
trait Number2T {
  def nums: Number2S
}

trait Number3SS extends Number1S with Number2S {
  override def numt: Number3TS
}
trait Number3TS extends Number1S with Number2T {
  override def nums: Number3SS
}
abstract class Number3ST(tail: () => Number3SS) extends Number1T(tail) with Number3SS {
  override def numt: Number3TS
}
abstract class Number3TT(tail: () => Number3TS) extends Number1T(tail) with Number3TS {
  override def nums: Number3SS
}
