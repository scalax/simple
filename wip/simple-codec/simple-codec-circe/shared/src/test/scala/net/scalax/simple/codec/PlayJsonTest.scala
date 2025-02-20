package net.scalax.simple.codec

import play.api.libs.json._
import net.scalax.simple.codec.to_list_generic.{ModelLinkPojo, PojoInstance}

case class CatNameTest5(id5: Int, str5: Option[String], uClass5: Option[Long], name115: String, namexu5: String)

object CatNameTest5 {
  implicit val deco2_1: ModelLinkPojo[CatNameTest5] = ModelLinkPojo.derived

  implicit val modelWrites: PojoInstance[Writes, CatNameTest5] = PojoInstance.derived
}

object PlayJsonTest {

  import PlayJsonGeneric._

  val modelInstance: CatNameTest5 = CatNameTest5(
    id5 = 8594,
    str5 = Option("aaTest3"),
    uClass5 = Option.empty,
    name115 = "xxiwerwjkl",
    namexu5 = "jerokwjoe收代理Test3"
  )

  final def main(args: Array[String]): Unit = {
    println(Json.toJson(modelInstance))
  }

}
