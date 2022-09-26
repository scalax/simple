import sbt._
import sbtcrossproject.{CrossClasspathDependency, CrossProject, Platform}

object ProjectKeys {

  val rootCodegenPath = settingKey[File]("Codegen root path")
  val codegenImpl     = inputKey[Unit]("Execute codegen action")
  val preCodegenImpl  = inputKey[Unit]("Execute prepare codegen action")
  val filesToCross    = settingKey[Seq[File]]("Files to cross")
  val currentPlatform      = settingKey[Platform]("Current platform")
  val crossDepts      = settingKey[Seq[ModuleID]]("Cross dependencies.")

}
