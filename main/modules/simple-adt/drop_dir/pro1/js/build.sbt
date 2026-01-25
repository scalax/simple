scalaVersion := scalaV.v213
name         := "simple-adt"

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.`simple-adt-bridge-support`.value
libraryDependencies ++= libScalax.circe.value.map(_ % Test)
libraryDependencies ++= libScalax.`zio2`.value.map(_ % Test)

enableZIOTest := true

useKindProjector
