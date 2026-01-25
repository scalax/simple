name := "simple-nat"

run / fork := true
run / javaOptions += "-Xss5M"
reStart / javaOptions += "-Xss5M"

val taskAA = inputKey[Unit]("bb")

taskAA := {
  (Compile / runMain).inputTaskValue.partialInput(" net.scalax.simple.nat.number12.RunMain1").evaluated
  (Compile / runMain).inputTaskValue.partialInput(" net.scalax.simple.nat.number12.RunMain2").evaluated
  (Compile / runMain).inputTaskValue.partialInput(" net.scalax.simple.nat.number12.RunMain3").evaluated
}

libraryDependencies ++= libScalax.`scala-collection-compat`.value
libraryDependencies ++= libScalax.`simple-adt`.value
libraryDependencies ++= libScalax.`spire`.value
libraryDependencies ++= libScalax.`breeze`.value
libraryDependencies ++= libScalax.`commons-math3`.value

enableZIOTest := true
useKindProjector
