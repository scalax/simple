name := "simple-codec"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies += "org.playframework" %% "play-json" % "3.1.0-M1"
libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, _)) => List("org.scala-lang" % "scala-reflect" % scalaVersion.value)
    case _            => List.empty
  }
}

run / fork := true
