package net.scalax.simple
package adt

import CoreInstance._

trait AdtContext[In, Out, Poly] extends Any {
  def input(t: In): Out
}

object DefaultAdtContext {
  implicit def adtDefaultConvertImplicit[In <: Out, Out]: AdtContext[In, Out, DefaultAdtContext.type] =
    new AdtContext[In, Out, DefaultAdtContext.type] {
      override def input(t: In): Out = t
    }
}

class AdtAdapter[Target, Poly](val value: Target)
