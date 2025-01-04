name := "simple-codec-codegen"

libraryDependencies ++= libScalax.`commons-io`.value

val codegenPackageName = "net.scalax.simple.codec.codegen"

val scalaAllRunMainInputStr = settingKey[String]("scalaAllRunMainInputStr")
scalaAllRunMainInputStr := {
  val projectRoot = rootCodegenPath.value
  projectRoot.getAbsoluteFile.toString
}

val scala2RunMainClass = s"$codegenPackageName.ScalaAllCodegenExec"
codegenImpl := {
  (Compile / runMain).inputTaskValue.partialInput(s" $scala2RunMainClass").partialInput(s" ${scalaAllRunMainInputStr.value}").evaluated
}

scalafmtOnCompile := true
