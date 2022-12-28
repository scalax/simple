package net.scalax.simple.adt.codegen

import java.nio.file.Paths

object CommonScalaCodegenExec:

  def main(arr: Array[String]): Unit =
    val List(rootString) = arr.to(List)
    Paths.get(rootString)
  end main

end CommonScalaCodegenExec
