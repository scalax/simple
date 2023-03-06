scalaVersion := scalaV.v213
name         := "simple-codec"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

Test / scalaJSUseMainModuleInitializer := true
Test / scalaJSUseTestModuleInitializer := false
