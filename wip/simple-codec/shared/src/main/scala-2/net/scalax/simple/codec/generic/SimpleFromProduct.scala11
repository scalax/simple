package net.scalax.simple.codec.generic

import net.scalax.simple.codec.{NamedImplicit, SimpleFrom, SimpleTo}
import shapeless.{Generic, HList}

trait SimpleNamed[Model] {
  def labelled: HList
}

trait SimpleFromTo[Model] extends SimpleFrom[Model] with SimpleTo[Model] with SimpleNamed[Model] {
  override def from(t: HList): Model
  override def to(t: Model): HList
  override def labelled: HList
}

trait SimpleFromProduct[F[_[_]]] {
  val generic: SimpleFromTo[F[({ type M1[_] = Any })#M1]]
}

object SimpleFromProduct {

  def apply[F[_[_]]]: ApplyImpl1[F] = new ApplyImpl1[F] {
    //
  }

  trait ApplyImpl1[F[_[_]]] {

    def derived(implicit
      g: Generic.Aux[F[({ type M1[_] = Any })#M1], _ <: HList],
      n: NamedImplicit[F[({ type M1[_] = Any })#M1]]
    ): SimpleFromProduct[F] = {
      val gImpl = g.asInstanceOf[Generic.Aux[F[({ type M1[_] = Any })#M1], HList]]

      new SimpleFromProduct[F] {
        override val generic: SimpleFromTo[F[({ type M1[_] = Any })#M1]] = new SimpleFromTo[F[({ type M1[_] = Any })#M1]] {
          override def from(t: HList): F[({ type M1[_] = Any })#M1] = gImpl.from(t)
          override def to(t: F[({ type M1[_] = Any })#M1]): HList   = gImpl.to(t)
          override val labelled: HList                              = n.input
        }
      }
    }

  }

}
