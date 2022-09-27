import Settings._
import ProjectKeys._

common.collect

crossScalaVersions += scalaV.v3RC

val adt       = project in file(".") / "simple-adt"
val injection = project in file(".") / "simple-injection"

adt / copylibs    := copylibs.value
adt / copyManages := copyManages.value

injection / copylibs    := copylibs.value
injection / copyManages := copyManages.value

Test / test := (Test / test).dependsOn(adt / Test / test, injection / Test / test).value

preCodegenImpl := (adt / preCodegenImpl).evaluated
codegenImpl    := (adt / codegenImpl).evaluated
