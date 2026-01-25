package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{
  FillIdentity,
  Fold1FGenerc,
  ModelLink,
  ModelLinkPojo,
  PojoInstance,
  ToListByTheSameTypeGeneric
}

case class CatNameTest3(id3: Int, str3: Option[String], uClass3: Option[Long], name113: String, friends: List[CatNameTest3])

object CatNameTest3 {

  val longOptEncoder: Encoder[Option[Long]] = Encoder[Option[String]].contramap((opt: Option[Long]) => for (u <- opt) yield u.toString)

  implicit val modelLinkPojo: ModelLinkPojo[CatNameTest3] = ModelLinkPojo.derived

  implicit val jsonLabelled: SimpleJsonCodecLabelledPojo[CatNameTest3] =
    SimpleJsonCodecLabelledPojo.derived[CatNameTest3].codec.update(_.copy(_.id3)("miaomiao id"))

  import CirceGen.Pojo._
  implicit def modelEncoder: FillIdentity.Pojo[Encoder, CatNameTest3] =
    FillIdentity.Pojo[Encoder, CatNameTest3].derived.copy(_.uClass3)(longOptEncoder)
  implicit def modelDecoder: FillIdentity.Pojo[Decoder, CatNameTest3] = FillIdentity.Pojo[Decoder, CatNameTest3].derived

}

object CatNameTest3TestCase {

  import CirceGen.Pojo._

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

  def getNames(model: PojoInstance[({ type M1[_] = String })#M1, CatNameTest3]): List[String] = {
    val ge = ToListByTheSameTypeGeneric[({ type U1[X[_]] = PojoInstance[X, CatNameTest3] })#U1].derived(
      Fold1FGenerc[({ type U1[X[_]] = PojoInstance[X, CatNameTest3] })#U1]
        .derived(implicitly[ModelLinkPojo[CatNameTest3]].basedInstalled.simpleProduct1)
    )

    ge.toListByTheSameType[String, List[String]](List.empty, (t1, t2) => t2 :: t1)(model)
  }

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).flatMap(_.as[CatNameTest3]))
    println("// ===")
    val labelled1 = implicitly[ModelLinkPojo[CatNameTest3]].labelled.modelLabelled
    val labelled2 = labelled1.copy(_.name113)("name224")
    println(getNames(labelled1))
    println(getNames(labelled2))
    println(labelled1(_.name113))
    println(labelled2(_.name113))
    println(labelled1(_.id3))
    println(labelled2(_.id3))
    println(labelled1(_.friends))
    println(labelled2(_.friends))
  }

}
