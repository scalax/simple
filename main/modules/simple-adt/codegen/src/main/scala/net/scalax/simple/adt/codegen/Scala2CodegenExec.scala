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

    /*locally(().match
      case _ =>
        val filePath = writePath.resolve("ADTPassedFunction.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent: String = ADTPassedFunctionCodegen.text4
            writer.println(linerContent)
        )
    )

    locally {
      val filePath = writePath.resolve("TypeAdtRuntimeApply.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = CodePre2(isScala3 = false).text
        writer.println(linerContent)
      }
    }*/

  end main

end Scala2CodegenExec
