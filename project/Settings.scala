import sbt.*
import sbt.Keys.*

object CodegenPlugin extends AutoPlugin {
  object autoImport {
    val `root/file` = file(".").getCanonicalFile

    val codegenImpl     = inputKey[Unit]("Execute codegen action")
    val preCodegenImpl  = inputKey[Unit]("Execute prepare codegen action")
    val rootCodegenPath = settingKey[File]("Codegen root path")
  }
}
