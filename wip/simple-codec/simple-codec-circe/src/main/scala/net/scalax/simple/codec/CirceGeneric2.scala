package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.SimpleProduct

object CirceGeneric2 {

  def encodeModel[F[_[_]]](implicit
    g: F[Encoder],
    g1: SimpleProduct.Appender[F],
    named: NamedImplicit[F[LabelledInstalled.Named]]
  ): Encoder[F[cats.Id]] = {
    val labelledInstalled = LabelledInstalled[F].derived(g1, named)
    CirceGeneric.encodeModelImpl(g, g1, labelledInstalled.labelled)
  }

  def decodeModel[F[_[_]]](implicit
    g: F[Decoder],
    g1: SimpleProduct.Appender[F],
    named: NamedImplicit[F[LabelledInstalled.Named]]
  ): Decoder[F[cats.Id]] = {
    val labelledInstalled = LabelledInstalled[F].derived(g1, named)
    CirceGeneric.decodeModelImpl(g, g1, labelledInstalled.labelled)
  }

}
