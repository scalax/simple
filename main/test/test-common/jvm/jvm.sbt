scalaVersion := scalaV.v213
name         := "simple-test-common"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.`zio2`.value
