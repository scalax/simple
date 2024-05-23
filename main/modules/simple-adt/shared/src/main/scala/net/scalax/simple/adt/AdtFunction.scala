package net.scalax.simple.adt

trait AdtFunction[-In, +Out] extends Any {
  def input(t: In): Out
}
object AdtFunction {
  implicit def contextImplicitApply[In]: AdtFunction[In, In] = new AdtFunction[In, In] {
    def input(t: In): In = t
  }
}
