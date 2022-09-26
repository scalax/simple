import Settings._
import ProjectKeys._

common.collect

val injectionCore = crossProject(JSPlatform, JVMPlatform).in(file(".") / "core")

name := "simple-injection"

def addToCoreProject(p: Project) = {
  val s1 = p / name    := "simple-injection-core"
  val s2 = Test / test := (Test / test).dependsOn(p / Test / test).value
  Seq(s1, s2) ++: addFilesToCross(p)
}

injectionCore.componentProjects.flatMap(addToCoreProject)
