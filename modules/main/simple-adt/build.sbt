import Settings._
import ProjectKeys._
import scala.collection.compat._

common.collect

val adtCodegen = project in file(".") / "codegen"
val adtCore    = crossProject(JSPlatform, JVMPlatform).in(file(".") / "core")

val subProjects = adtCore.projects.values.to(List)

name              := "simple-adt"
adtCodegen / name := "simple-adt-codegen"

val sumTest = for (p <- subProjects) yield p / Test / test
Test / test := (Test / test).dependsOn(sumTest: _*).value

adtCodegen / rootCodegenPath := (adtCore.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

preCodegenImpl := (adtCodegen / preCodegenImpl).evaluated
codegenImpl    := (adtCodegen / codegenImpl).evaluated

for (t <- subProjects; t1 <- addFilesToCross(t)) yield t1

for (t <- subProjects) yield t / copylibs    := copylibs.value
for (t <- subProjects) yield t / copyManages := copyManages.value
for (t <- subProjects) yield t / name        := "simple-adt-core"
