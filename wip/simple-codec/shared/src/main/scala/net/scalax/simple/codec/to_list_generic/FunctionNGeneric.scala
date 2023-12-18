package net.scalax.simple.codec
package to_list_generic

trait ToListGenerc[F[_[_]]] {
  def toList[T]: F[({ type U1[_] = T })#U1] => List[T]
}

object ToListGenerc {
  //
}
