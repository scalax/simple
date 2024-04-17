package net.scalax.simple.codec
package to_list_generic

object SimpleProduct2 {

  trait AppendMonad[M[_, _]] {
    def zip[A, B, S, T](ma: M[A, B], ms: M[S, T]): M[(A, S), (B, T)]
    def to[A, B, S, T](m1: M[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M[S, T]
    def zero: M[Unit, Unit]
  }

  trait TypeGen[M2[_, _], M1[_], M3[_]] {
    def apply[T]: M2[M1[T], M3[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M3[_, _], M1[_], M2[_]](monad: AppendMonad[M3])(func: TypeGen[M3, M1, M2]): M3[F[M1], F[M2]]
  }

  object Appender {

    def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

    class ApplyImpl[F[_[_]]] {
      def derived(generic3: SimpleProduct.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
        def toHList[M1[_, _], M2[_], M3[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3]): M1[F[M2], F[M3]] = {
          type X[A, B, C] = M1[B, C]

          val mAdd: SimpleProduct.AppendMonad[X] = new SimpleProduct.AppendMonad[X] {
            override def zip[A, B, C, S, T, U](ma: M1[B, C], ms: M1[T, U]): M1[(B, T), (C, U)] = monad.zip(ma, ms)
            override def to[A, B, C, S, T, U](
              m1: M1[B, C]
            )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M1[T, U] = monad.to(m1)(in2, in3)(in5, in6)
            override def zero: M1[Unit, Unit] = monad.zero
          }

          def funcImpl[MMX[_]]: SimpleProduct.TypeGen[X, MMX, M2, M3] = new SimpleProduct.TypeGen[X, MMX, M2, M3] {
            override def apply[T]: M1[M2[T], M3[T]] = func[T]
          }

          def to[MMX[_]]: M1[F[M2], F[M3]] = generic3.toHList[X, MMX, M2, M3](mAdd)(funcImpl)

          to
        }
      }
    }

  }

}
