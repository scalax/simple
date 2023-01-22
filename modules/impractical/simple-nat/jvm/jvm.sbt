scalaVersion := scalaV.v213
name         := "simple-counter"

enableZIOTest := true

run / fork := true
javaOptions += "-Xss600k"
