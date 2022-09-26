import Settings._
import ProjectKeys._
import sbtcrossproject.{CrossProject, Platform}
import scala.collection.compat._

common.collect

val adtCodegen = project in file(".") / "codegen"
val adtCore    = crossProject(JSPlatform, JVMPlatform).in(file(".") / "core")

name              := "simple-adt"
adtCodegen / name := "simple-adt-codegen"


def addToCoreProject(p: Project, platform: Platform) = {
  val s1 = p / name    := "simple-adt-core"
  val s2 = Test / test := (Test / test).dependsOn(p / Test / test).value
  libraryDependencies := {
    libraryDependencies.value
  }
  Seq(s1, s2) ++: addFilesToCross(p)
}

adtCodegen / rootCodegenPath := (adtCore.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

preCodegenImpl := (adtCodegen / preCodegenImpl).evaluated
codegenImpl    := (adtCodegen / codegenImpl).evaluated

adtCore.projects.to(List).flatMap { case (s, t) => addToCoreProject(t, s) }
