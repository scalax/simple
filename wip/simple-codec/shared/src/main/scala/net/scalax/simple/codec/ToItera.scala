package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProductX

trait ToItera[F[_[_]]] {
  def to[T](simpleProductX: SimpleProductX[F]): SimpleProductX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
}

object ToItera {
  @inline private val toIteraImplImpl: ToItera[({ type F1[_[_]] = Any })#F1] = new ToItera[({ type F1[_[_]] = Any })#F1] {
    @inline def to[T](simpleProductX: SimpleProductX[({ type F1[_[_]] = Any })#F1]): SimpleProductX[({ type F1[_[_]] = Any })#F1] =
      simpleProductX
  }
  @inline private def toIteraImpl[F[_[_]]]: ToItera[F] = toIteraImplImpl.asInstanceOf[ToItera[F]]

  @inline private val builderImplImpl                = new Builder[({ type F1[_[_]] = Any })#F1]
  @inline private def applyImpl[F[_[_]]]: Builder[F] = builderImplImpl.asInstanceOf[Builder[F]]

  // ===
  class Builder[F[_[_]]] {
    @inline def derived: ToItera[F] = toIteraImpl[F]
  }
  @inline def apply[F[_[_]]]: Builder[F] = applyImpl[F]
}
