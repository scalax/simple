package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.SimpleProduct

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: SimpleProduct.AppenderImpl[F]): Encoder[F[cats.Id]] = {
    val fromList          = FromListByTheSameTypeGeneric[F].derived(g1)
    val labelledInstalled = CompatLabelled.toLabelled[F](g1, g1)
    CirceGeneric.encodeModelImpl(g, g1, labelledInstalled.modelLabelled)
  }

  def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: SimpleProduct.AppenderImpl[F]): Decoder[F[cats.Id]] = {
    val fromList          = FromListByTheSameTypeGeneric[F].derived(g1)
    val labelledInstalled = CompatLabelled.toLabelled[F](g1, g1)
    CirceGeneric.decodeModelImpl(g, g1, labelledInstalled.modelLabelled)
  }

}
