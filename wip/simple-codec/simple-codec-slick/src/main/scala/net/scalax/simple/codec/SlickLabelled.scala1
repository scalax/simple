package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalled, PojoInstance}

trait SlickLabelled[F[_[_]]] {
  SlickLabelledSelf =>

  def labelled: F[({ type NamedF[_] = String })#NamedF]

  def update(func: F[({ type NamedF[_] = String })#NamedF] => F[({ type NamedF[_] = String })#NamedF]): SlickLabelled[F] =
    new SlickLabelled[F] {
      override def labelled: F[({ type NamedF[_] = String })#NamedF] = func(SlickLabelledSelf.labelled)
    }

}

object SlickLabelled {

  class Builder[FMM[_[_]]] {
    def derived(implicit bi: BasedInstalled[FMM]): SlickLabelled[FMM] = new SlickLabelled[FMM] {
      override def labelled: FMM[({ type NamedF[_] = String })#NamedF] = bi.labelled.modelLabelled
    }
  }

  object F {
    def apply[FMM[_[_]]]: Builder[FMM] = new Builder[FMM]
  }
  type F[FMM[_[_]]] = SlickLabelled[FMM]

  object Pojo {
    def apply[Model]: Builder[({ type POJOF[U[_]] = PojoInstance[U, Model] })#POJOF] =
      new Builder[({ type POJOF[U[_]] = PojoInstance[U, Model] })#POJOF]
  }
  type Pojo[Model] = SlickLabelled[({ type POJOF[U[_]] = PojoInstance[U, Model] })#POJOF]

}
