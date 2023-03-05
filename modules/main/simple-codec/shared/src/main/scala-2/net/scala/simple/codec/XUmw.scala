package net.scalax.simple
package nat

import shapeless._

package impl {

  trait FillerImplImplicitExtra {
    implicit def genericApply[T](implicit gen: Generic.Aux[T, _]): FillerImpl[T] = new FillerImpl[T] {
      override def funcInput(list: Seq[Any]): T = {
        def toHList(l: Seq[Any]): HList = l.headOption match {
          case Some(t) => t :: toHList(l.tail)
          case _       => HNil
        }
        gen.from(toHList(list).asInstanceOf[gen.Repr])
      }
    }
  }
}
