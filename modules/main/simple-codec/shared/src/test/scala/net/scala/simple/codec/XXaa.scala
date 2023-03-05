package net.scalax.simple
package codec

object xxbb {

  case class Model[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Class[_]], name11: F[String])

  type UModel[T[_]] = Model[T]

  type AnyF[_] = Any
  type Id[T]   = T

  def main(arr: Array[String]): Unit = {
    implicit val filler: Filler[UModel]              = Filler.from
    implicit val noneFiller: NoneModelFiller[UModel] = NoneModelFiller.fill
    implicit val length: ModelLength[UModel]         = ModelLength.fill
    val value: UModel[Id] = filler.input[Id](List(2, Option("nnuu"), classOf[String], "sdfjowiejrowehreiowjhrtf"))
    // val aa: LabelledNames[UModel]           = LabelledNames.init[UModel](impl.LabelledNamesImpl.get)
    println(length.length)
    println(length.length)
    println(length.length)
    println(length.length)
    println(length.length)
    println(value)
    println(value)
    println(value)
    println(value)
  }

}
