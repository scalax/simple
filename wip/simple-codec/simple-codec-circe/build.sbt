scalaVersion := scalaV.v213
name         := "simple-codec-circe"

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`circe`.value

run / fork := true

scalafmtOnCompile := true
