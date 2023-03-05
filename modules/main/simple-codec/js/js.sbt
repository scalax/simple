scalaVersion := scalaV.v213
name         := "simple-codec"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value

crossScalaVersions := Seq( scalaV.v212, scalaV.v213, scalaV.v3)