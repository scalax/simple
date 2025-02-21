package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{ModelLinkPojo, PojoInstance}

case class CatNameTest3(id3: Int, str3: Option[String], uClass3: Option[Long], name113: String, friends: List[CatNameTest3])

object CatNameTest3 {
  implicit val deco2_1: ModelLinkPojo[CatNameTest3] = ModelLinkPojo.derived

  import CirceGeneric2._

  implicit val modelEncoder: PojoInstance[Encoder, CatNameTest3] = PojoInstance.derived
  implicit val modelDecoder: PojoInstance[Decoder, CatNameTest3] = PojoInstance.derived
}

object CatNameTest3TestCase {

  import CirceGeneric2._

  val cat1: CatNameTest3 = CatNameTest3(
    id3 = 1257,
    str3 = Option("cat-b"),
    uClass3 = Option(3256),
    name113 = "HardCoreTest0032",
    friends = List.empty
  )

  val modelInstance: CatNameTest3 = CatNameTest3(
    id3 = 8594,
    str3 = Option("aaTest3"),
    uClass3 = Option.empty,
    name113 = "xxiwerwjkl",
    friends = List(cat1)
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[CatNameTest3]))
  }

}
