import Settings._
import ProjectKeys._
import scala.collection.compat._

common.collect

val adtCodegen = project in file(".") / "codegen"
val adtCore    = crossProject(JSPlatform, JVMPlatform).in(file(".") / "core")

name              := "simple-adt"
adtCodegen / name := "simple-adt-codegen"

def addToCoreProject(p: Project) = (p / name := "simple-adt-core") +:
  (Test / test := (Test / test).dependsOn(p / Test / test).value) +:
  Seq((p / Test / libraryDependencies) ++= getProjectId(crossDepts.value, (p / crossProjectPlatform).value))

adtCodegen / rootCodegenPath := (adtCore.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

preCodegenImpl := (adtCodegen / preCodegenImpl).evaluated
codegenImpl    := (adtCodegen / codegenImpl).evaluated

adtCore.componentProjects.flatMap(addToCoreProject)
adtCore.componentProjects.flatMap(addFilesToCross)
