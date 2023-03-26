package net.scalax.simple
package codec
package impl

import shapeless3.deriving.*

trait FillerImplImplicitExtra {
  class SetterImpl[F[_[_]]] extends SetterImplImpl[F, F[ContextI#AnyF]]

  trait SetterImplImpl[F[_[_]], Model] {
    def generic(using g: K0.ProductGeneric[Model]): Setter[F] = new Setter[F] {
      override def input[H[_]](list: Seq[Any]): F[H] = {
        def fromList(l: Seq[Any]): Tuple = if (l.isEmpty) EmptyTuple else l.head *: fromList(l.tail)
        g.fromProduct(fromList(list)).asInstanceOf[F[H]]
      }
    }
  }
}
