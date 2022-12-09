val `root/file` = file(".").getCanonicalFile

val `module/file` = `root/file` / "modules"
val `geshu/file`  = `root/file` / "geshu"

val `counter/file` = `geshu/file` / "counter"

val `test/file` = `module/file` / "test"
val `main/file` = `module/file` / "main"

val `core/file`        = `main/file` / "simple-core"
val `injection/file`   = `main/file` / "simple-injection"
val `codec/file`       = `main/file` / "simple-codec"
val `adt/file`         = `main/file` / "simple-adt"
val `adt-codegen/file` = `adt/file` / "codegen"
val `adt-core/file`    = `adt/file` / "core"

val `list/file` = `main/file` / "simple-list"

val `test-common/file` = `test/file` / "test-common"

scalaVersion := scalaV.v213
name         := "simple-nat"

lazy val testProjects = project in `test/file`
lazy val mainProjects = project in `main/file`

lazy val core = crossProject(JSPlatform, JVMPlatform) in `core/file`

lazy val adt = project in `adt/file`

lazy val `adt-codegen` = project in `adt-codegen/file`
lazy val `adt-core`    = crossProject(JSPlatform, JVMPlatform) in `adt-core/file` dependsOn (core, `test-common` % Test)

lazy val `adt-coreJVM` = `adt-core`.jvm
lazy val `adt-coreJS`  = `adt-core`.js

lazy val list = crossProject(JSPlatform, JVMPlatform) in `list/file` dependsOn (core, `test-common` % Test)

lazy val listJVM = list.jvm
lazy val listJS  = list.js

lazy val injection = crossProject(JSPlatform, JVMPlatform) in `injection/file` dependsOn (core, `test-common` % Test)

lazy val injectionJVM = injection.jvm
lazy val injectionJS  = injection.js

lazy val codec = crossProject(JSPlatform, JVMPlatform) in `codec/file` dependsOn (core, `test-common` % Test)

lazy val codecJVM = codec.jvm
lazy val codecJS  = codec.js

lazy val counter = crossProject(JSPlatform, JVMPlatform) in `counter/file` dependsOn (core, `test-common` % Test)

lazy val `test-common` = crossProject(JSPlatform, JVMPlatform) in `test-common/file`

`adt-codegen` / rootCodegenPath := (`adt-core`.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

val adtTestAll       = `adt-core`.componentProjects.map(t => t / Test / test)
val listTestAll      = list.componentProjects.map(t => t / Test / test)
val injectionTestAll = injection.componentProjects.map(t => t / Test / test)
val codecTestAll     = codec.componentProjects.map(t => t / Test / test)

adt / Test / test := (adt / Test / test).dependsOn(adtTestAll: _*).value

val adtTestAction       = adt / Test / test
val listTestAction      = listTestAll
val injectionTestAction = injectionTestAll
val codecTestAction     = codecTestAll

mainProjects / Test / test := (mainProjects / Test / test)
  .dependsOn(adtTestAction)
  .dependsOn(listTestAction: _*)
  .dependsOn(injectionTestAction: _*)
  .dependsOn(codecTestAction: _*)
  .value

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV!;adt-codegen/preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV!;adt-codegen/codegenImpl")
addCommandAlias("executeTest", "+mainProjects/test")
