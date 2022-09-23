import Settings._

common.collect

name := "simple-nat"

val adt       = project in file(".") / "simple-adt"
val injection = project in file(".") / "simple-injection"

addCommandAlias("preCodegen", s";++${scalaV.v3} adt/preCodegenImpl")
addCommandAlias("codegen", s";++${scalaV.v3} adt/codegenImpl")
addCommandAlias("executeTest", ";+adt/test;+injection/test")
addCommandAlias("t", "executeTest")
