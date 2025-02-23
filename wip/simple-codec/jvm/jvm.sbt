name := "simple-codec"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`play-json`.value
libraryDependencies ++= libScalax.`scala-reflect`.value

run / fork := true
