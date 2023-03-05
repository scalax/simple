package net.scalax.simple.nat
package impl

trait FillerImpl[T] {
  def funcInput(list: Seq[Any]): T
}

object FillerImpl extends FillerImplImplicitExtra
