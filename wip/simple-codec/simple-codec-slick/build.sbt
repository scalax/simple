scalaVersion := scalaV.v213
name         := "simple-codec-slick"

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`slick`.value

libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, _)) => List(("net.scalax" %% "slickless" % "0.3.7-M7"))
    case _            => List.empty
  }
}

run / fork := true

scalafmtOnCompile := true
