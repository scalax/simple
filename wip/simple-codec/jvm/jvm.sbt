scalaVersion := scalaV.v213
name         := "simple-codec"

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v211, scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`doobie`.value
libraryDependencies ++= libScalax.`cats-effect`.value
libraryDependencies ++= libScalax.`fs2`.value
libraryDependencies ++= libScalax.`circe`.value
libraryDependencies ++= libScalax.`slick`.value

libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, _)) => List(("net.scalax" %% "slickless" % "0.3.7-M6"))
    case _            => List.empty
  }
}
