package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.ModelLink

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: ModelLink[F, F[cats.Id]]): Encoder[F[cats.Id]] = CirceGeneric.encodeModelImpl(g1, g)
  def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: ModelLink[F, F[cats.Id]]): Decoder[F[cats.Id]] = CirceGeneric.decodeModelImpl(g1, g)

}
