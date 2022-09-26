import ProjectKeys.{crossDepts, filesToCross}
import sbt._
import sbt.Keys._
import org.scalafmt.sbt.ScalafmtPlugin.autoImport.{scalafmtOnCompile, scalafmtSbt}
import sbtcrossproject.CrossProject

object Settings {

  private val depts = Dependencies

  object scalaV {
    val v211    = "2.11.12"
    val v212    = "2.12.15"
    val v213    = "2.13.8"
    val v3      = "3.2.0"
    val v3RC    = "3.2.2-RC1-bin-20220920-b1b1dfd-NIGHTLY"
    val collect = Seq(v211, v212, v213, v3)
  }

  private def scalacOptionsVersion(scalaVersion: String): Seq[String] = {
    val common = Seq("-feature", "-deprecation", "-encoding", "UTF-8")
    val compat = CrossVersion.partialVersion(scalaVersion) match {
      case Some((2, scalaMajor)) => Seq("-Ywarn-dead-code")
      case Some((3, scalaMajor)) => Seq("-Ykind-projector")
      case _                     => Seq.empty
    }
    common ++ compat
  }

  private def genDirectory(sourceFile: File, parVersion: String, exists: Seq[File]): Seq[File] = {
    val fileList = CrossVersion.partialVersion(parVersion) match {
      case Some((2, 11)) =>
        Seq(sourceFile / "scala-2", sourceFile / "scala-2.11", sourceFile / "scala-2.11-2.12")
      case Some((2, 12)) =>
        Seq(
          sourceFile / "scala-2",
          sourceFile / "scala-2.11-2.12",
          sourceFile / "scala-2.12",
          sourceFile / "scala-2.12-2.13"
        )
      case Some((2, 13)) =>
        Seq(sourceFile / "scala-2", sourceFile / "scala-2.12-2.13", sourceFile / "scala-2.13")
      case Some((2, _)) => Seq(sourceFile / "scala-2")
      case Some((3, _)) => Seq(sourceFile / "scala-3")
      case _            => Seq.empty
    }
    val existsPaths = exists.map(_.getCanonicalPath)
    fileList.filterNot(s => existsPaths.exists(t => t == s.getCanonicalPath))
  }

  object org {
    val s1 = version              := "0.1.0"
    val s2 = organization         := "net.scalax"
    val s3 = organizationName     := "Scala Workers"
    val s4 = organizationHomepage := Some(url("https://github.com/scala-workers"))

    val collect = Seq(s1, s2, s3, s4)
  }

  object all {
    val filesToCrossSetting = Seq(
      filesToCross := Seq.empty,
      filesToCross += baseDirectory.value / "src" / "codegen",
      Compile / filesToCross += baseDirectory.value / "src" / "main",
      Test / filesToCross += baseDirectory.value / "src" / "test"
    )

    val crossSetting = crossDepts:=Seq.empty

    val scalafmtSetting    = scalafmtOnCompile  := true
    val scalafmtSbtSetting = Compile / compile  := ((Compile / compile) dependsOn (Compile / scalafmtSbt)).value
    val scalaOptions       = scalacOptions ++= scalacOptionsVersion(scalaVersion.value)
    val crossV             = crossScalaVersions := scalaV.collect
    val compileFolder =
      (Compile / unmanagedSourceDirectories) ++= (Compile / filesToCross).value
        .flatMap(genDirectory(_, scalaVersion.value, (Compile / unmanagedSourceDirectories).value))
    val testFolder = Test / unmanagedSourceDirectories ++= (Test / filesToCross).value
      .flatMap(genDirectory(_, scalaVersion.value, (Test / unmanagedSourceDirectories).value))
    val collect =
      Seq(
        scalafmtSetting,
        scalafmtSbtSetting,
        scalaOptions,
        crossV,
        compileFolder,
        testFolder,
        depts.kindProjector,
        crossSetting
      ) ++: filesToCrossSetting
  }

  object common {
    val scalaVersionSetting = scalaVersion := scalaV.v213
    val collect             = scalaVersionSetting +: org.collect ++: all.collect
  }

  object scala3 {
    val scalaVersionSetting = scalaVersion := scalaV.v3
    val collect             = scalaVersionSetting +: org.collect ++: all.collect
  }

  object scala3RC {
    val scalaVersionSetting = scalaVersion := scalaV.v3RC
    val crossAdd            = crossScalaVersions += scalaV.v3RC
    val collect             = scalaVersionSetting +: crossAdd +: org.collect ++: all.collect
  }

  def addFilesToCross(p: Project) =
    Seq(
      (p / filesToCross) ++= Seq((p / baseDirectory).value / ".." / "shared" / "src" / "codegen"),
      (p / Compile / filesToCross) ++= Seq((p / baseDirectory).value / ".." / "shared" / "src" / "main"),
      (p / Test / filesToCross) ++= Seq((p / baseDirectory).value / ".." / "shared" / "src" / "test")
    )

}
