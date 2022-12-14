val `root/file` = file(".").getCanonicalFile

val `module/file`      = `root/file` / "modules"
val `impractical/file` = `module/file` / "impractical"

val `nat/file` = `impractical/file` / "simple-nat"

val `test/file` = `module/file` / "test"
val `main/file` = `module/file` / "main"

val `core/file`         = `main/file` / "simple-core"
val `wire/file`         = `main/file` / "simple-wire"
val `wire-core/file`    = `wire/file` / "core"
val `wire-web-app/file` = `wire/file` / "web-app"
val `codec/file`        = `main/file` / "simple-codec"
val `adt/file`          = `main/file` / "simple-adt"
val `adt-codegen/file`  = `adt/file` / "codegen"
val `adt-core/file`     = `adt/file` / "core"
val `generic/file`      = `main/file` / "simple-generic"

val `list/file` = `main/file` / "simple-list"

val `test-common/file` = `test/file` / "test-common"

scalaVersion := scalaV.v213
name         := "simple"

lazy val testProjects = project in `test/file`
lazy val mainProjects = project in `main/file`

lazy val core = crossProject(JSPlatform, JVMPlatform) in `core/file`

lazy val coreJVM = core.jvm
lazy val coreJS  = core.js

lazy val adt = project in `adt/file`

lazy val `adt-codegen` = project in `adt-codegen/file`
lazy val `adt-core`    = crossProject(JSPlatform, JVMPlatform) in `adt-core/file` dependsOn (core, `test-common` % Test)

lazy val `adt-coreJVM` = `adt-core`.jvm
lazy val `adt-coreJS`  = `adt-core`.js

lazy val list = crossProject(JSPlatform, JVMPlatform) in `list/file` dependsOn (core, `test-common` % Test)

lazy val listJVM = list.jvm
lazy val listJS  = list.js

lazy val wire = project in `wire/file`

lazy val `wire-core` = crossProject(JSPlatform, JVMPlatform) in `wire-core/file` dependsOn (core, `test-common` % Test)

lazy val `wire-coreJVM` = `wire-core`.jvm
lazy val `wire-coreJS`  = `wire-core`.js

lazy val `wire-web-app` = (project in `wire-web-app/file`).dependsOn(`wire-coreJVM`)

lazy val codec = crossProject(JSPlatform, JVMPlatform) in `codec/file` dependsOn (core, `test-common` % Test)

lazy val codecJVM = codec.jvm
lazy val codecJS  = codec.js

lazy val nat    = crossProject(JSPlatform, JVMPlatform) in `nat/file` dependsOn (core, `test-common` % Test)
lazy val natJVM = nat.jvm
lazy val natJS  = nat.js

lazy val generic    = crossProject(JSPlatform, JVMPlatform) in `generic/file` dependsOn (core, `test-common` % Test)
lazy val genericJVM = generic.jvm
lazy val genericJS  = generic.js

lazy val `test-common` = crossProject(JSPlatform, JVMPlatform) in `test-common/file`

`adt-codegen` / rootCodegenPath := (`adt-core`.jvm / baseDirectory).value / ".." / "shared" / "src" / "codegen"

val adtTestAll     = `adt-core`.componentProjects.map(t => t / Test / test)
val listTestAll    = list.componentProjects.map(t => t / Test / test)
val wireTestAll    = `wire-core`.componentProjects.map(t => t / Test / test)
val codecTestAll   = codec.componentProjects.map(t => t / Test / test)
val genericTestAll = generic.componentProjects.map(t => t / Test / test)

adt / Test / test := (adt / Test / test).dependsOn(adtTestAll: _*).value

val adtTestAction     = adt / Test / test
val listTestAction    = listTestAll
val wireTestAction    = wireTestAll
val codecTestAction   = codecTestAll
val genericTestAction = genericTestAll

mainProjects / Test / test := (mainProjects / Test / test)
  .dependsOn(adtTestAction)
  .dependsOn(listTestAction: _*)
  .dependsOn(wireTestAction: _*)
  .dependsOn(codecTestAction: _*)
  .dependsOn(genericTestAction: _*)
  .value

val codegenScalaV = scalaV.v3RC
addCommandAlias("preCodegen", s";++$codegenScalaV!;adt-codegen/preCodegenImpl")
addCommandAlias("codegen", s";++$codegenScalaV!;adt-codegen/codegenImpl")
addCommandAlias("executeTest", "+mainProjects/test")
