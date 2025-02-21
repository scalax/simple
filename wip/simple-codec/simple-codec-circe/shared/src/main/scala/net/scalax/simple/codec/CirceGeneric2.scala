package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, ModelLink, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit

object CirceGeneric2 {

  implicit def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: ModelLink[F, F[cats.Id]]): Encoder[F[cats.Id]] =
    Encoder.instance[F[cats.Id]](m => CirceGeneric.encodeModelImpl[F](m, g1, g))
  implicit def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: ModelLink[F, F[cats.Id]]): Decoder[F[cats.Id]] =
    Decoder.instance[F[cats.Id]](h => CirceGeneric.decodeModelImpl[F](h, g1, g))

  implicit def encodePojo[Model](implicit
    g1: ModelGetSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g: ByNameImplicit[PojoInstance[Encoder, Model]]
  ): Encoder[Model] = Encoder.instance[Model](m =>
    CirceGeneric.encodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F](g1.toIdentity(m), basedInstalled, g.value)
  )

  implicit def decodePojo[Model](implicit
    g1: ModelGetSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g: ByNameImplicit[PojoInstance[Decoder, Model]]
  ): Decoder[Model] = {
    val de1 = Decoder.instance[PojoInstance[cats.Id, Model]](h =>
      CirceGeneric.decodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F](h, basedInstalled, g.value)
    )

    for (m <- de1) yield g1.fromIdentity(m)
  }

}
