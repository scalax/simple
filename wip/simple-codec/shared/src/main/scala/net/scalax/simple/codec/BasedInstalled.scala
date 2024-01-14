package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1}
import net.scalax.simple.codec.unzip_generic.Func50GenericImpl

trait BasedInstalled[F[_[_]]] {
  def labelled: LabelledInstalled[F]
  def funcion50: Function50Generic[F]
  def decode: ToDecoderGeneric[F]
  def decode1: ToDecoderGeneric1[F]
}

object BasedInstalled {

  class DerivedApply[F[_[_]]] {
    def derived(
      compatLabelledInstalled: CompatLabelledInstalled[F],
      mapper: Function50Generic[F],
      decode: ToDecoderGeneric[F],
      decode1: ToDecoderGeneric1[F]
    ): BasedInstalled[F] = {
      val l1 = LabelledInstalled[F].derived(compatLabelledInstalled, mapper)
      derived(l1, mapper, decode, decode1)
    }

    def derived(
      labelledInstalled: LabelledInstalled[F],
      mapper: Function50Generic[F],
      decode: ToDecoderGeneric[F],
      decode1: ToDecoderGeneric1[F]
    ): BasedInstalled[F] = {
      val l1          = labelledInstalled
      val decodeImpl  = decode
      val decode1Impl = decode1

      val func50_1: Func50GenericImpl[F] = new Func50GenericImpl[F] {
        override def function0[T[_]](func1: Function0Apply[T]): F[T] = mapper.function0[T](func1)
        override def function2[S[_], T[_], U[_]](func1: Function2Apply[S, T, U])(f1: F[S], f2: F[T]): F[U] = {

          trait TMImpl[MX1[_], MX2[_]] {

            type ZipMin[T] = (MX1[T], MX2[T])

            type M1[S, T] = S => T
            val func1Impl: ToDecoderGeneric.FuncImpl[MX1, M1, MX2] = new ToDecoderGeneric.FuncImpl[MX1, M1, MX2] {
              override def apply[T]: MX1[T] => MX2[T] = func1[T]
            }
            val monadImpl: MonadAdd[M1] = new MonadAdd[M1] {
              override def zip[A, B, S, T](ma: A => B, ms: S => T): Tuple2[A, S] => Tuple2[B, T] = t => ma(t._1) -> ms(t._2)
              override def to[A, B, S, T](m1: A => B)(in1: A => S, in2: B => T)(out1: S => A, out2: T => B): S => T = sModel =>
                in2(m1(out1(sModel)))
              override def zero: Unit => Unit = identity
            }

            def inputOutput: (F[MX1] => F[MX2]) => F[MX1] => F[ZipMin]

          }

          mapper.function2[S, T, U](func1)(f1, f2)
        }

        override def function1[T1[_], TOut[_]](func: Function1Apply[T1, TOut])(
          t1: F[T1]
        ): F[TOut] = {
          type M1[S, T] = S => T
          val func1Impl: ToDecoderGeneric.FuncImpl[T1, M1, TOut] = new ToDecoderGeneric.FuncImpl[T1, M1, TOut] {
            override def apply[T]: T1[T] => TOut[T] = func[T]
          }
          val monadImpl: MonadAdd[M1] = new MonadAdd[M1] {
            override def zip[A, B, S, T](ma: A => B, ms: S => T): Tuple2[A, S] => Tuple2[B, T] = t => ma(t._1) -> ms(t._2)
            override def to[A, B, S, T](m1: A => B)(in1: A => S, in2: B => T)(out1: S => A, out2: T => B): S => T = sModel =>
              in2(m1(out1(sModel)))
            override def zero: Unit => Unit = identity
          }
          decode.toHList[T1, M1, TOut](monadImpl)(func1Impl)(t1)
        }
      }

      new BasedInstalled[F] {
        override def labelled: LabelledInstalled[F]  = l1
        override def funcion50: Function50Generic[F] = mapper
        override def decode: ToDecoderGeneric[F]     = decodeImpl
        override def decode1: ToDecoderGeneric1[F]   = decode1Impl
      }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
