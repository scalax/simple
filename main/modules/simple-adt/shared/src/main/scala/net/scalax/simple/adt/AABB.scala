package net.scalax.simple.adt

import net.scalax.simple.adt.builder.DataTaker
import net.scalax.simple.ghdmzsk.ghdmzsk

object CCDD {

  trait P1

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

}
