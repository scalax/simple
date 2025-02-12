name := "simple-codec"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value

Test / scalaJSUseMainModuleInitializer := true
Test / scalaJSUseTestModuleInitializer := false
