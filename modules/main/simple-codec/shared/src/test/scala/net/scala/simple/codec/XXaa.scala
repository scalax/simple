package net.scalax.simple
package nat

import core._
import net.scalax.simple.nat.injection.ModelLength

object xxbb {

  class XXBB[F[_]] {
    case class Model(name: F[Int], str: F[Option[String]], uClass: F[Class[_]], name11: F[String])
  }

  type UModel[T[_]] = XXBB[T]#Model

  type AnyF[_] = Any
  type Id[T]   = T

  val anyXXBB: XXBB[AnyF] = new XXBB

  def main(arr: Array[String]): Unit = {
    val filler: Filler[UModel]              = Filler.from(Filler.fill[anyXXBB.Model])
    val noneFiller: NoneModelFiller[UModel] = NoneModelFiller.fill(filler)
    val length: ModelLength.Length[UModel]  = ModelLength.size(noneFiller)
    val value: XXBB[Id]#Model               = filler.input[Id](List(2, Option("nnuu"), classOf[String], "sdfjowiejrowehreiowjhrtf"))
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
