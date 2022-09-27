import Settings._
import ProjectKeys._
import scala.collection.compat._

common.collect
scalaVersion := scalaV.v213

val injectionCore = crossProject(JSPlatform, JVMPlatform).in(file(".") / "core")

val subProjects = injectionCore.projects.values.to(List)

name := "simple-injection"

val sumTest = for (p <- subProjects) yield p / Test / test
Test / test := (Test / test).dependsOn(sumTest: _*).value

for (t <- subProjects; t1 <- addFilesToCross(t)) yield t1

for (t <- subProjects) yield t / copylibs    := copylibs.value
for (t <- subProjects) yield t / copyManages := copyManages.value
for (t <- subProjects) yield t / name        := "simple-injection-core"
