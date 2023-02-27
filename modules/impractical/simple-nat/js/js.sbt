scalaVersion := scalaV.v213
name         := "simple-counter"

enableZIOTest := true

crossSbtVersions := Seq(scalaV.v211, scalaV.v212, scalaV.v213, scalaV.v3)
