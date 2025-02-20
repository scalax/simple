name := "simple-codec"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies += "org.playframework" %% "play-json" % "3.1.0-M1"

run / fork := true
