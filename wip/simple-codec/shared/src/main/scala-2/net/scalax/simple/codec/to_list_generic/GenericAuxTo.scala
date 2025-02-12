package net.scalax.simple.codec
package to_list_generic

trait GenericAuxTo[F[_[_]]] {
  def toModel[X[_]](model: F[X]): Any
}
