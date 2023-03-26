package net.scalax.simple
package codec

trait Setter[F[_[_]]] {
  def input[H[_]](list: Seq[Any]): F[H]
}

object Setter extends impl.FillerImplImplicitExtra {
  def apply[F[_[_]]]: SetterImpl[F] = new SetterImpl[F]
}
