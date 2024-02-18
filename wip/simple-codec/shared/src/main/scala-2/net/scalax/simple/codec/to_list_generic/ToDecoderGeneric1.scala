package net.scalax.simple.codec
package to_list_generic

trait ToDecoderGeneric1[F[_[_]]] {
  def toHList1[M1[_], M2[_]](monad: MonadAdd1[M1])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M1[F[M2]]
}

object ToDecoderGeneric1 {

  type IdImpl[T] = T

  trait FuncImpl1[M1[_], M2[_]] {
    def apply[T]: M1[M2[T]]
  }

  def fromGeneric2[F[_[_]]](generic2: ToDecoderGeneric[F], modelStr: F[LabelledInstalled.Named]): ToDecoderGeneric1[F] =
    new ToDecoderGeneric1[F] {
      override def toHList1[M1[_], M2[_]](monad: MonadAdd1[M1])(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M1[F[M2]] = {
        type X[A, B] = A => M1[B]

        val mAdd: MonadAdd1111[X] = new MonadAdd1111[X] {
          override def zip[A, B, S, T](ma: A => M1[B], ms: S => M1[T]): ((A, S)) => M1[(B, T)] = { t =>
            val t1 = ma(t._1)
            val t2 = ms(t._2)
            monad.zip(t1, t2)
          }
          override def to[A, B, S, T](m1: A => M1[B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): S => M1[T] = s =>
            monad.to[B, T](m1(in3(s)))(in2)(in4)
          override def zero: Unit => M1[Unit] = _ => monad.zero
        }

        val funcImpl: ToDecoderGeneric.FuncImpl[X, LabelledInstalled.Named, M2] =
          new ToDecoderGeneric.FuncImpl[X, LabelledInstalled.Named, M2] {
            override def apply[T]: LabelledInstalled.Named[T] => M1[M2[T]] = _ => func[T]
          }

        val to = generic2.toHList[X, LabelledInstalled.Named, M2](mAdd)(funcImpl)

        to(modelStr)
      }
    }

}
