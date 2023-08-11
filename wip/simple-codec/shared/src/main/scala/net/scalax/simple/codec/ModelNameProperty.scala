package net.scalax.simple.codec

import scala.collection.compat._

trait ModelNameProperty[F[_[_]]] {
  def model: F[ModelNameProperty.Aux]
}

object ModelNameProperty {
  type Aux[_] = String
  def generic[F[_[_]]](implicit modelNames: ModelNames[F], setter: ModelSetter[F[ModelNameProperty.Aux]]): ModelNameProperty[F] = {
    val m: F[ModelNameProperty.Aux] = setter.inputList(modelNames.names)
    new ModelNameProperty[F] {
      override val model: F[Aux] = m
    }
  }
}
