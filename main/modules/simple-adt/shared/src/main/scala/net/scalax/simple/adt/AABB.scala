package net.scalax.simple.adt

import net.scalax.simple.adt.builder.DataTaker
import net.scalax.simple.ghdmzsk.ghdmzsk

object CCDD {

  trait P1

  trait Positive2[+T, Tail[_] <: P1, Data] extends P1 {
    def folddd[TD >: Data](f: T => TD): Tail[TD]
    def apply[TD >: Data](f: T => TD): Tail[TD]
  }

  trait PZero3[Data] extends P1 {
    def value: Data
  }

  trait CoCoProduct[+PP[_] <: P1] {
    def P: PP[Nothing]
  }
  trait CoCoPositive[+Data, PP[_] <: P1] extends CoCoProduct[({ type H2[DABB] = Positive2[Data, PP, DABB] })#H2] {
    override def P: Positive2[Data, PP, Nothing]
  }

  def cc: Positive2[
    Int,
    ({ type F1[U1] = Positive2[String, ({ type F2[U2] = Positive2[Double, ({ type F3[U3] = PZero3[U3] })#F3, U2] })#F2, U1] })#F1,
    Nothing
  ] = ???

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
