package net.scalax.simple
package codec

trait GenericFiller[T] {
  def funcInput(list: Seq[Any]): T
}

object GenericFiller extends impl.FillerImplImplicitExtra
