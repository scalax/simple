scalaVersion := scalaV.v213
name         := "simple-adt-core"

libraryDependencies ++= `kind-projector`.value
libraryDependencies += `scala-collection-compat`.value

enableZIOTest := true
