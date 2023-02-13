package net.scalax.simple
package adt

object DefaultAdtContext {
  implicit def adtDefaultContextImplicit[In <: Out, Out, Poly]: TypeAdt.Context[In, Out, Poly] = new TypeAdt.Context[In, Out, Poly] {
    override def input(t: In): Out = t
  }
}

object TypeClassAdtContext {
  implicit def adtTypeClassContextImplicit[In, F[_], Poly](implicit v: F[In]): TypeAdt.Context[In, F[In], Poly] =
    new TypeAdt.Context[In, F[In], Poly] {
      override def input(t: In): F[In] = v
    }
}
