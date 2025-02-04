package net.scalax.simple.codec

import shapeless.DefaultSymbolicLabelling

trait ModelLink[F[_[_]], Model] {
  def toIdentity(t: Model): F[({ type U1[X] = X })#U1]
  def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model
  def compatNamed: Any
  def FToInstance[T[_]](x: F[T]): Any
  def FFromInstance[T[_]](x: Any): F[T]
}

object ModelLink {

  class Builder0[F[_[_]], Model] {
    def toLabelled(fromId: F[({ type U1[X] = X })#U1] => Model, toId: Model => F[({ type U1[X] = X })#U1])(implicit
      compatNamed: DefaultSymbolicLabelling.Aux[Model, _ <: shapeless.HList],
      g: shapeless.Generic.Aux[F[({ type U1[_] = Any })#U1], _ <: shapeless.HList]
    ): ModelLink[F, Model] = {
      val named = compatNamed.apply()
      new ModelLink[F, Model] {
        override def toIdentity(t: Model): F[({ type U1[X] = X })#U1]   = toId(t)
        override def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model = fromId(t)
        override val compatNamed: Any                                   = named
        override def FToInstance[T[_]](x: F[T]): Any                    = g.to(x.asInstanceOf[F[({ type U1[_] = Any })#U1]])
        override def FFromInstance[T[_]](x: Any): F[T]                  = g.from(x.asInstanceOf[g.Repr]).asInstanceOf[F[T]]
      }
    }
  }

  def apply0[F[_[_]], Model]: Builder0[F, Model] = new Builder0[F, Model]

  class Builder1[F[_[_]]] {
    protected val builder0: Builder0[F, F[({ type U1[X] = X })#U1]] = apply0[F, F[({ type U1[X] = X })#U1]]

    def toLabelled(implicit
      compatNamed: DefaultSymbolicLabelling.Aux[F[({ type U1[X] = X })#U1], _ <: shapeless.HList],
      g: shapeless.Generic.Aux[F[({ type U1[_] = Any })#U1], _ <: shapeless.HList]
    ): ModelLink[F, F[({ type U1[X] = X })#U1]] = builder0.toLabelled(identity, identity)(compatNamed, g)
  }

  def apply1[F[_[_]]]: Builder1[F] = new Builder1[F]

}
