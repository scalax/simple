name := "simple-codec-slick"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`slick`.value
libraryDependencies ++= libScalax.`h2`.value

run / fork := true

scalafmtOnCompile := true
