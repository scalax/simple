package net.scalax.simple.adt

trait Valued[+T] {
  def value: T
}

trait ResultFolderValuedApply[Data, Tail[_] <: Any, Result] extends ResultFolder[Data, Tail, Valued[Result]] {
  self =>

  def __peotectedValuedApply[TD >: Result](f: Data => TD): Tail[Valued[TD]] = self.apply[Valued[TD]](f)

  override def apply[TD >: Valued[Result]](f: Data => TD): Tail[TD]
}

trait ResultFolder[Data, Tail[_] <: Any, Result] {
  def apply[TD >: Result](f: Data => TD): Tail[TD]
}

object CCDD {

  trait ABDECD[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, Q1, Q1Append[
    _,
    _ <: Q1
  ] <: Q1, Q1Zero <: Q1, M[_ <: P1, _ <: X1, _ <: Q1]] {
    def append[A, P <: P1, X <: X1, Q <: Q1](m: M[P, X, Q]): M[P1Append[A, P], X1Append[A, X], Q1Append[A, Q]]
    def zero: M[P1Zero, X1Zero, Q1Zero]
  }

  trait ABCD2[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[_ <: P1, _ <: X1]]
      extends ABDECD[
        P1,
        P1Append,
        P1Zero,
        P1,
        P1Append,
        P1Zero,
        X1,
        X1Append,
        X1Zero,
        ({ type MX[A <: P1, B <: P1, C <: X1] = M2[B, C] })#MX
      ] {
    def append2[A, P <: P1, X <: X1](m: M2[P, X]): M2[P1Append[A, P], X1Append[A, X]]
    def zero2: M2[P1Zero, X1Zero]

    final override def append[A, PP <: P1, P2 <: P1, X <: X1](m: M2[P2, X]): M2[P1Append[A, P2], X1Append[A, X]] = append2(m)
    final override def zero: M2[P1Zero, X1Zero]                                                                  = zero2
  }

  type ProductType22AppenderImpl2[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[
    _ <: P1,
    _ <: X1
  ]] = utils.ProductType22Appender[
    P1,
    P1Append,
    P1Zero,
    P1,
    P1Append,
    P1Zero,
    X1,
    X1Append,
    X1Zero,
    ({ type MX[A <: P1, B <: P1, C <: X1] = M2[B, C] })#MX
  ]

  object ProductType22AppenderImpl2 {
    def gen[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[
      _ <: P1,
      _ <: X1
    ]](
      a: ABCD2[P1, P1Append, P1Zero, X1, X1Append, X1Zero, M2]
    ): ProductType22AppenderImpl2[P1, P1Append, P1Zero, X1, X1Append, X1Zero, M2] = utils.ProductType22AppenderGen.gen[
      P1,
      P1Append,
      P1Zero,
      P1,
      P1Append,
      P1Zero,
      X1,
      X1Append,
      X1Zero,
      ({ type MX[A <: P1, B <: P1, C <: X1] = M2[B, C] })#MX
    ](a)
  }

  trait ABCD1[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[_ <: P1]]
      extends ABCD2[P1, P1Append, P1Zero, P1, P1Append, P1Zero, ({ type MX[B <: P1, C <: P1] = M2[C] })#MX] {
    def append1[A, P <: P1](m: M2[P]): M2[P1Append[A, P]]
    def zero1: M2[P1Zero]

    final override def append2[A, PP <: P1, P2 <: P1](m: M2[P2]): M2[P1Append[A, P2]] = append1(m)
    final override def zero2: M2[P1Zero]                                              = zero1
  }

  type ProductType22AppenderImpl1[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[_ <: P1]] = ProductType22AppenderImpl2[
    P1,
    P1Append,
    P1Zero,
    P1,
    P1Append,
    P1Zero,
    ({ type MX[B <: P1, C <: P1] = M2[C] })#MX
  ]

  object ProductType22AppenderImpl1 {
    def gen[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[
      _ <: P1
    ]](a: ABCD1[P1, P1Append, P1Zero, M2]): ProductType22AppenderImpl1[P1, P1Append, P1Zero, M2] = utils.ProductType22AppenderGen.gen[
      P1,
      P1Append,
      P1Zero,
      P1,
      P1Append,
      P1Zero,
      P1,
      P1Append,
      P1Zero,
      ({ type MX[A <: P1, B <: P1, C <: P1] = M2[C] })#MX
    ](a)
  }

}
