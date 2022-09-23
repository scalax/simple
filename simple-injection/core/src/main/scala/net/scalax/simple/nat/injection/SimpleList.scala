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

abstract case class SimpleAdd[+T](data: T, tail: SimpleList[T]) extends SimpleList[T]

trait SimpleListAbs[+T] extends SimpleListSImpl[T] with SimpleList[T] {
  override def num2: SimpleAddAbs[T]
}
trait SimpleAddAbs[+T] extends SimpleListAddImpl[T] with SimpleList[T] {
  override def num1: SimpleListAbs[T]
}
