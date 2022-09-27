import sbt._
import sbt.Keys._
import Settings._
import sbtcrossproject.Platform

object ProjectKeys {

  val rootCodegenPath = settingKey[File]("Codegen root path")
  val codegenImpl     = inputKey[Unit]("Execute codegen action")
  val preCodegenImpl  = inputKey[Unit]("Execute prepare codegen action")
  val filesToCross    = settingKey[Seq[File]]("Files to cross")
  val crossDepts      = settingKey[Seq[(Platform, ModuleID)]]("Cross dependencies.")

}
