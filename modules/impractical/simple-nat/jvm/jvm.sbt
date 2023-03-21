scalaVersion := scalaV.v213
name         := "simple-nat"

enableZIOTest := true

run / fork := true
run / javaOptions += "-Xss15M"

crossScalaVersions := Seq(scalaV.v211, scalaV.v212, scalaV.v213, scalaV.v3)
