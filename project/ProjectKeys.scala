import sbt._

object ProjectKeys {

  val rootCodegenPath = settingKey[File]("Codegen root path")
  val codegenImpl     = inputKey[Unit]("Execute codegen action")
  val preCodegenImpl  = inputKey[Unit]("Execute prepare codegen action")

}
