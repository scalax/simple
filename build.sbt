import Settings._
import ProjectKeys._
import rootProject.subs.simpleAdt.{root => simpeAdtPath}

common.collect

name := "simple-nat"

val simpleAdt = project in simpeAdtPath

addCommandAlias("preCodegen", s";++${scalaV.v3} simpleAdt/preGen")
addCommandAlias("codegen", s";++${scalaV.v3} simpleAdt/runGen")
addCommandAlias("executeTest", ";+simpleAdt/test")
