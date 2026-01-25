package net.scalax.simple.codec
package to_list_generic

import shapeless.DefaultSymbolicLabelling

trait ModelLink[F[_[_]], Model]
    extends BasedInstalledSimpleProduct[F]
    with BasedInstalledLabelled[F]
    with BasedInstalledModelSized[F]
    with ModelGet[F, Model]
    with ModelSet[F, Model]

object ModelLink {
  ModelLinkSelf =>

  class BuilderCommonF[FMM[_[_]]] {
    def derived(implicit
      compatNamed: DefaultSymbolicLabelling.Aux[FMM[({ type U1[X] = X })#U1], _ <: shapeless.HList],
      g: shapeless.Generic.Aux[FMM[({ type U1[_] = Any })#U1], _ <: shapeless.HList]
    ): ModelLinkSelf.F[FMM] = {
      val namedModel = compatNamed.apply()

      new ModelLinkCommonF[FMM] {
        override val compatNamed: Any                    = namedModel
        override def FToInstance[T[_]](x: FMM[T]): Any   = g.to(x.asInstanceOf[FMM[({ type U1[_] = Any })#U1]])
        override def FFromInstance[T[_]](x: Any): FMM[T] = g.from(x.asInstanceOf[g.Repr]).asInstanceOf[FMM[T]]
      }
    }

    def implicitly(implicit u: ModelLinkSelf.F[FMM]): ModelLinkSelf.F[FMM] = u
  }

  object F {
    def apply[F[_[_]]]: BuilderCommonF[F] = new BuilderCommonF[F]
  }
  type F[FModel[_[_]]] = ModelLink[FModel, FModel[({ type IDF[T] = T })#IDF]]

  /*class BuilderPojo[Model] {
    def derived(implicit
      g: shapeless.Generic.Aux[Model, _ <: shapeless.HList],
      c: DefaultSymbolicLabelling.Aux[Model, _ <: shapeless.HList]
    ): ModelLinkSelf.Pojo[Model] = {
      val namedModel = c.apply()

      new ModelLinkPojo[Model] {
        override val compatNamed: Any           = namedModel
        override def genericFrom(x: Any): Model = g.from(x.asInstanceOf[g.Repr])
        override def genericTo(x: Model): Any   = g.to(x)
      }
    }

    def implicitly(implicit u: ModelLinkSelf.Pojo[Model]): ModelLinkSelf.Pojo[Model] = u
  }*/

  /*object Pojo {
    def derived[Model](implicit
      g: shapeless.Generic.Aux[Model, _ <: shapeless.HList],
      c: DefaultSymbolicLabelling.Aux[Model, _ <: shapeless.HList]
    ): Pojo[Model] = {
      val namedModel = c.apply()
      new Pojo[Model] {
        override val compatNamed: Any           = namedModel
        override def genericFrom(x: Any): Model = g.from(x.asInstanceOf[g.Repr])
        override def genericTo(x: Model): Any   = g.to(x)
      }
    }

    def implicitly[Model](implicit u: ModelLinkSelf.Pojo[Model]): ModelLinkSelf.Pojo[Model] = u
  }
  trait Pojo[Model] extends ModelLinkPojo[Model]*/

}
