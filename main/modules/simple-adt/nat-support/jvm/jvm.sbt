name := "simple-adt-nat-support"

libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`shapeless`.value
libraryDependencies ++= libScalax.`simple-append-support`.value

useKindProjector

enableZIOTest := true

scalafmtOnCompile := true
