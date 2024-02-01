package net.scalax.simple.codec.codegen
package text

import org.apache.commons.io.FileUtils

import java.nio.file.Paths

object PreCodegen:

  def text1: String =
    s"""
       package net.scalax.simple.codec

       import decode.projection._
       ${(for (i <- 1 to 22) yield {

        s"""trait Monad${i}TypeLevel[M1[${(for (_ <- 1 to i) yield '_').mkString(','.toString)}]] {

         def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

         // def zip[@for(i1 <- 1 to i) { IA@{i1} , } @for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}](m1: M1[@for(i1 <- 1 to i - 1) { IA@{i1} , } IA@{i}], m2: M1[@for(i1 <- 1 to i - 1) { IB@{i1} , } IB@{i}]): M1[@for(i1 <- 1 to i - 1) { (IA@{i1}, IB@{i1}) , } (IA@{i}, IB@{i})]
}
"""
      }).mkString}
       """

end PreCodegen
