package net.scalax.simple.adt
package instance
package support

object AppendTailHelper2 {
  AppendTailSelf =>

  implicit def appendAbs1[XAA, S, CA <: AdtCoProduct.Use.Positive[_, _], CB <: AdtCoProduct.Use.Positive[_, _]](implicit
    tail: AppendAdt1.AdtSupport[XAA, CA, CB]
  ): AppendAdt1.AdtSupport[XAA, AdtCoProduct.Use.Positive[S, CA], AdtCoProduct.Use.Positive[S, CB]] =
    tail.next[S, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  implicit def zeroAppender[Item1, Zero]
    : AppendAdt1.AdtSupport[Zero, AdtCoProduct.Use.One[Item1], AdtCoProduct.Use.Positive[Item1, AdtCoProduct.Use.One[Zero]]] =
    AppendAdt1.adtSupportZero[Zero, Item1]

  def appendByDefault[U, Z1 <: AdtCoProduct.Use.Positive[_, _], Z2 <: AdtCoProduct.Use.Positive[_, _]](
    input: AdtCoProduct.Use.Positive[U, Z1]
  )(implicit u1: AppendAdt1.AdtSupport[U, Z1, Z2]): Z2 = {
    val ei1: Either[U, Z1] = input._foldCoProduct((u: U) => Left(u), (z1: Z1) => Right(z1))
    u1.current(ei1)
  }

}
