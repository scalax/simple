import sbt._
import sbt.Keys._

object Dependencies {
  object versions {
    val zioLogging    = "0.5.9"
    val slef4j        = "1.7.36"
    val commonsIO     = "1.3.2"
    val kindProjector = "0.13.2"
  }

  val commonsIO     = "org.apache.commons" % "commons-io"     % versions.commonsIO
  val kindProjector = "org.typelevel"      % "kind-projector" % versions.kindProjector cross CrossVersion.full

}
