scalaVersion := scalaV.v213
name         := "simple-nat"

enableZIOTest := true

run / fork := true
// run / javaOptions += "-Xss5M"

crossScalaVersions := Seq(scalaV.v211, scalaV.v212, scalaV.v213, scalaV.v3)

val taskAA = inputKey[Unit]("bb")

taskAA := {
  (Compile / runMain).inputTaskValue.partialInput(" net.scalax.simple.nat.number12.RunMain1").evaluated
  (Compile / runMain).inputTaskValue.partialInput(" net.scalax.simple.nat.number12.RunMain2").evaluated
  (Compile / runMain).inputTaskValue.partialInput(" net.scalax.simple.nat.number12.RunMain3").evaluated
}

libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`simple-adt`.value
