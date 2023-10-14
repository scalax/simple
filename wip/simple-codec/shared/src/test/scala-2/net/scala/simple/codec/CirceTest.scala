package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._

case class CatNameScala2[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object scala2xbb11 extends IOApp {

  implicit val im1 = implicitly[LabelledInstalled[CatNameScala2]]
  println(im1.model)

  def encodeModel[F[_[_]]](implicit
    modelEn: F[Encoder],
    g: ModelGetter[F[Encoder]],
    g1: ModelGetter[F[cats.Id]],
    lNames: ModelNames[F]
  ): Encoder[F[cats.Id]] = {
    val encoders = g.data(modelEn).asInstanceOf[List[Encoder[Any]]]
    Encoder.instance[F[cats.Id]] { m =>
      val dataList = g1.data(m)
      val jsonList: List[(String, Json)] = encoders.zip(dataList).zip(lNames.names).map { case ((en, data), name) =>
        (name, en(data))
      }
      val jsonObject = JsonObject.fromIterable(jsonList)
      Json.fromJsonObject(jsonObject)
    }
  }

  type EncoderAux[_]      = Encoder[String]
  type EncoderModelAux[_] = String
  def encodeModelName[F[_[_]]](implicit
    modelEn: F[EncoderAux],
    g: ModelGetter[F[EncoderAux]],
    g1: ModelGetter[F[EncoderModelAux]],
    lNames: ModelNames[F]
  ): Encoder[F[EncoderModelAux]] = {
    val encoders = g.data(modelEn).asInstanceOf[List[Encoder[Any]]]
    Encoder.instance[F[EncoderModelAux]] { m =>
      val dataList = g1.data(m)
      val jsonList: List[(String, Json)] = encoders.zip(dataList).zip(lNames.names).map { case ((en, data), name) =>
        (name, en(data))
      }
      val jsonObject = JsonObject.fromIterable(jsonList)
      Json.fromJsonObject(jsonObject)
    }
  }

  implicit def getter[U[_]]: ModelGetter[CatName[U]]         = ModelGetter.generic
  implicit def setter[U[_]]: ModelSetter[CatName[U]]         = ModelSetter[CatName[U]](u => CatName[U](u.get, u.get, u.get, u.get, u.get))
  implicit val propertyAny: CatName[PropertyTag.AnyAux]      = PropertyTag.genericAny[CatName]
  implicit val propertyTag: CatName[PropertyTag]             = PropertyTag.generic
  implicit val modelNames: ModelNames[CatName]               = ModelNames.generic
  implicit val modelLength: ModelLength[CatName]             = ModelLength.generic
  implicit val modelNameProperty: ModelNameProperty[CatName] = ModelNameProperty.generic
  implicit val modelEncoder: CatName[Encoder]                = CatName[Encoder](implicitly, implicitly, implicitly, implicitly, implicitly)
  implicit val modelStringEncoder: CatName[EncoderAux]     = CatName[EncoderAux](implicitly, implicitly, implicitly, implicitly, implicitly)
  implicit val caseClassEncoder: Encoder[CatName[cats.Id]] = encodeModel
  implicit val caseClassNameEncoder: Encoder[CatName[EncoderModelAux]] = encodeModelName

  val modelInstance: CatName[cats.Id] =
    CatName[cats.Id](
      name = 8594,
      str = Option("sdfwerwfweher迷雾日哦"),
      uClass = Option.empty,
      name11 = "xxiwerwjkl",
      namexu = "jerokwjoe收代理费加沃尔"
    )

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      _ <- IO(println(modelNameProperty.model.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */
}
