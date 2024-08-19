package net.scalax.simple.adt.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object ScalaInnerCodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)
    val writePath        = rootPath.resolve(Paths.get("net", "scalax", "simple", "adt", "impl"))
    Files.createDirectories(writePath)

    locally(().match
      case _ =>
        val filePath = writePath.resolve("ABC.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = "package net.scalax.simple.nat.not_used"
            writer.println(linerContent)
        )
    )

    locally {
      val filePath = writePath.resolve("ProductTypeCodegen.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.ProductTypeCodegen(22).text
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("ProductTypeAppender.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.text.ProductTypeAppenderCodegen(22).text
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("ProductTypeAppenderGen.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.text.ProductTypeAppenderImplCodegen(22).text
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("Folder22TypeParam.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.FunctionTypeCodegen(22).text
        writer.println(linerContent)
      }
    }

    locally {
      val filePath = writePath.resolve("ProductType22Support.scala")
      Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name())) { writer =>
        val linerContent: String = net.scalax.simple.adt.codegen.text.TranAbsCodegen(22).text
        writer.println(linerContent)
      }
    }

  end main

end ScalaInnerCodegenExec
