package net.scalax.simple.adt.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object ScalaOuterCodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePathScala2  = rootPath.resolve(Paths.get("scala-2", "net", "scalax", "simple", "adt", "impl"))
    Files.createDirectories(writePathScala2)

    locally {
      val filePath = writePathScala2.resolve("ProductType22Support.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.text.TranCodegen(22).text
        writer.println(linerContent)
      }
    }

  end main

end ScalaOuterCodegenExec
