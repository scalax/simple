name := "simple-adt"

libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`simple-append-support`.value

enableZIOTest := true
useKindProjector
