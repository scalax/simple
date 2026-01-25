package net.scalax.simple
package adt

trait AdtFunction[In, Out] extends Any {
  AdtFunctionSelf =>
  @inline def instance: In <:< Out
  @inline def higherKindApply[F[+_]](input: F[In]): F[Out]
  @inline def adtFunctionApply(input: In): Out = AdtFunctionSelf.instance(input)
}

object AdtFunction {

  @inline implicit def contextImplicitApply[In, Out >: In]: AdtFunction[In, Out] = new AdtFunction[In, Out] {
    @inline override def instance: In <:< Out                         = implicitly[In <:< Out]
    @inline override def higherKindApply[F[+_]](input: F[In]): F[Out] = input
  }

}
