package net.scalax.simple
package codec

import utils.AnyItemInstalller

trait Setter[F[_[_]]] {
  def input[H[_]](list: Seq[Any]): F[H]
}

object Setter {
  def apply[F[_[_]]]: SetterImpl[F] = new SetterImpl[F]

  class SetterImpl[F[_[_]]] extends SetterImplImpl[F, F[ContextI#AnyF]]

  trait SetterImplImpl[F[_[_]], Model] {
    def build(u: AnyItemInstalller[F] => Model): Setter[F] = new Setter[F] {
      override def input[U[_]](list: Seq[Any]): F[U] = u(AnyItemInstalller.fromSeq(list)).asInstanceOf[F[U]]
    }
  }
}
