val `root-path` = file(".").getCanonicalFile

val `module-path` = `root-path` / "modules"

val `test-path` = `module-path` / "test"
val `main-path` = `module-path` / "main"

val `core-path`        = `main-path` / "simple-core"
val `adt-path`         = `main-path` / "simple-adt"
val `adt-codegen-path` = `adt-path` / "codegen"
val `adt-core-path`    = `adt-path` / "core"

val `list-path` = `main-path` / "simple-list"

val `test-common-path` = `test-path` / "test-common"

scalaVersion := scalaV.v213
name         := "simple-nat"

lazy val testProjects = project in `test-path`
lazy val mainProjects = project in `main-path`

lazy val core = crossProject(JSPlatform, JVMPlatform) in `core-path`

lazy val adt = project in `adt-path`

lazy val `adt-codegen` = project in `adt-codegen-path`
lazy val `adt-core`    = crossProject(JSPlatform, JVMPlatform) in `adt-core-path` dependsOn (core, `test-common` % Test)

lazy val `adt-coreJVM` = `adt-core`.jvm
lazy val `adt-coreJS`  = `adt-core`.js

lazy val `list` = crossProject(JSPlatform, JVMPlatform) in `list-path` dependsOn (core, `test-common` % Test)

lazy val `listJVM` = `list`.jvm
lazy val `listJS`  = `list`.js

lazy val `test-common` = crossProject(JSPlatform, JVMPlatform) in `test-common-path`

`adt-codegen` / rootCodegenPath := (`adt-core`.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

val adtTestAll  = `adt-core`.componentProjects.map(t => t / Test / test)
val listTestAll = `list`.componentProjects.map(t => t / Test / test)

adt / Test / test := (adt / Test / test).dependsOn(adtTestAll: _*).value

val adtTestAction  = adt / Test / test
val listTestAction = listTestAll

mainProjects / Test / test := (mainProjects / Test / test).dependsOn(adtTestAction).dependsOn(listTestAction: _*).value

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV!;adt-codegen/preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV!;adt-codegen/codegenImpl")
addCommandAlias("executeTest", "+mainProjects/test")
