import sbt._
import sbt.Keys._

import java.io.PrintWriter
import java.nio.file.Files
import scala.util.Using

object CodegenPlugin extends AutoPlugin {
  object autoImport {
    val codegenImpl     = inputKey[Unit]("Execute codegen action")
    val preCodegenImpl  = inputKey[Unit]("Execute prepare codegen action")
    val rootCodegenPath = settingKey[File]("Codegen root path")
  }
}

object CopyFilePlugin extends AutoPlugin {

  trait WithFile {
    self =>

    protected def baseFile: File

    protected def extraFiles: Seq[File]

    def instance: Unit = instance(baseFile)

    def instance(f1: File, f: File*): File = instance(f1 +: f)

    def instance(f: Seq[File]): File = {
      val arrs = extraFiles.map(t => Files.readAllBytes(t.toPath))
      for (extFile <- f) {
        val copyFile = extFile / "copyBuild.sbt"
        Files.deleteIfExists(copyFile.toPath)
        Using.resource(new java.io.FileOutputStream(copyFile)) { p =>
          Using.resource(new PrintWriter(p)) { u =>
            for (eachArr <- arrs) {
              p.write(eachArr)
              p.flush()
              u.println()
              u.flush()
            }
          }
        }
      }
      baseFile
    }

    def instance(f1: File => File, f: (File => File)*): File = instance((f1 +: f).map(t => t(self.baseFile)))

    def withBuildFile(f: Seq[File]): WithFile = new WithFile {
      override def baseFile: File        = self.baseFile
      override def extraFiles: Seq[File] = f ++: self.extraFiles
    }

    def withBuildFile(f1: File, f: File*): WithFile = withBuildFile(f1 +: f)

    def withBuildFile(f1: File => File, f: (File => File)*): WithFile = withBuildFile((f1 +: f).map(t => t(self.baseFile)))
  }

  object WithFile {
    def apply(f: File): WithFile = new WithFile {
      override def baseFile: File        = f
      override def extraFiles: Seq[File] = Seq.empty
    }
  }

  object autoImport {
    val toJsRoot: File => File  = f => f / "js"
    val toJVMRoot: File => File = f => f / "jvm"

    val `root-path`    = file(".").getAbsoluteFile
    val `scripts-root` = `root-path` / "scripts"
    val globalScripts  = Seq(`scripts-root` / "all-depts.sbt.script", `scripts-root` / "settings-global.sbt.script")

    val scalaJsCommonScripts = Seq(`scripts-root` / "scalajs-common.sbt.script")
    val scalaJsJvmScripts    = scalaJsCommonScripts
    val scalaJsJsScripts     = Seq(`scripts-root` / "scalajs-js.sbt.script") ++: scalaJsCommonScripts

    implicit class fileExt(val file: File) extends AnyVal {
      def withBuildFile(f: Seq[File]): WithFile                         = WithFile(file).withBuildFile(f)
      def withBuildFile(f1: File, f: File*): WithFile                   = WithFile(file).withBuildFile(f1, f: _*)
      def withBuildFile(f1: File => File, f: (File => File)*): WithFile = WithFile(file).withBuildFile(f1, f: _*)
    }
  }

}
