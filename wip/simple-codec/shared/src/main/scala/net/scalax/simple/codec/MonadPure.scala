package net.scalax.simple.codec

trait MonadAdd[M[_, _]] {
  def to[A, B, S, T](monad: M[A, B]): M[S, T]
}
