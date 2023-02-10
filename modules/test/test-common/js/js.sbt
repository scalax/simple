scalaVersion := scalaV.v213

crossScalaVersions        := Seq(scalaV.v211, scalaV.v212, scalaV.v213, scalaV.v3)
Test / crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)
