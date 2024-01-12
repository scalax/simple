package net.scalax.simple.codec

trait MonadAdd[M[_, _]] {
  def to[A, B, S, T](in1: A => B, in2: S => T, out1: B => A, out2: T => S): M[A, B] => M[S, T]
}

/*trait MonadAdd[M[_, _]] {
  def to[A, B, S, T](in1: M[A, S], out1: M[B, T]): M[A, B] => M[S, T]
}*/
