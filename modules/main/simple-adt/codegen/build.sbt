name := "simple-adt-codegen"

scalaVersion := RCScalaVersion
val codegenPackageName = "net.scalax.simple.adt.codegen"

val commonScalaRunMainInputStr = settingKey[String]("commonScalaRunMainInputStr")
commonScalaRunMainInputStr := {
  val projectRoot = rootCodegenPath.value / "scala"
  projectRoot.getAbsoluteFile.toString
}

val commonScalaRunMainClass = s"$codegenPackageName.CommonScalaCodegenExec"
codegenImpl := {
  (Compile / runMain).inputTaskValue
    .partialInput(s" $commonScalaRunMainClass")
    .partialInput(s" ${commonScalaRunMainInputStr.value}")
    .evaluated
}

val scala2RunMainInputStr = settingKey[String]("scala2RunMainInputStr")
scala2RunMainInputStr := {
  val projectRoot = rootCodegenPath.value / "scala-2"
  projectRoot.getAbsoluteFile.toString
}

val scala2RunMainClass = s"$codegenPackageName.Scala2CodegenExec"
codegenImpl := {
  codegenImpl.evaluated
  (Compile / runMain).inputTaskValue.partialInput(s" $scala2RunMainClass").partialInput(s" ${scala2RunMainInputStr.value}").evaluated
}

val scala3RunMainInputStr = settingKey[String]("scala3RunMainInputStr")
scala3RunMainInputStr := {
  val projectRoot = rootCodegenPath.value / "scala-3"
  projectRoot.getAbsoluteFile.toString
}

val scala3RunMainClass = s"$codegenPackageName.Scala3CodegenExec"
codegenImpl := {
  codegenImpl.evaluated
  (Compile / runMain).inputTaskValue.partialInput(s" $scala3RunMainClass").partialInput(s" ${scala3RunMainInputStr.value}").evaluated
}

val preGenMainClass = s"$codegenPackageName.PreCodegen"
preCodegenImpl := (Compile / runMain).inputTaskValue
  .partialInput(s" $preGenMainClass")
  .partialInput(s" ${rootCodegenPath.value.getAbsoluteFile.toString}")
  .evaluated

// Not support 3.2.0
scalafmtOnCompile := true
