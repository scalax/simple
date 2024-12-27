package net.scalax.simple.codec
package to_list_generic

import utils.SimpleP

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

    /*trait Mon[M1X[_, _], M2X[_, _], F[_[_]]] {
      def aa: Appender[F]

      type M3X[T1, T2, T3] = M1X[M2X[T1, T2], T3]

      def appendToList1[M1[_], M2[_]](monad: AppendMonad[M1X])(func: TypeGen[M1X, M1, M2]): M1X[F[M1], F[M2]] =
        aa.toHList(monad)(func)
      def appendToList2[M1[_], M2[_]](monad: AppendMonad[M2X])(func: TypeGen[M2X, M1, M2]): M2X[F[M1], F[M2]] =
        aa.toHList(monad)(func)

      trait AA extends AppendMonad[M3X] {
        def bx: SimpleP.AppendMonad[M]
        /*override def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[(A, S), (B, T), (C, U)]
        override def to[A, B, C, S, T, U](
          m1: M[A, B, C]
        )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
        override def zero: M[Unit, Unit, Unit]*/

        def zip[A, B, S, T](ma: NewM2[A, B], ms: NewM2[S, T]): NewM2[(A, S), (B, T)] = new NewM2[(A, S), (B, T)] {
          override def to[T3]: M[(A, S), (B, T), T3] = 11
        }
        def to[A, B, S, T](m1: NewM2[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): NewM2[S, T]
        def zero: NewM2[Unit, Unit]
      }

      /*trait AppenderImpl extends SimpleP.Appender[F] {
        override def toHList[M4[_, _, _], M1[_], M2[_], M3[_]](monad: utils.SimpleP.AppendMonad[M4])(
          func: utils.SimpleP.TypeGen[M4, M1, M2, M3]
        ): M4[F[M1], F[M2], F[M3]]
      }*/
    }*/

    def apply[F[_[_]]]: ApplyImpl[F] = new ApplyImpl[F]

    class ApplyImpl[F[_[_]]] {
      def derived(generic3: SimpleP.Appender[F]): SimpleProduct2.Appender[F] = new SimpleProduct2.Appender[F] {
        def toHList[M1[_, _], M2[_], M3[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3]): M1[F[M2], F[M3]] = {
          type X[A, B, C] = M1[B, C]

          val mAdd: SimpleP.AppendMonad[X] = new SimpleP.AppendMonad[X] {
            override def zip[A, B, C, S, T, U](ma: M1[B, C], ms: M1[T, U]): M1[(B, T), (C, U)] = monad.zip(ma, ms)
            override def to[A, B, C, S, T, U](
              m1: M1[B, C]
            )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M1[T, U] = monad.to(m1)(in2, in3)(in5, in6)
            override def zero: M1[Unit, Unit] = monad.zero
          }

          def funcImpl[MMX[_]]: SimpleP.TypeGen[X, MMX, M2, M3] = new SimpleP.TypeGen[X, MMX, M2, M3] {
            override def apply[T]: M1[M2[T], M3[T]] = func[T]
          }

          def to[MMX[_]]: M1[F[M2], F[M3]] = generic3.toHList[X, MMX, M2, M3](mAdd)(funcImpl)

          to
        }
      }
    }

  }

}
