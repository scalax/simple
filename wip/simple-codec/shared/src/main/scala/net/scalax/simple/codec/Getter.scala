package net.scalax.simple
package codec

import scala.collection.compat._

trait Getter[F[_[_]]] {
  def output[H[_]](model: F[H]): List[Any]
}

object Getter {
  def apply[F[_[_]]]: GetterImpl[F] = new GetterImpl[F]

  class GetterImpl[F[_[_]]] {
    def generic(implicit cv: F[ContextI#AnyF] <:< Product): Getter[F] = new Getter[F] {
      override def output[H[_]](model: F[H]): List[Any] = model.asInstanceOf[F[ContextI#AnyF]].productIterator.to(List)
    }
  }
}
