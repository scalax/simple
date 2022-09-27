import Settings._
import ProjectKeys._
import sbt.Project.projectToLocalProject

import scala.collection.compat._

forTest.collect

val testCommon = crossProject(JSPlatform, JVMPlatform).in(file(".") / "test-common")

val sumCrossDepts = testCommon.componentProjects.map(t => t / crossDepts)
crossDepts ++= Def.uniform(sumCrossDepts)(_.flatten).value

val pushTasks = testCommon.componentProjects.map(t => t / publishLocal)
publishLocal := publishLocal.dependsOn(pushTasks: _*).value

testCommon.componentProjects.flatMap(p => (p / name := "test-common").seq)

enablePlugins(GitVersioning)

git.useGitDescribe := true
