package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.{ModelLink, PojoInstance}

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: ModelLink[F, F[cats.Id]]): Encoder[F[cats.Id]] =
    CirceGeneric.encodeModelImpl[F, F[cats.Id]](g1, g)
  def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: ModelLink[F, F[cats.Id]]): Decoder[F[cats.Id]] =
    CirceGeneric.decodeModelImpl[F, F[cats.Id]](g1, g)

  def encodePojo[Model](implicit
    g: PojoInstance[Encoder, Model],
    g1: ModelLink[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model]
  ): Encoder[Model] = CirceGeneric.encodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model](g1, g)
  def decodePojo[Model](implicit
    g: PojoInstance[Decoder, Model],
    g1: ModelLink[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model]
  ): Decoder[Model] = CirceGeneric.decodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model](g1, g)

}
