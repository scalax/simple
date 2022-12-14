scalaVersion := scalaV.v213
name         := "simple-wire-web-app"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= http4s.value
libraryDependencies ++= `cats-effect`.value
libraryDependencies ++= cats.value
libraryDependencies ++= doobie.value
libraryDependencies ++= h2.value
libraryDependencies ++= macwire.value
