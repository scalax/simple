package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleName

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.ToNamed]
}

object LabelledInstalled {

  type ToNamed[_] = String

  class DerivedApply[F[_[_]]] {
    def derived(implicit compatLabelledInstalled: CompatLabelledInstalled[F], mapper: Function50Generic[F]): LabelledInstalled[F] = {
      instance(compatLabelledInstalled.model)
    }

    def instance(model: F[ToNamed]): LabelledInstalled[F] = {
      val model1 = model
      new LabelledInstalled[F] {
        override val model: F[ToNamed] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}

import java.time._
import io.circe._

trait AA {

  def localdatetimeEncoder: Encoder[LocalDateTime] = Encoder.encodeLocalDateTimeWithFormatter(fmt)
  val fmt                                          = format.DateTimeFormatter.ofPattern("yyyy-MM-dd MM:mm:ss")

}

object CodecI extends AA
