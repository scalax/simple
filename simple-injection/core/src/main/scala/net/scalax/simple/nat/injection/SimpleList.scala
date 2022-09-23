package net.scalax.simple.nat.injection

sealed trait SimpleList[+T] {
  def get(i: Int): Option[T]
  def size: Int
  def add[U >: T](d: U): SimpleList[U]
}

abstract class SimpleZero[+T] extends SimpleList[T]
object SimpleZero extends SimpleZero[Nothing] with impl.SimpleZeroImplObject {
  def unapply(u: SimpleList[Nothing]): Boolean = u match {
    case _: SimpleZero[_] => true
    case _                => false
  }
}

abstract class SimpleAdd[+T](val data: T, val tail: SimpleList[T]) extends SimpleList[T]
object SimpleAdd {
  import impl._
  def unapply[T](u: SimpleList[T]): Option[(T, SimpleList[T])] = u match {
    case s: SimpleAdd[T]  => Option((s.data, s.tail))
    case _: SimpleZero[_] => Option.empty
  }
}
