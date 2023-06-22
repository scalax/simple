package net.scalax.simple
package codec

import distage._
import io.circe._
import cats.effect._

case class Model[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

trait EmptySetter

object xxbb1 extends IOApp.Simple {

  def encoderFromModel[F[_[_]]](modelEn: F[Encoder], g: ModelGetter[F], lNames: ModelNames[F]): Encoder[F[cats.Id]] = {
    val encoders = g.data(modelEn).asInstanceOf[List[Encoder[Any]]]
    Encoder[F[cats.Id]] { m =>
      val dataList = g.data(m)
      val jsonList: List[(String, Json)] = encoders.zip(dataList).zip(lNames.names).map { case ((en, data), name) =>
        (name, en(data))
      }
      val jsonObject = JsonObject.fromIterable(jsonList)
      Json.fromJsonObject(jsonObject)
    }
  }

  type AnyFunc[T] = PropertyTag[Any]

  val ecec = {
    def HelloByeModule = new ModuleDef {
      make[PropertyTag[Any]].fromValue(PropertyTag.value[Any])
      make[Model[PropertyTag]].from { (u: Model[AnyFunc]) => u.asInstanceOf[Model[PropertyTag]] }
      make[Model[AnyFunc]]
      make[ModelLength[Model]].from { (u: Model[PropertyTag], getter: ModelGetter[Model]) =>
        ModelLength.generic[Model](u, getter)
      }
      make[ModelGetter[Model]].fromValue(ModelGetter.generic[Model])
      make[ModelSetter[Model]].from { (u: ModelLength[Model]) =>
        ModelSetter.generic[Model](u)
      }
      make[ModelNames[Model]].from { (u: Model[AnyFunc]) =>
        ModelNames.generic[Model](u)
      }
      make[ModelProperty[Model]].from { (modelNames: ModelNames[Model], modelSetter: ModelSetter[Model]) =>
        ModelProperty.generic[Model](modelNames, modelSetter)
      }
      make[Model[Encoder]]
      make[Encoder[Model[cats.Id]]].from { (modelEn: Model[Encoder], g: ModelGetter[Model], lNames: ModelNames[Model]) =>
        encoderFromModel[Model](modelEn, g, lNames)
      }
      // circe
      make[Encoder[Int]].fromValue(Encoder[Int])
      make[Encoder[Long]].fromValue(Encoder[Long])
      make[Encoder[String]].fromValue(Encoder[String])
      make[Encoder[Option[String]]].fromValue(Encoder[Option[String]])
      make[Encoder[Option[Long]]].fromValue(Encoder[Option[Long]])
      //
    }

    val objectGraphResource = {
      Injector[IO]().produce(
        HelloByeModule,
        Roots.target[Model[AnyFunc]] ++ Roots.target[ModelLength[Model]] ++ Roots.target[ModelGetter[Model]] ++ Roots
          .target[ModelSetter[Model]] ++ Roots.target[ModelNames[Model]] ++ Roots.target[ModelProperty[Model]] ++ Roots
          .target[Encoder[Model[cats.Id]]]
      )
    }

    objectGraphResource.toCats.use { t =>
      val e1 = t.get[Model[AnyFunc]]
      val e2 = t.get[ModelLength[Model]]
      val e3 = t.get[ModelGetter[Model]]
      val e4 = t.get[ModelSetter[Model]]
      val e5 = t.get[ModelNames[Model]]
      val e6 = t.get[ModelProperty[Model]]
      val e7 = t.get[Encoder[Model[cats.Id]]]
      IO((e1, e2, e3, e4, e5, e6, e7))
    }
  }

  def modelInstance: Model[cats.Id] =
    Model[cats.Id](
      name = 8594,
      str = Option("sdfwerwfweher迷雾日哦"),
      uClass = Option.empty,
      name11 = "xxiwerwjkl",
      namexu = "jerokwjoe收代理费加沃尔"
    )

  override val run: IO[Unit] = {
    for {
      eu <- ecec
      (e1, e2, e3, e4, e5, e6, e7) = eu
      _ <- IO(println(e1))
      _ <- IO(println(e1.name11))
      _ <- IO(println(e2.size))
      _ <- IO(println(e3.data(modelInstance)))
      u <- IO(e4.input[cats.Id](List(126722, Option("xxuulhjweikr"), Option.empty, "asdqr", "aweqwwrweew")))
      _ <- IO(println(u))
      _ <- IO(println(u.namexu))
      _ <- IO(println(u.name11))
      _ <- IO(println(e5.names))
      _ <- IO(println(e6.model))
      _ <- IO(println(e7(u)))
    } yield {
      val n: String = e6.model.uClass
      //
    }
  }

}
