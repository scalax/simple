package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProductX

trait ToItera[F[_[_]]] {
  def to[T]: SimpleProductX.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
}

object ToItera {
  class Builder[F[_[_]]] {
    @inline def derived(implicit @inline basedInstalled: SimpleProductX.NotHList.Appender[F]): ToItera[F] = new ToItera[F] {
      @inline def to[T]: SimpleProductX.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        basedInstalled.asInstanceOf[SimpleProductX.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]]
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
