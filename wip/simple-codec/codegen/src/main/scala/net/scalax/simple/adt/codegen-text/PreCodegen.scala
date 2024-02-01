package net.scalax.simple.codec.codegen
package text

import org.apache.commons.io.FileUtils

import java.nio.file.Paths

object PreCodegen:

  def repeat(times: Int)(text: Int => String): List[String] = {
    val listString = for (i <- 1 to times) yield text(i)
    listString.to(List)
  }
  val dot1: String = ','.toString

  def text1: String =
    s"""
       package net.scalax.simple.codec

       import decode.projection._
       ${(for (i <- 1 to 22) yield {

        s"""trait Monad${i}TypeLevel[M1[${repeat(i)(_ => '_'.toString).mkString(dot1)}]] {

        def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

        def zip[
          ${repeat(i)(i => "IA" + i).mkString(dot1) +
            ',' +
            repeat(i)(i => "IB" + i).mkString(dot1)}](
          m1: M1[${repeat(i)(i => "IA" + i).mkString(dot1)}],
          m2: M1[${repeat(i)(i => "IB" + i).mkString(dot1)}]
        ): M1[${repeat(i)(i => s"(IA$i, IB$i)").mkString(dot1)}]

      }
    """
      }).mkString}
       """

end PreCodegen
