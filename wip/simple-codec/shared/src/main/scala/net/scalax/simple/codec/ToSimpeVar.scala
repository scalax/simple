package net.scalax.simple.codec

import scala.collection.compat._

trait ToSimpeVar[F[_[_]]] {
  self =>
  def prepareInput(model: F[ContextI#AnyF]): F[ContextI#AnyF]
  def map(func: F[ContextI#AnyF] => F[ContextI#AnyF]): ToSimpeVar[F] = new ToSimpeVar[F] {
    def prepareInput(model: F[ContextI#AnyF]): F[ContextI#AnyF] = func(self.prepareInput(model))
  }

  final def input[U[_]](model: F[U]): F[({ type XK[H] = ContextI#SimpleVarF[U[H]] })#XK] = prepareInput(
    model.asInstanceOf[F[ContextI#AnyF]]
  ).asInstanceOf[F[({ type XK[H] = ContextI#SimpleVarF[U[H]] })#XK]]
}

object ToSimpeVar {
  def init[F[_[_]]](implicit modelMap: ModelMap[F]): ToSimpeVar[F] = new ToSimpeVar[F] {
    override def prepareInput(model: F[ContextI#AnyF]): F[ContextI#AnyF] = modelMap.map(model, (t: Any) => SimpleVar(t))
  }
}
