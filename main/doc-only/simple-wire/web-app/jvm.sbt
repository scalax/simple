scalaVersion := scalaV.v213
name         := "simple-wire-web-app"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.`http4s-Release`.value
libraryDependencies ++= libScalax.`http4s-Release-ember-server`.value
libraryDependencies ++= libScalax.`http4s-twirl`.value
libraryDependencies ++= libScalax.`cats-effect`.value
libraryDependencies ++= libScalax.`cats`.value
libraryDependencies ++= libScalax.`doobie`.value
libraryDependencies ++= libScalax.`doobie-h2`.value
libraryDependencies ++= libScalax.`h2`.value
libraryDependencies ++= libScalax.`zio-config`.value
libraryDependencies ++= libScalax.`scalatest`.value
libraryDependencies ++= libScalax.`macwire`.value
