package net.scalax.simple.nat.adt.codegen

import java.nio.file.Paths

object CommonScalaCodegenExec {

  def main(arr: Array[String]): Unit = {
    val List(rootString) = arr.to(List)
    Paths.get(rootString)
  }

}
