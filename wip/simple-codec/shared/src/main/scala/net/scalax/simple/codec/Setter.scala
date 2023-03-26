package net.scalax.simple
package codec

import shapeless._

trait Setter[F[_[_]]] {
  def input[H[_]](list: Seq[Any]): F[H]
}

object Setter {
  def apply[F[_[_]]]: SetterImpl[F] = new SetterImpl[F]

  class SetterImpl[F[_[_]]] extends SetterImplImpl[F, F[ContextI#AnyF]]

  trait SetterImplImpl[F[_[_]], Model] {
    def generic[H <: HList](implicit g: Generic.Aux[Model, H], modelSize: ModelLength[F]): Setter[F] = new Setter[F] {
      override def input[U[_]](list: Seq[Any]): F[U] = {
        def fromList(list: Seq[Any], size: Int): HList = {
          if (size > 0)
            list.head :: fromList(list.tail, size - 1)
          else HNil
        }

        val modelHList: HList = fromList(list, modelSize.length)
        g.asInstanceOf[Generic.Aux[F[U], HList]].from(modelHList)
      }
    }
  }
}
