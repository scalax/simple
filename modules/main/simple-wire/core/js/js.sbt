scalaVersion := scalaV.v3
name         := "simple-wire"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= cats.value

enableZIOTest := true
