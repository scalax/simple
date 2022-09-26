import Settings._

common.collect

name := "simple-nat"

val modulePath = file(".") / "modules"

val testProjects = project in modulePath / "test"
val mainProjects = project in modulePath / "main"

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV;mainProjects/preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV;mainProjects/codegenImpl")
addCommandAlias("executeTest", ";+mainProjects/test")
addCommandAlias("t", ";all scalafmtSbt;executeTest")
