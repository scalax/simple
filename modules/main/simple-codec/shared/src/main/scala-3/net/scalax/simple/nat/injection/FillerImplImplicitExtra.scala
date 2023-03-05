package net.scalax.simple
package codec
package impl

import shapeless3.deriving.*

trait FillerImplImplicitExtra {
  given [T](using gen: K0.ProductGeneric[T]): GenericFiller[T] = new GenericFiller[T] {
    override def funcInput(list: Seq[Any]): T = {
      def toHList(l: Seq[Any]): Tuple = l.headOption match {
        case Some(t) => t *: toHList(l.tail)
        case _       => EmptyTuple
      }
      gen.fromRepr(toHList(list).asInstanceOf[gen.MirroredElemTypes])
    }
  }
}
