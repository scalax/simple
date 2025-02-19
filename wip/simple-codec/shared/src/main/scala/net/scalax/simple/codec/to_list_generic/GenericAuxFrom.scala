package net.scalax.simple.codec
package to_list_generic

trait GenericAuxFrom[F[_[_]]] {
  def fromModel[X[_]](collection: Any): F[X]
}
