package net.scalax.simple
package codec
package impl

import shapeless._

trait FillerImplImplicitExtra {
  implicit def genericApply[T](implicit gen: Generic.Aux[T, _]): GenericFiller[T] = new GenericFiller[T] {
    override def funcInput(list: Seq[Any]): T = {
      def toHList(l: Seq[Any]): HList = l.headOption match {
        case Some(t) => t :: toHList(l.tail)
        case _       => HNil
      }
      gen.from(toHList(list).asInstanceOf[gen.Repr])
    }
  }
}
