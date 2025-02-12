name := "simple-codec-circe"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`circe`.value

run / fork := true

scalafmtOnCompile := true
