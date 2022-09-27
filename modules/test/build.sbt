import Settings._
import ProjectKeys._

import scala.collection.compat._

forTest.collect
scalaVersion := scalaV.v213

name := "test-modules"

val testCommon = crossProject(JSPlatform, JVMPlatform) in file(".") / "test-common"

val subProjects = testCommon.projects.values.to(List)

val classPaths = for (t <- subProjects) yield t: ClasspathDep[ProjectReference]
dependsOn(classPaths: _*)

val sumManages = for (p <- subProjects) yield p / copyManages
copyManages := Def.uniform(sumManages)(_.flatten).value

val sumlibs = for (p <- subProjects) yield p / copylibs
copylibs := Def.uniform(sumlibs)(_.flatten).value

val sumTest = for (p <- subProjects) yield p / Test / test
Test / test := (Test / test).dependsOn(sumTest: _*).value
