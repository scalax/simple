scalaVersion := scalaV.v213
name         := "simple-codec"

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`cats-effect`.value
libraryDependencies ++= libScalax.`distage`.value
libraryDependencies ++= libScalax.`circe`.value


Test / scalaJSUseMainModuleInitializer := true
Test / scalaJSUseTestModuleInitializer := false
