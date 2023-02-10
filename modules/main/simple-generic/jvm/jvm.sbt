scalaVersion := scalaV.v213
name         := "simple-generic"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= cats.value
libraryDependencies ++= libScalax.circe.value

enableZIOTest := true
