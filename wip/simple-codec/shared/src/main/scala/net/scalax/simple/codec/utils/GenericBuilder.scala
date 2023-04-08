package net.scalax.simple
package codec

package utils

trait GenericBuilder[Model, Poly] {
  def value: Model
}

object GenericBuilder extends impl.GenericBuilderImpl
