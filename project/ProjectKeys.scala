import sbt._

object ProjectKeys {

  val rootCodegenPath = settingKey[File]("Codegen root path")
  val runGen          = inputKey[Unit]("Execute codegen action")
  val preGen          = inputKey[Unit]("Execute prepare codegen action")

}
