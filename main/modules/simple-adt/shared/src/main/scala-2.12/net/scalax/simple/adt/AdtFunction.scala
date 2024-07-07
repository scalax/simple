package net.scalax.simple
package adt

trait AdtFunction[-In, +Out] extends Any {
  @inline def higherKindApply[F[+_]](input: F[In]): F[Out]
  @inline def adtFunctionApply(input: In): Out = higherKindApply[({ type IDApply[+T] = T })#IDApply](input)
}

object AdtFunction {

  @inline implicit def contextImplicitApply[In]: AdtFunction[In, In] = new AdtFunction[In, In] {
    @inline override def higherKindApply[F[+_]](input: F[In]): F[In] = input
  }

}
