scalaVersion := scalaV.v3
name         := "simple-adt-codegen"

libraryDependencies ++= libScalax.`commons-io`.value

val codegenPackageName = "net.scalax.simple.adt.codegen"

val scala2RunMainInputStr = settingKey[String]("scala2RunMainInputStr")
scala2RunMainInputStr := {
  val projectRoot = rootCodegenPath.value / "scala-2"
  projectRoot.getAbsoluteFile.toString
}

val scala2RunMainClass = s"$codegenPackageName.Scala2CodegenExec"
codegenImpl := {
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

val scalaAllRunMainInputStr = settingKey[String]("scalaAllRunMainInputStr")
scalaAllRunMainInputStr := {
  val projectRoot = rootCodegenPath.value / "scala"
  projectRoot.getAbsoluteFile.toString
}

val scalaAllRunMainClass = s"$codegenPackageName.ScalaAllCodegenExec"
codegenImpl := {
  codegenImpl.evaluated
  (Compile / runMain).inputTaskValue.partialInput(s" $scalaAllRunMainClass").partialInput(s" ${scalaAllRunMainInputStr.value}").evaluated
}

val scalaInnerRunMainInputStr = settingKey[String]("scalaInnerRunMainInputStr")
scalaInnerRunMainInputStr := {
  val projectRoot = rootCodegenPath.value / ".." / ".." / ".." / "implemention" / "shared" / "src" / "codegen" / "scala"
  projectRoot.getAbsoluteFile.toString
}

val scalaInnerRunMainClass = s"$codegenPackageName.ScalaInnerCodegenExec"
codegenImpl := {
  codegenImpl.evaluated
  (Compile / runMain).inputTaskValue
    .partialInput(s" $scalaInnerRunMainClass")
    .partialInput(s" ${scalaInnerRunMainInputStr.value}")
    .evaluated
}

val scalaOuterRunMainInputStr = settingKey[String]("scalaOuterRunMainInputStr")
scalaOuterRunMainInputStr := {
  val projectRoot = rootCodegenPath.value / ".." / ".." / ".." / "bridge-support" / "shared" / "src" / "codegen"
  projectRoot.getAbsoluteFile.toString
}

val scalaOuterRunMainClass = s"$codegenPackageName.ScalaOuterCodegenExec"
codegenImpl := {
  codegenImpl.evaluated
  (Compile / runMain).inputTaskValue
    .partialInput(s" $scalaOuterRunMainClass")
    .partialInput(s" ${scalaOuterRunMainInputStr.value}")
    .evaluated
}

val preGenMainClass = s"$codegenPackageName.PreCodegen"
preCodegenImpl := (Compile / runMain).inputTaskValue
  .partialInput(s" $preGenMainClass")
  .partialInput(s" ${rootCodegenPath.value.getAbsoluteFile.toString}")
  .evaluated

scalafmtOnCompile := true
