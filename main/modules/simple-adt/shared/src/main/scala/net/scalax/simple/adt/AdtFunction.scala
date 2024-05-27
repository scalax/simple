package net.scalax.simple
package adt

trait AdtFunction[-In, +Out] extends Any {
  @inline def higherTypeApply[F[+_]](input: F[In]): F[Out]
  @inline def adtFunctionApply(input: In): Out = higherTypeApply[({ type IdType[+T] = T })#IdType](input)
}
object AdtFunction {
  @inline implicit def contextImplicitApply[In]: AdtFunction[In, In] = new AdtFunction[In, In] {
    @inline override def higherTypeApply[F[+_]](input: F[In]): F[In] = input
  }
}
