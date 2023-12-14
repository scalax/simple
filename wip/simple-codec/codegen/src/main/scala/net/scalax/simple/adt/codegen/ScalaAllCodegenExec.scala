package net.scalax.simple.codec.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object ScalaAllCodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePath1       = rootPath.resolve(Paths.get("net", "scalax", "simple", "codec"))
    val writePath2       = writePath1.resolve("impl")
    Files.createDirectories(writePath1)
    Files.createDirectories(writePath2)

    locally {
      val filePath = writePath2.resolve("FunctionNGeneric.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.codec.codegen.txt.FunctionNGeneric().body
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath1.resolve("FunctionNApply.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.codec.codegen.txt.FunctionNFunc().body
        writer.println(linerContent)
      }
    }

  end main

end ScalaAllCodegenExec
