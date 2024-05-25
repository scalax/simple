package net.scalax.simple.adt.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object ScalaAllCodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePath        = rootPath.resolve(Paths.get("net", "scalax", "simple", "adt", "impl"))
    Files.createDirectories(writePath)

    locally {
      val filePath = writePath.resolve("TypeAdtAlias.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.TypeAdtAlias().body
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("TypeAdtAliasModelUnapply.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.TypaAdtAliasModelUnapplyScalaAll().body
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("TypeAdtAliasModel.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent = net.scalax.simple.nat.adt.codegen.txt.TypeAdtAliasModel().body
        writer.println(linerContent)
      }
    }

  end main

end ScalaAllCodegenExec
