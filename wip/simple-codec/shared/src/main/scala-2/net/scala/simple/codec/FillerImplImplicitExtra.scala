package net.scalax.simple
package codec
package impl

import shapeless._

trait FillerImplImplicitExtra {
  class SetterImpl[F[_[_]]] extends SetterImplImpl[F, F[ContextI#AnyF]]

  trait SetterImplImpl[F[_[_]], Model] {
    def generic(implicit g: Generic.Aux[Model, _ <: HList]): Setter[F] = new Setter[F] {
      override def input[U[_]](list: Seq[Any]): F[U] = {
        def fromList(l: Seq[Any]): HList = if (l.isEmpty) HNil else l.head :: fromList(l.tail)
        g.asInstanceOf[Generic.Aux[F[U], HList]].from(fromList(list))
      }
    }
  }
}
