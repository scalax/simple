package net.scalax.simple.codec
package utils

abstract class ByNameImplicit[T] {
  def value: T
}

object ByNameImplicit {
  implicit def implicitFetch[T](implicit v: => T): ByNameImplicit[T] = new ByNameImplicit[T] {
    override def value: T = v
  }
}
