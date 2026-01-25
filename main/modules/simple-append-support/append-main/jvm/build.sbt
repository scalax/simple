name := "simple-append-support"

libraryDependencies ++= libScalax.`scala-collection-compat`.value

scalafmtOnCompile := true
enableZIOTest     := true
useKindProjector
