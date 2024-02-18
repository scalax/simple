package net.scalax.simple.codec

trait MonadAdd1111[M[_, _]] {
  def zip[A, B, S, T](ma: M[A, B], ms: M[S, T]): M[(A, S), (B, T)]
  def to[A, B, S, T](m1: M[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M[S, T]
  def zero: M[Unit, Unit]
}

trait MonadAdd[M[_, _, _]] {
  def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[(A, S), (B, T), (C, U)]
  def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
  def zero: M[Unit, Unit, Unit]
}

trait MonadAdd1[M[_]] {
  def zip[A, B](ma: M[A], ms: M[B]): M[(A, B)]
  def to[A, B](m1: M[A])(in1: A => B)(out1: B => A): M[B]
  def zero: M[Unit]
}
