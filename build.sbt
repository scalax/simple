import Settings._
import ProjectKeys._

common.collect

name := "simple-nat"

val modulePath = file(".") / "modules"

val testProjects = project in modulePath / "test"
val mainProjects = project in modulePath / "main"

mainProjects / crossDepts ++= (testProjects / crossDepts).value

(mainProjects / Test / test) := (mainProjects / Test / test).dependsOn(testProjects / publishLocal).value

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV;mainProjects/preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV;mainProjects/codegenImpl")
addCommandAlias("executeTest", s";+mainProjects/test")
addCommandAlias("t", ";all scalafmtSbt;executeTest")
