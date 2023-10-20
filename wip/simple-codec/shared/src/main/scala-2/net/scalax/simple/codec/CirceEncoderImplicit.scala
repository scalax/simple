package net.scalax.simple.codec

import io.circe._
import shapeless._
import CirceAlias.JsonObjectEncoder

trait CirceEncoderImplicit[F[_[_]]] {
  def model: JsonObjectEncoder[F[CirceEncoderImplicit.Id]]
}

object CirceEncoderImplicit {
  type Id[T]      = T
  type StringF[T] = String

  trait ToListJson[H1, H2, H3] {
    def toListJSON(h1: H1, h2: H2, h3: H3): List[(String, Json)]
  }
  object ToListJson {
    implicit def implicit1[H1 <: HList, H2 <: HList, H3 <: HList, T](implicit
      t: ToListJson[H1, H2, H3]
    ): ToListJson[String :: H1, T :: H2, Encoder[T] :: H3] =
      new ToListJson[String :: H1, T :: H2, Encoder[T] :: H3] {
        override def toListJSON(h1: String :: H1, h2: T :: H2, h3: Encoder[T] :: H3): List[(String, Json)] =
          (h1.head, h3.head(h2.head)) :: t.toListJSON(h1.tail, h2.tail, h3.tail)
      }
    implicit val implicit2: ToListJson[HNil, HNil, HNil] = new ToListJson[HNil, HNil, HNil] {
      override def toListJSON(h1: HNil, h2: HNil, h3: HNil): List[(String, Json)] = List.empty
    }
  }

  class DerivedApply[F[_[_]], StrModel <: F[StringF], EncoderModel <: F[Encoder], IdModel >: F[Id]](
    namedModel: StrModel,
    encoderModel: EncoderModel
  ) {

    def derived[H1, H2, H3](implicit
      generic1: Generic.Aux[StrModel, H1],
      generic2: Generic.Aux[IdModel, H2],
      generic3: Generic.Aux[EncoderModel, H3],
      toJson: ToListJson[H1, H2, H3]
    ): CirceEncoderImplicit[F] = new CirceEncoderImplicit[F] {
      override val model: JsonObjectEncoder[F[Id]] = JsonObjectEncoder.instance[F[Id]] { model =>
        val it = toJson.toListJSON(generic1.to(namedModel), generic2.to(model), generic3.to(encoderModel))
        JsonObject.fromIterable(it)
      }
    }

    def law[StrModelImpl >: StrModel <: F[StringF], EncoderModelIml >: EncoderModel <: F[Encoder], IdModelImpl >: F[Id]]
      : DerivedApply[F, StrModelImpl, EncoderModelIml, IdModelImpl] =
      new DerivedApply[F, StrModelImpl, EncoderModelIml, IdModelImpl](namedModel, encoderModel)

  }

  def apply[F[_[_]]](implicit
    namedModel: LabelledInstalled[F],
    encoderModel: FillIdentity[F, Encoder]
  ): DerivedApply[F, F[StringF], F[Encoder], F[Id]] =
    new DerivedApply[F, F[StringF], F[Encoder], F[Id]](namedModel.model, encoderModel.model)

}
