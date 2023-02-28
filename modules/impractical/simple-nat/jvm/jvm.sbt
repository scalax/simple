scalaVersion := scalaV.v213
name         := "simple-counter"

enableZIOTest := true

run / fork := true
javaOptions += "-Xss800k"

crossScalaVersions := Seq(scalaV.v211, scalaV.v212, scalaV.v213, scalaV.v3)
