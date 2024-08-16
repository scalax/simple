package net.scalax.simple.adt

import net.scalax.simple.adt.SimpleCoProductImpl.HListFuncMapGeneric
import net.scalax.simple.adt.builder.DataTaker
import net.scalax.simple.ghdmzsk.ghdmzsk

object CCDD {

  /*trait P1

  trait Positive2[T, Tail[_] <: P1, Data] extends P1 {
    def folddd[TD >: Data](f: T => TD): Tail[TD]
    def apply[TD >: Data](f: T => TD): Tail[TD]
  }

  trait PZero3[Data] extends P1 {
    def value: Data
  }

  trait Func[T[_] <: P1] {
    type U[A] = T[A]
    def instance: T[Nothing]
  }
  type Append[Data, PP[_] <: P1] = Func[({ type F1[DAB] = Positive2[Data, PP, DAB] })#F1]
  type Zero                      = Func[({ type F1[DAB] = PZero3[DAB] })#F1]

  type AB = Append[Int, Append[String, Append[Double, Zero#U]#U]#U]

  def ab: AB            = ???
  def cc: AB#U[Nothing] = ab.instance

  {
    def dd =
      cc.folddd(intValue => Some(BigDecimal(intValue)))
        .folddd(strValue => scala.util.Try(BigDecimal(strValue)).toOption)
        .folddd(doubleValue => Some(BigDecimal(doubleValue)))

    def ee                     = dd.value
    def ff: Option[BigDecimal] = ee
  }

  {
    def dd = cc(intValue => Some(BigDecimal(intValue)))(strValue => scala.util.Try(BigDecimal(strValue)).toOption)(doubleValue =>
      Some(BigDecimal(doubleValue))
    )

    def ee                     = dd.value
    def ff: Option[BigDecimal] = ee
  }

  trait PiUU[T <: RuntimeNat] {
    type U[_] <: P1
  }

  object PiUU extends PolyA {
    type Aux[T <: RuntimeNat, U1[_] <: P1] = PiUU[T] {
      type U[X] = U1[X]
    }

    implicit def bb: PiUU.Aux[RuntimeZero, ({ type F1[DAB] = PZero3[DAB] })#F1] = ???
  }

  trait PolyA {
    implicit def aa[T1 <: RuntimeNat, U1[_] <: P1, Data](implicit
      cv: PiUU.Aux[T1, U1]
    ): PiUU.Aux[RuntimeData[Data, T1], ({ type F1[DAB] = Positive2[Data, U1, DAB] })#F1] = ???
  }

  trait CVAB[Ty <: RuntimeNat] {
    def fold[U1[_] <: P1](implicit u: PiUU.Aux[Ty, U1]): U1[Nothing] = ???
  }

  def cvab[Ty <: RuntimeNat]: CVAB[Ty] = new CVAB[Ty] {
    //
  }*/

  // val bb = cvab[RuntimeData[BigDecimal, RuntimeData[Int, RuntimeData[String, RuntimeData[Option[BigDecimal], RuntimeZero]]]]].fold

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

  trait ProductType22AppenderImpl2[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, X1, X1Append[_, _ <: X1] <: X1, X1Zero <: X1, M2[
    _ <: P1,
    _ <: X1
  ]] extends utils.ProductType22Appender[
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
    override def helper: ABCD2[P1, P1Append, P1Zero, X1, X1Append, X1Zero, M2]
  }

  trait ABCD1[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[_ <: P1]]
      extends ABCD2[P1, P1Append, P1Zero, P1, P1Append, P1Zero, ({ type MX[B <: P1, C <: P1] = M2[C] })#MX] {
    def append1[A, P <: P1](m: M2[P]): M2[P1Append[A, P]]
    def zero1: M2[P1Zero]

    final override def append2[A, PP <: P1, P2 <: P1](m: M2[P2]): M2[P1Append[A, P2]] = append1(m)
    final override def zero2: M2[P1Zero]                                              = zero1
  }

  trait ProductType22AppenderImpl1[P1, P1Append[_, _ <: P1] <: P1, P1Zero <: P1, M2[_ <: P1]]
      extends ProductType22AppenderImpl2[
        P1,
        P1Append,
        P1Zero,
        P1,
        P1Append,
        P1Zero,
        ({ type MX[B <: P1, C <: P1] = M2[C] })#MX
      ] {
    override def helper: ABCD1[P1, P1Append, P1Zero, M2]
  }

}
