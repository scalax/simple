package net.scalax.simple.codec.codegen

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.Using

object ScalaAllCodegenExec:

  def main(arr: Array[String]): Unit =

    val List(rootString) = arr.to(List)
    val rootPath         = Paths.get(rootString)

    val writePath1 = rootPath.resolve(Paths.get("scala", "net", "scalax", "simple", "codec"))
    val writePath2 = writePath1.resolve("impl")
    Files.createDirectories(writePath1)
    Files.createDirectories(writePath2)

    val scala2Rooot1 = rootPath.resolve(Paths.get("scala-2", "net", "scalax", "simple", "codec"))
    val scala2Rooot2 = scala2Rooot1.resolve("impl")
    Files.createDirectories(scala2Rooot1)
    Files.createDirectories(scala2Rooot2)

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = writePath2.resolve("FunctionNGeneric.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = net.scalax.simple.nat.codec.codegen.txt.FunctionNGeneric().body
            writer.println(linerContent)
        )
    )*/

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = writePath1.resolve("FunctionNApply.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = net.scalax.simple.nat.codec.codegen.txt.FunctionNFunc().body
            writer.println(linerContent)
        )
    )*/

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = writePath1.resolve("Function50Generic.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = net.scalax.simple.nat.codec.codegen.txt.Function50Generic().body
            writer.println(linerContent)
        )
    )*/

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = writePath1.resolve("MNFunc.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = net.scalax.simple.nat.codec.codegen.txt.MNFunc().body
            writer.println(linerContent)
        )
    )*/

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = writePath1.resolve("MNFuncGeneric.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = net.scalax.simple.nat.codec.codegen.txt.MNFuncGeneric().body
            writer.println(linerContent)
        )
    )

    locally(EmptyTuple.match
      case _ =>
        val filePath = writePath1.resolve("MMFunctionInput.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent = net.scalax.simple.nat.codec.codegen.txt.MMFunctionInput().body
            writer.println(linerContent)
        )
    )*/

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = scala2Rooot2.resolve("Method22FromProjection.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent: String = text.PreCodegen.text1
            writer.println(linerContent)
        )
    )*/

    /*locally(EmptyTuple.match
      case _ =>
        val filePath = scala2Rooot2.resolve("Methond50Compat11.scala")
        Using.resource(new PrintWriter(filePath.toFile, StandardCharsets.UTF_8.name()))(_.match
          case writer =>
            val linerContent: String = net.scalax.simple.adt.codegen_text1.Codegen50Text2.render
            writer.println(linerContent)
        )
    )*/

  end main

end ScalaAllCodegenExec
