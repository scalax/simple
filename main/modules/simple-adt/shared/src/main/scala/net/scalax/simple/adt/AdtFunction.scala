package net.scalax.simple
package adt

trait AdtFunction[-In, +Out] extends Any {
  def instance: In <:< Out
  def adtFunctionApply(input: In): Out
}

object AdtFunction {

  implicit def contextImplicitApply[In, Out](implicit cv: In <:< Out): AdtFunction[In, Out] = new AdtFunction[In, Out] {
    override def instance: In <:< Out             = cv
    override def adtFunctionApply(input: In): Out = instance(input)
  }

}
