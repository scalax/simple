package net.scalax.simple
package codec

import distage._
import io.circe._
import cats.effect._

case class Model[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

trait EmptySetter

object xxbb1 extends IOApp.Simple {

  def encoderFromModel(modelEn: Model[Encoder], g: Getter[Model], lNames: LabelledNames[Model]): Encoder[Model[cats.Id]] = {
    val encoders = g.output(modelEn).asInstanceOf[List[Encoder[Any]]]
    Encoder[Model[cats.Id]] { m =>
      val dataList = g.output(m)
      val jsonList: List[(String, Json)] = encoders.zip(dataList).zip(lNames.names).map { case ((en, data), name) =>
        (name, en(data))
      }
      val jsonObject = JsonObject.fromIterable(jsonList)
      Json.fromJsonObject(jsonObject)
    }
  }

  val ecec = {
    def HelloByeModule = new ModuleDef {
      make[Encoder[Int]].from(Encoder[Int])
      make[Encoder[String]].from(Encoder[String])
      make[Encoder[Long]].from(Encoder[Long])
      make[Encoder[Option[Long]]].from { (e: Encoder[Long]) =>
        Encoder[Option[Long]]
      }
      make[Encoder[Option[String]]].from { (e: Encoder[String]) =>
        Encoder[Option[String]]
      }
      make[Model[Encoder]]
      make[Getter[Model]].from(Getter[Model].generic)
      make[Setter[Model]].from(Setter[Model].build(implicit m => m.generic))
      // 待修改
      make[EmptyTagModelFiller[Model]].from(EmptyTagModelFiller[Model].generic)
      make[LabelledNames[Model]].from { (u: EmptyTagModelFiller[Model]) =>
        LabelledNames[Model].distage(u)
      }
      make[Encoder[Model[cats.Id]]].from { (modelEn: Model[Encoder], g: Getter[Model], lNames: LabelledNames[Model]) =>
        encoderFromModel(modelEn, g, lNames)
      }
    }

    import cats.effect.unsafe.implicits.global

    val objectGraphResource = {
      Injector[IO]().produce(HelloByeModule, Roots.target[Encoder[Model[cats.Id]]])
    }

    objectGraphResource.toCats.use { t =>
      val e = t.get[Encoder[Model[cats.Id]]]
      IO(e)

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
      en <- ecec
      _  <- IO(println(en(modelInstance)))
    } yield {
      //
    }
  }

}
