enablePlugins(CopyFilePlugin, CodegenPlugin)

scalaVersion := scalaV.v213
name         := "simple-nat"

val `module-path` = `root-path` / "modules"

val `test-path` = `module-path` / "test"
val `main-path` = `module-path` / "main"

val `adt-path`       = `main-path` / "simple-adt"
val `injection-path` = `main-path` / "simple-injection"

val `test-common-path` = `test-path` / "test-common"

lazy val testProjects = project in `test-path`
lazy val mainProjects = project in `main-path`

lazy val adt           = project in `adt-path`.withBuildFile(globalScripts).instance
lazy val `adt-codegen` = project in (`adt-path` / "codegen").withBuildFile(globalScripts).instance enablePlugins (CodegenPlugin)
lazy val `adt-core` = crossProject(
  JSPlatform,
  JVMPlatform
) in (`adt-path` / "core")
  .withBuildFile(scalaJsGlobalScripts)
  .withBuildFile(_ / "build.sbt.script")
  .instance(_ / "js", _ / "jvm") dependsOn (`test-common` % Test)

lazy val injection = project in `injection-path`.withBuildFile(globalScripts).instance
lazy val `injection-core` =
  crossProject(
    JSPlatform,
    JVMPlatform
  ) in (`injection-path` / "core")
    .withBuildFile(scalaJsGlobalScripts)
    .withBuildFile(_ / "build.sbt.script")
    .instance(_ / "js", _ / "jvm") dependsOn (`test-common` % Test)

lazy val `test-common` = crossProject(JSPlatform, JVMPlatform) in `test-common-path`
  .withBuildFile(scalaJsGlobalScripts)
  .withBuildFile(_ / "build.sbt.script")
  .instance(_ / "js", _ / "jvm")

`adt-codegen` / rootCodegenPath := (`adt-core`.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

preCodegenImpl := (`adt-codegen` / preCodegenImpl).evaluated
codegenImpl    := (`adt-codegen` / codegenImpl).evaluated

val adtTestAll       = `adt-core`.componentProjects.map(t => t / Test / test)
val injectionTestAll = `injection-core`.componentProjects.map(t => t / Test / test)

adt / Test / test          := (adt / Test / test).dependsOn(adtTestAll: _*).value
injection / Test / test    := (injection / Test / test).dependsOn(injectionTestAll: _*).value
mainProjects / Test / test := (mainProjects / Test / test).dependsOn(adt / Test / test, injection / Test / test).value

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV;preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV;codegenImpl")
addCommandAlias("executeTest", "+mainProjects/test")
addCommandAlias("t", ";all scalafmtSbt;executeTest")
