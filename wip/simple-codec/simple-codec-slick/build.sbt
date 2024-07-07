scalaVersion := scalaV.v213
name         := "simple-codec-slick"

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`slick`.value
libraryDependencies ++= libScalax.`slickless`.value

run / fork := true

scalafmtOnCompile := true
