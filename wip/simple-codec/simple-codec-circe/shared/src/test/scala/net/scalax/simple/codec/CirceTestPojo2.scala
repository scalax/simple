package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, ModelLinkPojo, PojoInstance}

trait CusType
case class CatNameTest6(id3: Int, str3: Option[String], uClass3: Option[CusType], name113: String, friends: List[CusType])

object CatNameTest6 {

  import CirceGen.Pojo._

  val compileCtx = TypeClassOptCtx[Encoder]

  implicit val modelLinkPojo: ModelLinkPojo[CatNameTest6] = ModelLinkPojo.derived

  implicit def encoderInstance: PojoInstance[compileCtx.EncoderGetter, CatNameTest6] =
    FillIdentity.Pojo[compileCtx.EncoderGetter, CatNameTest6].derived

  def typeClassOpt: compileCtx.TypeClassOpt[CatNameTest6] = compileCtx.TypeClassOpt.Pojo[CatNameTest6].derived

  // implicit def codec1: Codec[CatNameTest6] = ???

}

object CatNameTes6EncoderInstance {

  final def main(args: Array[String]): Unit = {
    println(CatNameTest6.typeClassOpt)
    println(CatNameTest6.typeClassOpt.info.succeed)
    println(CatNameTest6.typeClassOpt.info.failed)
  }

}
