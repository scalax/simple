scalaVersion := scalaV.v213
name         := "simple-adt-support"

libraryDependencies ++= libScalax.`kind-projector`.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`shapeless`.value

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
