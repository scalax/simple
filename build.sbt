enablePlugins(CopyFilePlugin, CodegenPlugin)

scalaVersion       := scalaV.v213
name               := "simple-nat"
crossScalaVersions := scalaV.collect

val `module-path` = `root-path` / "modules"

val `test-path` = `module-path` / "test"
val `main-path` = `module-path` / "main"

val `adt-path`         = `main-path` / "simple-adt"
val `adt-codegen-path` = `adt-path` / "codegen"
val `adt-core-path`    = `adt-path` / "core"

val `injection-path`      = `main-path` / "simple-injection"
val `injection-core-path` = `injection-path` / "core"

val `test-common-path` = `test-path` / "test-common"

lazy val testProjects = project in `test-path`
lazy val mainProjects = project in `main-path`

lazy val adt = project in `adt-path`

val exec = {
  `adt-path`.withBuildFile(globalScripts).instance
  `adt-codegen-path`.withBuildFile(globalScripts).instance
  `injection-path`.withBuildFile(globalScripts).instance
  locally {
    val filePath = `adt-core-path`.withBuildFile(globalScripts).withBuildFile(scalaJsJvmScripts).withBuildFile(_ / "build.sbt.script")
    filePath.instance(toJVMRoot)
    filePath.withBuildFile(scalaJsJsScripts).instance(toJsRoot)
  }
  locally {
    val filePath = `injection-core-path`.withBuildFile(globalScripts).withBuildFile(scalaJsJvmScripts).withBuildFile(_ / "build.sbt.script")
    filePath.instance(toJVMRoot)
    filePath.withBuildFile(scalaJsJsScripts).instance(toJsRoot)
  }
  locally {
    val filePath = `test-common-path`.withBuildFile(globalScripts).withBuildFile(scalaJsJvmScripts).withBuildFile(_ / "build.sbt.script")
    filePath.instance(toJVMRoot)
    filePath.withBuildFile(scalaJsJsScripts).instance(toJsRoot)
  }
}

lazy val `adt-codegen` = project in `adt-codegen-path` enablePlugins (CodegenPlugin)
lazy val `adt-core`    = crossProject(JSPlatform, JVMPlatform) in `adt-core-path` dependsOn (`test-common` % Test)

lazy val injection        = project in `injection-path`
lazy val `injection-core` = crossProject(JSPlatform, JVMPlatform) in `injection-core-path` dependsOn (`test-common` % Test)

lazy val `test-common` = crossProject(JSPlatform, JVMPlatform) in `test-common-path`

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
