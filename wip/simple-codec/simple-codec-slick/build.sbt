name := "simple-codec-slick"

enableZIOTest := true

libraryDependencies ++= libScalax.shapeless.value
libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`slick`.value
libraryDependencies ++= libScalax.`slickless`.value

run / fork := true

scalafmtOnCompile := true
