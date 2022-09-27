package net.scalax.simple.nat.adt.codegen

import org.apache.commons.io.FileUtils

import java.nio.file.Paths

object PreCodegen:

  def main(arr: Array[String]): Unit =
    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    FileUtils.deleteDirectory(rootPath.toFile)
  end main

end PreCodegen
