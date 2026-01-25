name := "simple-adt-implemention"

scalaVersion       := scalaV.v213
crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= libScalax.`kind-projector`.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`zio2`.value.map(_ % Test)

enableZIOTest := true
