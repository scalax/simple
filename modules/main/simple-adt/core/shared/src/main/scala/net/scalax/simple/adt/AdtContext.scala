package net.scalax.simple
package adt

import CoreInstance._

object DefaultAdtContext {
  implicit def adtDefaultConvertImplicit[In <: Out, Out]: TypeAdt.Context[In, Out, DefaultAdtContext.type] =
    new TypeAdt.Context[In, Out, DefaultAdtContext.type] {
      override def input(t: In): Out = t
    }
}
