name := "simple-nat"

libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`simple-adt`.value

enableZIOTest := true
useKindProjector
