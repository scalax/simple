package net.scalax.simple
package codec

trait Setter[F[_[_]]] {
  def input[H[_]](list: Seq[Any]): F[H]
}

object Setter {
  def from[F[_[_]]](implicit lFunc: GenericFiller[ContextO[F]#AnyF]): Setter[F] = new Setter[F] {
    override def input[H[_]](list: Seq[Any]): F[H] = lFunc.funcInput(list).asInstanceOf[F[H]]
  }
}
