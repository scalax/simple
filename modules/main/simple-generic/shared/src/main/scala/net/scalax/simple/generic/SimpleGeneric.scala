package net.scalax.simple.generic

import cats.Id
import io.circe._
import io.circe.syntax._

case class TestModel[F[_]](name: F[String], id: F[Long], age: F[Int], nick: F[String])

object TestModel {

  private def setter[F[_]](parameter: List[Any]): TestModel[F] = {
    def setModel(p: List[Any], func: Any): TestModel[F] = p match {
      case head :: tail => setModel(tail, func.asInstanceOf[Any => Any](head))
      case Nil          => func.asInstanceOf[TestModel[F]]
    }
    setModel(parameter, (TestModel.apply[F] _).curried)
  }

  private def circeDecoderImpl(fModel: TestModel[Decoder]): Decoder[TestModel[Id]] = {
    val names: List[String]        = fModel.productElementNames.to(List)
    val decoders: List[Decoder[_]] = fModel.productIterator.to(List).asInstanceOf[List[Decoder[_]]]

    def takeList(ns: List[String], ds: List[Decoder[_]], jsObj: HCursor): Decoder.Result[List[Any]] =
      ds match {
        case head :: tail =>
          val r1 = jsObj.downField(ns.head).as(head)
          for {
            r1Inner <- r1
            r2Inner <- takeList(ns.tail, tail, jsObj)
          } yield r1Inner :: r2Inner
        case Nil => Right(List.empty[Any])
      }

    for (t <- Decoder.instance(c => takeList(names, decoders, c))) yield setter(t)
  }

  private def circeEncoderImpl(fModel: TestModel[Encoder]): Encoder[TestModel[Id]] = {
    val names: List[String]        = fModel.productElementNames.to(List)
    val encoders: List[Encoder[_]] = fModel.productIterator.to(List).asInstanceOf[List[Encoder[_]]]

    def takeList(ns: List[String], ms: List[Any], ds: List[Encoder[_]]): List[(String, Json)] =
      ds match {
        case head :: tail =>
          (ns.head, head.asInstanceOf[Encoder[Any]](ms.head)) :: takeList(ns.tail, ms.tail, tail)
        case Nil => List.empty[(String, Json)]
      }

    Encoder.instance(t => Json.fromJsonObject(JsonObject.fromIterable(takeList(names, t.productIterator.to(List), encoders))))
  }

  implicit val testModelEncoder: Encoder[TestModel[Id]] = circeEncoderImpl(
    new TestModel[Encoder](implicitly, implicitly, implicitly, implicitly)
  )
  implicit val testModelDecoder: Decoder[TestModel[Id]] = circeDecoderImpl(
    new TestModel[Decoder](implicitly, implicitly, implicitly, implicitly)
  )

}

object Runner {

  def main(arr: Array[String]): Unit = {
    val 甜在心        = TestModel[Id](name = "甜在心", id = 2, age = 6, nick = "小星心")
    val strPrintln = 甜在心.asJson.noSpaces
    println(strPrintln)
    val parseResult   = io.circe.parser.parse(strPrintln)
    val modelFromJson = for (m1 <- parseResult; m2 <- m1.as[TestModel[Id]]) yield m2
    val modelGet      = modelFromJson.getOrElse(throw new Exception("Parse 失败"))
    println(modelGet)
    println(modelGet == 甜在心)
  }

}
