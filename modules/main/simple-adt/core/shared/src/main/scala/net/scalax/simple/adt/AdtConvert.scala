package net.scalax.simple
package adt

import CoreInstance._

trait AdtConvert[In, Out, Poly] {
  def input(t: In): Out
}

object AdtDefaultConvert {
  implicit def adtDefaultConvertImplicit[In <: Out, Out]: AdtConvert[In, Out, AdtDefaultConvert.type] =
    new AdtConvert[In, Out, AdtDefaultConvert.type] {
      override def input(t: In): Out = t
    }
}

case class AdtConvertWrapper(result: Core2, convert: AdtConvert[Any, Any, Any]) extends Core2 {
  override def apply(t: () => Core2): Core2 = throw new Exception
}
