package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.CirceField
import net.scalax.simple.codec.to_list_generic.ModelLinkPojo

case class AnnTestCatName(
  id4: Int,
  str4: Option[String],
  @CirceField(name = "circeNamed1") uClass4: Option[Long],
  name114: String,
  namexu4: String
)

object AnnTestCatName {

  implicit def modelLink: ModelLinkPojo[AnnTestCatName]    = ModelLinkPojo.derived
  def annInstance: ForAnn.Pojo[AnnTestCatName, CirceField] = ForAnn.Pojo[AnnTestCatName, CirceField].derived

}

object AnnCirceTest1 {

  import CirceGen.Pojo._

  final def main(args: Array[String]): Unit = {
    println(AnnTestCatName.annInstance.annInstance(_.name114))
    println(AnnTestCatName.annInstance.annInstance(_.uClass4))
  }

}
