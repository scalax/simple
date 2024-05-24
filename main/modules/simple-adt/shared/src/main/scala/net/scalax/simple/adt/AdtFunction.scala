package net.scalax.simple
package adt

trait AdtFunction[-In, +Out] extends Any {
  def adtFunctionApply(t: In): Out
}
object AdtFunction {
  implicit def contextImplicitApply[In]: AdtFunction[In, In] = new AdtFunction[In, In] {
    def adtFunctionApply(t: In): In = t
  }

  def defalutValue[In]: AdtFunction[In, IsFinishAndNothing] = new AdtFunction[In, IsFinishAndNothing] {
    override def adtFunctionApply(t: In): IsFinishAndNothing = IsFinishAndNothing.value(t)
  }
}
