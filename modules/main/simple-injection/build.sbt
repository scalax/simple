import Settings._
import ProjectKeys._

common.collect

val injectionCore = crossProject(JSPlatform, JVMPlatform).in(file(".") / "core")

name := "simple-injection"

def addToCoreProject(p: Project): Seq[Setting[_]] = ((p / name) := "simple-injection-core") +:
  (Test / test := (Test / test).dependsOn(p / Test / test).value) +:
  Seq((p / Test / libraryDependencies) ++= getProjectId(crossDepts.value, (p / crossProjectPlatform).value))

injectionCore.componentProjects.flatMap(addToCoreProject)

injectionCore.componentProjects.flatMap(addFilesToCross)
