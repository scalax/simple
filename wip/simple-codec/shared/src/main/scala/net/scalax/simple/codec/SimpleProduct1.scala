package net.scalax.simple.codec
package to_list_generic

import utils.SimpleP

object SimpleProduct1 {

  trait AppendMonad[M[_]] {
    def zip[A, B](ma: M[A], ms: M[B]): M[(A, B)]
    def to[A, B](m1: M[A])(in1: A => B)(out1: B => A): M[B]
    def zero: M[Unit]
  }

  trait TypeGen[M1[_], M2[_]] {
    def apply[T]: M1[M2[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList1[M1[_], M2[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2]): M1[F[M2]]
  }

  object Appender {

    class ApplyImpl[F[_[_]]] {
      def derived(toDecoderGeneric: SimpleP.Appender[F]): Appender[F] = derived1(
        SimpleProduct2.Appender[F].derived(toDecoderGeneric)
      )

      def derived1(toDecoderGeneric: SimpleProduct2.Appender[F]): Appender[F] = new Appender[F] {
        override def toHList1[M1[_], M2[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2]): M1[F[M2]] = {
          type X[A, B] = M1[B]

          val mAdd: SimpleProduct2.AppendMonad[X] = new SimpleProduct2.AppendMonad[X] {
            override def zip[A, B, S, T](ma: M1[B], ms: M1[T]): M1[(B, T)]                                    = monad.zip(ma, ms)
            override def to[A, B, S, T](m1: M1[B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M1[T] = monad.to[B, T](m1)(in2)(in4)
            override def zero: M1[Unit]                                                                       = monad.zero
          }

          def funcImpl[MMX[_]]: SimpleProduct2.TypeGen[X, MMX, M2] = new SimpleProduct2.TypeGen[X, MMX, M2] {
            override def apply[T]: M1[M2[T]] = func[T]
          }

          def to[MMX[_]]: M1[F[M2]] = toDecoderGeneric.toHList[X, MMX, M2](mAdd)(funcImpl)

          to
        }
      }
    }

    def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

  }

}
