package net.scalax.simple
package adt

trait AdtFunction[-In, +Out] extends Any {
  @inline def instance: In <:< Out
  @inline def higherKindApply[F[+_]](input: F[In]): F[Out] = instance.liftCo[F](input)
  @inline def adtFunctionApply(input: In): Out             = higherKindApply[({ type IDApply[+T] = T })#IDApply](input)
}

object AdtFunction {

  @inline implicit def contextImplicitApply[In, Out](implicit cv: In <:< Out): AdtFunction[In, Out] = new AdtFunction[In, Out] {
    @inline override def instance: In <:< Out = cv
  }

}
