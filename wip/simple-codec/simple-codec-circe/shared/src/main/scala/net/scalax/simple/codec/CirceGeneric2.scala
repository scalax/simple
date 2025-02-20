package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, ModelLink, PojoInstance}

object CirceGeneric2 {

  implicit def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: ModelLink[F, F[cats.Id]]): Encoder[F[cats.Id]] =
    CirceGeneric.encodeModelImpl[F](g1, g)
  implicit def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: ModelLink[F, F[cats.Id]]): Decoder[F[cats.Id]] =
    CirceGeneric.decodeModelImpl[F](g1, g)

  implicit def encodePojo[Model](implicit
    g1: ModelGetSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g: PojoInstance[Encoder, Model]
  ): Encoder[Model] =
    CirceGeneric.encodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F](basedInstalled, g).contramap(g1.toIdentity)

  implicit def decodePojo[Model](implicit
    g1: ModelGetSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g: PojoInstance[Decoder, Model]
  ): Decoder[Model] = for (t <- CirceGeneric.decodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F](basedInstalled, g))
    yield g1.fromIdentity(t)

}
