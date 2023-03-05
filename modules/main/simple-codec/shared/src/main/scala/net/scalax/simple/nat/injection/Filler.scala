package net.scalax.simple
package codec

trait Filler[F[_[_]]] {
  def input[H[_]](list: Seq[Any]): F[H]
}

object Filler {
  def from[F[_[_]]](implicit lFunc: GenericFiller[ContextO[F]#AnyF]): Filler[F] = new Filler[F] {
    override def input[H[_]](list: Seq[Any]): F[H] = lFunc.funcInput(list).asInstanceOf[F[H]]
  }
}
