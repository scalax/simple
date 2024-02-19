package net.scalax.simple.codec
package to_list_generic

trait ToDecoderGeneric1[F[_[_]]] {
  def toHList1[M1[_], M2[_]](monad: MonadAdd1[M1])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M1[F[M2]]
}

object ToDecoderGeneric1 {

  trait FuncImpl1[M1[_], M2[_]] {
    def apply[T]: M1[M2[T]]
  }

  class ApplyImpl[F[_[_]]] {
    def derived(basedInstall: BasedInstalled[F]): ToDecoderGeneric1[F] = fromInstance(
      ToDecoderGeneric[F].fromInstance(basedInstall.decode2222)
    )

    def fromInstance(toDecoderGeneric: ToDecoderGeneric[F]): ToDecoderGeneric1[F] = new ToDecoderGeneric1[F] {
      override def toHList1[M1[_], M2[_]](monad: MonadAdd1[M1])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M1[F[M2]] = {
        type X[A, B] = M1[B]

        val mAdd: MonadAdd1111[X] = new MonadAdd1111[X] {
          override def zip[A, B, S, T](ma: M1[B], ms: M1[T]): M1[(B, T)]                                    = monad.zip(ma, ms)
          override def to[A, B, S, T](m1: M1[B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M1[T] = monad.to[B, T](m1)(in2)(in4)
          override def zero: M1[Unit]                                                                       = monad.zero
        }

        def funcImpl[MMX[_]]: ToDecoderGeneric.FuncImpl[X, MMX, M2] =
          new ToDecoderGeneric.FuncImpl[X, MMX, M2] {
            override def apply[T]: M1[M2[T]] = func[T]
          }

        def to[MMX[_]]: M1[F[M2]] = toDecoderGeneric.toHList[X, MMX, M2](mAdd)(funcImpl)

        to
      }
    }
  }

  def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

}
