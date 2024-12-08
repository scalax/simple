package net.scalax.simple.ghdmzsk

import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive}

object SimpleCoProduct2 {

  trait AppendMonad[M1[_, _, _]] {
    def to[A, B, C, S, T, U](m1: M1[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M1[S, T, U]
    def zero: M1[Unit, Unit, Unit]
  }

  trait TypeGen[M1[_, _, _], M2[_, _], M3[_, _], M4[_, _]] {
    def apply[T1, T2]: M1[M2[T1, T2], M3[T1, T2], M4[T1, T2]]
    def either[A, B, C, S, T, U](ma: M1[M1[A, B, C], M1[S, T, U]]): M1[M2[A, S], M3[B, T], M4[C, U]]
  }

  trait Appender[F[_[_, _]]] {
    def toHList[M1[_, _, _], M2[_, _], M3[_, _], M4[_, _]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]]
  }

}

object SimpleCoProductImpl {

  /*trait HListFuncMapGeneric[Source1, Target1, Target2, Target3, M1[_, _, _], M2[_], M3[_], M4[_]] {
    def output(monad: SimpleCoProduct.AppendMonad[M1]): M1[Target1, Target2, Target3]
  }

  def appendImpl[T1, Source1 <: AdtNat, HL1 <: AdtNat, HL2 <: AdtNat, HL3 <: AdtNat, M1Context[_, _, _], M2[_], M3[_], M4[_]](
    tail: HListFuncMapGeneric[Source1, HL1, HL2, HL3, M1Context, M2, M3, M4]
  ): HListFuncMapGeneric[AdtNatPositive[T1, Source1], AdtNatPositive[M2[T1], HL1], AdtNatPositive[
    M3[T1],
    HL2
  ], AdtNatPositive[M4[T1], HL3], M1Context, M2, M3, M4] =
    new HListFuncMapGeneric[
      AdtNatPositive[T1, Source1],
      AdtNatPositive[M2[T1], HL1],
      AdtNatPositive[M3[T1], HL2],
      AdtNatPositive[M4[T1], HL3],
      M1Context,
      M2,
      M3,
      M4
    ] {
      override def output(
        o: SimpleCoProduct.AppendMonad[M1Context]
      ): M1Context[AdtNatPositive[M2[T1], HL1], AdtNatPositive[
        M3[T1],
        HL2
      ], AdtNatPositive[M4[
        T1
      ], HL3]] = {
        val tailM1: M1Context[Either[M2[T1], HL1], Either[M3[T1], HL2], Either[M4[T1], HL3]] = o.either(Right(tail.output(o)))

        o.to[Either[M2[T1], HL1], Either[
          M3[T1],
          HL2
        ], Either[M4[
          T1
        ], HL3], AdtNatPositive[M2[T1], HL1], AdtNatPositive[
          M3[T1],
          HL2
        ], AdtNatPositive[M4[
          T1
        ], HL3]](tailM1)(
          (t1: Either[M2[T1], HL1]) =>
            new AdtNatPositive[M2[T1], HL1] {
              override def data: Either[M2[T1], HL1] = t1
            },
          (t1: Either[M3[T1], HL2]) =>
            new AdtNatPositive[M3[T1], HL2] {
              override def data: Either[M3[T1], HL2] = t1
            },
          (t1: Either[M4[T1], HL3]) =>
            new AdtNatPositive[M4[T1], HL3] {
              override def data: Either[M4[T1], HL3] = t1
            }
        )(_.data, _.data, _.data)
      }
    }

  def append[T1, Source1 <: AdtNat, HL1 <: AdtNat, HL2 <: AdtNat, HL3 <: AdtNat, M1Context[_, _, _], M2[_], M3[_], M4[_]](
    tail: Either[SimpleCoProduct.TypeGen[M1Context, M2, M3, M4], HListFuncMapGeneric[Source1, HL1, HL2, HL3, M1Context, M2, M3, M4]]
  ): HListFuncMapGeneric[AdtNatPositive[T1, Source1], AdtNatPositive[M2[T1], HL1], AdtNatPositive[
    M3[T1],
    HL2
  ], AdtNatPositive[M4[T1], HL3], M1Context, M2, M3, M4] =
    new HListFuncMapGeneric[
      AdtNatPositive[T1, Source1],
      AdtNatPositive[M2[T1], HL1],
      AdtNatPositive[M3[T1], HL2],
      AdtNatPositive[M4[T1], HL3],
      M1Context,
      M2,
      M3,
      M4
    ] {
      override def output(
        o: SimpleCoProduct.AppendMonad[M1Context]
      ): M1Context[AdtNatPositive[M2[T1], HL1], AdtNatPositive[
        M3[T1],
        HL2
      ], AdtNatPositive[M4[
        T1
      ], HL3]] = {
        val tailM1: M1Context[Either[M2[T1], HL1], Either[M3[T1], HL2], Either[M4[T1], HL3]] =
          o.either(tail.left.map(t1 => t1[T1]).right.map(t2 => t2.output(o)))

        o.to[Either[M2[T1], HL1], Either[
          M3[T1],
          HL2
        ], Either[M4[
          T1
        ], HL3], AdtNatPositive[M2[T1], HL1], AdtNatPositive[
          M3[T1],
          HL2
        ], AdtNatPositive[M4[
          T1
        ], HL3]](tailM1)(
          (t1: Either[M2[T1], HL1]) =>
            new AdtNatPositive[M2[T1], HL1] {
              override def data: Either[M2[T1], HL1] = t1
            },
          (t1: Either[M3[T1], HL2]) =>
            new AdtNatPositive[M3[T1], HL2] {
              override def data: Either[M3[T1], HL2] = t1
            },
          (t1: Either[M4[T1], HL3]) =>
            new AdtNatPositive[M4[T1], HL3] {
              override def data: Either[M4[T1], HL3] = t1
            }
        )(_.data, _.data, _.data)
      }
    }*/

}
