package net.scalax.simple
package codec

object xxbb {

  case class Model[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Class[_]], name11: F[String])

  type UModel[T[_]] = Model[T]

  def main(arr: Array[String]): Unit = {
    implicit val setter: Setter[UModel]              = Setter.from
    implicit val noneFiller: NoneModelFiller[UModel] = NoneModelFiller.fill
    implicit val length: ModelLength[UModel]         = ModelLength.fill
    val value: ContextO[UModel]#IdF = setter.input[ContextI#IdF](List(2, Option("nnuu"), classOf[String], "sdfjowiejrowehreiowjhrtf"))
    implicit val namesImplicit: LabelledNames[UModel] = LabelledNames.fill
    implicit val namedModel: LabelledInstance[UModel] = LabelledInstance.fill
    println(length.length)
    println(length.length)
    println(namesImplicit.names)
    println(namesImplicit.names)
    println(namedModel.model)
    println(namedModel.model.name: String)
    println(namedModel.model.uClass: String)
    println(namedModel.model.str: String)
    println(namedModel.model.name11: String)
    println(value)
    println(value)
    println(value)
    println(value)
  }

}
