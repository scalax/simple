import Settings._
import ProjectKeys._
import ProjectPaths.projects.simpleAdt.{root => simpeAdtPath}

common.collect

name := "simple-nat"

val simpleAdt = project in simpeAdtPath

val preCodegen = inputKey[Unit]("Prepare to codegen.")
val codegen    = inputKey[Unit]("Execute codegen.")

preCodegen := {
  (simpleAdt / preGen).evaluated
}
codegen := {
  (simpleAdt / runGen).evaluated
}
