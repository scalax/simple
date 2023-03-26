package net.scalax.simple
package codec
package impl

trait GenericBuilder[Model] {
  def value: Model
}

object GenericBuilder extends GenericBuilderImpl
