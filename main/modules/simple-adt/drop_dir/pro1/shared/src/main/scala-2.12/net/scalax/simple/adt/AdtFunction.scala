package net.scalax.simple
package adt

trait AdtFunction[-In, +Out] extends Any {
  AdtFunctionSelf =>
  @inline def instance: In <:< Out
  @inline def higherKindApply[F[+_]](input: F[In]): F[Out]
  @inline def adtFunctionApply(input: In): Out = AdtFunctionSelf.instance(input)
}

object AdtFunction {

  @inline implicit def contextImplicitApply[In]: AdtFunction[In, In] = new AdtFunction[In, In] {
    @inline override def instance: In <:< In = implicitly[In <:< In]
    @inline override def higherKindApply[F[+_]](input: F[In]): F[In] = input
  }

}
