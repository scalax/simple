import sbt._
import sbt.Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {
  object versions {
    val zioLogging            = "0.5.9"
    val slef4j                = "1.7.36"
    val commonsIO             = "1.3.2"
    val kindProjector         = "0.13.2"
    val scalaCollectionCompat = "2.8.1"
    val ceTestSpecs2          = "1.4.0"
    val ceTestSpecs211        = "1.4.0"
    val zio                   = "2.0.2"
  }

  val commonsIO             = libraryDependencies += "org.apache.commons"       % "commons-io"              % versions.commonsIO
  val scalaCollectionCompat = libraryDependencies += "org.scala-lang.modules" %%% "scala-collection-compat" % versions.scalaCollectionCompat

  val kindProjector = libraryDependencies ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, _)) => Seq(compilerPlugin("org.typelevel" % "kind-projector" % versions.kindProjector cross CrossVersion.full))
      case _            => Seq.empty
    }
  }

  val zio = libraryDependencies += "dev.zio" %%% "zio" % versions.zio

}
