package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct}

trait ReplaceByPropertyName[F[_[_]]] {
  def replaceImpl[UX](proName: String, proValue: UX): F[({ type X1[_] = UX })#X1] => F[({ type X1[_] = UX })#X1]
  def replace[T[_]](proName: String, proValue: Any): F[T] => F[T] = {
    val funcImpl: F[({ type X1[_] = Any })#X1] => F[({ type X1[_] = Any })#X1] = replaceImpl[Any](proName = proName, proValue = proValue)
    funcImpl.asInstanceOf[F[T] => F[T]]
  }
}

object ReplaceByPropertyName {

  class Builder[F[_[_]]] {
    def derivedImpl(
      indexOfPropertyName: IndexOfPropertyName[F],
      replaceByIndex: ReplaceByIndex[F],
      labelled: ModelLabelled[F]
    ): ReplaceByPropertyName[F] = new ReplaceByPropertyName[F] {
      override def replaceImpl[UX](proName: String, proValue: UX): F[({ type X1[_] = UX })#X1] => F[({ type X1[_] = UX })#X1] = {
        val indexInt = indexOfPropertyName.ofName(proName, labelled.modelLabelled)
        replaceByIndex.replaceImpl[UX](indexInt, proValue)
      }
    }

    def derived(basedInstalled: BasedInstalledSimpleProduct[F], labelled: BasedInstalledLabelled[F]): ReplaceByPropertyName[F] = {
      val appender1 = basedInstalled.basedInstalled.simpleProduct1
      derivedImpl(IndexOfPropertyName[F].derived(appender1), ReplaceByIndex[F].derived(appender1), labelled.labelled)
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
