package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.utils.SimpleP

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: SimpleP.Appender[F], labelled: ModelLabelled[F]): Encoder[F[cats.Id]] = {
    CirceGeneric.encodeModelImpl(g, g1, labelled.modelLabelled)
  }

  def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: SimpleP.Appender[F], labelled: ModelLabelled[F]): Decoder[F[cats.Id]] = {
    CirceGeneric.decodeModelImpl(g, g1, labelled.modelLabelled)
  }

}
