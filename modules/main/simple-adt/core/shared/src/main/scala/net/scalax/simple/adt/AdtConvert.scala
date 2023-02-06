package net.scalax.simple
package adt

import CoreInstance._

trait AdtContext[In, Out, Poly] {
  def input(t: In): Out
}

object AdtDefaultContext {
  implicit def adtDefaultConvertImplicit[In <: Out, Out]: AdtContext[In, Out, AdtDefaultContext.type] =
    new AdtContext[In, Out, AdtDefaultContext.type] {
      override def input(t: In): Out = t
    }
}

case class AdtConvertWrapper(result: Core2, convert: AdtContext[Any, Any, Any]) extends Core2 {
  override def apply(t: () => Core2): Core2 = throw new Exception
}
