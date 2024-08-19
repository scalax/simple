package net.scalax.simple.adt.codegen

import org.apache.commons.io.FileUtils

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object ScalaOuterCodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePathScala2  = rootPath.resolve(Paths.get("scala-2", "net", "scalax", "simple", "adt", "impl"))
    val writePathScala3  = rootPath.resolve(Paths.get("scala-3", "net", "scalax", "simple", "adt", "impl"))
    FileUtils.deleteDirectory(writePathScala2.toFile)
    FileUtils.deleteDirectory(writePathScala3.toFile)
    Files.createDirectories(writePathScala2)
    Files.createDirectories(writePathScala3)

    locally {
      val filePath = writePathScala2.resolve("ProductType22Support.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.text.TranCodegen(22).text
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePathScala3.resolve("ProductType22Support.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.text.TranS3Codegen(22).text
        writer.println(linerContent)
      }
    }

  end main

end ScalaOuterCodegenExec
