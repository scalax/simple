import Settings._
import ProjectKeys._
import ProjectPaths.projects.simpleAdt.{root => simpeAdtPath}

common.collect

name := "simple-nat"

val simpleAdt = project in simpeAdtPath

addCommandAlias("preCodegen", s";++${scalaV.v213} simpleAdt/preGen")
addCommandAlias("codegen", s";++${scalaV.v213} simpleAdt/runGen")
addCommandAlias("executeTest", ";+simpleAdt/test")
