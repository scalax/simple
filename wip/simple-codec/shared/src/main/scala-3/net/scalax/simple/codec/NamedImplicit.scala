package net.scalax.simple.codec

import to_list_generic._
import scala.deriving.Mirror
import scala.compiletime.constValueTuple

trait NamedImplicit[T] {
  def input: List[String]
}

object NamedImplicit {
  inline given [T](using e: Mirror.ProductOf[T]): NamedImplicit[T] = new NamedImplicit {
    override val input: List[String] = constValueTuple[e.MirroredElemLabels].toList.asInstanceOf[List[String]]
  }
}
