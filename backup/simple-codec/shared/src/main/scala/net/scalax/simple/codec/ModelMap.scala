package net.scalax.simple.codec

import scala.collection.compat._

trait ModelMap[F[_[_]]] {
  def map(model: F[ContextI#AnyF], func: Any => Any): F[ContextI#AnyF]
}

object ModelMap {
  def init[F[_[_]]](implicit setter: Setter[F], getter: Getter[F]): ModelMap[F] = new ModelMap[F] {
    override def map(model: F[ContextI#AnyF], func: Any => Any): F[ContextI#AnyF] = setter.input(getter.output(model))
  }
}
