package net.scalax.simple.codec.utils

object SimpleP {

  trait AppendMonad[M[_, _, _]] {
    def zip[A, B, C, S, T, U](ma: M[A, B, C], ms: M[S, T, U]): M[(A, S), (B, T), (C, U)]
    def to[A, B, C, S, T, U](m1: M[A, B, C])(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): M[S, T, U]
    def zero: M[Unit, Unit, Unit]
  }

  trait TypeGen[M1[_, _, _], M2[_], M3[_], M4[_]] {
    def apply[T]: M1[M2[T], M3[T], M4[T]]
  }

  trait Appender[F[_[_]]] {
    def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](monad: AppendMonad[M1])(func: TypeGen[M1, M2, M3, M4]): M1[F[M2], F[M3], F[M4]]
  }

  trait ABDECD[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, Q1, Q1Append[
    _,
    _ <: Q1
  ] <: Q1, Q1Zero <: Q1, M[_, _, _]] {
    def append[A, P <: P1, X <: X1, Q <: Q1](m: M[P, X, Q]): M[P1Append[A, P], X1Append[A, X], Q1Append[A, Q]]
    def zero: M[P1Zero, X1Zero, Q1Zero]
  }

}

trait HListUtils2[Appendable, AppendablePositive[_, _ <: Appendable] <: Appendable, AppendZero <: Appendable] {
  def appendData[Head, Tail <: Appendable](h: Head, t: Tail): AppendablePositive[Head, Tail]
  def takeHead[Head, Tail <: Appendable](dataList: AppendablePositive[Head, Tail]): Head
  def takeTail[Head, Tail <: Appendable](dataList: AppendablePositive[Head, Tail]): Tail
  def takeZero: AppendZero

  def abab[M1[_, _, _], M2[_], M3[_], M4[_]]: SimpleP.ABDECD[
    Appendable,
    ({ type H1[Head, Tail <: Appendable] = AppendablePositive[M2[Head], Tail] })#H1,
    AppendZero,
    Appendable,
    ({ type H1[Head, Tail <: Appendable] = AppendablePositive[M3[Head], Tail] })#H1,
    AppendZero,
    Appendable,
    ({ type H1[Head, Tail <: Appendable] = AppendablePositive[M4[Head], Tail] })#H1,
    AppendZero,
    ({ type MX[A, B, C] = (SimpleP.AppendMonad[M1], SimpleP.TypeGen[M1, M2, M3, M4]) => M1[A, B, C] })#MX
  ] =
    new SimpleP.ABDECD[
      Appendable,
      ({ type H1[Head, Tail <: Appendable] = AppendablePositive[M2[Head], Tail] })#H1,
      AppendZero,
      Appendable,
      ({ type H1[Head, Tail <: Appendable] = AppendablePositive[M3[Head], Tail] })#H1,
      AppendZero,
      Appendable,
      ({ type H1[Head, Tail <: Appendable] = AppendablePositive[M4[Head], Tail] })#H1,
      AppendZero,
      ({ type MX[A, B, C] = (SimpleP.AppendMonad[M1], SimpleP.TypeGen[M1, M2, M3, M4]) => M1[A, B, C] })#MX
    ] {
      override def append[A, P <: Appendable, X <: Appendable, Q <: Appendable](
        m: (SimpleP.AppendMonad[M1], SimpleP.TypeGen[M1, M2, M3, M4]) => M1[P, X, Q]
      ): (
        SimpleP.AppendMonad[M1],
        SimpleP.TypeGen[M1, M2, M3, M4]
      ) => M1[AppendablePositive[M2[A], P], AppendablePositive[M3[A], X], AppendablePositive[M4[A], Q]] = { (o, func) =>
        val tailM1: M1[P, X, Q]                          = m(o, func)
        val headM1: M1[M2[A], M3[A], M4[A]]              = func[A]
        val zipM: M1[(P, M2[A]), (X, M3[A]), (Q, M4[A])] = o.zip(tailM1, headM1)

        o.to(zipM)(
          in1 = t => appendData(t._2, t._1),
          in2 = t => appendData(t._2, t._1),
          in3 = t => appendData(t._2, t._1)
        )(
          in4 = t => (takeTail(t), takeHead(t)),
          in5 = t => (takeTail(t), takeHead(t)),
          in6 = t => (takeTail(t), takeHead(t))
        )
      }

      override def zero: (SimpleP.AppendMonad[M1], SimpleP.TypeGen[M1, M2, M3, M4]) => M1[AppendZero, AppendZero, AppendZero] = {
        (o, func) =>
          o.to(o.zero)(
            _ => takeZero: AppendZero,
            _ => takeZero: AppendZero,
            _ => takeZero: AppendZero
          )(
            (_: AppendZero) => (),
            (_: AppendZero) => (),
            (_: AppendZero) => ()
          )
      }
    }

  def append[T1, HL1[_[_]] <: Appendable](
    tail: SimpleP.Appender[HL1]
  ): SimpleP.Appender[({ type HA[UA[_]] = AppendablePositive[UA[T1], HL1[UA]] })#HA] =
    new SimpleP.Appender[({ type FU[UA[_]] = AppendablePositive[UA[T1], HL1[UA]] })#FU] {
      override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](o: SimpleP.AppendMonad[M1])(
        func: SimpleP.TypeGen[M1, M2, M3, M4]
      ): M1[AppendablePositive[M2[T1], HL1[M2]], AppendablePositive[M3[T1], HL1[M3]], AppendablePositive[M4[T1], HL1[M4]]] = {
        val c = abab[M1, M2, M3, M4]
        c.append((x, a) => tail.toHList(x)(a))(o, func)
      }
    }

  val zero: SimpleP.Appender[({ type HA[_[_]] = AppendZero })#HA] = new SimpleP.Appender[({ type HA[_[_]] = AppendZero })#HA] {
    override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](
      o: SimpleP.AppendMonad[M1]
    )(func: SimpleP.TypeGen[M1, M2, M3, M4]): M1[AppendZero, AppendZero, AppendZero] = {
      val c = abab[M1, M2, M3, M4]
      c.zero(o, func)
    }
  }

}
