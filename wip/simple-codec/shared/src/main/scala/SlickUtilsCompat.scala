package net.scalax.simple.codec

object SlickUtilsCompat {
  trait FunctionOpt[-A, +B] extends (A => B) {
    self =>

    override def apply(t: A): B

    def opt: FunctionOpt[A, Option[B]] = new FunctionOpt[A, Option[B]] {
      override def apply(t: A): Option[B] = Option(self(t))
    }
  }

  trait GenericInstance[Model, H] {
    def from: SlickUtilsCompat.FunctionOpt[H, Model]

    def to: SlickUtilsCompat.FunctionOpt[Model, H]
  }
}
