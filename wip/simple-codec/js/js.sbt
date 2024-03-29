scalaVersion := scalaV.v213
name         := "simple-codec"

enableZIOTest := true

crossScalaVersions := Seq(scalaV.v212, scalaV.v213, scalaV.v3)

libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) => libScalax.shapeless.value
    case Some((2, 12)) => libScalax.shapeless.value
    case _             => List.empty
  }
}
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`cats-effect`.value
libraryDependencies ++= libScalax.`circe`.value

Test / scalaJSUseMainModuleInitializer := true
Test / scalaJSUseTestModuleInitializer := false
