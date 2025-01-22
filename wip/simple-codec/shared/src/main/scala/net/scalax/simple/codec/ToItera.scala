package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct3

trait ToItera[F[_[_]]] {
  def to[T]: SimpleProduct3.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
}

object ToItera {

  class ApplyImpl[F[_[_]]] {
    @inline def derived(implicit basedInstalled: SimpleProduct3.NotHList.Appender[F]): ToItera[F] = new ToItera[F] {
      @inline def to[T]: SimpleProduct3.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        basedInstalled.asInstanceOf[SimpleProduct3.NotHList.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]]
    }
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

}
