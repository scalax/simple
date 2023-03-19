package net.scalax.simple
package adt

object DefaultAdtContext {
  implicit def adtDefaultContextImplicit[In <: Out, Out, Poly]: TypeAdt.Context[In, Out, Poly] = new TypeAdt.Context[In, Out, Poly] {
    override def input(t: In): Out = t
  }
}

object ImplicitlyAdtContext {
  implicit def adtTypeClassContextImplicit[In, Imp, Poly](implicit v: Imp): TypeAdt.Context[In, Imp, Poly] =
    new TypeAdt.Context[In, Imp, Poly] {
      override def input(t: In): Imp = v
    }
}
