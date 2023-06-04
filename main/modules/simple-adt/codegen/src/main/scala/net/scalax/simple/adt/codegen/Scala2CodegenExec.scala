package net.scalax.simple.adt.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object Scala2CodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePath        = rootPath.resolve(Paths.get("net", "scalax", "simple", "adt", "impl"))
    Files.createDirectories(writePath)

    locally {
      val filePath = writePath.resolve("FoldNatPositiveHelper.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.FoldNatPositive().body
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("InnerTypeAdtClass.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.InnerTypeAdtClassScala2().body
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("TypeAdtAliasModel.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.TypeAdtAliasScala2().body
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("TypeAdtRuntimeApply.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.TypeAdtRuntimeApplyScala2().body
        writer.println(linerContent)
      }
    }

  end main

end Scala2CodegenExec
