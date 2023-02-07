scalaVersion := scalaV.v213
name         := "simple-adt-core"

libraryDependencies ++= `kind-projector`.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= {
  if (scalaBinaryVersion.value == "2.11") Seq("io.circe" %%% "circe-core" % "0.11.2") else libScalax.circe.value.map(_ % Test)
}

enableZIOTest := true
