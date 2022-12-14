scalaVersion := scalaV.v3
name         := "simple-injection"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= http4s.value
libraryDependencies ++= `cats-effect`.value
libraryDependencies ++= cats.value

enableZIOTest := true
