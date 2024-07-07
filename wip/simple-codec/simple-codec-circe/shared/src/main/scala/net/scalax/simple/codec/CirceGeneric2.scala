package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.SimpleProduct

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: SimpleProduct.Appender[F] with ModelLabelled[F]): Encoder[F[cats.Id]] = {
    val fromList          = FromListByTheSameTypeGeneric[F].derived(g1)
    val labelledInstalled = fromList.fromListByTheSameType(g1.modelLabelled)
    CirceGeneric.encodeModelImpl(g, g1, labelledInstalled)
  }

  def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: SimpleProduct.Appender[F] with ModelLabelled[F]): Decoder[F[cats.Id]] = {
    val fromList          = FromListByTheSameTypeGeneric[F].derived(g1)
    val labelledInstalled = fromList.fromListByTheSameType(g1.modelLabelled)
    CirceGeneric.decodeModelImpl(g, g1, labelledInstalled)
  }

}
