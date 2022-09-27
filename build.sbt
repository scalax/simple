import Settings._
import ProjectKeys._
import scala.collection.compat._

common.collect

name := "simple-nat"

val modulePath = file(".") / "modules"

val testProjects = project in modulePath / "test"
val mainProjects = project in modulePath / "main"

(mainProjects / copylibs)    := (testProjects / copylibs).value
(mainProjects / copyManages) := (testProjects / copyManages).value

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV;mainProjects/preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV;mainProjects/codegenImpl")
addCommandAlias("executeTest", s";+mainProjects/test")
addCommandAlias("t", ";all scalafmtSbt;executeTest")
