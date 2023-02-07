scalaVersion := scalaV.v213
name         := "simple-adt-core"

libraryDependencies ++= `kind-projector`.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.circe.value.map(_ % Test)

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
