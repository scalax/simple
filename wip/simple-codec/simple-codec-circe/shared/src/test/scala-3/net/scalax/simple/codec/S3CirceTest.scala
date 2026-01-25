package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, ModelLinkPojo}

case class S3CatName(id4: Int, str4: Option[String], uClass4: Option[Long], name114: String, namexu4: String)
    derives ModelLinkPojo,
      SimpleJsonCodecLabelledPojo

object S3CatName {

  given FillIdentity.Pojo[Encoder, S3CatName] = FillIdentity.Pojo[Encoder, S3CatName].derived
  given FillIdentity.Pojo[Decoder, S3CatName] = FillIdentity.Pojo[Decoder, S3CatName].derived

}

object S3CirceTest1 {

  import CirceGen.Pojo._

  val modelInstance: S3CatName = S3CatName(
    id4 = 8594,
    str4 = Option("aaTest3"),
    uClass4 = Option.empty,
    name114 = "xxiwerwjkl",
    namexu4 = "jerokwjoe收代理Test3"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[S3CatName]))
  }

}
