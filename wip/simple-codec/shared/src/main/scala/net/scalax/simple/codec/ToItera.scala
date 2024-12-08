package net.scalax.simple.codec

import utils.SimpleP

trait ToItera[F[_[_]]] {
  def to[T]: SimpleP.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
}

object ToItera {

  class ApplyImpl[F[_[_]]] {

    def derived(implicit basedInstalled: SimpleP.Appender[F]): ToItera[F] = new ToItera[F] {
      override def to[T]: SimpleP.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        new SimpleP.Appender[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
          override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: SimpleP.AppendMonad[M1])(
            func: SimpleP.TypeGen[M1, M2, M3, M4]
          ): M1[F[({ type T1[_] = M2[T] })#T1], F[({ type T1[_] = M3[T] })#T1], F[({ type T1[_] = M4[T] })#T1]] = {
            type M2X[_] = M2[T]
            type M3X[_] = M3[T]
            type M4X[_] = M4[T]
            basedInstalled.toHList[M1, M2X, M3X, M4X](monad)(new SimpleP.TypeGen[M1, M2X, M3X, M4X] {
              override def apply[U]: M1[M2[T], M3[T], M4[T]] = func[T]
            })
          }
        }
    }

  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]
}
