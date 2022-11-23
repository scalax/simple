package net.scalax.simple.nat.adt.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

import language.experimental.fewerBraces

object Scala3CodegenExec:

  def main(arr: Array[String]): Unit =
    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePath        = rootPath.resolve(Paths.get("net", "scalax", "simple", "nat", "adt", "impl"))
    Files.createDirectories(writePath)

    locally {
      val filePath = writePath.resolve("TypeAdtAlias.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8)) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.TypeAdtAliasScala3().body
        writer.println(linerContent)
      }
    }

  end main

end Scala3CodegenExec
