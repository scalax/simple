package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalled, ModelLink, ModelLinkCommonF, SimpleProductX}

trait ToItera[F[_[_]]] {
  toIteraSelf =>

  def to[T](simpleProductX: SimpleProductX[F]): SimpleProductX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
  def toBasedInstalled[T](oldInstanlled: BasedInstalled[F]): BasedInstalled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
    new BasedInstalled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
      override def basedInstalled: SimpleProductX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to[T](oldInstanlled.basedInstalled)
      override def labelled: ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.labelled.modelLabelled)
      override def size: ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.size.modelSize)
    }

  def toModelLink[T](
    oldInstanlled: ModelLink[F, F[({ type X1[U] = U })#X1]]
  ): ModelLink[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, F[({ type X1[_] = T })#X1]] =
    new ModelLink[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, F[({ type X1[_] = T })#X1]] {
      override def basedInstalled: SimpleProductX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to[T](oldInstanlled.basedInstalled)
      override def labelled: ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.labelled.modelLabelled)
      override def size: ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.size.modelSize)

      override def toIdentity(t: F[({ type X1[_] = T })#X1]): F[({ type X1[_] = T })#X1]   = t
      override def fromIdentity(t: F[({ type X1[_] = T })#X1]): F[({ type X1[_] = T })#X1] = t
    }
}

object ToItera {
  @inline private val toIteraImplImpl: ToItera[({ type F1[_[_]] = Any })#F1] = new ToItera[({ type F1[_[_]] = Any })#F1] {
    @inline def to[T](simpleProductX: SimpleProductX[({ type F1[_[_]] = Any })#F1]): SimpleProductX[({ type F1[_[_]] = Any })#F1] =
      simpleProductX
  }
  @inline private def toIteraImpl[F[_[_]]]: ToItera[F] = toIteraImplImpl.asInstanceOf[ToItera[F]]

  @inline private val builderImplImpl                = new Builder[({ type F1[_[_]] = Any })#F1]
  @inline private def applyImpl[F[_[_]]]: Builder[F] = builderImplImpl.asInstanceOf[Builder[F]]

  // ===
  class Builder[F[_[_]]] {
    @inline def derived: ToItera[F] = toIteraImpl[F]
  }
  @inline def apply[F[_[_]]]: Builder[F] = applyImpl[F]
}
