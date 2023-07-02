package net.scalax.simple.codec

import scala.collection.compat._

trait ModelProperty[F[_[_]]] {
  def model: F[ModelProperty.AuxS]
}

object ModelProperty {
  type AuxS[_] = String
  def generic[F[_[_]] <: Product](modelNames: ModelNames[F], modelSetter: ModelSetter[F]): ModelProperty[F] = {
    val l = modelSetter.inputList[AuxS](modelNames.names)
    new ModelProperty[F] {
      override val model: F[ModelProperty.AuxS] = l
    }
  }
}
