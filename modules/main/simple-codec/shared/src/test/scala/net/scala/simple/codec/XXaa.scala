package net.scalax.simple
package codec

import shapeless.LabelledGeneric

object xxbb {

  case class Model[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Class[_]], name11: F[String])

  case class BB(xx: Int, werwe: Int)

  type UModel[T[_]] = Model[T]

  type AnyF[_] = Any
  type Id[T]   = T

  def main(arr: Array[String]): Unit = {
    val filler: Filler[UModel]              = Filler.from[UModel]
    val noneFiller: NoneModelFiller[UModel] = NoneModelFiller.fill(filler)
    val length: ModelLength[UModel]         = ModelLength.size(noneFiller)
    val value: UModel[Id]                   = filler.input[Id](List(2, Option("nnuu"), classOf[String], "sdfjowiejrowehreiowjhrtf"))
    // val aa: LabelledNames[UModel]           = LabelledNames.init[UModel](impl.LabelledNamesImpl.get)
    val xx = LabelledGeneric[BB]
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
