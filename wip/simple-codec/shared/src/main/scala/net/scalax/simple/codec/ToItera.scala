package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct

trait ToItera[F[_[_]]] {
  def to[T]: SimpleProduct.AppenderImpl[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
}

object ToItera {

  class ApplyImpl[F[_[_]]] {

    def derived(implicit basedInstalled: SimpleProduct.AppenderImpl[F]): ToItera[F] = new ToItera[F] {
      override def to[T]: SimpleProduct.AppenderImpl[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        new SimpleProduct.AppenderImpl[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
          override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: SimpleProduct.AppendMonad[M1])(
            func: SimpleProduct.TypeGen[M1, M2, M3, M4]
          ): M1[F[({ type T1[_] = M2[T] })#T1], F[({ type T1[_] = M3[T] })#T1], F[({ type T1[_] = M4[T] })#T1]] = {
            type M2X[_] = M2[T]
            type M3X[_] = M3[T]
            type M4X[_] = M4[T]
            basedInstalled.toHList[M1, M2X, M3X, M4X](monad)(new SimpleProduct.TypeGen[M1, M2X, M3X, M4X] {
              override def apply[U]: M1[M2[T], M3[T], M4[T]] = func[T]
            })
          }

          override val modelLabelled: F[CompatLabelled.CompatNamed] = basedInstalled.modelLabelled
          override val modelSize: Int                               = basedInstalled.modelSize
        }
    }

  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]
}
