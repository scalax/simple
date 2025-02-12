package net.scalax.simple.codec

import to_list_generic._
import scala.deriving.Mirror
import scala.compiletime.constValueTuple

trait NamedImplicit[T] {
  def input: Tuple
}

object NamedImplicit {
  inline given [T <: Tuple]: NamedImplicit[T] = new NamedImplicit {
    override val input: Tuple = constValueTuple[T]
  }
}
