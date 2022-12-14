package net.scalax.simple.core

trait Core3[M[_]] {
  def from[T](i2: T): M[T]
  def to[T](i1: M[T]): T
}
