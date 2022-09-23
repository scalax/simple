import sbt._
import sbt.Keys._
import org.scalafmt.sbt.ScalafmtPlugin.autoImport.{scalafmtOnCompile, scalafmtSbt}

object Settings {

  object scalaV {
    val v211    = "2.11.12"
    val v212    = "2.12.15"
    val v213    = "2.13.8"
    val v3      = "3.2.0"
    val collect = Seq(v211, v212, v213, v3)
  }

  private def scalacOptionsVersion(scalaVersion: String): Seq[String] = {
    val common = Seq(
      "-feature",
      "-deprecation",
      "-encoding",
      "UTF-8"
    )
    val compat = CrossVersion.partialVersion(scalaVersion) match {
      case Some((2, scalaMajor)) => Seq("-Ywarn-dead-code")
      case Some((3, scalaMajor)) => Seq("-Ykind-projector")
      case _                     => Seq.empty
    }
    common ++ compat
  }

  private def genDirectory(sourceFile: File, c: String, parVersion: String): Seq[File] = {
    val common = sourceFile / c / "scala"
    val compat = CrossVersion.partialVersion(parVersion) match {
      case Some((2, 11)) =>
        Seq(sourceFile / c / "scala-2", sourceFile / c / "scala-2.11", sourceFile / c / "scala-2.11-2.12")
      case Some((2, 12)) =>
        Seq(
          sourceFile / c / "scala-2",
          sourceFile / c / "scala-2.11-2.12",
          sourceFile / c / "scala-2.12",
          sourceFile / c / "scala-2.12-2.13"
        )
      case Some((2, 13)) =>
        Seq(sourceFile / c / "scala-2", sourceFile / c / "scala-2.12-2.13", sourceFile / c / "scala-2.13")
      case Some((2, _)) => Seq(sourceFile / c / "scala-2")
      case Some((3, _)) => Seq(sourceFile / c / "scala-3")
      case _            => Seq.empty
    }
    common +: compat
  }

  object org {
    val s1 = version              := "0.1.0"
    val s2 = organization         := "net.scalax"
    val s3 = organizationName     := "Scala Workers"
    val s4 = organizationHomepage := Some(url("https://github.com/scala-workers"))

    val collect = Seq(s1, s2, s3, s4)
  }

  object all {
    def deptsAdd(need: Boolean) = if (need) Seq(compilerPlugin(Dependencies.kindProjector)) else Seq.empty
    val kindProjector = libraryDependencies ++= {
      val v = for ((i, _) <- CrossVersion.partialVersion(scalaVersion.value)) yield i == 2
      deptsAdd(v.getOrElse(false))
    }

    val scalafmtSetting    = scalafmtOnCompile  := true
    val scalafmtSbtSetting = Compile / compile  := ((Compile / compile) dependsOn (Compile / scalafmtSbt)).value
    val scalaOptions       = scalacOptions ++= scalacOptionsVersion(scalaVersion.value)
    val crossV             = crossScalaVersions := scalaV.collect
    val compileFolder = Compile / unmanagedSourceDirectories ++= {
      val addToMain    = genDirectory(sourceDirectory.value, "main", scalaVersion.value)
      val addToCodeGen = genDirectory(sourceDirectory.value, "codegen", scalaVersion.value)
      addToMain ++: addToCodeGen
    }
    val testFolder = Test / unmanagedSourceDirectories ++= genDirectory(sourceDirectory.value, "test", scalaVersion.value)
    val collect    = Seq(scalafmtSetting, scalafmtSbtSetting, scalaOptions, crossV, compileFolder, testFolder, kindProjector)
  }

  object common {
    val scalaVersionSetting = scalaVersion := scalaV.v213
    val collect             = scalaVersionSetting ++: org.collect ++: all.collect
  }

  object scala3 {
    val scalaVersionSetting = scalaVersion := scalaV.v3
    val collect             = scalaVersionSetting ++: org.collect ++: all.collect
  }

}
