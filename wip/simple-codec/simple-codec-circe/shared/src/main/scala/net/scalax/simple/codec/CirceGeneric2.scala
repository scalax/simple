package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.SimpleProduct

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: SimpleProduct.Appender[F], named: LabelledInstalled[F]): Encoder[F[cats.Id]] = {
    val ig1               = ToItera[F].derived.to[String]
    val labelledInstalled = named.impl.labelled(ig1)
    CirceGeneric.encodeModelImpl(g, g1, labelledInstalled)
  }

  def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: SimpleProduct.Appender[F], named: LabelledInstalled[F]): Decoder[F[cats.Id]] = {
    val ig1               = ToItera[F].derived.to[String]
    val labelledInstalled = named.impl.labelled(ig1)
    CirceGeneric.decodeModelImpl(g, g1, labelledInstalled)
  }

}
