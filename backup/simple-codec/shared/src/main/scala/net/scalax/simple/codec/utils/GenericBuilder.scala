package net.scalax.simple
package codec

package utils

trait GenericBuilder[Model, PolyInstance] {
  def value: Model
}

object GenericBuilder {
  type Aux[Model, PolyInstance] = GenericBuilder[Model, PolyInstance with DefaultGenericBuilder.type]
}

object DefaultGenericBuilder extends impl.GenericBuilderImpl
